package org.blockchain.wallet.controller;

import org.blockchain.wallet.entity.CryptoBroadcast;
import org.blockchain.wallet.resttemplate.CryptoRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/BCH")
public class BchController {

    @Autowired
    CryptoRestAPI cryptoRestAPI;

    @GetMapping(value = "/address/{address}")
    public String getAddressInfo(@PathVariable String address) {
        return cryptoRestAPI.getBCHAddressInfo(address);
    }

    @GetMapping(value = "/address/{address}/transaction")
    public String getTxList(@PathVariable String address) {
        return cryptoRestAPI.getBCHTxList(address);
    }

    @GetMapping(value = "/txid/{hash}")
    public String getTxid(@PathVariable String hash) {
        return cryptoRestAPI.getBCHTxInfo(hash);
    }

    @GetMapping(value = "/tx/fee")
    public String getTxFee() {
        return cryptoRestAPI.getBCHTxFee();
    }

    @PostMapping(value = "/send_tx")
    public String broadcast(@RequestBody CryptoBroadcast cryptoBroadcast) {
        return cryptoRestAPI.broadcastBch(cryptoBroadcast);
    }
}
