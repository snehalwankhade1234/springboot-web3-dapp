package com.snehal.web3.dapp.controller;
import com.snehal.web3.dapp.model.TokenBalance;
import com.snehal.web3.dapp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/token")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @GetMapping("/balance")
    public List<TokenBalance> getBalances(@RequestParam String wallet) {
        return tokenService.getTokenBalances(wallet);
    }
}
