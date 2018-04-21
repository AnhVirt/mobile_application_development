package com.example.anhviet.moneychange;

import java.util.HashMap;

/**
 * Created by Anh Viet on 4/21/2018.
 */

public class ExchangeRate {
    private HashMap<String, Double> hashMap = new HashMap<String,Double>();

    public void onCreate(){
        hashMap.put("USD", 25000.0);
        hashMap.put("AUD", 17438.53);
        hashMap.put("VND", 1.0);
        hashMap.put("EUR",27888.95);
    }
    public double get(String key){
        return hashMap.get(key);
    }
}
