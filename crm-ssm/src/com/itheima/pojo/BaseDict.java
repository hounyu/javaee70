package com.itheima.pojo;
/**
 * 
FieldTypeComment
dict_idvarchar(32) 
dict_type_codevarchar(
dict_type_namevarchar(
dict_item_namevarchar(
dict_item_codevarchar(为空)
dict_sortint(10) NULL
dict_enablechar(1) NOT
dict_memo
 * @author houningyu
 *
 */
public class BaseDict {
	private String dict_id;
	private String dict_type_code;
	private String dict_type_name;
	private String dict_item_name;
	private String dict_item_code;
	public String getDict_id() {
		return dict_id;
	}
	public void setDict_id(String dict_id) {
		this.dict_id = dict_id;
	}
	public String getDict_type_code() {
		return dict_type_code;
	}
	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}
	public String getDict_type_name() {
		return dict_type_name;
	}
	public void setDict_type_name(String dict_type_name) {
		this.dict_type_name = dict_type_name;
	}
	public String getDict_item_name() {
		return dict_item_name;
	}
	public void setDict_item_name(String dict_item_name) {
		this.dict_item_name = dict_item_name;
	}
	public String getDict_item_code() {
		return dict_item_code;
	}
	public void setDict_item_code(String dict_item_code) {
		this.dict_item_code = dict_item_code;
	}
	
	
	
}
