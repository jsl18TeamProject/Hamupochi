package com.example.HamuPochi.Product;

import com.example.HamuPochi.DTO.ProductDTO;
import com.example.HamuPochi.Repository.ProductRepository;
import com.example.HamuPochi.Service.ProductServiceImpl;
import com.example.HamuPochi.Util.Criteria;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static com.example.HamuPochi.Entity.QProduct.product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class MainProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService; // 구현체 사용

    @Mock
    private JPAQueryFactory queryFactory; // Mock할 JPAQueryFactory

    @Mock
    private ProductRepository productRepository; // Mock할 ProductRepository

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Mockito 초기화
    }

//    @Test
//    public void testGetListWithPaging() {
//        // Mocking the behavior of the query
//        List<ProductDTO> mockList = new ArrayList<>();
//        mockList.add(new ProductDTO(1L, null, null, null, null, "Test Product 1", "Description", 1000L, "thumbnail1.jpg", 1, null, null));
//        mockList.add(new ProductDTO(2L, null, null, null, null, "Test Product 2", "Description", 2000L, "thumbnail2.jpg", 1, null, null));
//        mockList.add(new ProductDTO(3L, null, null, null, null, "Test Product 1", "Description", 1000L, "thumbnail1.jpg", 1, null, null));
//        mockList.add(new ProductDTO(4L, null, null, null, null, "Test Product 2", "Description", 2000L, "thumbnail2.jpg", 0, null, null));
//        mockList.add(new ProductDTO(5L, null, null, null, null, "Test Product 1", "Description", 1000L, "thumbnail1.jpg", 1, null, null));
//        mockList.add(new ProductDTO(6L, null, null, null, null, "Test Product 2", "Description", 2000L, "thumbnail2.jpg", 1, null, null));
//        mockList.add(new ProductDTO(7L, null, null, null, null, "Test Product 1", "Description", 1000L, "thumbnail1.jpg", 0, null, null));
//        mockList.add(new ProductDTO(8L, null, null, null, null, "Test Product 2", "Description", 2000L, "thumbnail2.jpg", 1, null, null));
//        mockList.add(new ProductDTO(9L, null, null, null, null, "Test Product 1", "Description", 1000L, "thumbnail1.jpg", 1, null, null));
//        mockList.add(new ProductDTO(10L, null, null, null, null, "Test Product 2", "Description", 2000L, "thumbnail2.jpg", 0, null, null));
//        mockList.add(new ProductDTO(11L, null, null, null, null, "Test Product 1", "Description", 1000L, "thumbnail1.jpg", 1, null, null));
//        mockList.add(new ProductDTO(12L, null, null, null, null, "Test Product 2", "Description", 2000L, "thumbnail2.jpg", 1, null, null));
//        mockList.add(new ProductDTO(13L, null, null, null, null, "Test Product 1", "Description", 1000L, "thumbnail1.jpg", 1, null, null));
//        mockList.add(new ProductDTO(14L, null, null, null, null, "Test Product 2", "Description", 2000L, "thumbnail2.jpg", 1, null, null));
//        mockList.add(new ProductDTO(15L, null, null, null, null, "Test Product 1", "Description", 1000L, "thumbnail1.jpg", 1, null, null));
//        mockList.add(new ProductDTO(16L, null, null, null, null, "Test Product 2", "Description", 2000L, "thumbnail2.jpg", 1, null, null));
//        mockList.add(new ProductDTO(17L, null, null, null, null, "Test Product 1", "Description", 1000L, "thumbnail1.jpg", 1, null, null));
//        mockList.add(new ProductDTO(18L, null, null, null, null, "Test Product 2", "Description", 2000L, "thumbnail2.jpg", 1, null, null));
//
//        // Mocking the repository method
//        when(productRepository.getListWithPaging(any(Criteria.class))).thenReturn(mockList);
//
//        // Create Criteria
//        Criteria criteria = new Criteria();
//        criteria.setPageNum(1);
//        criteria.setAmount(9);
//        criteria.setType("title");
//        criteria.setKeyword("Test");
//
//        // Call the method
//        List<ProductDTO> resultList = productService.getListWithPaging(criteria);
//
//        // Assertions
//        assertNotNull(resultList);
//        assertEquals(18, resultList.size()); // Mocked data size
//        assertEquals("Test Product 1", resultList.get(0).getTitle());
//    }

    @Test
    public void test(){
        int rate = (7 * 100) / 72;
        System.out.println(rate);
    }

    @Test
    public void testGetCountForList() {
        // Mocking the count behavior
        when(productRepository.getCountForList(any(Criteria.class))).thenReturn(2L); // Mocking the count result

        // Create Criteria
        Criteria criteria = new Criteria();
        criteria.setType("title");
        criteria.setKeyword("Test");

        // Call the method
        long count = productService.getTotalCount(criteria);

        // Assertions
        assertEquals(2L, count); // Check if the count is as expected
    }
}