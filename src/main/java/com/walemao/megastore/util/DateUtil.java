package com.walemao.megastore.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {
	
	public static List<String> getDefaultDates(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date today = new Date();
		Date endDate = new Date();
		Date startDate = new Date(today.getTime() - (7 * 24 * 3600 * 1000));
		
		List<String> dateList = new ArrayList<String>();
		dateList.add(dateFormat.format(startDate));
		dateList.add(dateFormat.format(endDate));
		
		return dateList;
	}
}
