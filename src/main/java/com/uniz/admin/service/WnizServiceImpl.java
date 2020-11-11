package com.uniz.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniz.admin.domain.Wniz;
import com.uniz.admin.mapper.WnizMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class WnizServiceImpl implements WnizService{

	@Setter(onMethod_ = @Autowired)
	private WnizMapper wnizMapper;
	
	@Override
	public List<Wniz> wnizList() {
	
		return wnizMapper.getWnizList();
	}
	
	@Override
	public String wnizInsert(Wniz wniz) {
	
		int check = wnizCheck(wniz);
		String resultStr ="";
		
		if(check <= 0) {
			try{
				int resultCnt = wnizMapper.wnizInsert(wniz);
				
				if(resultCnt >0) {
					resultStr = "success";
				}else {
					resultStr = "fail";
				}
			}catch (Exception e) {
				e.printStackTrace();
				resultStr = "fail";
			}
		} else {
			resultStr = "duplicate";
		}
		
		return resultStr;
	}

	@Override
	public String wnizUpdate(Wniz wniz) {

		int check = wnizCheck(wniz);
		String resultStr ="";
		
		if(check > 0) {
			try{
				int resultCnt = wnizMapper.wnizUpdate(wniz);
				
				if(resultCnt >0) {
					resultStr = "success";
				}else {
					resultStr = "fail";
				}
			}catch (Exception e) {
				e.printStackTrace();
				resultStr = "fail";
			}
		} else {
			resultStr = "duplicate";
		}
		
		return resultStr;
	}

	@Override
	public String wnizDelete(Wniz wniz) {
	
		int check = wnizCheck(wniz);
		String resultStr ="";
		
		if(check > 0) {
			try{
				int resultCnt = wnizMapper.wnizDelete(wniz);
				
				if(resultCnt >0) {
					resultStr = "success";
				}else {
					resultStr = "fail";
				}
			}catch (Exception e) {
				e.printStackTrace();
				resultStr = "fail";
			}
		} else {
			resultStr = "duplicate";
		}
		
		return resultStr;
	}
	
	public int wnizCheck(Wniz wniz){
		return wnizMapper.selectWniz(wniz);
	}
}
