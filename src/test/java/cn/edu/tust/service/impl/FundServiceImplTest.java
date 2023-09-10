package cn.edu.tust.service.impl;

import cn.edu.tust.service.FundService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FundServiceImplTest {

    @Autowired
    private FundService service;
    @Test
    void getFundInfo() {
        System.out.println(
                service.getFundInfo(2, 3, "unit_net_val", "desc"));
    }
}