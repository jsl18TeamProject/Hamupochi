package com.example.HamuPochi.review;//package com.example.HamuPochi.Product;
import com.example.HamuPochi.DTO.ReviewDTO;
import com.example.HamuPochi.Entity.Buyer;
import com.example.HamuPochi.Entity.Product;
import com.example.HamuPochi.Entity.Review;
import com.example.HamuPochi.Repository.ReviewRepository;
import com.example.HamuPochi.Service.ReviewServiceImpl;
import com.example.HamuPochi.Util.Criteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
public class MainReviewServiceTest {

    @InjectMocks
    private ReviewServiceImpl reviewService; // 리뷰 서비스 구현체 사용

    @Mock
    private ReviewRepository reviewRepository; // Mock할 ReviewRepository

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Mockito 초기화
    }

    @Test
    public void testGetListWithPaging() {
        // Mocking the behavior of the review list
        List<Review> mockList = new ArrayList<>();
        Buyer buyer = Buyer.builder().id(3).build();
        Product product = Product.builder().id(1).build();

        mockList.add(new Review(1L, buyer, product, "Great product!", 5, LocalDateTime.now(), LocalDateTime.now()));
        mockList.add(new Review(2L, buyer, product, "Satisfactory", 4, LocalDateTime.now(), LocalDateTime.now()));
        mockList.add(new Review(3L, buyer, product, "Not bad", 3, LocalDateTime.now(), LocalDateTime.now()));
        mockList.add(new Review(4L, buyer, product, "Could be better", 2, LocalDateTime.now(), LocalDateTime.now()));

        // Mocking the repository method
        when(reviewRepository.findAllPagingByProduct(any(Criteria.class), eq(product))).thenReturn(Optional.of(mockList));

        // Create Criteria
        Criteria criteria = new Criteria();
        criteria.setPageNum(1);
        criteria.setAmount(4);

        // Call the method
        Optional<List<Review>> resultList = reviewService.getListWithPagingByProduct(criteria, product);

        // Assertions
        assertNotNull(resultList);
        assertTrue(resultList.isPresent()); // Optional이 비어 있지 않음을 확인
        assertEquals(4, resultList.get().size()); // Mocked data size
        assertEquals("Great product!", resultList.get().get(0).getContent());
    }

//    @Test
//    public void testGetCountForList() {
//        // Mocking the count behavior
//        when(reviewRepository.getCountForList(any(Criteria.class))).thenReturn(4L); // Mocking the count result
//
//        // Create Criteria
//        Criteria criteria = new Criteria();
//        criteria.setType("rating");
//        criteria.setKeyword("Test");
//
//        // Call the method
//        long count = reviewService.getTotalCount(criteria);
//
//        // Assertions
//        assertEquals(4L, count); // Check if the count is as expected
//    }
}