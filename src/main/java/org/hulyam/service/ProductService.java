package org.hulyam.service;

import org.hulyam.dto.request.ProductSaveRequestDto;
import org.hulyam.dto.response.ProductFindAllResponseDto;
import org.hulyam.mapper.IProductMapper;
import org.hulyam.repository.IProductRepository;
import org.hulyam.repository.entity.Product;
import org.hulyam.utility.ServiceManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends ServiceManager<Product, Long> {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    public Product saveDto(ProductSaveRequestDto dto) {
        return save(IProductMapper.INSTANCE.fromSaveRequestDto(dto));
    }

    public List<ProductFindAllResponseDto> findAllResponseDtos() {
        List<ProductFindAllResponseDto> list = new ArrayList<>();
        findAll().forEach(product -> {
            list.add(IProductMapper.INSTANCE.toProductFindAllResponseDto(product));
        });
        return list;
    }

    public List<ProductFindAllResponseDto> findAllByName(String name) {
        List<ProductFindAllResponseDto> list = new ArrayList<>();
        findAllResponseDtos().stream().filter(p -> p.getName().equals(name)).forEach(list::add);
        return list;
    }

    public List<ProductFindAllResponseDto> findAllByBrand(String brand) {
        List<ProductFindAllResponseDto> list = new ArrayList<>();
        findAllResponseDtos().stream().filter(p -> p.getBrand().equals(brand)).forEach(list::add);
        return list;
    }
}
