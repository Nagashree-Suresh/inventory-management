package com.trial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/userEditServlet")
public class userEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Product</h1>");
		String sid=request.getParameter("product_id");
		int id=Integer.parseInt(sid);
		
		product e=productDao.getEmployeeById(id);
		out.print("Note: Users are allowed to modify the quantity. Please contact administrator for other modifications");
		out.println("<br>");
		out.print("<form action='userEditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td><input type='hidden' name='product_id' value='"+e.getProduct_id()+"'/></td></tr>");
		out.print("<tr><td>Product Name:</td><td><input type='text' name='product_name' value='"+e.getProduct_name()+"' readonly ></td></tr>");
		out.print("<tr><td>Quantity:</td><td><input type='number' name='quantity' value='"+e.getQuantity()+"' min='1'/></td></tr>");
		out.print("<tr><td>Price:</td><td><input type='number' name='price' value='"+e.getPrice()+"' readonly/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.close();
	}
}