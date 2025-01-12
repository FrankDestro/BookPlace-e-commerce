package com.dev.BookPlace.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PhoneDTO {

    private Long id;
    private Integer country;
    private Integer area;
    private Integer number;
    private String  type;
    private Long userId;
}
