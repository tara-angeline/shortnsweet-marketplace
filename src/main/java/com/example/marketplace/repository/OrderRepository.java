package com.example.marketplace.repository;

import com.example.marketplace.model.Order;
import com.example.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserOrderByCreatedAtDesc(User user);

    @Query("select distinct o from Order o left join fetch o.items left join fetch o.user order by o.createdAt desc")
    List<Order> findAllWithItemsNewestFirst();

    @Query("select o from Order o left join fetch o.items left join fetch o.user where o.id = :id")
    Optional<Order> findByIdWithItems(Long id);
}