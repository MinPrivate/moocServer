package com.mooc.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.mooc.serviceImpl.CreateFusionChartServiceImp;
import com.mooc.utils.FileUtils;

public class WriterChartXml {
	
	private static String moocQuokrComPath = FileUtils.sourceDataPath + "mooc.guokr.com.xlsx";
	private static String activity_newPaht = FileUtils.sourceDataPath + "activity_new.xlsx";
	private static String sina_newPath = FileUtils.sourceDataPath + "sina.news.xlsx";
	private static String sohu_newPath = FileUtils.sourceDataPath + "sohu.com.xlsx";
	private static String hangyePath = FileUtils.sourceDataPath + "hangye.xlsx";

	/**
	 * 写公开课视频数量柱状图xml
	 * @return
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public static String writeVideoNumXml() throws ClassNotFoundException, ParseException{
		
		ReadExcelData readExcelData = new ReadExcelData();
		
		List<List<String>> infos = readExcelData.readMoocQuokrComSheet2(moocQuokrComPath);

		
		String sChartName = "videonum.xml";
		String caption = "各类公开课数量对比";
		String yName = "公开课数量";
		
		int videoNum = infos.size();
		String[] columnKeys = new String[videoNum];
		String[] data = new String[videoNum];
		
		for (int j = 0; j < videoNum; j++){
			columnKeys[j] = infos.get(j).get(0);
			data[j] = infos.get(j).get(1);
		}
		
		try {
			sChartName = CreateFusionChartServiceImp.BuildXMLDocOfColumn2DFromDs(caption, "", "", yName, columnKeys, data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sChartName;
	}
	
	/**
	 * 写公开课视频浏览量柱状图xml
	 * @return
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public static String writeVideoScanNumXml() throws ClassNotFoundException, ParseException{
		
		ReadExcelData readExcelData = new ReadExcelData();
		
		List<List<String>> infos = readExcelData.readMoocQuokrComSheet2(moocQuokrComPath);

		
		String sChartName = "videonum.xml";
		String caption = "各类公开课浏览量对比";
		String yName = "公开课浏览量";
		
		int videoNum = infos.size();
		String[] columnKeys = new String[videoNum];
		String[] data = new String[videoNum];
		
		for (int j = 0; j < videoNum; j++){
			columnKeys[j] = infos.get(j).get(0);
			data[j] = infos.get(j).get(2);
		}
		
		try {
			sChartName = CreateFusionChartServiceImp.BuildXMLDocOfColumn2DFromDs(caption, "", "", yName, columnKeys, data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sChartName;
	}
	
	/**
	 * 写公开课视频评分柱状图xml
	 * @return
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public static String writeVideoCommentXml() throws ClassNotFoundException, ParseException{
		
		ReadExcelData readExcelData = new ReadExcelData();
		
		List<List<String>> infos = readExcelData.readMoocQuokrComSheet2(moocQuokrComPath);

		
		String sChartName = "videonum.xml";
		String caption = "各类公开课评分对比";
		String yName = "公开课评分";
		
		int videoNum = infos.size();
		String[] columnKeys = new String[videoNum];
		String[] data = new String[videoNum];
		
		for (int j = 0; j < videoNum; j++){
			columnKeys[j] = infos.get(j).get(0);
			data[j] = infos.get(j).get(3);
		}
		
		try {
			sChartName = CreateFusionChartServiceImp.BuildXMLDocOfColumn2DFromDs(caption, "", "", yName, columnKeys, data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sChartName;
	}
	
	/**
	 * 写客户参与曲线xml
	 * @return
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public static String writeClientCommentXml() throws ClassNotFoundException, ParseException{
		
		//读取数据
		ReadExcelData readExcelData = new ReadExcelData();
		List<List<String>> infos = readExcelData.readActivity_newSheet1(activity_newPaht);
		
		//将同一天的数据统计
		int num = infos.size();
		Map<String, Double> map = new HashMap<String, Double>();
		for(int i = 0; i < num; i++){
			List<String> info = infos.get(i);
			String time = info.get(4);
			String commentNum = info.get(3);
			double dCommentNum = Double.parseDouble(commentNum);
			
			if(!map.containsKey(time)){
				map.put(time, dCommentNum);
			}else{
				double sum = map.get(time) + dCommentNum;
				map.put(time, sum);
			}
		}
		SortedMap<String, Double> sortedMap = new TreeMap<String, Double>(map);
		
		String sChartName = "";
		String caption = "客户参与度曲线";
		String yName = "客户参与次数";
		
		int rowNum = 1;
		String[] rowKeys = new String[1];
		rowKeys[0] = "客户参与度曲线";
		
		int timeNum = sortedMap.size();
		String[] columnKeys = new String[timeNum];	
		
		int index = 0;
		for (String time : sortedMap.keySet()){
			columnKeys[index] = time;
			index++;
		}
		
		double[][] data = new double[rowNum][timeNum];
		for (int i=0; i<rowKeys.length; i++){
			int j = 0;
			for (String time : sortedMap.keySet()){
				
				data[i][j] = sortedMap.get(time);
				j++;
				
			}
		}
		
		try {
			sChartName = CreateFusionChartServiceImp.BuildXMLDocOfMsLineFromDsShow(caption, "", "时间点", yName, columnKeys, rowKeys, data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sChartName;
	}
	
	/**
	 * 写新浪新闻曲线xml
	 * @return
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public static String writeSinaNewsXml() throws ClassNotFoundException, ParseException{
		
		//读取数据
		ReadExcelData readExcelData = new ReadExcelData();
		List<List<String>> infos = readExcelData.readSinanewSheet1(sina_newPath);
		
		//将同一天的数据统计
		int num = infos.size();
		Map<String, Double> map = new HashMap<String, Double>();
		for(int i = 0; i < num; i++){
			List<String> info = infos.get(i);
			String time = info.get(2);
			time = time.substring(0, 6);
			double commentNum = 0;
			
			if(!map.containsKey(time)){
				commentNum++;
				map.put(time, commentNum);
			}else{
				double sum = map.get(time) + 1;
				map.put(time, sum);
			}
		}
		SortedMap<String, Double> sortedMap = new TreeMap<String, Double>(map);
		
		String sChartName = "";
		String caption = "新浪新闻搜索度曲线";
		String yName = "关注度";
		
		int rowNum = 1;
		String[] rowKeys = new String[1];
		rowKeys[0] = "新浪新闻搜索度曲线";
		
		int timeNum = sortedMap.size();
		String[] columnKeys = new String[timeNum];	
		
		int index = 0;
		for (String time : sortedMap.keySet()){
			columnKeys[index] = time;
			index++;
		}
		
		double[][] data = new double[rowNum][timeNum];
		for (int i=0; i<rowKeys.length; i++){
			int j = 0;
			for (String time : sortedMap.keySet()){
				
				data[i][j] = sortedMap.get(time);
				j++;
				
			}
		}
		
		try {
			sChartName = CreateFusionChartServiceImp.BuildXMLDocOfMsLineFromDsShow(caption, "", "时间点", yName, columnKeys, rowKeys, data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sChartName;
	}
	
	/**
	 * 写搜狐新闻曲线xml
	 * @return
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public static String writeSohuNewsXml() throws ClassNotFoundException, ParseException{
		
		//读取数据
		ReadExcelData readExcelData = new ReadExcelData();
		List<List<String>> infos = readExcelData.readSinanewSheet1(sohu_newPath);
		
		//将同一天的数据统计
		int num = infos.size();
		Map<String, Double> map = new HashMap<String, Double>();
		for(int i = 0; i < num; i++){
			List<String> info = infos.get(i);
			String time = info.get(2);
			double commentNum = 0;
			
			if(!map.containsKey(time)){
				commentNum++;
				map.put(time, commentNum);
			}else{
				double sum = map.get(time) + 1;
				map.put(time, sum);
			}
		}
		SortedMap<String, Double> sortedMap = new TreeMap<String, Double>(map);
		
		String sChartName = "";
		String caption = "搜狐新闻搜索度曲线";
		String yName = "关注度";
		
		int rowNum = 1;
		String[] rowKeys = new String[1];
		rowKeys[0] = "搜狐新闻搜索度曲线";
		
		int timeNum = sortedMap.size();
		String[] columnKeys = new String[timeNum];	
		
		int index = 0;
		for (String time : sortedMap.keySet()){
			columnKeys[index] = time;
			index++;
		}
		
		double[][] data = new double[rowNum][timeNum];
		for (int i=0; i<rowKeys.length; i++){
			int j = 0;
			for (String time : sortedMap.keySet()){
				
				data[i][j] = sortedMap.get(time);
				j++;
				
			}
		}
		
		try {
			sChartName = CreateFusionChartServiceImp.BuildXMLDocOfMsLineFromDsShow(caption, "", "时间点", yName, columnKeys, rowKeys, data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sChartName;
	}
	
	/**
	 * 写行业市场规模曲线xml
	 * @return
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public static String writeHangyeMarketScaleXml() throws ClassNotFoundException, ParseException{
		
		//读取数据
		ReadExcelData readExcelData = new ReadExcelData();
		List<List<String>> infos = readExcelData.readHangYeScaeSheet1(hangyePath);
		
		String sChartName = "";
		String caption = "行业市场规模曲线";
		String yName = "亿元";
		
		int rowNum = 1;
		String[] rowKeys = new String[1];
		rowKeys[0] = "行业市场规模曲线";
		
		int timeNum = infos.size();
		String[] columnKeys = new String[timeNum];	
		
		for (int i = 0; i < timeNum; i++){
			columnKeys[i] = infos.get(i).get(0).substring(0, 4);
		}
		
		double[][] data = new double[rowNum][timeNum];
		for (int i=0; i<rowKeys.length; i++){
			
			for (int j = 0; j < timeNum; j++){
				
				data[i][j] = Double.parseDouble(infos.get(j).get(1));
				
				
			}
		}
		
		try {
			sChartName = CreateFusionChartServiceImp.BuildXMLDocOfMsLineFromDsShow(caption, "", "时间点", yName, columnKeys, rowKeys, data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sChartName;
	}
	
	/**
	 * 写行业用户规模曲线xml
	 * @return
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public static String writeHangyeUserScaleXml() throws ClassNotFoundException, ParseException{
		
		//读取数据
		ReadExcelData readExcelData = new ReadExcelData();
		List<List<String>> infos = readExcelData.readHangYeScaeSheet1(hangyePath);
		
		String sChartName = "";
		String caption = "行业用户规模曲线";
		String yName = "万人";
		
		int rowNum = 1;
		String[] rowKeys = new String[1];
		rowKeys[0] = "行业用户规模曲线";
		
		int timeNum = infos.size();
		String[] columnKeys = new String[timeNum];	
		
		for (int i = 0; i < timeNum; i++){
			columnKeys[i] = infos.get(i).get(0).substring(0, 4);
		}
		
		double[][] data = new double[rowNum][timeNum];
		for (int i=0; i<rowKeys.length; i++){
			
			for (int j = 0; j < timeNum; j++){
				
				data[i][j] = Double.parseDouble(infos.get(j).get(3));
				
				
			}
		}
		
		try {
			sChartName = CreateFusionChartServiceImp.BuildXMLDocOfMsLineFromDsShow(caption, "", "时间点", yName, columnKeys, rowKeys, data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sChartName;
	}
	
	/**
	 * 写行业比例饼状图xml
	 * @return
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public static String writeHangyePieXml() throws ClassNotFoundException, ParseException{
		
		//读取数据
		
		String sChartName = "";
		String caption = "";
		
		
		String[] columnKeys = {"高等学历在线教育","在线语言培训","职业在线教育","中小学在线教育","企业E-learning"};
		
		double[] data = {48.6,19.4,20.8,8.3,2.9};
		
		try {
			sChartName = CreateFusionChartServiceImp.BuildXMLDocOfPie2DFromDs(caption, "", columnKeys, data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sChartName;
	}
	
	/**
	 * 写行业年龄分布柱状图xml
	 * @return
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public static String writeHangyeAgeDisXml() throws ClassNotFoundException, ParseException{
		
		String[] ageNames = {"19岁及以下", "20~29岁", "30~39岁", "40~49岁", "50岁及以上"};
		String[] ages = {"2", "21", "63", "10", "4"};
		
		String sChartName = "";
		String caption = "人群年龄分布";
		String yName = "百分比";
		
		int num = ageNames.length;
		String[] columnKeys = new String[num];
		String[] data = new String[num];
		
		for (int j = 0; j < num; j++){
			columnKeys[j] = ageNames[j];
			data[j] = ages[j];
		}
		
		try {
			sChartName = CreateFusionChartServiceImp.BuildXMLDocOfColumn2DFromDs(caption, "", "", yName, columnKeys, data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sChartName;
	}
	
	/**
	 * 写行业性别分布饼状图xml
	 * @return
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 */
	public static String writeHangyePieSexXml() throws ClassNotFoundException, ParseException{
		
		//读取数据
		
		String sChartName = "";
		String caption = "行业性别比例分布";
		
		
		String[] columnKeys = {"男性","女性"};
		
		double[] data = {87,13};
		
		try {
			sChartName = CreateFusionChartServiceImp.BuildXMLDocOfPie2DFromDs(caption, "", columnKeys, data);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sChartName;
	}
}
