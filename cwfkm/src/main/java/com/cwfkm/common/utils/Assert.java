package com.cwfkm.common.utils;

public class Assert {
	private Assert() {}
	
	public static void isValid(boolean valid,String message) {
		if(!valid)
			throw new IllegalArgumentException(message);
	}
	public static void isNull(Object object,String message) {
		if(object==null) {
			throw new IllegalArgumentException(message);
		}
	}
	public static void isEmpty(String object,String message) {
		if(object==null||"".equals(object.trim())) {
			throw new IllegalArgumentException(message);
		}
	}
	public static void isEmpty(Integer[]array,String message) {
		if(array==null||array.length==0) {
			throw new IllegalArgumentException(message);
		}
	}
}








