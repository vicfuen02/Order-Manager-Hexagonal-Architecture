package com.springbootessentials.springbootessentials.service.events;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SendSPEssentialsEventServiceImpl implements SendSPEssentialsEventService {

    private final Map<SPEssentialsEvent, List<SPEssentialsEventListener>> customers;

    public SendSPEssentialsEventServiceImpl() {
        customers = new HashMap<>();
        Arrays.stream(SPEssentialsEvent.values()).forEach(event -> customers.put(event, new ArrayList<>()));
    }


    @Override
    public void subscribe(SPEssentialsEvent SPEssentialsEventType, SPEssentialsEventListener listener) {
        customers.get(SPEssentialsEventType).add(listener);
    }

    @Override
    public void unsubscribe(SPEssentialsEvent SPEssentialsEventType, SPEssentialsEventListener listener) {
        customers.get(SPEssentialsEventType).remove(listener);
    }

    @Override
    public void notify(SPEssentialsEvent SPEssentialsEventType, Object data) {
        customers.get(SPEssentialsEventType).forEach(listener -> listener.update(SPEssentialsEventType, data));
    }

}
