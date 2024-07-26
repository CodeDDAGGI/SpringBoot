package com.study.rest.repository;

import com.study.rest.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    // 추상메서드 작성 (우선 작성함)
    // Product 객체를 저장
    int save(Product product);
}
