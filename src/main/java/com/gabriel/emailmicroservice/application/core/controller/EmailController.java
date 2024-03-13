package com.gabriel.emailmicroservice.application.core.controller;

import com.gabriel.emailmicroservice.application.core.domain.dto.EmailDTO;
import com.gabriel.emailmicroservice.application.core.domain.service.EmailServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    private final EmailServiceImpl emailServiceImpl;

    public EmailController(EmailServiceImpl emailServiceImpl) {
        this.emailServiceImpl = emailServiceImpl;
    }

    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailDTO email) {
        emailServiceImpl.sendEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body("E-mail enviado com sucesso!");
    }
}
