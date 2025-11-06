package com.example.apidevsproduct.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "api-product")
@Getter
@Setter
@Builder
public class Product {
    @Id
    private String id;
    private String productName;
    private BigDecimal price;
    private LocalDateTime date;
    private String userEmail;
}
