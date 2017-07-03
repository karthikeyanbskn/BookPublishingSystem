package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	// @Query(value="select * from orders o, order_items oi where o.id =
	// oi.order_id and user_id =?1", nativeQuery=true)
	public List<Order> findByUserIdOrderByIdDesc(Long userId);

	public List<Order> findByOrderByIdDesc();

	/*
	 * @Query(name = "SELECT fn_get_order_amount(?1)", nativeQuery = true)
	 * public Integer findTotalPrice(Long orderId);
	 */

}
