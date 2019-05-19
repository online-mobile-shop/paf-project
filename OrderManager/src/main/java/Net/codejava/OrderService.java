package Net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repo;
	
	public List<Order> listAll(){
		return repo.findAll();

}
	public void save(Order order) {
		repo.save(order);
}
	public Order get(Integer idorders) {
		return repo.findById(idorders).get();
		}
	
	public void delete(Integer  idorders) {
		repo.deleteById(idorders);
	}
}