package com.cnp.Dao;

import com.cnp.Model.Coupon;

public interface CoupanDao {
void save(Coupon cp);

Coupon findByCode(String code);

}
