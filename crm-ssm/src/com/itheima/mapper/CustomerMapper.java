package com.itheima.mapper;

import java.util.List;

import com.itheima.pojo.Customer;
import com.itheima.pojo.CustomerInfo;

public interface CustomerMapper {
	
	List<Customer> findByCustomerInfo(CustomerInfo customerInfo);
	int findCountByCustomerInfo(CustomerInfo customerInfo);
	Customer findById(long id);
	void updateCustomer(Customer customer);
	void deleteCustomer(long id);
}
