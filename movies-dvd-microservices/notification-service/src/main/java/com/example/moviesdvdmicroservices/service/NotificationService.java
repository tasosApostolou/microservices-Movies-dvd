package com.example.moviesdvdmicroservices.service;

import com.example.moviesdvdmicroservices.event.CustomerPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final JavaMailSender javaMailSender;

    @KafkaListener(topics = "customer-placed",groupId = "notificationService")
    public void listen(CustomerPlacedEvent customerPlacedEvent) {
        log.info("notification to send");
        log.info("emaill--------------------------------------"+ customerPlacedEvent.getEmail());
        System.out.println(customerPlacedEvent.getEmail());
        log.info("Got message from customer-placed topic {}",customerPlacedEvent);
        // Send email to the customer
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("movieshop@email.com");
            messageHelper.setTo(customerPlacedEvent.getEmail().toString());
            messageHelper.setSubject(String.format("Customer user with username %s is placed succesfully",customerPlacedEvent.getUsername()));
            messageHelper.setText(String.format( """
                    Hi %s %s

                    Your account in movie shop has been created successfully"

                    Best regards
                    Movie Shop
                    """,
                    customerPlacedEvent.getFirstname().toString(),
                    customerPlacedEvent.getLastname().toString()
               ));
        };

        try {
            javaMailSender.send(messagePreparator);
            log.info("Order Notification email sent!");
        }catch (MailException e){
            log.error("Exception occurred when sending email",e);
            throw new RuntimeException("Exception occurred when sending email");
        }
    }
}
