package com.loginext_assignment.ServiceLayer.OrderDetails;

import com.loginext_assignment.Exceptions.CustomerNotFoundException;
import com.loginext_assignment.Exceptions.DeliveryBoyNotFoundException;
import com.loginext_assignment.Exceptions.OrderDetailsNotFoundException;
import com.loginext_assignment.Model.OrderDetails;

public interface OrderDetailsService {

    OrderDetails addOrderDetails(OrderDetails orderDetails, Integer custId) throws CustomerNotFoundException, DeliveryBoyNotFoundException;

    OrderDetails getOrderDetails(Integer id) throws OrderDetailsNotFoundException;

    OrderDetails updateOrderDetails(OrderDetails orderDetails) throws OrderDetailsNotFoundException;

    String deleteOrderDetails(Integer id) throws OrderDetailsNotFoundException;
}
