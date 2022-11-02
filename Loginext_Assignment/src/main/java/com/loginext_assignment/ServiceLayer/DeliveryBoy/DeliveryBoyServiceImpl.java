package com.loginext_assignment.ServiceLayer.DeliveryBoy;

import com.loginext_assignment.Dao.DeliveryBoyDao;
import com.loginext_assignment.Dao.OrderDetailsDao;
import com.loginext_assignment.Exceptions.DeliveryBoyNotFoundException;
import com.loginext_assignment.Exceptions.OrderDetailsNotFoundException;
import com.loginext_assignment.Model.DeliveryBoy;
import com.loginext_assignment.Model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryBoyServiceImpl implements DeliveryBoyService{

    @Autowired
    private DeliveryBoyDao deliveryBoyDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;



    @Override
    public DeliveryBoy addDeliveryBoy(DeliveryBoy deliveryBoy) {
        return deliveryBoyDao.save(deliveryBoy);
    }

    @Override
    public DeliveryBoy getDeliveryBoy(Integer id) throws DeliveryBoyNotFoundException {
        DeliveryBoy deliveryBoy = null;

        Optional<DeliveryBoy> optDeliveryBoy = deliveryBoyDao.findById(id);

        if (optDeliveryBoy.isPresent()) deliveryBoy = optDeliveryBoy.get();
        else {
            throw new DeliveryBoyNotFoundException("Delivery Boy Not Found");
        }
        return deliveryBoy;
    }

    @Override
    public DeliveryBoy updateDeliveryBoy(DeliveryBoy deliveryBoy) throws DeliveryBoyNotFoundException {
        Optional<DeliveryBoy> optDeliveryBoy = deliveryBoyDao.findById(deliveryBoy.getId());

        if (optDeliveryBoy.isPresent()) deliveryBoyDao.save(deliveryBoy);
        else {
            throw new DeliveryBoyNotFoundException("Delivery Boy Not Found");
        }
        return deliveryBoy;
    }

    @Override
    public String deleteDeliveryBoy(Integer id) throws DeliveryBoyNotFoundException {

        Optional<DeliveryBoy> optDeliveryBoy = deliveryBoyDao.findById(id);

        if (optDeliveryBoy.isPresent()) deliveryBoyDao.delete(optDeliveryBoy.get());
        else {
            throw new DeliveryBoyNotFoundException("Delivery Boy Not Found");
        }
        return "DeliveryBoy Deleted Successfully";
    }

    @Override
    public String changeOrderCompleteStatus(Integer orderId) throws OrderDetailsNotFoundException {
        OrderDetails orderDetails = null;
        DeliveryBoy deliveryBoy = null;

        Optional<OrderDetails> optOrder = orderDetailsDao.findById(orderId);

        if(optOrder.isPresent()){
            orderDetails = optOrder.get();

            orderDetails.setStatus("Delivered");
            deliveryBoy = orderDetails.getDeliveryBoy();

            deliveryBoy.setStatus("Vacant");

            deliveryBoyDao.save(deliveryBoy);
            orderDetailsDao.save(orderDetails);
        }
        else{
            throw new OrderDetailsNotFoundException("Order Details Not Found");
        }
        return "Status Changed";
    }
}
