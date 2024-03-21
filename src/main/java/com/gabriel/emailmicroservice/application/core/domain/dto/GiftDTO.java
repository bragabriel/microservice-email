package com.gabriel.emailmicroservice.application.core.domain.dto;

import lombok.Data;

@Data
public class GiftDTO {
    private String name;
    private String description;
    private String recipientId;
    private String senderId;
}
