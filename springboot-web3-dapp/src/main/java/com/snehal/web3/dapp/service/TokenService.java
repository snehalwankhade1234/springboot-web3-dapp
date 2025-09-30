package com.snehal.web3.dapp.service;

import com.snehal.web3.dapp.model.TokenBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.generated.Uint256;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
@Service
public class TokenService {

    @Autowired
    private Web3j web3j;

    // Example ERC-20 contract address
    private static final String TOKEN_ADDRESS = "0xYourTokenContractAddress";

    public List<TokenBalance> getTokenBalances(String walletAddress) {
        List<TokenBalance> balances = new ArrayList<>();
        try {
            // Build ERC-20 balanceOf(address) function
            Function function = new Function(
                    "balanceOf",
                    Collections.singletonList(new Address(walletAddress)),
                    Collections.singletonList(new TypeReference<Uint256>() {})
            );

            String encodedFunction = FunctionEncoder.encode(function);

            // Call the contract (eth_call)
            EthCall response = web3j.ethCall(
                    Transaction.createEthCallTransaction(walletAddress, TOKEN_ADDRESS, encodedFunction),
                    DefaultBlockParameterName.LATEST
            ).send();

            // Decode result
            List<org.web3j.abi.datatypes.Type> decoded = FunctionReturnDecoder.decode(
                    response.getValue(), function.getOutputParameters()
            );

            BigInteger balance = (BigInteger) decoded.get(0).getValue();
            balances.add(new TokenBalance("DemoToken", "DTK", balance.toString()));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return balances;
    }
}