package com.multi.account_service.model;

import lombok.*;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class Customer {
    private Long id;
    private String name;
    private String email;
}
