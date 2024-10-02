package com.dev.BookPlace.Gateway.models.entities;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Card {

    private String network_token;
    private String exp_month;
    private String exp_year;
    private String security_code;
    private Holder holder;
    private TokenData token_data = new TokenData();
}
