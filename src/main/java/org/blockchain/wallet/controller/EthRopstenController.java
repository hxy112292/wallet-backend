package org.blockchain.wallet.controller;

import org.blockchain.wallet.resttemplate.EtherscanRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/ETHTEST")
public class EthRopstenController {

    @Autowired
    EtherscanRestAPI etherscanRestAPI;

    @GetMapping(value = "/address/{address}")
    public String getAddressInfo(@PathVariable String address) {
        return etherscanRestAPI.getRopstenAddressInfo(address);
    }

    @GetMapping(value = "/address/{address}/transaction")
    public String getTxList(@PathVariable String address) {
        return etherscanRestAPI.getRopstenTxList(address);
    }

    @GetMapping(value = "/address/{address}/tokentx")
    public String getErc20TxList(@PathVariable String address, @RequestParam String contractAddress) {
        return etherscanRestAPI.getRopstenERC20TxList(address, contractAddress);
    }

}
