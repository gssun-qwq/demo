package cn.edu.tust.service;

import cn.edu.tust.pojo.vo.FundVO;

import java.util.List;

public interface FundService {
    List<FundVO> getFundInfo(Integer pageNum, Integer pageSize, String sortField, String sortDirection);
}
