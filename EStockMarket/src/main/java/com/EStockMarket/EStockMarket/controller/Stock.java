package com.EStockMarket.EStockMarket.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.EStockMarket.EStockMarket.entity.CompanyInfo;
import com.EStockMarket.EStockMarket.entity.StockInfo;
import com.EStockMarket.EStockMarket.service.StockService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1.0/market/stock")
public class Stock {

	@Autowired
	private StockService stockService;

	@Autowired
	private CompanyDetailsProxy companyproxy;

	@PostMapping(path = "/add/{companycode}")
	public ResponseEntity<Void> addStockDetails(@PathVariable Long companycode, @RequestBody StockInfo stockInfo) {
		CompanyInfo companyDetails = companyproxy.getCompanyDetailsByCode(companycode);
		stockInfo.setCompanyInfo(companyDetails);
		stockService.addStockDetails(companycode, stockInfo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/api/v1.0/market/company/info")
				.path("/{companyCode}").buildAndExpand(companycode).toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping(path = "/get/{companycode}")
	public List<StockInfo> getAllStockDetailsByCode(@PathVariable Long companycode) {
		return stockService.getAllStockDetailsByCode(companycode);
	}

	@GetMapping(path = "/get/{companycode}/{startdate}/{enddate}")
	public List<StockInfo> getAllStockDetails(@PathVariable Long companycode, @PathVariable String startdate,
			@PathVariable String enddate) {
		return stockService.getAllStockDetails(companycode, startdate, enddate);
	}

}
