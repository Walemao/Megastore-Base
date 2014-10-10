package com.walemao.megastore.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FileTypeUtil {
	public final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();

	private FileTypeUtil() {
	}

	static {
		getAllFileType(); // 初始化文件类型信息
	}

	private static void getAllFileType() {
		// TODO Auto-generated method stub
		FILE_TYPE_MAP.put("jpg", "FFD8FF"); // JPEG (jpg)
		FILE_TYPE_MAP.put("png", "89504E47"); // PNG (png)
		FILE_TYPE_MAP.put("gif", "47494638"); // GIF (gif)
	}

	/**
	 * Created on 2010-7-1
	 * <p>
	 * Discription:[getFileTypeByStream]
	 * </p>
	 * 
	 * @param b
	 * @return fileType
	 * @author:[shixing_11@sina.com]
	 */
	public final static String getFileTypeByStream(byte[] b) {
		String filetypeHex = String.valueOf(getFileHexString(b));
		Iterator<Entry<String, String>> entryiterator = FILE_TYPE_MAP
				.entrySet().iterator();
		while (entryiterator.hasNext()) {
			Entry<String, String> entry = entryiterator.next();
			String fileTypeHexValue = entry.getValue();
			if (filetypeHex.toUpperCase().startsWith(fileTypeHexValue)) {
				return entry.getKey();
			}
		}
		return null;
	}

	/**
	 * Created on 2010-7-1
	 * <p>
	 * Discription:[getFileHexString]
	 * </p>
	 * 
	 * @param b
	 * @return fileTypeHex
	 * @author:[shixing_11@sina.com]
	 */
	private final static String getFileHexString(byte[] b) {
		StringBuilder stringBuilder = new StringBuilder();
		if (b == null || b.length <= 0) {
			return null;
		}
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}
}
