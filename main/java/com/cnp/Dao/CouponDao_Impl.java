package com.cnp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Cnp_Util.ConnectionUtil;
import com.cnp.Model.Coupon;

public class CouponDao_Impl implements CoupanDao {

	@Override
	public void save(Coupon cp) {
		Connection con = ConnectionUtil.getConnection();
		try {
 PreparedStatement ps = con.prepareStatement("insert into coupongenerator(couponcode,discount,expdate)values(?,?,?)");
	ps.setString(1, cp.getCode());
	ps.setBigDecimal(2, cp.getDiscount());
	ps.setString(3, cp.getExpDate());
	ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Coupon findByCode(String code) {
		Coupon c = new  Coupon();
		Connection conn = ConnectionUtil.getConnection();
		try {
			PreparedStatement ps1 = conn.prepareStatement("select*from coupongenerator where couponcode=?");
		ps1.setString(1, code);
		ResultSet rs = ps1.executeQuery();
		while(rs.next()) {
			c.setId(1);
			c.setCode(rs.getString(2));
			c.setDiscount(rs.getBigDecimal(3));
			c.setExpDate(rs.getString(4));
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}
