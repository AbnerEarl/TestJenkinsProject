package com.ycj.phonenumber.test;

import java.util.Map;

import static com.ycj.phonenumber.util.RSAUtils.*;

/**
 * @author: Frank
 * @email 1320259466@qq.com
 * @date: 2020/5/14
 * @time: 11:22
 * @fuction: about the role of class.
 */
public class MethodTest {
    public static void main(String[] args) {
        try {
            Map<String,Object> keyMap = genKeyPair();
            System.out.println("publicKey:"+getPublicKey(keyMap));
            System.out.println("privateKey:"+getPrivateKey(keyMap));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
