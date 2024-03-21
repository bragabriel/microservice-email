package com.gabriel.emailmicroservice.application.core.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailDTO {
    private String fromPersonName;
    private String toPersonName;
    private String toEmail;
}
