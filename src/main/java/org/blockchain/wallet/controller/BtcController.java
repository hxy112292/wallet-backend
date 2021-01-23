package org.blockchain.wallet.controller;

import org.blockchain.wallet.resttemplate.SochainRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/BTC")
public class BtcController {

    @Autowired
    SochainRestAPI sochainRestAPI;

    @GetMapping(value = "/tx/{hash}")
    public String getTxInfo(@PathVariable String hash) {
        return sochainRestAPI.getBTCTxInfo(hash);
    }
}
