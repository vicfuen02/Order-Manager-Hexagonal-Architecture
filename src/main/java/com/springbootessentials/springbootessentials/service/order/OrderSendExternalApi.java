package com.springbootessentials.springbootessentials.service.order;

import com.springbootessentials.springbootessentials.service.order.dto.SendOrderBDTO;

public interface OrderSendExternalApi {

    void sendOrderToExternalApi(SendOrderBDTO order);

}
