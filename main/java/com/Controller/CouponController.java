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
import com.cnp.Model.Coupon;
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private CouponDao_Impl dao= new CouponDao_Impl();
	public CouponController() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if(action.equals("create")) {
			createCoupon(req, resp);
		}else if(action.equals("find")) {
			String cop = req.getParameter("couponCode");
			Coupon coupon = dao.findByCode(cop);
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println(coupon);

//			findCoupon(req, resp);
		}
	}
	
	private void createCoupon(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String couponCode = request.getParameter("couponCode");
		String discount = request.getParameter("discount");
		String expiryDate = request.getParameter("expiryDate");
		
		Coupon c=new Coupon();
		c.setCode(couponCode);
		c.setDiscount(new BigDecimal(discount));
		c.setExpDate(expiryDate);
		dao.save(c);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b> Coupon Created!!!!!!</b>");
		out.print("<br/><h1><a href=index.html>Home</a></h1>");
	}
	
	private void findCoupon(HttpServletRequest req,HttpServletResponse res) {
		String Code = req.getParameter("couponCode");
		Coupon cp = dao.findByCode(Code);
		req.setAttribute("coupon", cp);
		
		try {
			req.getRequestDispatcher("findCoupon.jsp").forward(req, res);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
