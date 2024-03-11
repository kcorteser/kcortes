package com.example.kcortes.listener;

import com.example.kcortes.event.TruckDriverEvent;
import com.example.kcortes.service.impl.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TruckDriverEventListener {

    @Autowired
    private EmailNotificationService emailNotificationService;

    @EventListener
    public void handleTruckEvent(TruckDriverEvent event) {
        String emailAddress = event.getTruck().getWarehouse().getEmailAddress();
        String message = event.getAction() + " - " + event.getTruck().getRegistrationNumber();
        emailNotificationService.sendNotification(emailAddress, "Notificación de camión", message);
    }

    @EventListener
    public void handleDriverEvent(TruckDriverEvent event) {
        String emailAddress = event.getDriver().getEmailAddress();
        String message = event.getAction() + " - " + event.getDriver().getFirstName() + " " + event.getDriver().getLastName() ;
        emailNotificationService.sendNotification(emailAddress, "Notificación de conductor", message);
    }

}