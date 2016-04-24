package com.bishe.photo.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Test {
	public static void main(String[] args) {
		
	try {
		System.out.println(URLDecoder.decode("%E4%B8%AD%E5%9B%BD","UTF-8"));
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	}
}
