/**
 * 
 */
package com.EStockMarket.EStockMarket.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.EStockMarket.EStockMarket.entity.CompanyInfo;

@FeignClient(name = "EStockApplication", url="localhost:8100")
public interface CompanyDetailsProxy {

	@GetMapping(path = "/api/v1.0/market/company/info/{companycode}")
	public CompanyInfo getCompanyDetailsByCode(@PathVariable("companycode") Long companycode);

}
