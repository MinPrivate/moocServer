package com.mooc.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mooc.utils.TimeUtils;

public class ReadExcelData {
	
	public static void main(String args[]) throws ClassNotFoundException, ParseException{
		ReadExcelData readExcelData = new ReadExcelData();
//		List<List<String>> infos = readExcelData.readMoocQuokrComSheet1("sourceExcelData/mooc.guokr.com.xlsx");
//		List<List<String>> infos = readExcelData.readActivity_newSheet1("sourceExcelData/activity_new.xlsx");
//		
//		int num = infos.size();
//		Map<String, Double> map = new HashMap<String, Double>();
//		for(int i = 0; i < num; i++){
//			List<String> info = infos.get(i);
//			String time = info.get(4);
//			String commentNum = info.get(3);
//			double dCommentNum = Double.parseDouble(commentNum);
//			
//			if(!map.containsKey(time)){
//				map.put(time, dCommentNum);
//			}else{
//				double sum = map.get(time) + dCommentNum;
//				map.put(time, sum);
//			}
//		}
//		SortedMap<String, Double> sortedMap = new TreeMap<String, Double>(map);
//		
//		System.out.println("Size: " + sortedMap.size());
//		System.out.println(sortedMap);
		List<List<String>> infos = readExcelData.readHangYeScaeSheet1("sourceExcelData/1014_src.xls");
		System.out.println("Size: "+ infos.size());
		for(int i = 0; i < infos.size(); i++){
			List<String> info = infos.get(i);
			System.out.println(i + " | " + info);
//			for(int j = 0; j < info.size(); j++){
//				System.out.println(info.get(j));
//			}
		}
	}
	
	/**
	 * 读hangye.xls 第一个sheet的数据，并以list形式返回
	 * @param excelName
	 * @return
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 */
	public List<List<String>> readHangYeScaeSheet1(String excelName) throws ParseException, ClassNotFoundException {
		List<List<String>> infos = null;
		
		List<Sheet> sheets = getSheet(excelName);
		
		Sheet sheet = sheets.get(0);
		
		
		int rowCount = sheet.getPhysicalNumberOfRows();// 行数
		//System.out.println(rowCount);
		if(rowCount > 0){
			infos = new ArrayList<List<String>>();
		}
		//从第二行开始读
		for (int i = 1; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			
			List<String> info = new ArrayList<String>();
			for(int c = 0; c < 5; c++){
				
				Cell cell1 = row.getCell(c);
				String content = "";
				if (cell1 == null)
					break;
				else {
					if (cell1.getCellType() == Cell.CELL_TYPE_NUMERIC)
						content = String.valueOf(cell1.getNumericCellValue()).trim();
					if (cell1.getCellType() == Cell.CELL_TYPE_STRING)
						content = String.valueOf(cell1.getStringCellValue()).trim();
				}
				
				info.add(content);
				//System.out.println(content);
			}
			infos.add(info);
		}
		return infos;
	}
	
	/**
	 * 读取sina.news.xlsx 第一个sheet的数据，并以list形式返回
	 * @param excelName
	 * @return
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 */
	public List<List<String>> readSinanewSheet1(String excelName) throws ParseException, ClassNotFoundException {
		List<List<String>> infos = null;
		
		List<Sheet> sheets = getSheet(excelName);
		
		Sheet sheet = sheets.get(0);
		
		
		int rowCount = sheet.getPhysicalNumberOfRows();// 行数
		//System.out.println(rowCount);
		if(rowCount > 0){
			infos = new ArrayList<List<String>>();
		}
		//从第二行开始读
		for (int i = 1; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			
			List<String> info = new ArrayList<String>();
			for(int c = 0; c < 4; c++){
				
				Cell cell1 = row.getCell(c);
				String content = "";
				if (cell1 == null)
					break;
				else {
					if (cell1.getCellType() == Cell.CELL_TYPE_NUMERIC)
						content = String.valueOf(cell1.getNumericCellValue()).trim();
					if (cell1.getCellType() == Cell.CELL_TYPE_STRING)
						content = String.valueOf(cell1.getStringCellValue()).trim();
				}
				if(c == 2){
					content = TimeUtils.sinaDataString2dateFormat(content);
				}
				info.add(content);
				//System.out.println(content);
			}
			infos.add(info);
		}
		return infos;
	}
	
	/**
	 * 读取activity_new.xlsx 第一个sheet的数据，并以list形式返回
	 * @param excelName
	 * @return
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 */
	public List<List<String>> readActivity_newSheet1(String excelName) throws ParseException, ClassNotFoundException {
		List<List<String>> infos = null;
		
		List<Sheet> sheets = getSheet(excelName);
		for (Sheet sheet : sheets) {
			if (sheet.getSheetName().contains("Sheet1")){
				infos = getActivity_newContentOfExcel1(sheet);
			}else{
				continue;
			}
		}
		return infos;
	}
	
	/**
	 * 读取activity_new.xlsx 第二个sheet的数据，并以list形式返回
	 * @param sheet
	 * @return
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 */
	public List<List<String>> getActivity_newContentOfExcel1(Sheet sheet)
			throws ParseException, ClassNotFoundException {
		
		List<List<String>> infos = null;
		
		int rowCount = sheet.getPhysicalNumberOfRows();// 行数
		//System.out.println(rowCount);
		if(rowCount > 0){
			infos = new ArrayList<List<String>>();
		}
	
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			
			List<String> info = new ArrayList<String>();
			for(int c = 0; c < 5; c++){
				
				Cell cell1 = row.getCell(c);
				String content = "";
				if (cell1 == null)
					break;
				else {
					if (cell1.getCellType() == Cell.CELL_TYPE_NUMERIC)
						content = String.valueOf(cell1.getNumericCellValue()).trim();
					if (cell1.getCellType() == Cell.CELL_TYPE_STRING)
						content = String.valueOf(cell1.getStringCellValue()).trim();
				}
				if(c == 4){
					content = TimeUtils.dataString2dateFormat(content);
				}
				info.add(content);
				//System.out.println(content);
			}
			infos.add(info);
		}
		return infos;
	}
	
	/**
	 * 读取mooc.quokr.com.xlsx 第一个sheet的数据，并以list形式返回
	 * @param excelName
	 * @return
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 */
	public List<List<String>> readMoocQuokrComSheet1(String excelName) throws ParseException, ClassNotFoundException {
		List<List<String>> infos = null;
		
		List<Sheet> sheets = getSheet(excelName);
		for (Sheet sheet : sheets) {
			if (sheet.getSheetName().contains("Sheet1")){
				infos = getMoocQuokrComContentOfExcel1(sheet);
			}else{
				continue;
			}
		}
		return infos;
	}
	
	/**
	 * 读取mooc.quokr.com.xlsx 第二个sheet的数据，并以list形式返回
	 * @param sheet
	 * @return
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 */
	public List<List<String>> getMoocQuokrComContentOfExcel1(Sheet sheet)
			throws ParseException, ClassNotFoundException {
		
		List<List<String>> infos = null;
		
		int rowCount = sheet.getPhysicalNumberOfRows();// 行数
		//System.out.println(rowCount);
		if(rowCount > 0){
			infos = new ArrayList<List<String>>();
		}
	
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			
			List<String> info = new ArrayList<String>();
			for(int c = 0; c < 6; c++){
				
				Cell cell1 = row.getCell(c);
				String content = "";
				if (cell1 == null)
					break;
				else {
					if (cell1.getCellType() == Cell.CELL_TYPE_NUMERIC)
						content = String.valueOf(cell1.getNumericCellValue()).trim();
					if (cell1.getCellType() == Cell.CELL_TYPE_STRING)
						content = String.valueOf(cell1.getStringCellValue()).trim();
				}
				info.add(content);
				//System.out.println(content);
			}
			infos.add(info);
		}
		return infos;
	}
	
	/**
	 * 读取mooc.quokr.com.xlsx 第二个sheet的数据，并以list形式返回
	 * @param excelName
	 * @return
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 */
	public List<List<String>> readMoocQuokrComSheet2(String excelName) throws ParseException, ClassNotFoundException {
		List<List<String>> infos = null;
		
		List<Sheet> sheets = getSheet(excelName);
		for (Sheet sheet : sheets) {
			if (sheet.getSheetName().contains("Sheet2")){
				infos = getMoocQuokrComContentOfExcel2(sheet);
			}else{
				continue;
			}
		}
		return infos;
	}
	
	/**
	 * 读取mooc.quokr.com.xlsx 第二个sheet的数据，并以list形式返回
	 * @param sheet
	 * @return
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 */
	public List<List<String>> getMoocQuokrComContentOfExcel2(Sheet sheet)
			throws ParseException, ClassNotFoundException {
		
		List<List<String>> infos = null;
		
		int rowCount = sheet.getPhysicalNumberOfRows();// 行数
		//System.out.println(rowCount);
		if(rowCount > 0){
			infos = new ArrayList<List<String>>();
		}
	
		for (int i = 0; i < rowCount; i++) {
			Row row = sheet.getRow(i);
			
			List<String> info = new ArrayList<String>();
			for(int c = 0; c < 4; c++){
				
				Cell cell1 = row.getCell(c);
				String content = "";
				if (cell1 == null)
					break;
				else {
					if (cell1.getCellType() == Cell.CELL_TYPE_NUMERIC)
						content = String.valueOf(cell1.getNumericCellValue()).trim();
					if (cell1.getCellType() == Cell.CELL_TYPE_STRING)
						content = String.valueOf(cell1.getStringCellValue()).trim();
				}
				info.add(content);
				//System.out.println(content);
			}
			infos.add(info);
		}
		return infos;
	}
	
	public String getContentOfCell(Cell cell) {
		if (cell == null)
			return " ";
		String content = "";
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			content = String.valueOf(cell.getNumericCellValue());
		if (cell.getCellType() == Cell.CELL_TYPE_STRING)
			content = cell.getStringCellValue();
		if (content == "") {
			content = " ";
		}
		return content;
	}
	
	public List<Sheet> getSheet(String path) throws ParseException {
		List<Sheet> sheets = null;
		File file = null;
		InputStream input = null;
		if (path != null && path.length() > 0) {
			String suffix = path
					.substring(path.lastIndexOf("."), path.length());
			file = new File(path);
			try {
				input = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				System.out.println("未找到指定的文件！");
			}
			if (".xls".equals(suffix)) {
				//System.out.println("Excel为2003版本");
				POIFSFileSystem fileSystem = null;
				HSSFWorkbook workBook = null;// 工作簿
//				XSSFWorkbook workBook = null;
				try {
					fileSystem = new POIFSFileSystem(input);
					workBook = new HSSFWorkbook(fileSystem);
//					workBook = new XSSFWorkbook(input);
				} catch (IOException e) {
					e.printStackTrace();
				}

				sheets = new ArrayList<Sheet>();
				for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
					sheets.add(workBook.getSheetAt(i));
				}
//				for (Sheet sheet1 : sheets) {
//					System.out.println(sheet1.getSheetName());
//				}
			} else if (".xlsx".equals(suffix)) {// 2007
				//System.out.println("Excel为2007版本");
				XSSFWorkbook workBook = null;
				try {
					workBook = new XSSFWorkbook(input);
				} catch (IOException e) {
					e.printStackTrace();
				}
				sheets = new ArrayList<Sheet>();
				for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
					sheets.add(workBook.getSheetAt(i));
				}
//				for (Sheet sheet1 : sheets) {
//					System.out.println(sheet1.getSheetName());
//				}
			}
		} else {
			System.out.println("非法的文件路径!");
		}

		return sheets;
	}
}
