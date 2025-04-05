package com.springbootessentials.springbootessentials.service.events;

public interface SendSPEssentialsEventService {


    void subscribe(SPEssentialsEvent SPEssentialsEventType, SPEssentialsEventListener listener);
    void unsubscribe(SPEssentialsEvent SPEssentialsEventType, SPEssentialsEventListener listener);
    void notify(SPEssentialsEvent SPEssentialsEventType, Object data);


}
