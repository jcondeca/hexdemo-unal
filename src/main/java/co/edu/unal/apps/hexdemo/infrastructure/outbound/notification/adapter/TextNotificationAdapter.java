package co.edu.unal.apps.hexdemo.infrastructure.outbound.notification.adapter;

import co.edu.unal.apps.hexdemo.application.outbound.services.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class TextNotificationAdapter implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending text notification: " + message);
    }
}
