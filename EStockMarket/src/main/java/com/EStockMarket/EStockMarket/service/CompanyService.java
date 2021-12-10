package com.EStockMarket.EStockMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EStockMarket.EStockMarket.entity.CompanyInfo;
import com.EStockMarket.EStockMarket.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyInfo addCompanyDetails(CompanyInfo companyInfo) 
	{
		CompanyInfo companyInfoCreated=companyRepository.save(companyInfo);
		return companyInfoCreated;
	}
	
	public CompanyInfo findByCompanyCode(Long id)
	{
		return companyRepository.findById(id).get();
	}
	
	public List<CompanyInfo> getAllCompanyDetails()
	{
		return companyRepository.findAll();
	}
	
	public void deleteByCompanyCode(Long companycode)
	{
		companyRepository.deleteById(companycode);
	}

}
