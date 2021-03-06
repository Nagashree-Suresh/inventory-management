package com.trial;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/userviewservlet")
public class userviewservlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//out.println("<h2><a href='index.html'>Add New Product</a></h2>");
		out.println("<h1>Product List</h1>");
		
		List<product> list=productDao.getAllProducts();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Product ID</th><th>Product Name</th><th>Product Quantity</th><th>Product Price</th></tr>");
		for(product e:list){
			out.print("<tr><td>"+e.getProduct_id()+"</td><td>"+e.getProduct_name()+"</td><td>"+e.getQuantity()+"</td><td>"+e.getPrice()+"</td><td><a href='userEditServlet?product_id="+e.getProduct_id()+"'>Click here to modify</a></td>");
		}
		
		out.print("</table>");
		
		out.close();
	}
}