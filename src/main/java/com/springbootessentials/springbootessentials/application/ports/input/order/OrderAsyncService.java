package com.springbootessentials.springbootessentials.application.ports.input.order;

import com.springbootessentials.springbootessentials.domain.order.SendOrder;

public interface OrderAsyncService {

    void sendOrderAsync(SendOrder order);
}
