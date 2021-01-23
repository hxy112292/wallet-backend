package org.blockchain.wallet.controller;

import org.blockchain.wallet.entity.SochainBroadcast;
import org.blockchain.wallet.resttemplate.CryptoRestAPI;
import org.blockchain.wallet.resttemplate.SochainRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hxy
 */
@RestController
@RequestMapping(value = "/LTCTEST")
public class LtcTestController {

    @Autowired
    SochainRestAPI sochainRestAPI;

    @Autowired
    CryptoRestAPI cryptoRestAPI;

    @GetMapping(value = "/address/{address}")
    public String getAddressInfo(@PathVariable String address) {
        return sochainRestAPI.getLTCTestAddressInfo(address);
    }

    @GetMapping(value = "/tx/{hash}")
    public String getTxInfo(@PathVariable String hash) {
        return sochainRestAPI.getLTCTestTxInfo(hash);
    }

    @GetMapping(value = "/tx/fee")
    public String getTxFee() {
        return cryptoRestAPI.getLTCTestTxFee();
    }

    @PostMapping(value = "/send_tx")
    public String broadcast(@RequestBody SochainBroadcast sochainBroadcast) {
        return sochainRestAPI.broadcastLTCTest(sochainBroadcast);
    }

    @GetMapping(value = "/unspent/{address}")
    public String getUnspentTx(@PathVariable String address) {
        return sochainRestAPI.getLTCTESTUnSpentTxInfo(address);
    }
}
