package cn.edu.tust.mapper;

import cn.edu.tust.pojo.entity.Company;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CompanyMapper {

    List<Company> getCompanies(Boolean isDesc);

    void insertCompanies(List<Company> companies);

    Company getById(Integer comId);

    void updateById(Company company);

    void deleteById(Integer comId);
}
