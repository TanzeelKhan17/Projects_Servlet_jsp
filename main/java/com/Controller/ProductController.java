package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cnp.Dao.CouponDao_Impl;
import com.cnp.Dao.ProductDao;
import com.cnp.Dao.ProductDao_Impl;
import com.cnp.Model.Coupon;
import com.cnp.Model.Product;
@WebServlet("/products")
public class ProductController extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
ProductDao pdd= new ProductDao_Impl();
CouponDao_Impl cdi = new CouponDao_Impl();
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name").trim();	
		String desc = req.getParameter("description");
		String price = req.getParameter("price");
		String cc = req.getParameter("CouponCode");
		Coupon coup = cdi.findByCode(cc);
		Product pd = new Product();
		pd.setName(name);
		pd.setDescription(desc);
		pd.setPrice(new BigDecimal(price).subtract(coup.getDiscount()));
		pd.setCouponCode(cc);
		pdd.save(pd);
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
	out.print("<b>Product Created</b>");
	out.println(pd);
	out.print("<br/><h1><a href=index.html>Home </a></h1>");
	
	}


}
