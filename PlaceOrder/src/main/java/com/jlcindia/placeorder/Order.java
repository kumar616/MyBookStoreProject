package com.jlcindia.placeorder;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name="myorders",schema="jlcordersdb")
@ApiModel("OrderItems contains Order Details")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="order_Id_generator")
	@SequenceGenerator(name="order_Id_generator",sequenceName="myorderId_gen",initialValue=5002,allocationSize=1)
	@Column(name="order_id")
	private Integer orderId;
	
	@Column(name = "order_date")
	private String orderDate;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "total_qty")
	private int totalQty;
	
	@Column(name = "total_cost")
	private double totalCost;
	
	@Column(name = "status")
	private String status;

	public Order() {}
	
	public Order(String orderDate, String userId, int totalQty, double totalCost, String status) {
		this.orderDate = orderDate;
		this.userId = userId;
		this.totalQty = totalQty;
		this.totalCost = totalCost;
		this.status = status;
	}
	
	public Order(Integer orderId, String orderDate, String userId, int totalQty, double totalCost, String status) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.userId = userId;
		this.totalQty = totalQty;
		this.totalCost = totalCost;
		this.status = status;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
