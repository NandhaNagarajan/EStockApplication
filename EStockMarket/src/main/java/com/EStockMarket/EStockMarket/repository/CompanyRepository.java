package com.EStockMarket.EStockMarket.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.EStockMarket.EStockMarket.entity.CompanyInfo;
import com.EStockMarket.EStockMarket.entity.StockInfo;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<CompanyInfo, Long> {

	@Query(value = "delete from COMPANY_INFO where Comapny_Code= ?1", nativeQuery = true)
	List<StockInfo> deleteByCompanyCode(Long companycode1);

}
