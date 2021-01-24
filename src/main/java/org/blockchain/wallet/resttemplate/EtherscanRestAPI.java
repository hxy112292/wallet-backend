package org.blockchain.wallet.resttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class EtherscanRestAPI {

    @Autowired
    RestTemplate restTemplate;

    @Value("${ropsten.etherscan.root.url}")
    String rootTestUrl;

    @Value("${etherscan.root.url}")
    String rootUrl;

    @Value("${ropsten.etherscan.api.key}")
    String apiKey;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getRopstenAddressInfo(String address) {
        String url = rootTestUrl + "/api?module={module}&action={action}&address={address}&apiKey={apiKey}&tag={tag}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "balance");
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("tag", "latest");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    public String getRopstenERC20TxList(String address, String contractAddress) {
        String url = rootTestUrl + "/api?module={module}&action={action}&contractaddress={contractaddress}" +
                "&address={address}&apiKey={apiKey}&sort={sort}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "tokentx");
        map.put("contractaddress", contractAddress);
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("sort", "desc");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    public String getRopstenTxList(String address) {

        String url = rootTestUrl + "/api?module={module}&action={action}&address={address}&apiKey={apiKey}&sort={sort}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "txlist");
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("sort", "desc");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    public String getAddressInfo(String address) {
        String url = rootUrl + "/api?module={module}&action={action}&address={address}&apiKey={apiKey}&tag={tag}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "balance");
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("tag", "latest");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    public String getERC20TxList(String address, String contractAddress) {
        String url = rootUrl + "/api?module={module}&action={action}&contractaddress={contractaddress}" +
                "&address={address}&apiKey={apiKey}&sort={sort}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "tokentx");
        map.put("contractaddress", contractAddress);
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("sort", "desc");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }

    public String getTxList(String address) {

        String url = rootUrl + "/api?module={module}&action={action}&address={address}&apiKey={apiKey}&sort={sort}";

        Map<String, String> map = new HashMap();

        map.put("module", "account");
        map.put("action", "txlist");
        map.put("address", address);
        map.put("apiKey", apiKey);
        map.put("sort", "desc");

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class, map);

        return response.getBody();
    }
}
