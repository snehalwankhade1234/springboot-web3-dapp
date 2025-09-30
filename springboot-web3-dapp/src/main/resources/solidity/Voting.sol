// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Voting {
    mapping(string => uint256) public votes;

    function vote(string memory option) public {
        votes[option]++;
    }

    function getVotes(string memory option) public view returns (uint256) {
        return votes[option];
    }
}
