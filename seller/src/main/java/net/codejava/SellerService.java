package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repo;
	
	public List<Seller> listAll(){
		return repo.findAll();
		
	}
	public void save(Seller seller) {
		repo.save(seller);
	}
	public Seller get(Integer idSeller) {
		return repo.findById(idSeller).get();
		}

	public void delete(Integer  idSeller) {
		repo.deleteById(idSeller);
	}
}
