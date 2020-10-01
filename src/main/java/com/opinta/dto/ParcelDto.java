package com.opinta.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ParcelDto {
    private long id;
    private float weight;
    private float length;
    private float width;
    private float height;
    private BigDecimal declaredPrice;
    private BigDecimal price;
    private List<ParcelItemDto> parcelItemDtos;

}
