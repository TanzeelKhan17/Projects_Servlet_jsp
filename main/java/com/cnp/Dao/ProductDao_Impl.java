package com.cnp.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Cnp_Util.ConnectionUtil;
import com.cnp.Model.Product;

public class ProductDao_Impl implements ProductDao {

	@Override
	public void save(Product pd) {
		Connection con = ConnectionUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into product_details(name,description,price) values(?,?,?)");
		ps.setString(1,pd.getName() );
		ps.setString(2, pd.getDescription());
		ps.setBigDecimal(3, pd.getPrice());
		ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
