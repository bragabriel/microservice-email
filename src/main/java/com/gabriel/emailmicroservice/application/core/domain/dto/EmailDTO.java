package com.gabriel.emailmicroservice.application.core.domain.dto;

import lombok.Data;

@Data
public class EmailDTO {
    private String fromPersonName;
    private String toPersonName;
    private String toEmail;
}
