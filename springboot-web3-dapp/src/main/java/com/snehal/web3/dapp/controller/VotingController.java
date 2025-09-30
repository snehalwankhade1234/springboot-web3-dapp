package com.snehal.web3.dapp.controller;

import com.snehal.web3.dapp.model.VoteResult;
import com.snehal.web3.dapp.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vote")
public class VotingController {
    @Autowired
    private VotingService votingService;

    @GetMapping("/result")
    public VoteResult getResults(@RequestParam String optionA,
                                 @RequestParam String optionB) {
        return votingService.getVoteResults(optionA, optionB);
    }


    @PostMapping("/submit")
    public String submitVote(@RequestParam String option) {
        return votingService.submitVote(option);
    }
}
