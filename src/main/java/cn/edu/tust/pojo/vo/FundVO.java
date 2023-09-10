package cn.edu.tust.pojo.vo;

import cn.edu.tust.pojo.entity.Fund;
import lombok.*;

import java.math.BigDecimal;

/**
 * <p>
 *
 * @author GSsun <br>
 * @date 2023/9/9 18:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FundVO extends Fund {
    private BigDecimal aWeek;// 近一周
    private BigDecimal aMonth;// 近一月
    private BigDecimal threeMonth;// 近三月
    private BigDecimal aYear;// 近一年
    private BigDecimal twoYear;// 近两年
    private BigDecimal threeYear;// 近三年
    private BigDecimal thisYear;// 近年来
    private BigDecimal untilToday;// 成立以来

    @Override
    public String toString() {
        return "FundVO{" + "fund_code=" + getFundCode() +
                ", fund_short_name=" + getFundShortName() +
                ", end_date=" + getEndDate() +
                ", unit_net_val=" + getUnitNetVal() +
                ", aWeek=" + aWeek +
                ", aMonth=" + aMonth +
                ", threeMonth=" + threeMonth +
                ", aYear=" + aYear +
                ", twoYear=" + twoYear +
                ", threeYear=" + threeYear +
                ", thisYear=" + thisYear +
                ", untilToday=" + untilToday +
                '}';
    }
}
