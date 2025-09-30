package com.snehal.web3.dapp.model;

public class NFTItem {
	 private String name;
	    private String tokenId;
	    private String imageUrl;

	    public NFTItem() {}

	    public NFTItem(String name, String tokenId, String imageUrl) {
	        this.name = name;
	        this.tokenId = tokenId;
	        this.imageUrl = imageUrl;
	    }

	    // Getters and Setters
	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }
	    public String getTokenId() { return tokenId; }
	    public void setTokenId(String tokenId) { this.tokenId = tokenId; }
	    public String getImageUrl() { return imageUrl; }
	    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
	}