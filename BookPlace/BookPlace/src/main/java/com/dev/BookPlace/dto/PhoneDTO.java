package com.dev.BookPlace.dto;

import com.dev.BookPlace.entities.Phone;
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

    public PhoneDTO(Phone phoneEntity) {
        id = phoneEntity.getId();
        country = phoneEntity.getCountry();
        area = phoneEntity.getArea();
        number = phoneEntity.getNumber();
        type = phoneEntity.getType();
        userId = phoneEntity.getClient().getId();
    }
}
