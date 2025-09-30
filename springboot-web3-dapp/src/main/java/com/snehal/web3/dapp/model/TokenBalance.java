package com.snehal.web3.dapp.model;

public class TokenBalance {

	  private String tokenName;
	    private String tokenSymbol;
	    private String balance;

	    public TokenBalance() {}

	    public TokenBalance(String tokenName, String tokenSymbol, String balance) {
	        this.tokenName = tokenName;
	        this.tokenSymbol = tokenSymbol;
	        this.balance = balance;
	    }

	    // Getters and Setters
	    public String getTokenName() { return tokenName; }
	    public void setTokenName(String tokenName) { this.tokenName = tokenName; }
	    public String getTokenSymbol() { return tokenSymbol; }
	    public void setTokenSymbol(String tokenSymbol) { this.tokenSymbol = tokenSymbol; }
	    public String getBalance() { return balance; }
	    public void setBalance(String balance) { this.balance = balance; }
	}
