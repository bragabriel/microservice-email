package com.gabriel.emailmicroservice.application.core.domain.service;

import com.gabriel.emailmicroservice.application.core.domain.dto.EmailDTO;
import com.gabriel.emailmicroservice.application.ports.out.EmailPort;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailPort {

    private final JavaMailSender javaMailSender;

    @Override
    public void giftSentEmail(EmailDTO emailDTO) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("bi.bragasilva@gmail.com");
        mailMessage.setTo(emailDTO.getToEmail());
        mailMessage.setSubject("Presente enviado! - SendGiftApp");
        mailMessage.setText(
                "Presente enviado através do SendGift-Application! \n\n\n" +
                "Prezado " + emailDTO.getFromPersonName() + ",\n\n" +
                "Este é um email de confirmação para informar que você enviou um presente no dia " + getCurrentDateTime() +
                "para o destinatário: " + emailDTO.getToPersonName() + "\n\n" +
                "Obrigado por usar nossa aplicação. Atenciosamente, \n" +
                "SendGift Application =)");

        javaMailSender.send(mailMessage);
    }

    @Override
    public void giftReceivedEmail(EmailDTO emailDTO) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("bi.bragasilva@gmail.com");
        mailMessage.setTo(emailDTO.getToEmail());
        mailMessage.setSubject("Presente recebido! - SendGiftApp");
        mailMessage.setText(
                "Presente recebido! \n\n\n" +
                "Prezado " + emailDTO.getToPersonName() + ",\n\n" +
                "Este é um email de confirmação para informar que você recebeu um pedido no dia " + getCurrentDateTime() + "\n\n" +
                "Obrigado por usar nossa aplicação. Atenciosamente, \n" +
                "SendGift Application =)");

        javaMailSender.send(mailMessage);
    }

    private String getCurrentDateTime() {
        Date dataAtual = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm");
        return dateFormat.format(dataAtual);
    }
}
