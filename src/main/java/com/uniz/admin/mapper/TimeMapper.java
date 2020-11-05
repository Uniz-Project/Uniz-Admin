package com.uniz.admin.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
//	@Select("SELECT sysdate FROM dual")l
//	public String getTime();
	
	public String getTime();
}
