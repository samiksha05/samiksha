package com.read.file;

import java.util.ArrayList;

public class transactionBean {
	private Long TransactionId;
	private String Instrument;
	private Long TransactionQuantity;
	private String TransactionType;
	public transactionBean(Long transactionId, String instrument,
			String transactionTypet,Long transactionQuantity) {
		// TODO Auto-generated constructor stub
		this.TransactionId = transactionId;
		this.Instrument = instrument;
		this.TransactionType= transactionTypet;
		this.TransactionQuantity= transactionQuantity;
	}
	public Long getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(Long transactionId) {
		TransactionId = transactionId;
	}
	public String getInstrument() {
		return Instrument;
	}
	public void setInstrument(String instrument) {
		Instrument = instrument;
	}
	public Long getTransactionQuantity() {
		return TransactionQuantity;
	}
	public void setTransactionQuantity(Long transactionQuantity) {
		TransactionQuantity = transactionQuantity;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	

}
