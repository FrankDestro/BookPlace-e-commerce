package com.dev.BookPlace.entities.pagseguro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BoletoDetails {

    private String due_date;
    private InstructionLines instruction_lines = new InstructionLines();
    private Holder holder = new Holder();
}
