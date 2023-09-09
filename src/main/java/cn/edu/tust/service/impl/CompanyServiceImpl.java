package cn.edu.tust.service.impl;

import cn.edu.tust.mapper.CompanyMapper;
import cn.edu.tust.pojo.entity.Company;
import cn.edu.tust.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *
 * @author GSsun <br>
 * @date 2023/9/9 16:55
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper mapper;

    @Override
    public List<Company> getAllCompanies(Boolean isDesc) {
        return mapper.getCompanies(isDesc);
    }

    @Override
    public void addCompany(Company company) {
        mapper.insertCompanies(Collections.singletonList(company));
    }

    @Override
    public Company getCompanyById(Integer comId) {
        return mapper.getById(comId);
    }

    @Override
    public void updateCompany(Company company) {
        mapper.updateById(company);
    }

    @Override
    public void deleteCompanyById(Integer comId) {
        mapper.deleteById(comId);
    }
}
