package com.example.apidevsproduct.service;

import com.example.apidevsproduct.consumer.payload.ProductPayload;
import com.example.apidevsproduct.entity.Product;
import com.example.apidevsproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public void save(final ProductPayload payload) {
        if (Objects.isNull(payload)) {
            throw new RuntimeException("Payload está nullo");
        }

        final Random random = new Random();
        final LocalDateTime now = LocalDateTime.now();
        final BigDecimal price = BigDecimal.valueOf(random.nextDouble(650, 999.99));

        final Product product = Product.builder()
                .productName(String.valueOf(payload.type()))
                .userEmail(payload.email())
                .date(now)
                .price(price)
                .build();

        try {
            productRepository.save(product);
            log.info("Mensagem de produto salva com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
