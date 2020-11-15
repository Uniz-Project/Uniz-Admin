package com.uniz.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniz.admin.domain.Criteria;
import com.uniz.admin.domain.Uniz;
import com.uniz.admin.domain.UnizLayer;
import com.uniz.admin.domain.unizPageDTO;
import com.uniz.admin.mapper.UnizMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class UnizServiceImpl implements UnizService{
	
	@Setter(onMethod_ = @Autowired)
	UnizMapper unizMapper;
	
	public List<Uniz> unizList2(){
		return unizMapper.unizList2();
	}
	
	@Override
	public List<Uniz> unizList(Criteria cri, Long unizSn) {
		// TODO Auto-generated method stub
		log.info("get Uniz LiST :" + unizSn);
		
		return unizMapper.getListWithPaging(cri, unizSn);
	}
	@Override
	public unizPageDTO getListPage(Criteria cri, Long unizSn) {
		// TODO Auto-generated method stub
		return new unizPageDTO(
				unizMapper.getCountByUniz(unizSn), 
				unizMapper.getListWithPaging(cri, unizSn));				
	}
	
	public int unizCheck(Uniz uniz){
		return unizMapper.selectUniz(uniz);
	}
	
	@Override
	public String unizInsert(Uniz uniz) {
		// TODO Auto-generated method stub

		
		int check = unizCheck(uniz);
		String resultStr ="";
		
		if(check <= 0) {
			try{
				int resultCnt = unizMapper.unizInsert(uniz);
				
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
	public String unizUpdate(Uniz uniz) {
		System.out.println("service Uniz"+ uniz);
		
		String resultStr ="";
			try{
				int resultCnt = unizMapper.unizUpdate(uniz);
				
				if(resultCnt >0) {
					resultStr = "success";
				}else {
					resultStr = "fail";
				}
			}catch (Exception e) {
				e.printStackTrace();
				resultStr = "fail";
			}
			return resultStr;
	}

	@Override
	public String unizDelete(Uniz uniz) {
		// TODO Auto-generated method stub
		System.out.println("service Uniz"+ uniz);
		
			String resultStr ="";
			try{
				int resultCnt = unizMapper.unizDelete(uniz);
				
				if(resultCnt >0) {
					resultStr = "success";
				}else {
					resultStr = "fail";
				}
			}catch (Exception e) {
				e.printStackTrace();
				resultStr = "fail";
			}
			return resultStr;
	}

	
	@Override
	public List<UnizLayer> unizLayerList() {
		// TODO Auto-generated method stub
		return unizMapper.unizLayerList();
	}

	@Override
	public String unizLayerInsert(UnizLayer unizLayer) {
		// TODO Auto-generated method stub
		int check = unizMapper.unizLayerCheck(unizLayer);
		String resultStr ="";
		
		if(check <= 0) {
			try{
				int resultCnt = unizMapper.unizLayerInsert(unizLayer);
				
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
	public String unizLayerUpdate(UnizLayer unizLayer) {
		// TODO Auto-generated method stub
		String resultStr ="";
		try{
			int resultCnt = unizMapper.unizLayerUpdate(unizLayer);
			
			if(resultCnt >0) {
				resultStr = "success";
			}else {
				resultStr = "fail";
			}
		}catch (Exception e) {
			e.printStackTrace();
			resultStr = "fail";
		}
		return resultStr;
	}

	@Override
	public String unizLayerDelete(UnizLayer unizLayer) {
		// TODO Auto-generated method stub
		String resultStr ="";
		try{
			int resultCnt = unizMapper.unizLayerDelete(unizLayer);
			
			if(resultCnt >0) {
				resultStr = "success";
			}else {
				resultStr = "fail";
			}
		}catch (Exception e) {
			e.printStackTrace();
			resultStr = "fail";
		}
		return resultStr;
	}

	@Override
	public List<Uniz> unizNotLayerList() {
		// TODO Auto-generated method stub
		return unizMapper.unizNotLayerList();
	}




}
