package cn.edu.tust.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @TableName fund
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fund implements Serializable {

    /**
     * 基金的代码，用于唯一标识一个基金
     */
    private Integer fundCode;
    /**
     * 简称
     */
    private String fundShortName;
    /**
     * 结束日期
     */
    private LocalDate endDate;
    /**
     * 单位净值
     */
    private BigDecimal unitNetVal;

}
