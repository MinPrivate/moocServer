package com.mooc.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mooc.service.WriterChartXml;

/**
 * Servlet implementation class ChartData
 */
@WebServlet("/ChartData")
public class ChartData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doOperation(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doOperation(request, response);
	}

	protected void doOperation(HttpServletRequest request, HttpServletResponse response){
		
		String part = (String)request.getParameter("part");
		String item = (String)request.getParameter("item");
		if(part.equals("init")){
			if(item.equals("all")){
				String sChartNamePie = null;
				String sChartName = null;
				String sChartNameComment = null;
				try {
					//饼状图
					sChartNamePie = WriterChartXml.writeHangyePieXml();
					//课程对比柱状图
					sChartName = WriterChartXml.writeVideoNumXml();
					//客户参与曲线
					sChartNameComment = WriterChartXml.writeClientCommentXml();
					//sChartNameComment = WriterChartXml.writeSinaNewsXml();
					
					if (sChartName==null || sChartName.equals(""))
						sChartName = "videonum.xml";
		
			        String url = "/mooc/dataFirstSuccess.jsp"
			        				+ "?sChartName=" + sChartName
			        				+ "&sChartNameComment=" + sChartNameComment
			        				+ "&sChartNamePie=" + sChartNamePie;
			        
			        response.setCharacterEncoding("UTF-8");
			        
			        response.sendRedirect(request.getContextPath() + url);
			        
				} catch (IOException | ClassNotFoundException | ParseException e) {
					e.printStackTrace();
				}
			}else if(item.equals("hyresult")){
				
				String sChartNameComment = null;
				String sChartNamesina = null;
				String sChartNameGuimo = null;
				String sChartNameMarketDis = null;
				String sChartNamePeopleAgeDis = null;
				String sChartNamePeopleSexDis = null;
				try {
					//客户参与度
					sChartNameComment = WriterChartXml.writeClientCommentXml();
					//新浪指数
					sChartNamesina = WriterChartXml.writeSinaNewsXml();
					//行业规模
					sChartNameGuimo = WriterChartXml.writeHangyeUserScaleXml();
					//市场分布
					sChartNameMarketDis = WriterChartXml.writeHangyePieXml();
					//人群年龄分布
					sChartNamePeopleAgeDis = WriterChartXml.writeHangyeAgeDisXml();
					//人群性别分布
					sChartNamePeopleSexDis = WriterChartXml.writeHangyePieSexXml();
					
			        String url = "/mooc/dataResultFirstSuccess.jsp"
			        				+ "?sChartNameComment=" + sChartNameComment
			        				+ "&sChartNamesina=" + sChartNamesina
			        				+ "&sChartNameGuimo=" + sChartNameGuimo
			        				+ "&sChartNameMarketDis=" + sChartNameMarketDis
			        				+ "&sChartNamePeopleAgeDis=" + sChartNamePeopleAgeDis
			        				+ "&sChartNamePeopleSexDis=" + sChartNamePeopleSexDis;
			        
			        response.setCharacterEncoding("UTF-8");
			        
			        response.sendRedirect(request.getContextPath() + url);
			        
				} catch (IOException | ClassNotFoundException | ParseException e) {
					e.printStackTrace();
				}
			}else if(item.equals("gsresult")){
				
				String sChartNameComment = null;
				String sChartNamesina = null;
				String sChartNameCouseNum = null;
				
				try {
					//客户参与度
					sChartNameComment = WriterChartXml.writeClientCommentXml();
					//新浪指数
					sChartNamesina = WriterChartXml.writeSinaNewsXml();
					//课程对比柱状图
					sChartNameCouseNum = WriterChartXml.writeVideoNumXml();
					
			        String url = "/mooc/dataResultcFirstSuccess.jsp"
			        				+ "?sChartNameComment=" + sChartNameComment
			        				+ "&sChartNamesina=" + sChartNamesina
			        				+ "&sChartNameCouseNum=" + sChartNameCouseNum;
			        				
			        
			        response.setCharacterEncoding("UTF-8");
			        
			        response.sendRedirect(request.getContextPath() + url);
			        
				} catch (IOException | ClassNotFoundException | ParseException e) {
					e.printStackTrace();
				}
			}
		}else if(part.equals("couse")){
			String sChartName = null;
			try {
				if(item.equals("cn")){
					sChartName = WriterChartXml.writeVideoNumXml();
				}else if(item.equals("cl")){
					sChartName = WriterChartXml.writeVideoScanNumXml();
				}else if(item.equals("cp")){
					sChartName = WriterChartXml.writeVideoCommentXml();
				}
			} catch (ClassNotFoundException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//返回
			try {
				
				if (sChartName==null || sChartName.equals(""))
					sChartName = "videonum.xml";
	
		        String url = "/mooc/dataCouseSuccess.jsp"
		        				+ "?sChartName=" + sChartName;
		        
		        response.setCharacterEncoding("UTF-8");
		        
		        response.sendRedirect(request.getContextPath() + url);
		        
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(part.equals("client")){
			String sChartNameComment = null;
			try {
				if(item.equals("client")){
					//客户参与曲线
					sChartNameComment = WriterChartXml.writeClientCommentXml();
				}else if(item.equals("sina")){
					sChartNameComment = WriterChartXml.writeSinaNewsXml();
				}else if(item.equals("sohu")){
					sChartNameComment = WriterChartXml.writeSohuNewsXml();
				}
				
				
		        String url = "/mooc/dataClientSuccess.jsp"
		        				+ "?sChartNameComment=" + sChartNameComment;
		        
		        response.setCharacterEncoding("UTF-8");
		        
		        response.sendRedirect(request.getContextPath() + url);
		        
			} catch (IOException | ClassNotFoundException | ParseException e) {
				e.printStackTrace();
			}
		}else if(part.equals("guimo")){
			String sChartName = null;
			try {
				if(item.equals("userGuimo")){
					//行业用户规模
					sChartName = WriterChartXml.writeHangyeUserScaleXml();
				}else if(item.equals("marketGuimo")){
					//行业市场规模规模
					sChartName = WriterChartXml.writeHangyeMarketScaleXml();
				}
				
				
		        String url = "/mooc/dataGuimoSuccess.jsp"
		        				+ "?sChartName=" + sChartName;
		        
		        response.setCharacterEncoding("UTF-8");
		        
		        response.sendRedirect(request.getContextPath() + url);
		        
			} catch (IOException | ClassNotFoundException | ParseException e) {
				e.printStackTrace();
			}
		}
		
	}
}
