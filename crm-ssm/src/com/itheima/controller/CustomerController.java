package com.itheima.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.pojo.BaseDict;
import com.itheima.pojo.Customer;
import com.itheima.pojo.CustomerInfo;
import com.itheima.service.BaseDictService;
import com.itheima.service.CustomerService;
import com.itheima.utils.Page;

@Controller
public class CustomerController {
	@Value("${customer.typeCode.source}")
	private String typeCodeSource;
	@Value("${customer.typeCode.industry}")
	private String typeCodeIndustry;
	@Value("${customer.typeCode.level}")
	private String typeCodeLevel;
	
	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String showCustomerList(Model model,CustomerInfo customerInfo,@RequestParam(defaultValue="1")Integer page) throws Exception{
		String custName = customerInfo.getCustName();
		if(custName!=null && custName !=""){
			custName = new String(custName.getBytes("iso8859-1"), "utf-8");
			customerInfo.setCustName(custName);
		}
		List<BaseDict> Source = baseDictService.findBaseDictInfo(typeCodeSource);
		List<BaseDict> Industry = baseDictService.findBaseDictInfo(typeCodeIndustry);
		List<BaseDict> Level = baseDictService.findBaseDictInfo(typeCodeLevel);
		
		Page<Customer> pageBean = customerService.findByCustomerInfo(customerInfo, page);
		
		//数据返显
		model.addAttribute("custName", customerInfo.getCustName());
		model.addAttribute("custSource", customerInfo.getCustSource());
		model.addAttribute("custIndustry", customerInfo.getCustIndustry());
		model.addAttribute("custLevel", customerInfo.getCustLevel());
		
		model.addAttribute("page", pageBean);
		model.addAttribute("fromType", Source);
		model.addAttribute("industryType", Industry);
		model.addAttribute("levelType", Level);
		
		return "customer";
	}
	
	/**
	 * 修改客户的数据回显
	 */
	@RequestMapping("customer/edit")
	@ResponseBody
	public Customer editCustomer(long id){
		Customer customer = customerService.findById(id);
		return customer ;
	} 
	
	/**
	 * 客户保存修改
	 */
	@RequestMapping("customer/update")
	@ResponseBody
	public String updateCustomer(Customer customer){
		customerService.updayeCustomer(customer);
		return "1";
	}
	
	/**
	 * 删除客户
	 */
	@RequestMapping("customer/delete")
	@ResponseBody
	public String deleteCustomer(long id){
		customerService.deleteCustomer(id);
		return "1";
	}
}
