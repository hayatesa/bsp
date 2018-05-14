package com.bsp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * 类名称：TimerTask 类描述：定时器任务 创建人：wjb 创建时间：2018年5月14日22:28:33
 * 
 * @version V1.0
 *
 */
@Component
public class TimerTask extends BaseController {

	//测试用例
	@Scheduled(cron = "0 54 23 * * ?") // 每天一次
	public void test2() {
		Date day = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(day) + "*********数据修改执行一次进入测试");
	}

}
