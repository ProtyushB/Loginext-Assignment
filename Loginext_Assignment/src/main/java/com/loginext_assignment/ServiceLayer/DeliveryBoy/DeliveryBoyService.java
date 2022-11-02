package com.loginext_assignment.ServiceLayer.DeliveryBoy;

import com.loginext_assignment.Exceptions.DeliveryBoyNotFoundException;
import com.loginext_assignment.Exceptions.OrderDetailsNotFoundException;
import com.loginext_assignment.Model.DeliveryBoy;

public interface DeliveryBoyService {

    DeliveryBoy addDeliveryBoy(DeliveryBoy deliveryBoy);

    DeliveryBoy getDeliveryBoy(Integer id) throws DeliveryBoyNotFoundException;

    DeliveryBoy updateDeliveryBoy(DeliveryBoy deliveryBoy) throws DeliveryBoyNotFoundException;

    String deleteDeliveryBoy(Integer id) throws DeliveryBoyNotFoundException;

    String changeOrderCompleteStatus(Integer orderId) throws OrderDetailsNotFoundException;
}
