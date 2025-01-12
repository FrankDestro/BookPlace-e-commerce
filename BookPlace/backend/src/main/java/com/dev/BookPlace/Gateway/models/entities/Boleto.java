package com.dev.BookPlace.Gateway.models.entities;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Boleto {

    private String id;
    private String barcode;
    private String formatted_barcode;
    private String due_date;
    private InstructionLines instruction_lines = new InstructionLines();
    private Holder holder = new Holder();
}
