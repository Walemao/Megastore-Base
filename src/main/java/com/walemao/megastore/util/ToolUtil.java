package com.walemao.megastore.util;

public class ToolUtil {
	public static String IntDataToString(int[] values){
		StringBuffer sb = new StringBuffer();
		int length = values.length;
		if (length > 0) {
			sb.append("(");
			for (int i = 0; i < length - 1; ++i) {
				sb.append(values[i] + ",");
			}
			;
			sb.append(values[length - 1] + ")");
		}
		return sb.toString();
	}
}
