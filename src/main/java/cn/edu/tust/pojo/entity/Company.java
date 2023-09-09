package cn.edu.tust.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @TableName company
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company implements Serializable {

    /**
     * 主键
     */
    private Integer id;
    /**
     * 组织的唯一标识码/代码
     */
    private String orgUniCode;
    /**
     * 中文名称
     */
    private String orgChiName;
    /**
     * 行业/业务
     */
    private String induSmaPar;
    /**
     * 法定代表人
     */
    private String orgDele;
    /**
     * 注册资本
     */
    private BigDecimal regCap;
    /**
     * 成立日期
     */
    private LocalDate orgEstDate;
}
