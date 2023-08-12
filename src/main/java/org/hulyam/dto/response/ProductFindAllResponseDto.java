package org.hulyam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFindAllResponseDto {
    String name;
    String brand;
    String model;
    String price;
}
