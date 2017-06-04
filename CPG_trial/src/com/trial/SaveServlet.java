package com.trial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int product_id= Integer.parseInt(request.getParameter("product_id"));
		String product_name=request.getParameter("product_name");
		
		String quantity=request.getParameter("quantity");
	String price=request.getParameter("price");
		
		product e=new product();
		e.setProduct_id(product_id);
		e.setProduct_name(product_name);
		e.setQuantity(quantity);
		e.setPrice(price);
		
		
		int status=productDao.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
