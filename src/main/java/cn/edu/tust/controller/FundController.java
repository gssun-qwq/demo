package cn.edu.tust.controller;

import cn.edu.tust.pojo.result.R;
import cn.edu.tust.pojo.vo.FundVO;
import cn.edu.tust.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * @author GSsun <br>
 * @date 2023/9/9 18:47
 */
@RestController
@RequestMapping("fund")
public class FundController {

    @Autowired
    private FundService service;

    /**
     * 分页查询基金的盈亏情况
     * <p>
     * 第二题的解题思路：主要步骤表现在Service层
     * 1. 首先查询出当前所有基金信息，保存到Map集合中。使用日期作为主键。
     * 2. 按照查询条件进行查询，对列表完成分页
     * 3. 根据列表中的日期进行计算
     * <p>
     * 说明:对于按照时间段进行排序的情况,可以通过修改表结构来实现.即在保存基金信息
     * 时,将对应的时间的盈亏信息可以保存到数据库中,这样可以降低代码编写的复杂度.
     *
     * @param pageNum 当前页
     * @param pageSize 显示条数
     * @param sortField 分类字段
     * @param sortDirection 排序方向
     * @return 基金盈亏情况
     */
    @GetMapping
    private R<List<FundVO>> getFundInfo(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam(defaultValue = "unit_net_val") String sortField,
                                        @RequestParam(defaultValue = "asc") String sortDirection) {
        return R.success(service.getFundInfo(pageNum, pageSize, sortField, sortDirection));
    }
}
