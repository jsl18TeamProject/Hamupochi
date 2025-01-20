package com.example.HamuPochi.Product;

import com.example.HamuPochi.DTO.ProductDTO;
import com.example.HamuPochi.Entity.*;
import com.example.HamuPochi.Repository.ProductRepository;
import com.example.HamuPochi.Service.ProductService;
import com.example.HamuPochi.Service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

public class SellerProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertProduct() {
        // Given
        ProductDTO productDTO = ProductDTO.builder()
                .title("Test Product")
                .content("This is a test product.")
                .price(1000L)
                .thumbnail_url("http://example.com/image.png")
                .status(1)
                .build();

        // When
        productService.setProduct(productDTO); // setProduct 메서드 호출

        // Then
        //verify(productRepository, times(1)).save(any(Product.class)); // save 메서드가 호출되었는지 확인
    }
}