package com.iTextdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AccountStatement {
	    
	   @Id
	    private Long accountId;
	    private String accountName;
	    private String address;
	    private String date;
	    private String accountNumber;
	    private String accountDescription;
	    private String branch;
	    private double drawingPower;
	    private double interestRate;
	    private double modBalance;
	    private String cifNo;
	    private String ifsCode;
	    private String micrCode;
		public Long getAccountId() {
			return accountId;
		}
		public void setAccountId(Long accountId) {
			this.accountId = accountId;
		}
		public String getAccountName() {
			return accountName;
		}
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getAccountDescription() {
			return accountDescription;
		}
		public void setAccountDescription(String accountDescription) {
			this.accountDescription = accountDescription;
		}
		public String getBranch() {
			return branch;
		}
		public void setBranch(String branch) {
			this.branch = branch;
		}
		public double getDrawingPower() {
			return drawingPower;
		}
		public void setDrawingPower(double drawingPower) {
			this.drawingPower = drawingPower;
		}
		public double getInterestRate() {
			return interestRate;
		}
		public void setInterestRate(double interestRate) {
			this.interestRate = interestRate;
		}
		public double getModBalance() {
			return modBalance;
		}
		public void setModBalance(double modBalance) {
			this.modBalance = modBalance;
		}
		public String getCifNo() {
			return cifNo;
		}
		public void setCifNo(String cifNo) {
			this.cifNo = cifNo;
		}
		public String getIfsCode() {
			return ifsCode;
		}
		public void setIfsCode(String ifsCode) {
			this.ifsCode = ifsCode;
		}
		public String getMicrCode() {
			return micrCode;
		}
		public void setMicrCode(String micrCode) {
			this.micrCode = micrCode;
		}
		public AccountStatement(Long accountId, String accountName, String address, String date, String accountNumber,
				String accountDescription, String branch, double drawingPower, double interestRate, double modBalance,
				String cifNo, String ifsCode, String micrCode) {
			this.accountId = accountId;
			this.accountName = accountName;
			this.address = address;
			this.date = date;
			this.accountNumber = accountNumber;
			this.accountDescription = accountDescription;
			this.branch = branch;
			this.drawingPower = drawingPower;
			this.interestRate = interestRate;
			this.modBalance = modBalance;
			this.cifNo = cifNo;
			this.ifsCode = ifsCode;
			this.micrCode = micrCode;
		}
		public AccountStatement() {
			super();
		}
		@Override
		public String toString() {
			return "AccountStatement [accountId=" + accountId + ", accountName=" + accountName + ", address=" + address
					+ ", date=" + date + ", accountNumber=" + accountNumber + ", accountDescription="
					+ accountDescription + ", branch=" + branch + ", drawingPower=" + drawingPower + ", interestRate="
					+ interestRate + ", modBalance=" + modBalance + ", cifNo=" + cifNo + ", ifsCode=" + ifsCode
					+ ", micrCode=" + micrCode + "]";
		}
	    
		
	    
	    
	    
}
