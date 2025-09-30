package com.snehal.web3.dapp.service;
import com.snehal.web3.dapp.model.VoteResult;
import com.snehal.web3.dapp.contracts.Voting;
import org.web3j.tx.RawTransactionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.Contract;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;

import java.math.BigInteger;
@Service
public class VotingService {


    private final Web3j web3j;
    private final Credentials credentials;
    private final String contractAddress;

    public VotingService(Web3j web3j,
                         @Value("${web3j.wallet.private-key}") String privateKey,
                         @Value("${voting.contract.address}") String contractAddress) {
        this.web3j = web3j;
        this.credentials = Credentials.create(privateKey);
        this.contractAddress = contractAddress;
    }

    private Voting loadContract() {
        RawTransactionManager txManager = new RawTransactionManager(web3j, credentials);
        return Voting.load(contractAddress, web3j, txManager, new DefaultGasProvider());
    }

    // read current votes for two options
    public VoteResult getVoteResults(String optionA, String optionB) {
        try {
            Voting contract = loadContract();
            BigInteger votesA = contract.getVotes(optionA).send(); // call (no tx)
            BigInteger votesB = contract.getVotes(optionB).send();
            return new VoteResult(votesA.intValue(), votesB.intValue());
        } catch (Exception e) {
            e.printStackTrace();
            return new VoteResult(0, 0);
        }
    }

    // submit a vote (sends a transaction)
    public String submitVote(String option) {
        try {
            Voting contract = loadContract();
            contract.vote(option).send(); // this is a real transaction (consumes gas)
            return "Vote submitted for " + option;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error submitting vote: " + e.getMessage();
        }
    }
}
