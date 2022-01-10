package com.EStockMarket.EStockMarket.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.EStockMarket.EStockMarket.entity.CompanyInfo;
import com.EStockMarket.EStockMarket.entity.CompanyPage;
import com.EStockMarket.EStockMarket.service.CompanyService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1.0/market/company")
public class Company {

	@Autowired
	private CompanyService companyService;

	@PostMapping(path = "/register")
	public ResponseEntity<Void> addCompanyDetails(@RequestBody CompanyInfo companyInfo) {

		CompanyInfo companyInfoCreated = companyService.addCompanyDetails(companyInfo);
		
		int count=0;
		if(count==0)
		{
			
		}

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/api/v1.0/market/company/info")
				.path("/{companyCode}").buildAndExpand(companyInfoCreated.getCompanyCode()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping(path = "/info/{companycode}")
	public CompanyInfo getCompanyDetailsByCode(@PathVariable Long companycode) {
		return companyService.findByCompanyCode(companycode);
	}

	/* @GetMapping(path = "/getall")
	public List<CompanyInfo> getAllCompanyDetails() {
		return companyService.getAllCompanyDetails();
	} */
	
	@GetMapping(path = "/getall")
	public ResponseEntity<Page<CompanyInfo>> getAllCompanyDetails(@RequestParam int page, @RequestParam int size)
	{
		CompanyPage companyPage= new CompanyPage();
		companyPage.setPageNumber(page);
		companyPage.setPageSize(size);
		return new ResponseEntity<>(companyService.getAllCompanyDetails(companyPage),HttpStatus.OK);
	}

	@DeleteMapping(path = "/delete/{companycode}")
	public ResponseEntity<Void> deleteByCompanyCode(@PathVariable Long companycode) {
		companyService.deleteByCompanyCode(companycode);

		return ResponseEntity.noContent().build();
	}

}
