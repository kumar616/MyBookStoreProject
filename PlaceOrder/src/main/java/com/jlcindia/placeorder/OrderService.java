package com.jlcindia.placeorder;

import java.util.List;

public interface OrderService {
	public void placeOrder(OrderInfo orderinfo);
	public List<Order> getOrdersByUserId(String userId);
}
