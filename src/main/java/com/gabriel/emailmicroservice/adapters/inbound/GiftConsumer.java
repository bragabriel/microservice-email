package com.gabriel.emailmicroservice.adapters.inbound;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabriel.emailmicroservice.application.core.domain.collection.User;
import com.gabriel.emailmicroservice.application.core.domain.dto.EmailDTO;
import com.gabriel.emailmicroservice.application.core.domain.dto.GiftDTO;
import com.gabriel.emailmicroservice.application.core.domain.service.EmailService;
import com.gabriel.emailmicroservice.application.core.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GiftConsumer {

    private static final Logger logger = LoggerFactory.getLogger(GiftConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;

    @KafkaListener(topics = "giftDelivery-topic", groupId = "group-1")
    public void consumeGift(String messageJson) {
        try {
            GiftDTO gift = objectMapper.readValue(messageJson, GiftDTO.class);
            logger.info("Received gift: {}", gift);

            sendGiftConfirmationEmails(gift);
        } catch (Exception e) {
            logger.error("Error processing gift message", e);
        }
    }

    private void sendGiftConfirmationEmails(GiftDTO gift) throws Exception {
        User sender = userService.getById(gift.getSenderId());
        User recipient = userService.getById(gift.getRecipientId());

        EmailDTO sentEmail = constructGiftConfirmationEmail(sender, recipient, true);
        emailService.giftSentEmail(sentEmail);

        EmailDTO receivedEmail = constructGiftConfirmationEmail(sender, recipient, false);
        emailService.giftReceivedEmail(receivedEmail);
    }

    private EmailDTO constructGiftConfirmationEmail(User sender, User recipient, boolean isSender) {
        String senderName = sender.getName();
        String recipientName = recipient.getName();
        String recipientEmail = isSender ? sender.getEmail() : recipient.getEmail();

        return new EmailDTO(senderName, recipientName, recipientEmail);
    }
}
