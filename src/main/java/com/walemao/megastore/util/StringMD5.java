package com.walemao.megastore.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringMD5 {
	public static String encode(String content) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(content.getBytes());
			return getEncode16(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 16位加密
	 * 
	 * @param digest
	 * @return
	 */
	private static String getEncode16(MessageDigest digest) {
		StringBuilder builder = new StringBuilder();
		for (byte b : digest.digest()) {
			builder.append(Integer.toHexString((b >> 4) & 0xf));
			builder.append(Integer.toHexString(b & 0xf));
		}

		// 16位加密，从第9位到25位
		// return builder.substring(8, 24).toString().toUpperCase();
		return builder.substring(8, 24).toString();
	}
}
