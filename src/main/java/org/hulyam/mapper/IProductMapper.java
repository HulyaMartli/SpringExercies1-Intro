package org.hulyam.mapper;

import org.hulyam.dto.request.ProductSaveRequestDto;
import org.hulyam.dto.response.ProductFindAllResponseDto;
import org.hulyam.dto.response.ProductSaveResponseDto;
import org.hulyam.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IProductMapper {
    IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

    Product fromSaveRequestDto(final ProductSaveRequestDto dto);

    ProductSaveResponseDto toProductSaveResponseDto(final Product product);
    ProductFindAllResponseDto toProductFindAllResponseDto(final Product product);

}
