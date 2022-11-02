package com.loginext_assignment.Controller;

import com.loginext_assignment.Exceptions.CustomerNotFoundException;
import com.loginext_assignment.Exceptions.DeliveryBoyNotFoundException;
import com.loginext_assignment.Exceptions.OrderDetailsNotFoundException;
import com.loginext_assignment.Model.OrderDetails;
import com.loginext_assignment.ServiceLayer.OrderDetails.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping("/{id}")
    public ResponseEntity<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails, @PathVariable ("id") Integer id) throws DeliveryBoyNotFoundException, CustomerNotFoundException {
        return new ResponseEntity<>(orderDetailsService.addOrderDetails(orderDetails, id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> getOrderDetails(@PathVariable ("id") Integer id) throws OrderDetailsNotFoundException {
        return new ResponseEntity<>(orderDetailsService.getOrderDetails(id), HttpStatus.FOUND);
    }

    @PutMapping("/")
    public ResponseEntity<OrderDetails> updateOrderDetails(@RequestBody OrderDetails orderDetails) throws OrderDetailsNotFoundException {
        return new ResponseEntity<>(orderDetailsService.updateOrderDetails(orderDetails), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderDetails(@PathVariable ("id") Integer id) throws OrderDetailsNotFoundException {
        return new ResponseEntity<>(orderDetailsService.deleteOrderDetails(id), HttpStatus.OK);
    }
}
