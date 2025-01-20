package com.example.HamuPochi.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityAccessTest { //권한별 액세스 테스트

    @Autowired
    private MockMvc mockMvc;
    //buyer -> /buyer test
    @Test
    @WithMockUser(username = "buyerUser", roles = {"BUYER"})
    public void testBuyerAccess() throws Exception {
        mockMvc.perform(get("/api/buyer/dashboard"))
                .andExpect(status().isOk());
    }

    //seller -> seller test
    @Test
    @WithMockUser(username = "sellerUser", roles = {"SELLER"})
    public void testSellerAccess() throws Exception {
        mockMvc.perform(get("/api/seller/dashboard"))
                .andExpect(status().isOk());
    }

    //admin -> admin test
    @Test
    @WithMockUser(username = "adminUser", roles = {"ADMIN"})
    public void testAdminAccess() throws Exception {
        mockMvc.perform(get("/api/admin/dashboard"))
                .andExpect(status().isOk());
    }

    //buyer -> /admin test
    @Test
    @WithMockUser(username = "buyerUser", roles = {"BUYER"})
    public void testAdminAccessDenied() throws Exception {
        mockMvc.perform(get("/api/admin/dashboard"))
                .andExpect(status().isForbidden());
    }

    //seller -> buyer test
    @Test
    @WithMockUser(username = "sellerUser", roles = {"SELLER"})
    public void testBuyerAccessDenied() throws Exception {
        mockMvc.perform(get("/api/buyer/dashboard"))
                .andExpect(status().isForbidden());
    }
}
