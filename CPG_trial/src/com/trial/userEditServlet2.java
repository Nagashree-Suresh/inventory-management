package com.trial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/userEditServlet2")
public class userEditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("product_id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("product_name");
		//System.out.println(name);
		String quantity=request.getParameter("quantity");
		String price=request.getParameter("price");
		product e=new product();
		e.setProduct_id(id);
		e.setProduct_name(name);
		e.setQuantity(quantity);
		e.setPrice(price);
		
		int status=productDao.update(e);
		if(status>0){
			response.sendRedirect("userviewservlet");
		}else{
			out.println("Sorry! Unable to update record");
		}
		
		out.close();
	}

}