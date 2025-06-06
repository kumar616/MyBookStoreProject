package com.jlcindia.placeorder;

import java.util.List;

public class OrderInfo {
	
	private Order order;
	private List<OrderItem> itemsList;
	
	public OrderInfo() {}
	
	public OrderInfo(Order order, List<OrderItem> itemsList) {
	super();
	this.order = order;
	this.itemsList = itemsList;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderItem> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<OrderItem> itemsList) {
		this.itemsList = itemsList;
	}
	
	
}
