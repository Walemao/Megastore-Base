package com.walemao.megastore.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {
	/**
	 * 
	 * @return 日历选择list
	 */
	public static List<String> getDefaultDates() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date today = new Date();
		Date endDate = new Date();
		Date startDate = new Date(today.getTime() - (7 * 24 * 3600 * 1000));

		List<String> dateList = new ArrayList<String>();
		dateList.add(dateFormat.format(startDate));
		dateList.add(dateFormat.format(endDate));

		return dateList;
	}

	/**
	 * 转化方法成yyyy-MM-dd HH:mm:ss格式
	 * 
	 * @param date
	 *            传入的Date格式的时间参数
	 * @return yyyy-MM-dd HH:mm:ss格式
	 */
	public static String FormatToD(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

	/**
	 * 转化方法成yyyy-MM-dd HH:mm:ss带换行格式
	 * 
	 * @param date
	 *            传入的Date格式的时间参数
	 * @return yyyy-MM-dd HH:mm:ss带换行格式
	 */
	public static String FormatToE(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd /n HH:mm:ss");
		return dateFormat.format(date);
	}
}
