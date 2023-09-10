package cn.edu.tust.mapper;

import cn.edu.tust.pojo.entity.Fund;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface FundMapper {
    List<Fund> getFundPageInfo(@Param("sortField") String sortField, @Param("sortDirection") String sortDirection);

    BigDecimal getEarliestDayFund();

}
