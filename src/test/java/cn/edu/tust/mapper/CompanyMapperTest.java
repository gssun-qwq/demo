package cn.edu.tust.mapper;

import cn.edu.tust.pojo.entity.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class CompanyMapperTest {

    @Autowired
    private CompanyMapper mapper;

    @Test
    void getCompanies() {
        List<Company> companies = mapper.getCompanies(true);
        System.out.println(companies);
    }

    @Test
    void insertCompanies() {
        Company company = Company.builder()
                .orgUniCode("test")
                .orgChiName("test")
                .induSmaPar("test")
                .orgDele("test")
                .regCap(BigDecimal.valueOf(1000.03))
                .orgEstDate(LocalDate.now())
                .build();
        mapper.insertCompanies(Collections.singletonList(company));
        System.out.println(company);
    }

    @Test
    void getById() {
        Company company = mapper.getById(1);
        System.out.println(company);
    }

    @Test
    void updateById() {
        Company company = Company.builder()
                .id(1)
                .orgUniCode("1111")
                .build();
        mapper.updateById(company);
    }

    @Test
    void deleteById() {
        mapper.deleteById(1);
    }
}