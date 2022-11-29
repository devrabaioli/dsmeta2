package dev.rabaioli.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.rabaioli.dsmeta.entities.Sale;
import dev.rabaioli.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repo;
	
	public Page<Sale> findSale(String minDate,String maxDate, Pageable page){
		
		LocalDate today =LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? today : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today.minusDays(365) :  LocalDate.parse(maxDate);
		
		return repo.findSales(min,max,page);
		
	}
}
