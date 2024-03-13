package com.gabriel.emailmicroservice.application.ports.out;

import com.gabriel.emailmicroservice.application.core.domain.dto.EmailDTO;

public interface EmailPort {
    void sendEmail(EmailDTO emailDTO);
}
