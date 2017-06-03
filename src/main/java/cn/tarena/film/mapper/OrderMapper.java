package cn.tarena.film.mapper;

import java.util.List;

import cn.tarena.film.pojo.Order;

public interface OrderMapper {

	List<Order> findAll();

	void deleteOrder(String[] orderId);

	void saveOrder(Order order);

	List<Order> findOrderByUid(String userId);

	Order findOrderByOId(String oid);

}
