package cn.tarena.film.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.film.mapper.OrderMapper;
import cn.tarena.film.mapper.SeatMapper;
import cn.tarena.film.pojo.Order;
import cn.tarena.film.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Resource
	private SeatMapper seatMapper;
	@Override
	public List<Order> findAll() {
		return orderMapper.findAll();
	}

	@Override
	public void deleteOrder(String[] orderId) {
		for (String oid : orderId) {
			Order order = orderMapper.findOrderByOId(oid);
			seatMapper.deleteSeat(order.getSeat().getSeatId());
		}
		orderMapper.deleteOrder(orderId);
		
	}

	@Override
	public void saveOrder(Order order) {
		order.setOrderId(UUID.randomUUID().toString());
		orderMapper.saveOrder(order);
		
	}

	@Override
	public List<Order> findOrderByUId(String userId) {
		return orderMapper.findOrderByUid(userId);
	}

}
