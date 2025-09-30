package com.snehal.web3.dapp.controller;
import com.snehal.web3.dapp.model.NFTItem;
import com.snehal.web3.dapp.service.NFTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nft")
public class NFTController {
    @Autowired
    private NFTService nftService;

    @GetMapping("/list")
    public List<NFTItem> getNFTs(@RequestParam String wallet) {
        return nftService.getNFTs(wallet);
    }

    @PostMapping("/mint")
    public String mintNFT(@RequestParam String wallet, @RequestParam String name) {
        // TODO: Add mint logic
        return "NFT '" + name + "' minted to wallet " + wallet;
    }
}
