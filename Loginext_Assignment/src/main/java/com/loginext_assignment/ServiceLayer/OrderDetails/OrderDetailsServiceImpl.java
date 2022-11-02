package com.loginext_assignment.ServiceLayer.OrderDetails;

import com.loginext_assignment.Dao.CustomerDao;
import com.loginext_assignment.Dao.DeliveryBoyDao;
import com.loginext_assignment.Dao.OrderDetailsDao;
import com.loginext_assignment.Exceptions.CustomerNotFoundException;
import com.loginext_assignment.Exceptions.DeliveryBoyNotFoundException;
import com.loginext_assignment.Exceptions.OrderDetailsNotFoundException;
import com.loginext_assignment.Model.Customer;
import com.loginext_assignment.Model.DeliveryBoy;
import com.loginext_assignment.Model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private DeliveryBoyDao deliveryBoyDao;

    @Autowired
    private CustomerDao customerDao;


    @Override
    public OrderDetails addOrderDetails(OrderDetails orderDetails, Integer custId) throws CustomerNotFoundException, DeliveryBoyNotFoundException {
        List<Integer> deliveryBoys = deliveryBoyDao.getDeliveryBoyByStatus("Vacant");

        if (deliveryBoys.size()>0){
            Integer id = deliveryBoys.get(0);

            DeliveryBoy deliveryBoy = deliveryBoyDao.findById(deliveryBoys.get(0)).get();

            Customer customer = null;

            Optional<Customer> optCustomer = customerDao.findById(custId);

            if (optCustomer.isPresent()){
                customer = optCustomer.get();

                deliveryBoy.setStatus("Busy");

                orderDetails.setDeliveryBoy(deliveryBoy);
                orderDetails.setCustomer(customer);

                orderDetailsDao.save(orderDetails);
            }
            else{
                throw new CustomerNotFoundException("Customer Not Found");
            }
        }
        else{
            throw new DeliveryBoyNotFoundException("Delivery Boy Not Found");
        }

        return orderDetails;
    }

    @Override
    public OrderDetails getOrderDetails(Integer id) throws OrderDetailsNotFoundException {
        OrderDetails orderDetails = null;

        Optional<OrderDetails> optOrderDetails = orderDetailsDao.findById(id);

        if (optOrderDetails.isPresent()){
            orderDetails = optOrderDetails.get();
        }
        else {
            throw new OrderDetailsNotFoundException("Order Details Not Found");
        }
        return orderDetails;
    }

    @Override
    public OrderDetails updateOrderDetails(OrderDetails orderDetails) throws OrderDetailsNotFoundException {

        Optional<OrderDetails> optOrderDetails = orderDetailsDao.findById(orderDetails.getId());

        if (optOrderDetails.isPresent()){
            orderDetailsDao.save(orderDetails);
        }
        else {
            throw new OrderDetailsNotFoundException("Order Details Not Found");
        }

        return orderDetails;
    }

    @Override
    public String deleteOrderDetails(Integer id) throws OrderDetailsNotFoundException {
        Optional<OrderDetails> optOrderDetails = orderDetailsDao.findById(id);

        if (optOrderDetails.isPresent()) orderDetailsDao.delete(optOrderDetails.get());
        else {
            throw new OrderDetailsNotFoundException("Order Details Not Found");
        }
        return "Order Successfully Deleted";
    }
}
