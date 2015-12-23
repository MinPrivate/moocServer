package com.mooc.utils;

public class TimeUtils {

	public static String dataString2dateFormat(String stringDate){
		String dateFormat = "";
		//String dateBase = "2015-1-2";
		if(stringDate.contains("昨天")){
			dateFormat = "2015-01-01";
		}else if(stringDate.contains("分钟前") || stringDate.contains("小时前")){
			dateFormat = "2015-01-02";
		}else{
			dateFormat = stringDate;
		}
		dateFormat = dateFormat.replace("-", "");
		return dateFormat;
	}
	
	public static String sinaDataString2dateFormat(String stringDate){
		String dateFormat = "";
		//String dateBase = "2015-1-2";
		if(stringDate.contains("-")){
			dateFormat = stringDate.split(" ")[0];
		}
//		else if(stringDate.contains("分钟前") || stringDate.contains("小时前")){
//			dateFormat = "2015-01-02";
//		}
		else{
			dateFormat = "2015-01-03";
		}
		dateFormat = dateFormat.replace("-", "");
		
		return dateFormat;
	}
}
