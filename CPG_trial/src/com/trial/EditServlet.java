package com.trial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Product</h1>");
		String sid=request.getParameter("product_id");
		int id=Integer.parseInt(sid);
		
		product e=productDao.getEmployeeById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td>Please modify the details as you wish!</td><td><input type='hidden' name='product_id' value='"+e.getProduct_id()+"'/></td></tr>");
		out.print("<tr><td>Product Name:</td><td><input type='text' name='product_name' value='"+e.getProduct_name()+"'/></td></tr>");
		out.print("<tr><td>Quantity:</td><td><input type='text' name='quantity' value='"+e.getQuantity()+"'/></td></tr>");
		out.print("<tr><td>Price:</td><td><input type='text' name='price' value='"+e.getPrice()+"'/></td></tr>");
		
		
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
