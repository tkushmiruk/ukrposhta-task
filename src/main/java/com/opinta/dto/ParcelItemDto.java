package com.opinta.dto;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ParcelItemDto {
    private long id;
    private String name;
    private int quantity;
    private float weight;
    private BigDecimal price;
}
