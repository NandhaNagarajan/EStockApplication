package com.EStockMarket.EStockMarket.entity;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Stock_Info")
public class StockInfo {

	@Id
	@Column(name = "Stock_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockID;

	@Column(name = "Stock_Price")
	private BigDecimal stockPrice;

	@Column(name = "Stock_Date")
	private String stockDate;

	@Column(name = "Stock_Time")
	private String stockTime;
	
	@Column(name = "total_elements")
	private Integer totalElements;

	@ManyToOne
	@JoinColumn(name = "Company_Code")
	private CompanyInfo companyInfo;

	public StockInfo() {

	}

	public StockInfo(BigDecimal stockPrice, String stockDate, String stockTime) {
		super();
		this.stockPrice = stockPrice;
		this.stockDate = stockDate;
		this.stockTime = stockTime;
	}

	public BigDecimal getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(BigDecimal stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getStockDate() {
		return stockDate;
	}

	public void setStockDate(String stockDate) {
		this.stockDate = stockDate;
	}

	public String getStockTime() {
		return stockTime;
	}

	public void setStockTime(String stockTime) {
		this.stockTime = stockTime;
	}

	public Long getStockID() {
		return stockID;
	}

	public void setStockID(Long stockID) {
		this.stockID = stockID;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}
	
	public Integer getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

}
