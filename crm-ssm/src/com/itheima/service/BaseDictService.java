package com.itheima.service;

import java.util.List;

import com.itheima.pojo.BaseDict;

public interface BaseDictService {

	List<BaseDict> findBaseDictInfo(String typeCode);
	
}
