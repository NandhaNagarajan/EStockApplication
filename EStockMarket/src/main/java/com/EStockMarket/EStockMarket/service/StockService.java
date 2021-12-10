package com.EStockMarket.EStockMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EStockMarket.EStockMarket.controller.Company;
import com.EStockMarket.EStockMarket.entity.CompanyInfo;
import com.EStockMarket.EStockMarket.entity.StockInfo;
import com.EStockMarket.EStockMarket.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	public void addStockDetails(Long id,StockInfo stockInfo)
	{
		stockRepository.save(stockInfo);
	}
	
	public List<StockInfo> getAllStockDetailsByCode(Long companycode)
	{
		return stockRepository.findByCompanyCode(companycode);
	}

	
	public List<StockInfo> getAllStockDetails(Long companycode, String startDate, String endDate)
	{
		return stockRepository.findAll();
	}
}
