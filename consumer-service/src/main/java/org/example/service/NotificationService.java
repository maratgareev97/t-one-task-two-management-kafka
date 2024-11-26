package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    @Autowired
    public JavaMailSender emailSender;

    public void sendNotification(String message) {
        log.info("Сообщение отправлено: {}", message);
        sendEmail("maratwork1987@rambler.ru", "текст", message);
    }

    private void sendEmail(String to, String subject, String text) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(to);
            mailMessage.setSubject(subject);
            mailMessage.setText(text);
            emailSender.send(mailMessage);
            log.info("Email отправлена на {}", to);
        } catch (Exception e) {
            log.error("Ошибка отправления почты", e);
        }
    }
}