package com.gabriel.emailmicroservice.application.core.domain.service;

import com.gabriel.emailmicroservice.application.core.domain.dto.EmailDTO;
import com.gabriel.emailmicroservice.application.ports.out.EmailPort;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailPort {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(EmailDTO emailDTO) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("bi.bragasilva@gmail.com");
        mailMessage.setTo(emailDTO.getTo());
        mailMessage.setSubject(emailDTO.getSubject());
        mailMessage.setText(emailDTO.getBody());
        javaMailSender.send(mailMessage);
    }
}
