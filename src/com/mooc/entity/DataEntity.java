package com.mooc.entity;

public class DataEntity {

	/*
	 * 行业数据
	 */
	private static String[] industrys = {"在线教育", "房地产", "移动互联网", "新能源"};
	/*
	 * 公司数据
	 */
	private static String[] companys = {"MOOC", "mooc", "MOOC学院", "mooc学院", "极客学院", "网易云课堂", "果壳网", "网易公开课"};
	
	/**
	 * 判断输入的行业是否存在
	 * @param industry
	 * @return
	 */
	public static boolean existIndustry(String industry){
		boolean exist = false;
		for(int i = 0; i < industrys.length; i++){
			String entity = industrys[i];
			if(entity.contains(industry)){
				exist = true;
			}
		}
		return exist;
	}
	
	/**
	 * 判断输入的公司是否存在
	 * @param company
	 * @return
	 */
	public static boolean existCompany(String company){
		boolean exist = false;
		for(int i = 0; i < companys.length; i++){
			String entity = companys[i];
			if(entity.contains(company)){
				exist = true;
			}
		}
		return exist;
	}
}
