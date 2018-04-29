package com.bsp.utils;


/**
 * 封装异常代码
 */
public interface BusCode {
    /**
     * 未知异常，请联系管理员
     */
    int ERR_UNKONWN = 500;
    /**
     * 新增应用记录失败
     */
    int FAIL_RECODE_ADD = 10001;
    /**
     * 删除应用记录失败
     */
    int FAIL_RECODE_DEL = 10002;
    /**
     * 查询应用记录失败
     */
    int FAIL_RECODE_QUERRY = 10003;
    /**
     * 修改应用记录失败
     */
    int FAIL_RECODE_UPDATE = 10004;
}
