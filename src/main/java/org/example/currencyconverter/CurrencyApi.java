package org.example.currencyconverter;


import okhttp3.*;
import org.json.*;

import java.util.ArrayList;
import java.util.List;


public class CurrencyApi {
    //FETCHING AND RETRIEVING THE CONVERTED RATE
    public String connect()
    {
        HomeController hm = new HomeController();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request req = new Request.Builder()
                .url("https://api.apilayer.com/fixer/convert?to=INR&from=USD&amount=1")
                .addHeader("apikey",Apikey.apiKey)
                .build();

        try
        {
            Response res = client.newCall(req).execute();
            String resBody = res.body().string();

            JSONObject jsonOB = new JSONObject(resBody);
            double rate = jsonOB.getJSONObject("info").getDouble("rate");

            String rateString = String.valueOf(rate);
            return rateString;

        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    public List<String> fetchSymbols()
    {
        List<String> symbolsList = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request req = new Request.Builder()
                .url("https://api.apilayer.com/fixer/symbols")
                .addHeader("apikey", Apikey.apiKey)
                .build();

        try
        {
            Response res = client.newCall(req).execute();
            String resBody = res.body().string();

            JSONObject jOb = new JSONObject(resBody);
            JSONObject symbol = jOb.getJSONObject("symbols");

            symbol.keys().forEachRemaining(symbolsList::add);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return symbolsList;
    }


}
