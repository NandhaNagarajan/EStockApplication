package com.EStockMarket.EStockMarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.EStockMarket.EStockMarket.entity.StockInfo;

@Repository
public interface StockRepository extends JpaRepository<StockInfo, Long> {

	@Query(value = "select * from Stock_Info where Comapny_Code= ?1", nativeQuery = true)
	List<StockInfo> findByCompanyCode(Long companycode);

}
