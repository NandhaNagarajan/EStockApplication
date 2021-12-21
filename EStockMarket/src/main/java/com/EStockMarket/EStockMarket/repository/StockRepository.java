package com.EStockMarket.EStockMarket.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.EStockMarket.EStockMarket.entity.StockInfo;

@Repository
public interface StockRepository extends JpaRepository<StockInfo, Long> {

	@Query(value = "select * from Stock_Info where Comapny_Code= ?1", nativeQuery = true)
	List<StockInfo> findByCompanyCode(Long companycode,Pageable pageable);
	
	@Query(value ="select * from (SELECT *,Row_number() over(order by stock_date desc) as rownumber from stock_info where company_code=?1) as T where rownumber>?2 and rownumber<=?3 order by stock_date  desc", nativeQuery = true)
	List<StockInfo> findByCustomQuery(Long companycode,int page,int size);
	
	@Query(value ="select max(rownumber) from (SELECT *,Row_number() over(order by stock_id) as rownumber from stock_info where company_code=10005) as T", nativeQuery = true)
	int getTotalElementsValue(Long companycode);

}
