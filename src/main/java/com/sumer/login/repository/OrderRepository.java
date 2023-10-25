package com.sumer.login.repository;

import com.sumer.login.repository.dto.OrderFruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderFruit, Long>  {

    OrderFruit findOrderById(Long id);
}
