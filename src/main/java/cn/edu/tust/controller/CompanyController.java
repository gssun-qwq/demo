package cn.edu.tust.controller;

import cn.edu.tust.pojo.entity.Company;
import cn.edu.tust.pojo.result.R;
import cn.edu.tust.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author GSsun <br>
 * @date 2023/9/9 16:54
 */
@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService service;

    /**
     * 获取所有的热门企业
     * 查询要求：可以按照创建时间查询
     *
     * @return 企业列表
     */
    @GetMapping
    public R<List<Company>> getAllCompanies() {
        return R.success(service.getAllCompanies(true));
    }

    /**
     * 新增企业信息
     *
     * @param company 企业实体
     * @return R.success()
     */
    @PostMapping
    public R addCompany(@RequestBody Company company) {
        service.addCompany(company);
        return R.success();
    }

    /**
     * 根据企业id查询
     *
     * @param comId 企业id
     * @return 企业信息
     */
    @GetMapping("{comId}")
    public R<Company> getCompanyById(@PathVariable Integer comId) {
        return R.success(service.getCompanyById(comId));
    }

    /**
     * 更新企业信息
     *
     * @param company 企业信息
     * @param comId   企业id
     * @return R.success()
     */
    @PutMapping("{comId}")
    public R updateCompanyInfo(@RequestBody Company company, @PathVariable Integer comId) {
        company.setId(comId);
        service.updateCompany(company);
        return R.success();
    }

    /**
     * 根据id删除企业信息
     *
     * @param comId 企业id
     * @return R.success()
     */
    @DeleteMapping("{comId}")
    public R deleteCompanyById(@PathVariable Integer comId) {
        service.deleteCompanyById(comId);
        return R.success();
    }
}
