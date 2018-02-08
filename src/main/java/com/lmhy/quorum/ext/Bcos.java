package com.lmhy.quorum.ext;

import com.lmhy.quorum.contract.CKit;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Quorum;
import org.web3j.quorum.tx.ClientTransactionManager;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

public class Bcos {

    public static Web3j web3j = null;
    public static Credentials credentials = null;
    public static BcosRawTxManager bcosRawTxManager = null;
    public static final BigInteger GAS_PRICE = new BigInteger("100000000");
    public static final BigInteger GAS_LIMIT = new BigInteger("100000000");

    public static ClientTransactionManager transactionManager = null;

    public Bcos(BcosConfig config) {
        Quorum quorum = Quorum.build(new HttpService(config.getUrl()));
        this.web3j = quorum;
        try {
            credentials = WalletUtils.loadCredentials(config.getPwd(), new File(config.getWallet()));
        } catch (IOException | CipherException e) {
            e.printStackTrace();
        }
        this.bcosRawTxManager = new BcosRawTxManager(this.web3j, credentials, 100, 100);

        this.transactionManager = new ClientTransactionManager(quorum,"0xed9d02e382b34818e88B88a309c7fe71E65f419d", Arrays.asList());

//        BcosKit.deploySys();
        HashMap map = BcosKit.getAdr();
        if(map!=null){
            CKit.init(map);
        }
    }
}
