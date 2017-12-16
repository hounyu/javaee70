package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.mapper.CustomerMapper;
import com.itheima.pojo.Customer;
import com.itheima.pojo.CustomerInfo;
import com.itheima.service.CustomerService;
import com.itheima.utils.Page;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public Page findByCustomerInfo(CustomerInfo customerInfo, int currentPage) {
		int start = (currentPage -1) * customerInfo.getSize();
		customerInfo.setStart(start);
		Page<Customer> page = new Page<>();
		List<Customer> list = customerMapper.findByCustomerInfo(customerInfo);
		int count = customerMapper.findCountByCustomerInfo(customerInfo);
		page.setTotal(count);
		page.setPage(currentPage);
		page.setSize(customerInfo.getSize());
		page.setRows(list);
		return page;
	}

	@Override
	public Customer findById(long id) {
		Customer custoemr = customerMapper.findById(id);
		return custoemr;
	}

	@Override
	public void updayeCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(long id) {
		customerMapper.deleteCustomer(id);
		
	}

}
