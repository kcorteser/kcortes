package com.example.kcortes.service.impl;

import com.example.kcortes.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {
    @Autowired
    private JavaMailSender emailSender;

    public void sendNotification(String recipient, String title, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(title);
        message.setText(body);
        emailSender.send(message);
    }
}
