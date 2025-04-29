package com.springbootessentials.springbootessentials.application.ports.input.event;

import com.springbootessentials.springbootessentials.domain.events.SPEssentialsEvent;

public interface SendSPEssentialsEventService {


    void subscribe(SPEssentialsEvent SPEssentialsEventType, SPEssentialsEventListener listener);
    void unsubscribe(SPEssentialsEvent SPEssentialsEventType, SPEssentialsEventListener listener);
    void notify(SPEssentialsEvent SPEssentialsEventType, Object data);


}
