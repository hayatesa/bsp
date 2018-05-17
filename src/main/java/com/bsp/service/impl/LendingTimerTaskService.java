package com.bsp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsp.dao.LendingHistoryMapper;
import com.bsp.dao.LendingRecordMapper;
import com.bsp.dao.MappingMapper;
import com.bsp.dao.NewsMapper;
import com.bsp.entity.Administrator;
import com.bsp.entity.LendingHistory;
import com.bsp.entity.LendingRecord;
import com.bsp.entity.MailEntity;
import com.bsp.entity.News;
import com.bsp.exceptions.SendEmailException;
import com.bsp.exceptions.SystemErrorException;
import com.bsp.service.ILendingTimerTaskService;
import com.bsp.utils.mail.MailSendUtils;

@Service
public class LendingTimerTaskService implements ILendingTimerTaskService{
	@Autowired
	private LendingRecordMapper lendingRecordMapper;
	@Autowired
	private  MappingMapper mappingMapper;
	@Autowired
	private NewsMapper newsMapper;
	@Autowired
	private LendingHistoryMapper lendingHistoryMapper;
	private int daySeconds = 3600*24;	// 一天的秒数
	private int intervalUpdateSeconds = 60;	// 间隔30更新一次
	
	public void setLendingRecordMapper(LendingRecordMapper lendingRecordMapper) {
		this.lendingRecordMapper = lendingRecordMapper;
	}

	public void setMappingMapper(MappingMapper mappingMapper) {
		this.mappingMapper = mappingMapper;
	}

	public void setNewsMapper(NewsMapper newsMapper) {
		this.newsMapper = newsMapper;
	}

	public void setLendingHistoryMapper(LendingHistoryMapper lendingHistoryMapper) {
		this.lendingHistoryMapper = lendingHistoryMapper;
	}

	/**
	 * 处理借出记录中的各种超时订单
	 */
	@Override
	public void checkLendingRecordAllOvertime() {
		// 现在的服务器的时间
		Date nowDate = new Date();
		// 数据库所有的借出记录
		List<LendingRecord> lendingRecords = lendingRecordMapper.selectAllLendingRecord();

		// 借出人超时未同意天数
		int overtime_book_apply_check = Integer.valueOf((mappingMapper
				.selectByPrimaryKey("overtime_book_apply_check").getmValue()));
		// 借出人超时未同意天数
		int overtime_bring_to_transfer_station = Integer.valueOf((mappingMapper
				.selectByPrimaryKey("overtime_bring_to_transfer_station").getmValue()));
		// 借出人超时未同意天数
		int overtime_take_from_transfer_station = Integer.valueOf((mappingMapper
				.selectByPrimaryKey("overtime_take_from_transfer_station").getmValue()));
		List<MailEntity> mailBeans = new ArrayList<MailEntity>();	// 批量存放邮件
		List<News> newss = new ArrayList<News>();	// 批量存放通知消息
		for (LendingRecord lendingRecord : lendingRecords) {
			if(lendingRecord.getLrStruts() == 0){ 
				isOvertimeAgreeApply(lendingRecord, mailBeans, newss, nowDate);
			}else if (lendingRecord.getLrStruts() == 2) {
				
			}else if (lendingRecord.getLrStruts() == 4) {
				
			}else if (lendingRecord.getLrStruts() == 6) {
				
			}else if (lendingRecord.getLrStruts() == 8) {
				
			}
		}
		
		// 批量发送邮件
		for (MailEntity mailBean : mailBeans) {
			MailSendUtils mailSendUtils = new MailSendUtils();
			try {
				mailSendUtils.sendMail(mailBean.getToMail(), mailBean.getSubject(),mailBean.getContent());// 发送邮件
				System.out.println("mail ok");
			} catch (Exception e) {
				e.printStackTrace();
				throw new  SendEmailException("发送借阅申请失效提醒失败，系统异常");
			}
		}
		
		//批量发送通知消息
		for (News news : newss) {
			insertNews(news);
		}
	}
	
	/**
	 * 转态为0表示借书人提交了借书申请，判断借出人是否超时未同意借书人的借书请求。
	 * @param lendingRecord
	 * @param mailBeans
	 */
	private void isOvertimeAgreeApply(LendingRecord lendingRecord, List<MailEntity> mailBeans, List<News> newss, Date nowDate){
		// 借出人超时未同意天数
		int overtime_agree_apply = Integer.valueOf((mappingMapper
				.selectByPrimaryKey("overtime_agree_apply").getmValue()));

		// 提交借书的时间
		Date createTime = lendingRecord.getCreateTime();
		
		// 相差的时间秒数
		int seconds = (int) ((nowDate.getTime() - createTime.getTime()) / 1000);
		
		if (seconds >= (overtime_agree_apply - 2) * daySeconds 
				&& seconds < ((overtime_agree_apply - 2) * daySeconds + intervalUpdateSeconds)) {
			/*
			 * 还有两天时间就超时，但借出人没有同意借阅者的图书借阅申请。
			 * 发送通知信息到借出人账号和发送邮件提醒。
			 */
			String destMail = lendingRecord.getLoanableBook().getUser().getMail();
			// 生成邮件主题内容以及添加邮件到mailBeans
			String subject = "借阅申请提醒"; // 邮件主题
			String content = "您的《"+lendingRecord.getLoanableBook().getLbName()
					+"》图书正在被申请借阅，距离申请失效还有两天时间，请你尽快同意或拒接申请。谢谢!!!"; // 邮件主体内容
			MailEntity mailBean = new MailEntity(destMail,subject,content);
			mailBeans.add(mailBean);
			
			// 发送账号通知信息
			News news = new News(subject, new Date(), lendingRecord.getLoanableBook().getUser(), content);
			newss.add(news);
		}else if (seconds >= (overtime_agree_apply - 1) * daySeconds 
				&& seconds < ((overtime_agree_apply - 1) * daySeconds + intervalUpdateSeconds)) {
			/*
			 * 还有一天时间就超时，但借出人没有同意借阅者的图书借阅申请。
			 * 发送通知信息到借出人账号和发送邮件提醒。
			 */
			String destMail = lendingRecord.getLoanableBook().getUser().getMail();
			// 生成邮件主题内容以及添加邮件到mailBeans
			String subject = "借阅申请提醒"; // 邮件主题
			String content = "您的《"+lendingRecord.getLoanableBook().getLbName()
					+"》图书正在被申请借阅，距离申请失效还有一天时间，请你尽快同意或拒接申请。谢谢!!!"; // 邮件主体内容
			MailEntity mailBean = new MailEntity(destMail,subject,content);
			mailBeans.add(mailBean);

			// 发送账号通知信息
			News news = new News(subject, new Date(), lendingRecord.getLoanableBook().getUser(), content);
			newss.add(news);
		}else if (seconds >= overtime_agree_apply * daySeconds) {
			/*
			 * 借阅申请已经超时，但借出人没有同意借阅者的图书借阅申请。
			 * 发送通知信息到借出人账号和发送邮件提醒。
			 * 发送通知信息到借阅人账号和发送邮件提醒。
			 * 把该条记录移到lending_history表中，并修改状态为3表示申请超时，删除lending_record表中的记录
			 */
			String loanMail = lendingRecord.getLoanableBook().getUser().getMail();
			String borrowMail = lendingRecord.getUser().getMail();
			// 生成邮件主题内容以及添加邮件到mailBeans
			String subject = "借阅申请失效提醒"; // 邮件主题
			String loanContent = "您的《"+lendingRecord.getLoanableBook().getLbName()
					+"》图书被申请借阅，由于你超时未操作申请，系统自动已帮您取消了借阅申请。谢谢!!!"; // 给借出人邮件主体内容
			String borrowContent = "您申请借阅的《"+lendingRecord.getLoanableBook().getLbName()
					+"》图书，由于对方超时未操作申请，系统已自动取消了借阅申请。你可以去寻找别的图书进行借阅。谢谢!!!"; // 给借阅人邮件主体内容	
			MailEntity mailBean1 = new MailEntity(loanMail,subject,loanContent);
			MailEntity mailBean2 = new MailEntity(borrowMail,subject,borrowContent);
			mailBeans.add(mailBean1);
			mailBeans.add(mailBean2);

			// 发送账号通知信息
			News news1 = new News(subject, new Date(), lendingRecord.getLoanableBook().getUser(), loanContent);
			News news2 = new News(subject, new Date(), lendingRecord.getUser(), borrowContent);
			newss.add(news1);
			newss.add(news2);
			
			//把该条记录移到lending_history表中，并修改状态为3表示申请超时
			Administrator administrator = new Administrator();
			LendingHistory lendingHistory = new LendingHistory();
			lendingHistory.setLhId(lendingRecord.getLrId());
			lendingHistory.setCreateTime(lendingRecord.getCreateTime());
			lendingHistory.setLhStruts((byte)3);
			lendingHistory.setLoanPhone(lendingRecord.getLoanPhone());
			lendingHistory.setLoanableBook(lendingRecord.getLoanableBook());
			lendingHistory.setUser(lendingRecord.getUser());
			lendingHistory.setReceiveAdmin(administrator);
			lendingHistory.setBackAdmin(administrator);
			insertLendingHistory(lendingHistory); // insert到历史表中
			
			// 删除lending_record表中的该记录
			deleteLendingRecordByPrimaryKey(lendingRecord.getLrId());
			
		}
	}
	
	@Transactional
	private void deleteLendingRecordByPrimaryKey(Integer lrId) {
		try {
			lendingRecordMapper.deleteByPrimaryKey(lrId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemErrorException("操作失败，系统异常");
		}
	}

	@Transactional
	private void insertLendingHistory(LendingHistory lendingHistory) {
		try {
			lendingHistoryMapper.insertSelective(lendingHistory);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemErrorException("操作失败，系统异常");
		}
	}

	@Transactional
	private void insertNews(News news){
		try {
			newsMapper.insert(news);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemErrorException("操作失败，系统异常");
		}
	}
}
