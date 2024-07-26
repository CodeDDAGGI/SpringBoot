package com.study.rest.dto;

import com.study.rest.entity.Product;
import lombok.Data;

public class ProductDto {

    @Data
    public static class Register {
        private String productName;
        private int price;
        private int sizeId; // id가 넘어옴
        private int colorId;

        public Product toEntity() {
            return Product.builder()
                    .productName(productName)
                    .price(price)
                    .sizeId(sizeId)
                    .colorId(colorId)
                    .build();
        }
    }
}
