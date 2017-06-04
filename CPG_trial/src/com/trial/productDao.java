package com.trial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class productDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(product e){
		int status=0;
		try{
			Connection con=productDao.getConnection();
			System.out.println(con);
			PreparedStatement ps=con.prepareStatement("insert into product(product_id,product_name,quantity,price) values (?,?,?,?)");
			
			ps.setInt(1,e.getProduct_id());
			ps.setString(2,e.getProduct_name());
			ps.setString(3,e.getQuantity());
			ps.setString(4,e.getPrice());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static product getEmployeeById(int product_id){
		product e=new product();
		
		try{
			Connection con=productDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from product where product_id=?");
			ps.setInt(1,product_id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				e.setProduct_id(( rs.getInt(1)));
				e.setProduct_name((rs.getString(2)));
				e.setQuantity(rs.getString(3));
				e.setPrice(rs.getString(4));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<product> getAllProducts(){
		List<product> list=new ArrayList<product>();
		
		try{
			Connection con=productDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from product");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				product e=new product();
				
				e.setProduct_id(( rs.getInt(1)));
				e.setProduct_name((rs.getString(2)));
				e.setQuantity(rs.getString(3));
				e.setPrice(rs.getString(4));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
	
	
	public static int update(product e){
		int status=0;
		try{
			Connection con=productDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update product set product_name=?,quantity=?,price=? where product_id=?");
			ps.setString(1,e.getProduct_name());
			ps.setString(2,e.getQuantity());
			ps.setString(3,e.getPrice());
			ps.setInt(4,e.getProduct_id());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=productDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from product where product_id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
}
