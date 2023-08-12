package org.hulyam.mapper;

import javax.annotation.processing.Generated;
import org.hulyam.dto.request.ProductSaveRequestDto;
import org.hulyam.dto.response.ProductFindAllResponseDto;
import org.hulyam.dto.response.ProductSaveResponseDto;
import org.hulyam.repository.entity.Product;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-12T17:02:16+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class IProductMapperImpl implements IProductMapper {

    @Override
    public Product fromSaveRequestDto(ProductSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name( dto.getName() );
        product.brand( dto.getBrand() );
        product.model( dto.getModel() );
        product.price( dto.getPrice() );

        return product.build();
    }

    @Override
    public ProductSaveResponseDto toProductSaveResponseDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductSaveResponseDto.ProductSaveResponseDtoBuilder productSaveResponseDto = ProductSaveResponseDto.builder();

        productSaveResponseDto.id( product.getId() );
        productSaveResponseDto.name( product.getName() );
        productSaveResponseDto.brand( product.getBrand() );
        productSaveResponseDto.model( product.getModel() );
        if ( product.getPrice() != null ) {
            productSaveResponseDto.price( String.valueOf( product.getPrice() ) );
        }

        return productSaveResponseDto.build();
    }

    @Override
    public ProductFindAllResponseDto toProductFindAllResponseDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductFindAllResponseDto.ProductFindAllResponseDtoBuilder productFindAllResponseDto = ProductFindAllResponseDto.builder();

        productFindAllResponseDto.name( product.getName() );
        productFindAllResponseDto.brand( product.getBrand() );
        productFindAllResponseDto.model( product.getModel() );
        if ( product.getPrice() != null ) {
            productFindAllResponseDto.price( String.valueOf( product.getPrice() ) );
        }

        return productFindAllResponseDto.build();
    }
}
