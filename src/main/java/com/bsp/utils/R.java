package com.bsp.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public R() {
		//code==0,数据正常
		put("code", 0);
	}
	
	public static R error() {
		return error(BusCode.ERR_UNKONWN, "未知异常，请联系管理员");
	}
	
	public static R error(String msg) {
		return error(BusCode.ERR_UNKONWN, msg);
	}

	/**
	 * 指定异常code值，和异常描述
	 * @param code
	 * @param msg
	 * @return
	 */
	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	/**
	 * 将需要返回的数据put入
	 * @param key
	 * @param value
	 * @return
	 */
	@Override
	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
