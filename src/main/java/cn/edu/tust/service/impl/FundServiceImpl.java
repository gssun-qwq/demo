package cn.edu.tust.service.impl;

import cn.edu.tust.mapper.FundMapper;
import cn.edu.tust.pojo.entity.Fund;
import cn.edu.tust.pojo.vo.FundVO;
import cn.edu.tust.service.FundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *
 * @author GSsun <br>
 * @date 2023/9/9 18:48
 */
@Service
@Slf4j
public class FundServiceImpl implements FundService {
    @Autowired
    private FundMapper mapper;

    private static HashMap<LocalDate, Fund> fundHashMap;
    private static BigDecimal earliestDay;

    @Override
    public List<FundVO> getFundInfo(Integer pageNum, Integer pageSize, String sortField, String sortDirection) {
        List<Fund> fundList = mapper.getFundPageInfo(sortField, sortDirection);

        // 封装为map集合
        if (fundHashMap == null || fundHashMap.isEmpty()) {
            earliestDay = mapper.getEarliestDayFund();
            fundHashMap = new HashMap<>();
            fundList.forEach(item -> {
                Fund fund = fundHashMap.putIfAbsent(item.getEndDate(), item);
                if (fund != null) {
                    log.info("错误数据，日期：{}", fund.getEndDate());
                }
            });
        }
        int total = fundList.size();

        //开始索引
        int fromIndex = (pageNum - 1) * pageSize;
        //结束索引
        int toIndex = pageNum * pageSize;
        if (fromIndex + 1 > total) {
            return Collections.emptyList();
        }
        if (pageNum * pageSize > total) {
            toIndex = total;
        }

        ArrayList<FundVO> vos = new ArrayList<>();

        fundList.subList(fromIndex, toIndex).forEach(item -> {
            FundVO fundVO = getFundInfoByDate(item);
            vos.add(fundVO);
        });

        return vos;

    }

    private FundVO getFundInfoByDate(Fund item) {
        FundVO fundVO = new FundVO();
        BeanUtils.copyProperties(item, fundVO);
        LocalDate endDate = item.getEndDate();
        // 近一周
        LocalDate aWeek = endDate.minus(1, ChronoUnit.WEEKS);
        fundVO.setAWeek(calculateFundHistory(endDate, aWeek));

        // 近一月
        LocalDate aMonth = endDate.minus(1, ChronoUnit.MONTHS);
        fundVO.setAMonth(calculateFundHistory(endDate, aMonth));

        // 近三月
        LocalDate threeMonth = endDate.minus(3, ChronoUnit.MONTHS);
        fundVO.setThreeMonth(calculateFundHistory(endDate, threeMonth));

        // 近一年
        LocalDate aYear = endDate.minus(1, ChronoUnit.YEARS);
        fundVO.setAYear(calculateFundHistory(endDate, aYear));

        // 近两年
        LocalDate twoYear = endDate.minus(2, ChronoUnit.YEARS);
        fundVO.setTwoYear(calculateFundHistory(endDate, twoYear));

        // 近三年
        LocalDate threeYear = endDate.minus(3, ChronoUnit.YEARS);
        fundVO.setThreeYear(calculateFundHistory(endDate, threeYear));

        // 今年来
        LocalDate thisYear = LocalDate.now().withDayOfYear(1);
        fundVO.setThisYear(calculateFundHistory(endDate, thisYear));

        // 成立以来
        while (!fundHashMap.containsKey(endDate)){
            endDate = endDate.minus(1, ChronoUnit.DAYS);
        }
        fundVO.setUntilToday(calculateFundHistory(fundHashMap.get(endDate).getUnitNetVal(), earliestDay));

        return fundVO;
    }

    /**
     * 计算这个时间段的盈亏信息，需要确保往前计算是存在记录的
     *
     * @param begin 较迟的时间，即跟当前时间相近的时间
     * @param end   较早的时间，跟当前时间相距较远的时间
     * @return 盈亏信息
     */
    private BigDecimal calculateFundHistory(LocalDate begin, LocalDate end) {
        while (!fundHashMap.containsKey(begin)) {
            begin = begin.minus(1, ChronoUnit.DAYS);
        }
        while (!fundHashMap.containsKey(end)) {
            end = end.minus(1, ChronoUnit.DAYS);
        }
        Fund beginFund = fundHashMap.get(begin);
        Fund endFund = fundHashMap.get(end);

        return calculateFundHistory(beginFund.getUnitNetVal(), endFund.getUnitNetVal());
    }

    /**
     * 计算盈亏情况
     *
     * @param begin 晚的单位净值
     * @param end 早的单位净值
     * @return 计算结果
     */
    private BigDecimal calculateFundHistory(BigDecimal begin, BigDecimal end) {
        return begin.subtract(end)
                .multiply(BigDecimal.valueOf(100))
                .divide(end, RoundingMode.HALF_DOWN);
    }

}
