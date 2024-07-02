package com.dev.BookPlace.dto;

import com.dev.BookPlace.enums.PropType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PropsDTO {

    private Long id;
    private String name;
    private String propValue;
    private PropType type;
}
