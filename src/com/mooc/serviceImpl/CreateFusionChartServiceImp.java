package com.mooc.serviceImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.UUID;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import com.mooc.utils.FileUtils;


public class CreateFusionChartServiceImp {
	
	private static final String chartDataDir = "data";   //web项目下的临时目录
	
	//private static final String[] COLORS = {"fe5200","00479d","6e5aab","54cbec","ed1b23","8BBA00"};
	//										纯黄			中蓝色		纯绿		紫色
	private static final String[] COLORS = {"FFFF00","0000CD","008000","800080","ed1b23","8BBA00"};
	private static final String[] ANCHORSIDES = {"3","4","5","6","7","8"};
	private static final String outCnvbaseFontSize = "12";
	private static final String baseFontSize = "9";
	
	//图表右外边距 
	private static final String chartRightMargin = "50";
	//设置基线
	private static int baseLine = 70;
	
	
	public static String getUUID( ) throws Exception {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().toUpperCase();		
	}
	
	public static String getWebRootFullPath() {

		String path = CreateFusionChartServiceImp.class.getClassLoader().getResource("/").getPath();
		//System.out.println(path);
		
		int pos = path.indexOf("/WEB-INF/classes");
		if (pos>0){
			path = path.substring(0, pos);
			//System.out.println(path);
		}
		
		
		path = FileUtils.xmlDataPath;
		
		
		return path;

	}
	
	public static String getFileShortName(String fullName){
		
		String shortName = fullName.substring(fullName.lastIndexOf(File.separatorChar) + 1);
		shortName = shortName.substring(shortName.lastIndexOf("/") + 1);
		return shortName;
	}

	
	public static String getTempFileName() throws Exception{
		 	String prefix = "fusionChart-" + CreateFusionChartServiceImp.getUUID();
	        String suffix = ".xml";
	        
	        /*
	        HttpDoradoContext context = (HttpDoradoContext) DoradoContext.getContext();
			HttpServletRequest request = context.getRequest();
			if (request == null) {
				throw new NullPointerException("request参数不能为空。");
			}
			HttpSession session = request.getSession();
			String path = session.getServletContext().getRealPath("/" + chartDataDir + "/");
			*/
	        
			String path = getWebRootFullPath()  + chartDataDir + "\\";
			String tempFileName = path + prefix + suffix;
			
			return tempFileName;
	}
	
	
	public static void writeDocToXML(Document Doc, String fullFileName) throws IOException{
		   FileOutputStream fileStream = new FileOutputStream(fullFileName);
	        
	        XMLOutputter XMLOut = new XMLOutputter();
	        
	        XMLOut.setOmitEncoding(true);
	        XMLOut.setOmitDeclaration(true);
	        XMLOut.setEncoding("utf-8");
	        XMLOut.setNewlines(true);
	        XMLOut.setIndent(true);
	        
	        /*
	        Format format = Format.getPrettyFormat(); // 格式化文档
	        format.setEncoding("GBK"); // 由于默认的编码是utf-8,中文将显示为乱码，所以设为cubic 
	        XMLOut.setFormat(format);
	        */
	        /*
	        byte[] utf8Bom =  new byte[]{(byte) 0xef, (byte) 0xbb, (byte) 0xbf};  
	        String utf8BomStr = new String(utf8Bom,"UTF-8");  
	        XMLOut.output(utf8BomStr, fileStream);
	        */
	        
	        Writer foutw = new BufferedWriter(new OutputStreamWriter(fileStream, "UTF-8"));
	        fileStream.write(new byte[]{(byte)0xEF, (byte)0xBB, (byte)0xBF});
	        
	        if (Doc!=null) 
	        	XMLOut.output(Doc, fileStream);
	        fileStream.close();
	}
	
	/*****创建普通bar / line：参考数据集例子结构Bar2D.xml 或Column2D.xml 或line2D.xml*********/
	public static String BuildXMLDocOfBarOrLineFromDs(String caption, String subcaption, String xAxisName, String yAxisName, String[] columnKeys, double[] data) throws Exception{
		
		// 创建根节点 list;
        Element root = new Element("chart");
        root.setAttribute("caption", caption);
        root.setAttribute("subcaption",subcaption);
        
        root.setAttribute("xAxisName", xAxisName);
        root.setAttribute("yAxisName", yAxisName);
        root.setAttribute("rotateYAxisName", "1");
        
        root.setAttribute("showNames", "1");
        root.setAttribute("decimalPrecision", "0");
        root.setAttribute("formatNumberScale", "0");
        
        root.setAttribute("outCnvbaseFontSize", outCnvbaseFontSize);
        root.setAttribute("baseFontSize", baseFontSize);
        
        Document Doc = new Document(root);
        
        	
    	for (int i=0; i < columnKeys.length; i++){
    		Element point = new Element("set");
    		point.setAttribute("name",columnKeys[i]);
    		point.setAttribute("value",String.valueOf(data[i]));
    		
    		root.addContent(point);	
    	}
    	
    	String fullFileName = getTempFileName();
    	writeDocToXML(Doc, fullFileName);
      
        return getFileShortName(fullFileName);
		
	}
	
	/*****创建Multi Series Bar：参考数据集例子结构MSColumn2D.xml *********/
	//不同的bar并列
	public static String BuildXMLDocOfMsBarFromDs(String caption, String subcaption,String xAxisName, String yAxisName, String[] columnKeys, String[] rowKeys,
            double[][] data) throws Exception{
		
		// 创建根节点 list;
        Element root = new Element("chart");
        root.setAttribute("caption", caption);
        root.setAttribute("subcaption",subcaption);
        
        root.setAttribute("xAxisName", xAxisName);
        root.setAttribute("yAxisName", yAxisName);
        root.setAttribute("rotateYAxisName", "1");

        root.setAttribute("showNames", "1");
        root.setAttribute("decimalPrecision", "4");
        //root.setAttribute("formatNumberScale", "0");
        
        root.setAttribute("outCnvbaseFontSize", outCnvbaseFontSize);
        root.setAttribute("baseFontSize", baseFontSize);
        
        Document Doc = new Document(root);
        
        if (data==null){
	        String fullFileName = getTempFileName();
	        writeDocToXML(Doc, fullFileName);
	      
	        return getFileShortName(fullFileName);
        }
        
        //创建节点categories及其子节点(横轴上的列)
        Element categories = new Element("categories");
        for (int i=0; i < columnKeys.length; i++){
        	Element category = new Element("category");
        	category.setAttribute("name",columnKeys[i]);
        	categories.addContent(category);
        }
        
        root.addContent(categories);
        
        
        //创建数据系列：在每个系列serie上，为不同的category赋值
        for (int j=0; j < rowKeys.length; j++){
        	
        	//创建系列
        	Element serie = new Element("dataset");
        	serie.setAttribute("seriesName", rowKeys[j]);
        	serie.setAttribute("color", COLORS[j % COLORS.length]);
        	
        	for (int i=0; i < columnKeys.length; i++){
        		Element point = new Element("set");
        		point.setAttribute("value",String.valueOf(data[j][i]));
        		serie.addContent(point);
        	}
        	
        	root.addContent(serie);
        	
        }

        String fullFileName = getTempFileName();
        writeDocToXML(Doc, fullFileName);
      
        return getFileShortName(fullFileName);
		
	}
	
	
	/*****创建StackBar：参考数据集例子结构StCol2D.xml，与Multi Series Bar类似*********/
	//不同的bar堆积
	public static String BuildXMLDocOfStackBarFromDs(String caption, String subcaption, String xAxisName, String yAxisName, String[] columnKeys, String[] rowKeys,
            double[][] data) throws Exception{
		
		// 创建根节点 list;
        Element root = new Element("chart");
        root.setAttribute("caption", caption);
        root.setAttribute("subcaption",subcaption);
        
        root.setAttribute("xAxisName", xAxisName);
        root.setAttribute("yAxisName", yAxisName);
        root.setAttribute("rotateYAxisName", "1");

        root.setAttribute("showNames", "1");
        root.setAttribute("decimalPrecision", "0");
        root.setAttribute("formatNumberScale", "0");
        
        root.setAttribute("outCnvbaseFontSize", outCnvbaseFontSize);
        root.setAttribute("baseFontSize", baseFontSize);
        
        Document Doc = new Document(root);
        
        if (data==null){
	        String fullFileName = getTempFileName();
	        writeDocToXML(Doc, fullFileName);
	      
	        return getFileShortName(fullFileName);
        }
        
        //创建节点categories及其子节点(横轴上的列)
        Element categories = new Element("categories");
        for (int i=0; i < columnKeys.length; i++){
        	Element category = new Element("category");
        	category.setAttribute("name",columnKeys[i]);
        	categories.addContent(category);
        }
        
        root.addContent(categories);
        
        
        //创建数据系列：在每个系列serie上，为不同的category赋值
        for (int j=0; j < rowKeys.length; j++){
        	
        	//创建系列
        	Element serie = new Element("dataset");
        	serie.setAttribute("seriesName", rowKeys[j]);
        	serie.setAttribute("color", COLORS[j % COLORS.length]);
        	
        	for (int i=0; i < columnKeys.length; i++){
        		Element point = new Element("set");
        		point.setAttribute("value",String.valueOf(data[j][i]));
        		serie.addContent(point);
        	}
        	
        	root.addContent(serie);
        	
        }

        String fullFileName = getTempFileName();
        writeDocToXML(Doc, fullFileName);
      
        return getFileShortName(fullFileName);
	}
	


	/*****创建Multi Series Line：参考数据集例子结构MSLine.xml，与Multi Series Bar类似 *********/
	public static String BuildXMLDocOfMsLineFromDs(String caption, String subcaption, String xAxisName, String yAxisName, String[] columnKeys, String[] rowKeys,
            double[][] data) throws Exception{
		
		// 创建根节点 list;
        Element root = new Element("chart");
        root.setAttribute("caption", caption);
        root.setAttribute("subcaption",subcaption);
        
        root.setAttribute("xAxisName", xAxisName);
        root.setAttribute("yAxisName", yAxisName);
        root.setAttribute("rotatePYAxisName", "0");
        	
        root.setAttribute("showValues", "0");
        root.setAttribute("showNames", "1");
        root.setAttribute("decimalPrecision", "4");
        root.setAttribute("formatNumberScale", "1");
        
        root.setAttribute("outCnvbaseFontSize", outCnvbaseFontSize);
        root.setAttribute("baseFontSize", baseFontSize);
        //图表右外边距
       // root.setAttribute("chartRightMargin", chartRightMargin);
        //root.setAttribute("canvasPadding", "10");
        //root.setAttribute("canvasLeftMargin","40");
        root.setAttribute("canvasRightMargin","83");
        //root.setAttribute("legendPosition","RIGHT");
        
        
        root.setAttribute("anchorSides", "10");
        root.setAttribute("anchorRadius", "3");
        root.setAttribute("anchorBorderColor", "009900");
        root.setAttribute("anchorAlpha", "100");
        root.setAttribute("anchorBgAlpha", "50");
        root.setAttribute("numdivlines", "9");
        root.setAttribute("lineThickness", "2");
        root.setAttribute("numVDivLines", "20");
        
       // root.setAttribute("labelDisplay", "Stagger");
        //root.setAttribute("slantLabels", "1");
        //root.setAttribute("labelStep", "2");
        root.setAttribute("showAlternateVGridColor", "1");
        
        root.setAttribute("animation", "1");
        root.setAttribute("limitsDecimalPrecision", "0");
        root.setAttribute("divLineDecimalPrecision", "1");
        
        //设置y轴最大最小值
        root.setAttribute("yAxisMinValue", "0");
        root.setAttribute("yAxisMaxValue", "100");
        
        //设置基线
        Element trendlines = new Element("trendlines");
        Element line = new Element("line");
        line.setAttribute("startValue", String.valueOf(baseLine));
        line.setAttribute("displayValue", "");
        line.setAttribute("color", "ff0000");
        line.setAttribute("valueOnRight", "0");
        trendlines.addContent(line);
        root.addContent(trendlines);
        

        Document Doc = new Document(root);
        
        if (data==null){
	        String fullFileName = getTempFileName();
	        writeDocToXML(Doc, fullFileName);
	      
	        return getFileShortName(fullFileName);
        }

        
        //创建节点categories及其子节点(横轴上的列)
        Element categories = new Element("categories");
        for (int i=0; i < columnKeys.length; i++){
        	Element category = new Element("category");
        	//对于详细时间 进行截取
        	//System.out.println(columnKeys[i]);
        	String time = columnKeys[i];
        	if(time.contains("-")){
        		time = time.substring(time.indexOf("-")+1, time.length());
        	}
        	if(time.contains(":")){
        		time = time.substring(0,time.lastIndexOf(":"));
        		//System.out.println(time);
        	}
        	category.setAttribute("name",time);
        	//category.setAttribute("name",columnKeys[i]);
        	categories.addContent(category);
        }
        
        root.addContent(categories);
        
        
        //创建数据系列：在每个系列serie上，为不同的category赋值
        for (int j=0; j < rowKeys.length; j++){
        	
        	//创建系列
        	Element serie = new Element("dataset");
        	serie.setAttribute("seriesName", rowKeys[j]);
        	serie.setAttribute("color", COLORS[j % COLORS.length]);
        	
        	for (int i=0; i < columnKeys.length; i++){
        		Element point = new Element("set");
        		point.setAttribute("value",String.valueOf(data[j][i]));
        		//如果小于基线 则显示链接
//        		if(data[j][i] < baseLine){
//        			point.setAttribute("link", "n-./detailShow.jsp?ispName=" + rowKeys[j]);
//        		}
        		
        		serie.addContent(point);
        	}
        	
        	root.addContent(serie);
        	
        }

        String fullFileName = getTempFileName();
        writeDocToXML(Doc, fullFileName);
      
        return getFileShortName(fullFileName);
		
	}
	
	/*****创建Multi Series Line：参考数据集例子结构MSLine.xml，与Multi Series Bar类似 *********/
	public static String BuildXMLDocOfMsLineFromDsShow(String caption, String subcaption, String xAxisName, String yAxisName, String[] columnKeys, String[] rowKeys,
            double[][] data) throws Exception{
		
		// 创建根节点 list;
        Element root = new Element("chart");
        root.setAttribute("caption", caption);
        root.setAttribute("subcaption",subcaption);
        
        root.setAttribute("xAxisName", xAxisName);
        root.setAttribute("yAxisName", yAxisName);
        root.setAttribute("rotatePYAxisName", "0");
        	
        root.setAttribute("showValues", "0");
        root.setAttribute("showNames", "1");
        root.setAttribute("decimalPrecision", "4");
        root.setAttribute("formatNumberScale", "1");
        
        root.setAttribute("outCnvbaseFontSize", outCnvbaseFontSize);
        root.setAttribute("baseFontSize", baseFontSize);
        //图表右外边距
       // root.setAttribute("chartRightMargin", chartRightMargin);
        //root.setAttribute("canvasPadding", "10");
        //root.setAttribute("canvasLeftMargin","40");
        root.setAttribute("canvasRightMargin","83");
        //root.setAttribute("legendPosition","RIGHT");
        
        
        root.setAttribute("anchorSides", "10");
        root.setAttribute("anchorRadius", "3");
        root.setAttribute("anchorBorderColor", "009900");
        root.setAttribute("anchorAlpha", "100");
        root.setAttribute("anchorBgAlpha", "50");
        root.setAttribute("numdivlines", "9");
        root.setAttribute("lineThickness", "2");
        root.setAttribute("numVDivLines", "20");
        
       // root.setAttribute("labelDisplay", "Stagger");
        //root.setAttribute("slantLabels", "1");
        //root.setAttribute("labelStep", "2");
        root.setAttribute("showAlternateVGridColor", "1");
        
        root.setAttribute("animation", "1");
        root.setAttribute("limitsDecimalPrecision", "0");
        root.setAttribute("divLineDecimalPrecision", "1");
        
        //设置y轴最大最小值
        root.setAttribute("yAxisMinValue", "0");
        root.setAttribute("yAxisMaxValue", "10");
        
        //设置基线
//        Element trendlines = new Element("trendlines");
//        Element line = new Element("line");
//        line.setAttribute("startValue", String.valueOf(baseLine));
//        line.setAttribute("displayValue", "");
//        line.setAttribute("color", "ff0000");
//        line.setAttribute("valueOnRight", "0");
//        trendlines.addContent(line);
//        root.addContent(trendlines);
        

        Document Doc = new Document(root);
        
        if (data==null){
	        String fullFileName = getTempFileName();
	        writeDocToXML(Doc, fullFileName);
	      
	        return getFileShortName(fullFileName);
        }

        
        //创建节点categories及其子节点(横轴上的列)
        Element categories = new Element("categories");
        for (int i=0; i < columnKeys.length; i++){
        	Element category = new Element("category");
        	//对于详细时间 进行截取
        	//System.out.println(columnKeys[i]);
        	String time = columnKeys[i];
        	if(time.contains("-")){
        		time = time.substring(time.indexOf("-")+1, time.length());
        	}
        	if(time.contains(":")){
        		time = time.substring(0,time.lastIndexOf(":"));
        		//System.out.println(time);
        	}
        	category.setAttribute("name",time);
        	//category.setAttribute("name",columnKeys[i]);
        	categories.addContent(category);
        }
        
        root.addContent(categories);
        
        
        //创建数据系列：在每个系列serie上，为不同的category赋值
        for (int j=0; j < rowKeys.length; j++){
        	
        	//创建系列
        	Element serie = new Element("dataset");
        	serie.setAttribute("seriesName", rowKeys[j]);
        	serie.setAttribute("color", COLORS[j % COLORS.length]);
        	
        	for (int i=0; i < columnKeys.length; i++){
        		Element point = new Element("set");
        		point.setAttribute("value",String.valueOf(data[j][i]));
        		
        		serie.addContent(point);
        	}
        	
        	root.addContent(serie);
        	
        }

        String fullFileName = getTempFileName();
        writeDocToXML(Doc, fullFileName);
      
        return getFileShortName(fullFileName);
		
	}
	
	/*****创建Column2D *********/
	public static String BuildXMLDocOfColumn2DFromDs(String caption, String subcaption,
														String xAxisName, String yAxisName, 
														String[] columnKeys, String[] data)
																throws Exception{
		
		// 创建根节点 list;
        Element root = new Element("chart");
        root.setAttribute("caption", caption);
        root.setAttribute("subcaption",subcaption);
        
        root.setAttribute("xAxisName", xAxisName);
        root.setAttribute("yAxisName", yAxisName);
        root.setAttribute("baseFont", "宋体");
        root.setAttribute("baseFontSize", "12");
        root.setAttribute("bgColor", "ffffff,ffffff");
        	
        root.setAttribute("showValues", "1");
        root.setAttribute("showBorder", "0");
        root.setAttribute("useRoundEdges", "1");
//        root.setAttribute("showNames", "1");
//        root.setAttribute("decimalPrecision", "4");
//        root.setAttribute("formatNumberScale", "1");
        
//        root.setAttribute("outCnvbaseFontSize", outCnvbaseFontSize);
//        root.setAttribute("baseFontSize", baseFontSize);
        //图表右外边距
       // root.setAttribute("chartRightMargin", chartRightMargin);
        //root.setAttribute("canvasPadding", "10");
        //root.setAttribute("canvasLeftMargin","40");
        //root.setAttribute("canvasRightMargin","83");
        //root.setAttribute("legendPosition","RIGHT");
        
        
//        root.setAttribute("anchorSides", "10");
//        root.setAttribute("anchorRadius", "3");
//        root.setAttribute("anchorBorderColor", "009900");
//        root.setAttribute("anchorAlpha", "100");
//        root.setAttribute("anchorBgAlpha", "50");
//        root.setAttribute("numdivlines", "9");
//        root.setAttribute("lineThickness", "2");
//        root.setAttribute("numVDivLines", "20");
        
       // root.setAttribute("labelDisplay", "Stagger");
        //root.setAttribute("slantLabels", "1");
        //root.setAttribute("labelStep", "2");
//        root.setAttribute("showAlternateVGridColor", "1");
        
//        root.setAttribute("animation", "1");
//        root.setAttribute("limitsDecimalPrecision", "0");
//        root.setAttribute("divLineDecimalPrecision", "1");
        
        //设置y轴最大最小值
        root.setAttribute("yAxisMinValue", "0");
        root.setAttribute("yAxisMaxValue", "10");
        
        //设置基线
//        Element trendlines = new Element("trendlines");
//        Element line = new Element("line");
//        line.setAttribute("startValue", "70");
//        line.setAttribute("displayValue", "");
//        line.setAttribute("color", "ff0000");
//        line.setAttribute("valueOnRight", "0");
//        trendlines.addContent(line);
//        root.addContent(trendlines);
        

        Document Doc = new Document(root);
        
        if (data==null){
	        String fullFileName = getTempFileName();
	        writeDocToXML(Doc, fullFileName);
	      
	        return getFileShortName(fullFileName);
        }

        
        //创建节点
        
        for (int i=0; i < data.length; i++){
        	Element set = new Element("set");
        	
        	set.setAttribute("label",columnKeys[i]);
        	set.setAttribute("value", String.valueOf(data[i]));
        	root.addContent(set);
        }
        
        String fullFileName = getTempFileName();
        writeDocToXML(Doc, fullFileName);
      
        return getFileShortName(fullFileName);
		
	}
	
	/*****创建Pie2D *********/
	public static String BuildXMLDocOfPie2DFromDs(String caption, String subcaption,
														 
														String[] columnKeys, double[] data)
																throws Exception{
		
		// 创建根节点 list;
        Element root = new Element("chart");
        root.setAttribute("caption", caption);
        root.setAttribute("subcaption",subcaption);
        
//        root.setAttribute("xAxisName", xAxisName);
//        root.setAttribute("yAxisName", yAxisName);
        root.setAttribute("baseFont", "宋体");
        root.setAttribute("baseFontSize", "18");
        root.setAttribute("bgColor", "ffffff,ffffff");
        	
        root.setAttribute("showValues", "1");
        root.setAttribute("showLabels", "1");
        root.setAttribute("showLengend", "1");
        root.setAttribute("showPercentValues", "1");
        root.setAttribute("showPercentInLabel", "1");
//        root.setAttribute("showNames", "1");
//        root.setAttribute("decimalPrecision", "4");
//        root.setAttribute("formatNumberScale", "1");
        
//        root.setAttribute("outCnvbaseFontSize", outCnvbaseFontSize);
//        root.setAttribute("baseFontSize", baseFontSize);
        //图表右外边距
       // root.setAttribute("chartRightMargin", chartRightMargin);
        //root.setAttribute("canvasPadding", "10");
        //root.setAttribute("canvasLeftMargin","40");
        //root.setAttribute("canvasRightMargin","83");
        //root.setAttribute("legendPosition","RIGHT");
        
        
//        root.setAttribute("anchorSides", "10");
//        root.setAttribute("anchorRadius", "3");
//        root.setAttribute("anchorBorderColor", "009900");
//        root.setAttribute("anchorAlpha", "100");
//        root.setAttribute("anchorBgAlpha", "50");
//        root.setAttribute("numdivlines", "9");
//        root.setAttribute("lineThickness", "2");
//        root.setAttribute("numVDivLines", "20");
        
       // root.setAttribute("labelDisplay", "Stagger");
        //root.setAttribute("slantLabels", "1");
        //root.setAttribute("labelStep", "2");
//        root.setAttribute("showAlternateVGridColor", "1");
        
//        root.setAttribute("animation", "1");
//        root.setAttribute("limitsDecimalPrecision", "0");
//        root.setAttribute("divLineDecimalPrecision", "1");
        
        //设置y轴最大最小值
//        root.setAttribute("yAxisMinValue", "0");
//        root.setAttribute("yAxisMaxValue", "10");
        
        //设置基线
//        Element trendlines = new Element("trendlines");
//        Element line = new Element("line");
//        line.setAttribute("startValue", "70");
//        line.setAttribute("displayValue", "");
//        line.setAttribute("color", "ff0000");
//        line.setAttribute("valueOnRight", "0");
//        trendlines.addContent(line);
//        root.addContent(trendlines);
        

        Document Doc = new Document(root);
        
        if (data==null){
	        String fullFileName = getTempFileName();
	        writeDocToXML(Doc, fullFileName);
	      
	        return getFileShortName(fullFileName);
        }

        
        //创建节点
        
        for (int i=0; i < data.length; i++){
        	Element set = new Element("set");
        	
        	set.setAttribute("label",columnKeys[i]);
        	set.setAttribute("value", String.valueOf(data[i]));
        	set.setAttribute("color", COLORS[i % COLORS.length]);
        	root.addContent(set);
        }
        
        String fullFileName = getTempFileName();
        writeDocToXML(Doc, fullFileName);
      
        return getFileShortName(fullFileName);
		
	}
	
	/*****创建Multi Series 组合图：参考数据集例子结构Col2DLineDY *********/
	public static String BuildXMLDocOfCombBarAndLineFromDs(String caption, String subcaption, String xAxisName, String PrimaryYAxisName, String SecondYAxisName,String[] columnKeys, String[] PrimaryRowKeys, 
            double[][] PrimaryData,String[] SecondRowKeys, double[][] SecondData) throws Exception{
		
		
		
		// 创建根节点 list;
        Element root = new Element("chart");
        root.setAttribute("caption", caption);
        root.setAttribute("subcaption",subcaption);
        
        root.setAttribute("xAxisName", xAxisName);
        root.setAttribute("PYAxisName", PrimaryYAxisName); //主纵轴名称
        root.setAttribute("SYAxisName", SecondYAxisName); //从纵轴名称
        root.setAttribute("rotateYAxisName", "1");
        root.setAttribute("rotatePYAxisName", "0");
        root.setAttribute("rotateSYAxisName", "1");
        root.setAttribute("showNames", "1");
        root.setAttribute("showValues", "0");
        root.setAttribute("decimalPrecision", "4");
        root.setAttribute("formatNumberScale", "0");

        root.setAttribute("anchorSides", "10");
        root.setAttribute("anchorRadius", "3");
        root.setAttribute("anchorBorderColor", "009900");
        	
        root.setAttribute("outCnvbaseFontSize", outCnvbaseFontSize);
        root.setAttribute("baseFontSize", baseFontSize);
        	
        Document Doc = new Document(root);
        
        if (PrimaryData==null || SecondData==null){
	        String fullFileName = getTempFileName();
	        writeDocToXML(null, fullFileName);
	      
	        return getFileShortName(fullFileName);
        }

        
        
        //创建节点categories及其子节点(横轴上的列)
        Element categories = new Element("categories");
        for (int i=0; i < columnKeys.length; i++){
        	Element category = new Element("category");
        	category.setAttribute("name",columnKeys[i]);
        	categories.addContent(category);
        }
        
        root.addContent(categories);
        
        
        //创建主数据系列MultiColumn：在每个系列serie上，为不同的category赋值
        for (int j=0; j < PrimaryRowKeys.length; j++){
        	
        	//创建系列
        	Element serie = new Element("dataset");
        	serie.setAttribute("seriesName", PrimaryRowKeys[j]);
        	serie.setAttribute("showValues", "0");
        	serie.setAttribute("color", COLORS[j % COLORS.length]);
        	
        	for (int i=0; i < columnKeys.length; i++){
        		Element point = new Element("set");
        		point.setAttribute("value",String.valueOf(PrimaryData[j][i]));
        		serie.addContent(point);
        	}
        	
        	root.addContent(serie);
        	
        }

        //创建从数据系列MultiLine：在每个系列serie上，为不同的category赋值
        for (int j=0; j < SecondRowKeys.length; j++){
        	
        	//创建系列
        	Element serie = new Element("dataset");
        	serie.setAttribute("seriesName", SecondRowKeys[j]);
        	serie.setAttribute("showValues", "0");
        	serie.setAttribute("parentYAxis", "S"); //设置为从总坐标
        	serie.setAttribute("color", COLORS[j % COLORS.length]);
        	
        	 
        	serie.setAttribute("drawAnchors", "true");
        	serie.setAttribute("anchorSides", ANCHORSIDES[j % ANCHORSIDES.length]);
        	serie.setAttribute("anchorRadius", "3");
        	
        	
        	for (int i=0; i < columnKeys.length; i++){
        		Element point = new Element("set");
        		point.setAttribute("value",String.valueOf(SecondData[j][i]));
        		serie.addContent(point);
        	}
        	
        	root.addContent(serie);
        	
        }
        
        String fullFileName = getTempFileName();
        writeDocToXML(Doc, fullFileName);
      
        return getFileShortName(fullFileName);
		
	}
}
