package cn.edu.tust.service;

import cn.edu.tust.pojo.entity.Company;

import java.util.List;

public interface CompanyService {

    /**
     * 获取所有的热门企业
     *
     * @param isDesc true-降序，false-升序
     * @return 企业列表
     */
    List<Company> getAllCompanies(Boolean isDesc);

    /**
     * 新增企业
     *
     * @param company 企业信息
     */
    void addCompany(Company company);

    /**
     * 根据id查询企业信息
     *
     * @param comId 企业id
     * @return 企业信息
     */
    Company getCompanyById(Integer comId);

    /**
     * 更新企业信息
     *
     * @param company 企业信息
     */
    void updateCompany(Company company);

    /**
     * 根据id删除企业信息
     *
     * @param comId
     */
    void deleteCompanyById(Integer comId);
}
