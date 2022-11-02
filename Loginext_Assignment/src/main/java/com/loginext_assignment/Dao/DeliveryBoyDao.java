package com.loginext_assignment.Dao;

import com.loginext_assignment.Model.DeliveryBoy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryBoyDao extends JpaRepository<DeliveryBoy, Integer> {

    @Query ("select id from DeliveryBoy where status=?1 order by id")
    public List<Integer> getDeliveryBoyByStatus(String status);
}
