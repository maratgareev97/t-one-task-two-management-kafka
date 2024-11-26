package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaTaskListener {

    private final NotificationService notificationService;

    @KafkaListener(topics = "test-topic", groupId = "notification-service-group")
    public void listen(String message) {
        log.info("Сообщение: {}", message);
        notificationService.sendNotification(message);
    }
}