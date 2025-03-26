package com.springbootessentials.springbootessentials.service.events;

public interface SendEventService {


    void subscribe(Event eventType, EventListener listener);
    void unsubscribe(Event eventType, EventListener listener);
    void notify(Event eventType, Object data);


}
