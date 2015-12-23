package com.mooc.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.mooc.servlet.ChartData;

public class FileUtils {
	
	public static String eclipsePath = ChartData.class.getResource("").getPath().substring(1) + "../../../../../";
//	public static String tomcatPath = new File("").getAbsolutePath().replace("bin", "") + "\\webapps\\Mooc\\";
	

	//Eclipse 路径
	public static String xmlDataPath = eclipsePath + "mooc/";
	//tomcat 路径
//	public static String xmlDataPath = tomcatPath + "mooc\\";
	
	//Eclipse 路径
	public static String sourceDataPath = eclipsePath + "mooc/sourceExcelData/";
	//tomcat 路径
//	public static String sourceDataPath = tomcatPath + "sourceExcelData\\";
	
	
	
	public static boolean isFileExisted(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}

	public static List<String> readFileByLines(String fileName) {
		List<String> results = new ArrayList<String>();
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				results.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}

		return results;
	}

	public static void writeFileRecords(String fileName, List<String> recodes) {
		try {
			File file = new File(fileName);
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			for (String recode : recodes) {
				out.write(recode);
				out.newLine();
			}
			out.close();
			out = null;
			file = null;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}