package pt.isep.arqsoft.GorgeousSandwich.repository.order.wrapper;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Service;

import pt.isep.arqsoft.GorgeousSandwich.domain.order.DeliveryTime;
import pt.isep.arqsoft.GorgeousSandwich.domain.order.Order;
import pt.isep.arqsoft.GorgeousSandwich.dto.order.DeliveryTimeDTO;
import pt.isep.arqsoft.GorgeousSandwich.persistence.order.OrderPersistenceJPA;
import pt.isep.arqsoft.GorgeousSandwich.repository.order.IOrderRepositoryJPA;
import pt.isep.arqsoft.GorgeousSandwich.repository.order.mapper.OrderMapperJPA;

@Service("OrderRepositoryWrapperJPA")
public class OrderRepositoryWrapperJPA {

	private OrderMapperJPA mapper;

	private IOrderRepositoryJPA repository;
	
	public OrderRepositoryWrapperJPA(OrderMapperJPA mapper, IOrderRepositoryJPA repository) {
		this.mapper = mapper;
		this.repository = repository;
	}

	public Order save(Order model) {
		this.validateModel(model);
		OrderPersistenceJPA orderJPA = this.mapper.convertToPersistence(model);
		return this.mapper.convertToDomain(this.repository.save(orderJPA));
	}

	public List<Order> findAll() {
		List<OrderPersistenceJPA> ordersJPA = this.repository.findAll();
		return this.mapper.convertListToDomain(ordersJPA);
	}

	public Order update(Order model) {
		this.validateModel(model);
		OrderPersistenceJPA order = this.mapper.convertToPersistence(model);
		return this.mapper.convertToDomain(this.repository.save(order));
	}

	public Order getById(Long Id) {
		return this.mapper.convertToDomain(this.repository.findById(Id).get());
	}

	public List<Order> getByEmail(String email) {
		return this.mapper.convertListToDomain(this.repository.findByEmail(email));
	}

	private void validateModel(Order model) {
		List<DeliveryTimeDTO> list = DeliveryTime.calculateIntervals();
		DeliveryTimeDTO time = new DeliveryTimeDTO(model.obtainDeliveryTime().obtainStartTime().toString(),model.obtainDeliveryTime().obtainEndTime().toString());
		Validate.isTrue(list.contains(time),"Invalid delivery time interval");
	}

}
