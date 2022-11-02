package com.loginext_assignment.Controller;

import com.loginext_assignment.Exceptions.DeliveryBoyNotFoundException;
import com.loginext_assignment.Exceptions.OrderDetailsNotFoundException;
import com.loginext_assignment.Model.DeliveryBoy;
import com.loginext_assignment.ServiceLayer.DeliveryBoy.DeliveryBoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveryBoy")
public class DeliveryBoyController {

    @Autowired
    private DeliveryBoyService deliveryBoyService;

    @PostMapping("/")
    public ResponseEntity<DeliveryBoy> addDeliveryBoy(@RequestBody DeliveryBoy deliveryBoy){
        return new ResponseEntity<>(deliveryBoyService.addDeliveryBoy(deliveryBoy), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryBoy> getDeliveryBoy(@PathVariable ("id") Integer id) throws DeliveryBoyNotFoundException {
        return new ResponseEntity<>(deliveryBoyService.getDeliveryBoy(id), HttpStatus.FOUND);
    }

    @PutMapping("/")
    public ResponseEntity<DeliveryBoy> updateDeliveryBoy(@RequestBody DeliveryBoy deliveryBoy) throws DeliveryBoyNotFoundException {
        return new ResponseEntity<>(deliveryBoyService.updateDeliveryBoy(deliveryBoy), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeliveryBoy(@PathVariable ("id") Integer id) throws DeliveryBoyNotFoundException {
        return new ResponseEntity<>(deliveryBoyService.deleteDeliveryBoy(id), HttpStatus.OK);
    }

    @PutMapping("/changeStatus/{id}")
    public ResponseEntity<String> changeOrderStatus(@PathVariable ("id") Integer id) throws OrderDetailsNotFoundException {
        return new ResponseEntity<>(deliveryBoyService.changeOrderCompleteStatus(id), HttpStatus.ACCEPTED);
    }
}
