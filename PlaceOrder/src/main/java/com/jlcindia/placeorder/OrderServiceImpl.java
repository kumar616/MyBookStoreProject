package com.jlcindia.placeorder;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	OrderDAO orderDAO;
	
	@Autowired
	OrderItemDAO orderItemDAO;
	
	@Autowired
	BookInventoryDAO bookInventoryDAO;
	
	@Override
	public void placeOrder(OrderInfo orderinfo) {
		//1.Save Order
		Order order=orderinfo.getOrder();
		orderDAO.save(order);//5002
		int orderId=order.getOrderId();
		
		//2.Save orderItems
		for(OrderItem myitem:orderinfo.getItemsList()) {
			myitem.setOrderId(orderId);
			orderItemDAO.save(myitem);
		}
		
		//3.update Inventory at 2 places
		RestTemplate bookSearchRest=new RestTemplate();
		String endpoint="http://localhost:8000/updateBookInventory";
		
		for(OrderItem myitem:orderinfo.getItemsList()) {
			Integer bookId=myitem.getBookId();
			BookInventory bookInventory=bookInventoryDAO.findById(bookId).get();
			bookInventory.setBooksAvailable(bookInventory.getBooksAvailable()-1);
			
			//3A. update bookinventory locally at placeOrderMS
			bookInventoryDAO.save(bookInventory);
			
			//3B. Update Inventory of BookSearchMS Remotely
			bookSearchRest.put(endpoint, bookInventory);
		}
		
		
		
		
	}

	@Override
	public List<Order> getOrdersByUserId(String userId) {
		log.info("---OrderServiceImpl---getOrdersByUserId()-----");
		List<Order> orderList= orderDAO.findOrdersByUserId(userId);
		return orderList;
	}

}
