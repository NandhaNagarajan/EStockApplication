package com.EStockMarket.EStockMarket;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.EStockMarket.EStockMarket.controller.Company;
import com.EStockMarket.EStockMarket.entity.CompanyInfo;

public class CompanyTests {
	
	private Company company;
	@BeforeEach
	void setUp()
	{
		company = new Company();
	}
	
	@Test
	void getCompanyDetailsByCodeTest()
	{
		//given
		
		CompanyInfo companyInfo=new CompanyInfo();
		companyInfo.setCompanyCode(10001L);
		companyInfo.setCompanyName("IEX");
		companyInfo.setCompanyCEO("Narayana moorthy");
		companyInfo.setCompanyTurnOver(new BigDecimal(1000.00));
		companyInfo.setCompanyWebsite("IEX.com");
		companyInfo.setStockExchange("NSE");
		
		CompanyInfo expected=companyInfo;
		
		//when
		
		CompanyInfo actual=company.getCompanyDetailsByCode(10001L);
		
		//then
				
		assertEquals(expected,actual);	
	}

}
