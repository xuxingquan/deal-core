package com.bill99.base.account.deal;

import org.junit.Test;

public class Demo {
	@Test
	public void testString(){
//		System.out.println(StringUtils.join("cher",Constant.UNDER_LINE,"23234"));
		String string = "24324_aaa";
		String string2 = "6666";
		System.out.println(string.split("_")[0]);
		System.out.println(string2.split("_")[0]);
	}
}
