package com.itheima.service;

import java.util.List;

import com.itheima.pojo.Customer;
import com.itheima.pojo.CustomerInfo;
import com.itheima.utils.Page;

public interface CustomerService {
	Page<Customer> findByCustomerInfo(CustomerInfo customerInfo,int currentPage);

	Customer findById(long id);

	void updayeCustomer(Customer customer);

	void deleteCustomer(long id);
}
