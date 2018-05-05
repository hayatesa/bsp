package bsp.test.utils;

import org.junit.Test;

import com.bsp.utils.Cryptography;

public class MD5UtilTest {
	
	@Test
	public void get() {
		System.out.println(Cryptography.MD5Hash("123456", "358739303@qq.com"));
	}
	
}
