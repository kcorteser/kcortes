package com.example.kcortes.event;

import com.example.kcortes.model.Driver;
import com.example.kcortes.model.Truck;
import org.springframework.context.ApplicationEvent;

public class TruckDriverEvent extends ApplicationEvent {
    private Truck truck;
    private Driver driver;
    private String action;

    public TruckDriverEvent(Object source, Truck truck, String action) {
        super(source);
        this.truck = truck;
        this.action = action;
    }

    public TruckDriverEvent(Object source, Driver driver, String action) {
        super(source);
        this.action = action;
        this.driver = driver;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}