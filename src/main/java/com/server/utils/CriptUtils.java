package com.server.utils;

import org.apache.commons.codec.digest.Crypt;
import org.apache.commons.lang3.StringUtils;

public class CriptUtils {
	private static String password = "TESTE";
	
	public static void main(String[] args) {
		String passwordCrypt = addCrypt(password);
		
		System.out.println("Encrypt: TESTE = " + passwordCrypt);
		
		System.out.println("This password is " + new String(isValidPassword(addCrypt("tESTE")) ? "valid" : "invalid"));
		
	}
	
	public static String addCrypt(String data) {
		Crypt codifica = new Crypt();
		data = codifica.crypt(data, StringUtils.reverse("docrotas"));
		
		return data;
	}
	
	public static boolean isValidPassword(String data) {
		return data.equals(addCrypt(password));
	}

}
