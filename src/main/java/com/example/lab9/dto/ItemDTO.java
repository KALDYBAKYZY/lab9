package com.example.lab9.dto;

import com.example.lab9.dto.CountryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDTO {
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private CountryDTO manufacturer;
}
