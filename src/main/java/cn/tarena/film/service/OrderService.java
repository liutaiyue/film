package cn.tarena.film.service;

import java.util.List;

import cn.tarena.film.pojo.Order;

public interface OrderService {

	List<Order> findAll();

	void deleteOrder(String[] orderId);

	void saveOrder(Order order);

	List<Order> findOrderByUId(String userId);

}
