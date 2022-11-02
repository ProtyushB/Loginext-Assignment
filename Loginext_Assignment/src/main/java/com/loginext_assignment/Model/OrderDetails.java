package com.loginext_assignment.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class OrderDetails {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    Integer id;

    @NotNull
    Integer orderPlacementTime;

    @NotNull
    Integer travelTime;

    @NotNull
    String status="Processing";

    @OneToOne
    Customer customer;

    @OneToOne
    DeliveryBoy deliveryBoy;

    public OrderDetails() {
    }

    public OrderDetails(Integer id, Integer orderPlacementTime, Integer travelTime, String status, Customer customer, DeliveryBoy deliveryBoy) {
        this.id = id;
        this.orderPlacementTime = orderPlacementTime;
        this.travelTime = travelTime;
        this.status = status;
        this.customer = customer;
        this.deliveryBoy = deliveryBoy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderPlacementTime() {
        return orderPlacementTime;
    }

    public void setOrderPlacementTime(Integer orderPlacementTime) {
        this.orderPlacementTime = orderPlacementTime;
    }

    public Integer getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Integer travelTime) {
        this.travelTime = travelTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public DeliveryBoy getDeliveryBoy() {
        return deliveryBoy;
    }

    public void setDeliveryBoy(DeliveryBoy deliveryBoy) {
        this.deliveryBoy = deliveryBoy;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", orderPlacementTime=" + orderPlacementTime +
                ", travelTime=" + travelTime +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", deliveryBoy=" + deliveryBoy +
                '}';
    }
}
