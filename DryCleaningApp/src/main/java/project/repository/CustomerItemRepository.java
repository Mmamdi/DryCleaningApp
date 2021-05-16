package project.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.jpa.*;
import project.models.*;
@Repository
public class CustomerItemRepository implements ICustomerItemRepository{
	
	@Autowired
	private ICustomerItemJpa customeritemjpa;
	
	@Autowired
	private ICustomerJpa customerjpa;
	
	public CustomerItem addItem(CustomerItem item) {
		customeritemjpa.save(item);
		return(item);
	}
	
	public CustomerItem removeItem(long id) {
		CustomerItem c = customeritemjpa.findById(id).get();
		customeritemjpa.delete(c);
		return c;
	}
	
	public CustomerItem updateItem(long id, CustomerItem item) {
		CustomerItem c = customeritemjpa.findById(id).get();
		c.setItemId(item.getItemId());
		c.setCategory(item.getCategory());
		c.setColor(item.getColor());
		c.setCustomer(item.getCustomer());
		c.setDescription(item.getCategory());
		c.setMaterial(item.getMaterial());
		c.setName(item.getName());
		c.setQuantity(item.getQuantity());
		customeritemjpa.save(c);
		return c;
	}
	
	public CustomerItem getItem(long id) {
		CustomerItem c = customeritemjpa.findById(id).get();
		return c;
	}
	
	public List<CustomerItem> getItemsByCustomer(long customerId){
		Customer customer=customerjpa.findById(Long.toString(customerId)).get();
		List<CustomerItem> cItem = customeritemjpa.findByCustomer(customer);
		return cItem;
	}
}
