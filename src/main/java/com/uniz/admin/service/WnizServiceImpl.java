package com.uniz.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniz.admin.domain.UWmatchList;
import com.uniz.admin.domain.Wniz;
import com.uniz.admin.mapper.WnizMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class WnizServiceImpl implements WnizService {

	@Setter(onMethod_ = @Autowired)
	private WnizMapper wnizMapper;

	@Override
	public List<Wniz> wnizList() {

		return wnizMapper.getWnizList();
	}

	@Override
	public String wnizInsert(Wniz wniz) {

		int check = wnizCheck(wniz);
		String resultStr = "";

		if (check <= 0) {
			try {
				int resultCnt = wnizMapper.wnizInsert(wniz);

				if (resultCnt > 0) {
					resultStr = "success";
				} else {
					resultStr = "fail";
				}
			} catch (Exception e) {
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
		String resultStr = "";

		if (check > 0) {
			try {
				int resultCnt = wnizMapper.wnizUpdate(wniz);

				if (resultCnt > 0) {
					resultStr = "success";
				} else {
					resultStr = "fail";
				}
			} catch (Exception e) {
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
		String resultStr = "";

		if (check > 0) {
			try {
				int resultCnt = wnizMapper.wnizDelete(wniz);

				if (resultCnt > 0) {
					resultStr = "success";
				} else {
					resultStr = "fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
				resultStr = "fail";
			}
		} else {
			resultStr = "duplicate";
		}

		return resultStr;
	}

	public int wnizCheck(Wniz wniz) {
		return wnizMapper.selectWniz(wniz);
	}

	@Override
	public List<UWmatchList> uwMatchList() {

		return wnizMapper.getUWMatchList();
	}

	@Override
	public List<Wniz> uwNotMatchList() {

		return wnizMapper.getNotUWMatchList();
	}
	
	@Override
	public String uwMatchInsert(UWmatchList uwlist) {

		// FK 체크
		int check = uwFKCheck(uwlist);

		String resultStr = "";

		// FK값 2개 있어야 INSERT가능

		if (check >= 2) {
			try {
				int resultCnt = wnizMapper.uwMatchInsert(uwlist);

				if (resultCnt > 0) {
					resultStr = "success";
				} else {
					resultStr = "fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
				resultStr = "fail";
			}
		} else {
			resultStr = "duplicate";
		}

		return resultStr;

	}

	@Override
	public String uwMatchDelete(UWmatchList uwlist) {

		// FK 체크
		int check = uwFKCheck(uwlist);

		String resultStr = "";

		// FK값 2개 있어야 INSERT가능

		if (check >= 2) {
			try {
				int resultCnt = wnizMapper.uwMatchDelete(uwlist);

				if (resultCnt > 0) {
					resultStr = "success";
				} else {
					resultStr = "fail";
				}
			} catch (Exception e) {
				e.printStackTrace();
				resultStr = "fail";
			}
		} else {
			resultStr = "duplicate";
		}

		return resultStr;
	}
	
	
	public int uwFKCheck(UWmatchList uwlist) {
		return wnizMapper.selectUWFK(uwlist);
	}


}
