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
		
		log.info("get Uniz LiST :" + unizSn);
		
		return unizMapper.getListWithPaging(cri, unizSn);
	}

	public int unizCheck(Uniz uniz){
		return unizMapper.selectUniz(uniz.getUnizTypeSn(),uniz.getUnizKeyword());
	}

	@Override
	public String unizInsert(Uniz uniz) {
		
		//유니즈 중복체크
		int check = unizCheck(uniz);
		String resultStr ="";
		
		//유니즈 중복이 아니면
		if(check <= 0) {
			try{
				//DB에 문제가 있을 수 있으니 예외처리
				//쿼리 실행
				int resultCnt = unizMapper.unizInsert(uniz);
				
				if(resultCnt >0) {
					//제대로 동작했을 경우 "success" 반환
					resultStr = "success";
				} else {
					//문제가 있을 시 "fail"
					resultStr = "fail";
				}
			} catch (Exception e) {
				// DB에 문제가 있을 시 역시 "fail"
				e.printStackTrace();
				resultStr = "fail";
			}
		} else {
			// 해당 게시물이 존재하지 않을경우 "duplicate"
			resultStr = "duplicate";
		}
		
		//js에서 ajax호출시 반환받은 resultStr값으로 상태에 따른 alert출력.
		return resultStr;
	}

	@Override
	public String unizUpdate(Uniz uniz) {
		
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

		System.out.println("service Uniz"+ uniz);
		
			String resultStr = "";
			
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
		
		return unizMapper.unizLayerList();
	}

	@Override
	public String unizLayerInsert(UnizLayer unizLayer) {
		
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
		
		return unizMapper.unizNotLayerList();
	}




}
