package com.springbootessentials.springbootessentials.service.events;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SendEventServiceImpl implements SendEventService {

    private final Map<Event, List<EventListener>> customers;

    public SendEventServiceImpl() {
        customers = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event -> customers.put(event, new ArrayList<>()));
    }


    @Override
    public void subscribe(Event eventType, EventListener listener) {
        customers.get(eventType).add(listener);
    }

    @Override
    public void unsubscribe(Event eventType, EventListener listener) {
        customers.get(eventType).remove(listener);
    }

    @Override
    public void notify(Event eventType, Object data) {
        customers.get(eventType).forEach(listener -> listener.update(eventType, data));
    }

}
