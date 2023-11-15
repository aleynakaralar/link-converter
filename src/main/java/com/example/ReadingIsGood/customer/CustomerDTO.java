package com.example.ReadingIsGood.customer;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerDTO {
    private String id;
    private String name;
    private String phoneNumber;
}
