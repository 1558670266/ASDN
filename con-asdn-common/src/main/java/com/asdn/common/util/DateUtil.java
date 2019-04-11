package com.asdn.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtil {
	// 将时间字符串转Timestamp类型
	public static Timestamp string2Time(String dateString) throws ParseException {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.ENGLISH);
		dateFormat.setLenient(false);
		java.util.Date timeDate = dateFormat.parse(dateString);// util类型
		Timestamp dateTime = new Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
		return dateTime;
	}
}
