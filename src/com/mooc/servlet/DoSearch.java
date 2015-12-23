package com.mooc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.mooc.entity.DataEntity;

/**
 * Servlet implementation class DoSearch
 */
@WebServlet("/mooc/DoSearch")
public class DoSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doOperator(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doOperator(request, response);
	}
	
	private void doOperator(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String keyword = new String(request.getParameter("keyword").getBytes("iso-8859-1"), "UTF-8");
		HttpSession session = request.getSession(); 
		session.setAttribute("keyword",keyword);
		
		if(DataEntity.existIndustry(keyword)){
			response.sendRedirect("searchResult.jsp");
		}else if(DataEntity.existCompany(keyword)){
			response.sendRedirect("searchResultc.jsp");
		}else{
			response.sendRedirect("searchError.jsp");
		}
	}

}
