package dev.rabaioli.dsmeta.controlleres;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.rabaioli.dsmeta.entities.Sale;
import dev.rabaioli.dsmeta.services.SaleService;

@RestController
@RequestMapping (value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<Sale> findSales(
			@RequestParam(value="minDate",defaultValue = "") String minDate,
			@RequestParam(value="maxDate",defaultValue = "") String maxDate,
			Pageable page){
		
		return service.findSale(minDate,maxDate,page);
	}

}
