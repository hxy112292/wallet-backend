package org.blockchain.wallet.controller;

import org.blockchain.wallet.entity.SochainBroadcast;
import org.blockchain.wallet.resttemplate.CryptoRestAPI;
import org.blockchain.wallet.resttemplate.SochainRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/BTC")
public class BtcController {

    @Autowired
    SochainRestAPI sochainRestAPI;

    @Autowired
    CryptoRestAPI cryptoRestAPI;

    @GetMapping(value = "/tx/{hash}")
    public String getTxInfo(@PathVariable String hash) {
        return sochainRestAPI.getBTCTxInfo(hash);
    }

    @GetMapping(value = "/address/{address}")
    public String getAddressInfo(@PathVariable String address) {
        return sochainRestAPI.getBTCAddressInfo(address);
    }

    @GetMapping(value = "/tx/fee")
    public String getTxFee() {
        return cryptoRestAPI.getBTCTxFee();
    }

    @PostMapping(value = "/send_tx")
    public String broadcast(@RequestBody SochainBroadcast sochainBroadcast) {
        return sochainRestAPI.broadcastBTC(sochainBroadcast);
    }

    @GetMapping(value = "/unspent/{address}")
    public String getUnspentTx(@PathVariable String address) {
        return sochainRestAPI.getBTCUnSpentTxInfo(address);
    }
}
