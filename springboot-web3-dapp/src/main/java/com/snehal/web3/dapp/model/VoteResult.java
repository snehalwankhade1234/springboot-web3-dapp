package com.snehal.web3.dapp.model;

public class VoteResult {

	  private int optionA;
	    private int optionB;

	    public VoteResult() {}

	    public VoteResult(int optionA, int optionB) {
	        this.optionA = optionA;
	        this.optionB = optionB;
	    }

	    // Getters and Setters
	    public int getOptionA() { return optionA; }
	    public void setOptionA(int optionA) { this.optionA = optionA; }
	    public int getOptionB() { return optionB; }
	    public void setOptionB(int optionB) { this.optionB = optionB; }
	}