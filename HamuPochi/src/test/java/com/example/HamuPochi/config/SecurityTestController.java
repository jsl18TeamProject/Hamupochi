package com.example.HamuPochi.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
@Log4j2
public class SecurityTestController {

    @GetMapping("/buyer/dashboard")
    public String getBuyerDashboard() {
        log.info("@@@@@@@@BUYER");
        return "Buyer Dashboard";
    }

    @GetMapping("/seller/dashboard")
    public String getSellerDashboard() {
        log.info("@@@@@@@@SELLER");
        return "Seller Dashboard";
    }

    @GetMapping("/admin/dashboard")
    public String getAdminDashboard() {
        log.info("@@@@@@@@ADMIN");
        return "Admin Dashboard";
    }
}
