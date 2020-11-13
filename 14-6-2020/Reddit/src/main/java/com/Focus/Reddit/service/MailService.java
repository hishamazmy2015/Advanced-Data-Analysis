package com.Focus.Reddit.service;

import com.Focus.Reddit.model.NotificationEmail;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class mailService {
    private final JavaMailSender mailSender;
    private final MailContainBuilder mailContainBuilder;

    void sendMail(NotificationEmail notificationEmail) {
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {

        };
    }


}

