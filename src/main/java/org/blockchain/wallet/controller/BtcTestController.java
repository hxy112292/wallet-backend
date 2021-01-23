package org.blockchain.wallet.controller;

import org.blockchain.wallet.entity.SochainBroadcast;
import org.blockchain.wallet.resttemplate.CryptoRestAPI;
import org.blockchain.wallet.resttemplate.SochainRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/BTCTEST")
public class BtcTestController {

    @Autowired
    SochainRestAPI sochainRestAPI;

    @Autowired
    CryptoRestAPI cryptoRestAPI;

    @GetMapping(value = "/address/{address}")
    public String getAddressInfo(@PathVariable String address) {
        return sochainRestAPI.getBTCTESTAddressInfo(address);
    }

    @GetMapping(value = "/tx/{hash}")
    public String getTxInfo(@PathVariable String hash) {
        return sochainRestAPI.getBTCTESTTxInfo(hash);
    }

    @GetMapping(value = "/tx/fee")
    public String getTxFee() {
        return cryptoRestAPI.getBTCTestTxFee();
    }

    @PostMapping(value = "/send_tx")
    public String broadcast(@RequestBody SochainBroadcast sochainBroadcast) {
        return sochainRestAPI.broadcastBTCTEST(sochainBroadcast);
    }

    @GetMapping(value = "/unspent/{address}")
    public String getUnspentTx(@PathVariable String address) {
        return sochainRestAPI.getBTCTESTUnSpentTxInfo(address);
    }
}
