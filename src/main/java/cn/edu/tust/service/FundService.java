package cn.edu.tust.service;

import cn.edu.tust.pojo.vo.FundVO;

import java.util.List;

public interface FundService {
    /**
     * 分页查询基金的盈亏情况
     *
     * @param pageNum 当前页
     * @param pageSize 显示条数
     * @param sortField 分类字段
     * @param sortDirection 排序方向
     * @return 基金盈亏情况
     */
    List<FundVO> getFundInfo(Integer pageNum, Integer pageSize, String sortField, String sortDirection);
}
