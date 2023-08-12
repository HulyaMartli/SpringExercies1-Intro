package org.hulyam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSaveRequestDto {
    String name;
    String brand;
    String model;
    Double price;
}
