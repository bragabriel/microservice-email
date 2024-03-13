package com.gabriel.emailmicroservice.application.core.domain.dto;

import lombok.Data;

@Data
public class EmailDTO {
    private String to;
    private String subject;
    private String body;
}
