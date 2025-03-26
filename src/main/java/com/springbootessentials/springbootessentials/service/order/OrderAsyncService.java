package com.springbootessentials.springbootessentials.service.order;

import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;

public interface OrderAsyncService {

    void sendOrderAsync(SendOrderBDTO order);
}
