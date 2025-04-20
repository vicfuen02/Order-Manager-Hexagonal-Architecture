package com.springbootessentials.springbootessentials.application.ports.input.event;

import com.springbootessentials.springbootessentials.domain.events.SPEssentialsEvent;

public interface SPEssentialsEventListener {

    void update(SPEssentialsEvent evenEnum, Object data);

}
