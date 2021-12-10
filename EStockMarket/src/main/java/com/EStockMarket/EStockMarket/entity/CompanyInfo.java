package com.EStockMarket.EStockMarket.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "Company_Info")
public class CompanyInfo {

	@Id
	@Column(name = "Company_Code")
	@TableGenerator(name = "Company_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Company_Gen", initialValue = 10004)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "Company_Gen")
	private Long companyCode;

	@Column(name = "Company_Name", nullable = false)
	private String companyName;

	@Column(name = "Company_CEO", nullable = false)
	private String companyCEO;

	@Column(name = "Company_Turn_Over", columnDefinition = "Decimal(10,2)", nullable = false)
	private BigDecimal companyTurnOver;

	@Column(name = "Company_Website", nullable = false)
	private String companyWebsite;

	@Column(name = "Stock_Exchange", nullable = false)
	private String stockExchange;

	@OneToMany(mappedBy = "companyInfo", orphanRemoval = true)
	private List<StockInfo> stockInfo = new ArrayList<>();

	public CompanyInfo() {

	}

	public CompanyInfo(Long companyCode, String companyName, String companyCEO, BigDecimal companyTurnOver,
			String companyWebsite, String stockExchange) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.companyTurnOver = companyTurnOver;
		this.companyWebsite = companyWebsite;
		this.stockExchange = stockExchange;
	}

	public Long getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Long companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public BigDecimal getCompanyTurnOver() {
		return companyTurnOver;
	}

	public void setCompanyTurnOver(BigDecimal companyTurnOver) {
		this.companyTurnOver = companyTurnOver;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public List<StockInfo> getStockInfo() {
		return stockInfo;
	}

	public void setStockInfo(List<StockInfo> stockInfo) {
		this.stockInfo = stockInfo;
	}

}
