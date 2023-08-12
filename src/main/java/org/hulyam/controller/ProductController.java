package org.hulyam.controller;

import lombok.RequiredArgsConstructor;

import static org.hulyam.constant.EndPoints.*;

import org.hulyam.dto.request.ProductSaveRequestDto;
import org.hulyam.dto.response.ProductFindAllResponseDto;
import org.hulyam.dto.response.ProductSaveResponseDto;
import org.hulyam.mapper.IProductMapper;
import org.hulyam.repository.entity.Product;
import org.hulyam.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(API + VERSION + PRODUCT)
public class ProductController {
    private final ProductService productService;

    @PostMapping(SAVE)
    public ResponseEntity<ProductSaveResponseDto> save(ProductSaveRequestDto dto) {
        Product product = productService.saveDto(dto);
        return ResponseEntity.ok(IProductMapper.INSTANCE.toProductSaveResponseDto(product));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<ProductFindAllResponseDto>> findAll() {
        return ResponseEntity.ok(productService.findAllResponseDtos());
    }

    @GetMapping(FINDALLBYNAME)
    public ResponseEntity<List<ProductFindAllResponseDto>> findAllByName(String name) {
        return ResponseEntity.ok(productService.findAllByName(name));
    }

    @GetMapping(FINDALLBYBRAND)
    public ResponseEntity<List<ProductFindAllResponseDto>> findAllByBrand(String brand) {
        return ResponseEntity.ok(productService.findAllByBrand(brand));
    }
}
