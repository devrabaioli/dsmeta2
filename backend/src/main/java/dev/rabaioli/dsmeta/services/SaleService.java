package dev.rabaioli.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.rabaioli.dsmeta.entities.Sale;
import dev.rabaioli.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repo;
	
	public List<Sale> findSale(){
		
		return repo.findAll();
		
	}
}
