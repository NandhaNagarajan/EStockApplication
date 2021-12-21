package com.EStockMarket.EStockMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.EStockMarket.EStockMarket.controller.Company;
import com.EStockMarket.EStockMarket.entity.CompanyInfo;
import com.EStockMarket.EStockMarket.entity.CompanyPage;
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
	
	public List<StockInfo> getAllStockDetailsByCode(Long companycode, int page, int size)
	{
		return stockRepository.findByCustomQuery(companycode,page,size);
	}
	
	public int getTotalElementsValue(Long companycode)
	{
		return stockRepository.getTotalElementsValue(companycode);
	}
	
	/*public Page<StockInfo> getAllStockDetailsPaginate(CompanyPage companyPage,Long companyCode)
	{
		Sort sort=Sort.by(companyPage.getSortDirection(),companyPage.getSortBy() );
		Pageable pageable=PageRequest.of(companyPage.getPageNumber(),companyPage.getPageSize(),sort);
		return stockRepository.findByCompanyCode(companyCode,pageable);
	}*/

	
	/*public List<StockInfo> getAllStockDetails(Long companycode, String startDate, String endDate)
	{
		//return stockRepository.findAll();
	}*/
}
