package com.uniz.admin.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.Data;

@Data
public class DataTableDTO {
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	
	private List data;
	
	public List getData(){
        if(CollectionUtils.isEmpty(data)){
            data = new ArrayList<Object>();
        }
        return data;
    }

}
