package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.repository.ColorMapper;
import com.study.rest.repository.ProductMapper;
import com.study.rest.repository.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 
public class ProductServiceImpl implements ProductService{
    // 구조 : 컨트롤 -> 서비스 -> 레파지토리 (의존)

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SizeMapper sizeMapper;
    @Autowired
    private ColorMapper colorMapper;

    // ctrl + i 자동 오버라이드
    @Override
    public List<SizeDto.Info> getSizeListAll() {
        return SizeDto.toList(sizeMapper.findAll());
    }

    @Override
    public List<ColorDto.Info> getColorListAll() {
        return ColorDto.toList(colorMapper.findAll());
    }

    @Override
    public CommonResponseDto registerProduct(ProductDto.Register register){
        //Product product = register.toEntity(); // product를 변환

        return CommonResponseDto.ofDefault(productMapper.save(register.toEntity()));
    }

    @Override
    public CommonResponseDto registerSize(ReqRegisterSizeDto reqRegisterSizeDto) {
//        Size size = Size.builder()
//                .sizeName(reqRegisterSizeDto.getSizeName())
//                .build();
//        // 사이즈 객체를 담은 사이즈를 세이브에 저장
//
//        int successCount = sizeMapper.save(size);
//        return CommonResponseDto.ofDefault(successCount);
        
        // 위 코드를 한줄로 표현 sizeMapper를 이용해서
        return CommonResponseDto.ofDefault(sizeMapper.save(reqRegisterSizeDto.toEntity()));
    }

    @Override
    public CommonResponseDto registerColor(ReqRegisterColorDto reqRegisterColorDto) {
        return CommonResponseDto.ofDefault(colorMapper.save(reqRegisterColorDto.toEntity()));
    }
}
