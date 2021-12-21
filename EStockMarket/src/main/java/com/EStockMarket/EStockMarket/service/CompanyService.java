package com.EStockMarket.EStockMarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EStockMarket.EStockMarket.entity.CompanyInfo;
import com.EStockMarket.EStockMarket.entity.CompanyPage;
import com.EStockMarket.EStockMarket.repository.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public CompanyInfo addCompanyDetails(CompanyInfo companyInfo) {
		CompanyInfo companyInfoCreated = companyRepository.save(companyInfo);
		return companyInfoCreated;
	}

	public CompanyInfo findByCompanyCode(Long id) {
		return companyRepository.findById(id).get();
	}

	/*
	 * public List<CompanyInfo> getAllCompanyDetails() { return
	 * companyRepository.findAll(); }
	 */
	
	public Page<CompanyInfo> getAllCompanyDetails(CompanyPage companyPage)
	{
		Sort sort=Sort.by(companyPage.getSortDirection(),companyPage.getSortBy() );
		Pageable pageable=PageRequest.of(companyPage.getPageNumber(),companyPage.getPageSize(),sort);
		return companyRepository.findAll(pageable);
	}

	public void deleteByCompanyCode(Long companycode) {
		companyRepository.deleteById(companycode);
	}

}
