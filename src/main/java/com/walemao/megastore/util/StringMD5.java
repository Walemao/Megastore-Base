package com.walemao.megastore.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringMD5 {
	/**
	 * 转化成16位MD5,用于图片转化
	 * 
	 * @param content
	 *            变换成MD的字符串
	 * @return 你懂的
	 */
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
		return builder.substring(8, 24).toString();
	}
}
