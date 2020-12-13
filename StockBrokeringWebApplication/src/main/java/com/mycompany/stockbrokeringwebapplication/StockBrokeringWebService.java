/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockbrokeringwebapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import org.json.JSONObject;
import com.squareup.okhttp.*;


/**
 *
 * @author Ben
 */
@WebService(serviceName = "StockBrokeringWebService")
@Stateless()
public class StockBrokeringWebService {

    private String access_key = "e9b83f867fd578d5c5379ef351781eaf";

    /**
     * This is a sample web service operation
     */
    //
    /*public static void jsonToMap(String t) throws JSONException {

        HashMap<String, String> map = new HashMap<String, String>();
        JSONObject jObject = new JSONObject(t);
        Iterator<?> keys = jObject.keys();

        while( keys.hasNext() ){
            String key = (String)keys.next();
            String value = jObject.getString(key); 
            map.put(key, value);

        }

        System.out.println("json : "+jObject);
        System.out.println("map : "+map);
    }*/
    
    public static LinkedList<JSONObject> convertJsonListStringToList(String listString)
    {
        LinkedList<JSONObject> objects = new LinkedList<JSONObject>();
        
        int bracketCount = 0;
        
        String currentObjectString = "";
        
        for (int i = 1; i < objects.size() - 1; i++)
        {
            if (listString.charAt(i) == '[')
            {
                bracketCount++;
            }
            
            if (listString.charAt(i) == ']')
            {
                bracketCount--;
            }
            
            if (listString.charAt(i) == ',' && bracketCount == 0)
            {
                objects.add(new JSONObject(currentObjectString));
                currentObjectString = "";
                continue;
            }
            
            
            currentObjectString += listString.charAt(i);
            
        }
        
        return objects;
    }
    
    public String getAllCompanyData() {
        int repsoneCode = 0;
        String idek = "";
        
        try {
            /*URL url = new URL("http://api.marketstack.com/v1/tickers");
            System.out.println(url.getPath());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //con.addRequestProperty("Cookie", "__cfduid=da0179ff1be354aba2763e5f47faf8cfe1607866259");
            con.setRequestMethod("GET");

            if (con.getResponseCode() != 200) {
                repsoneCode = con.getResponseCode();
                idek = con.getResponseMessage() + " " + con.getRequestMethod() + con.getURL();
                throw new IOException(con.getResponseMessage());
            }
            BufferedReader ins = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inString;
            StringBuilder sb = new StringBuilder();
            while ((inString = ins.readLine()) != null) {
                sb.append(inString + "\n");
            }
            
            
            
            JSONObject obj = new JSONObject(sb.toString());
            String companiesListString = obj.get("data").toString();
            
            LinkedList<JSONObject> companies = convertJsonListStringToList(companiesListString);
            
            ListIterator it = companies.listIterator();
            
            String ret = "";
            
            while (it.hasNext())
            {
                ret += ((JSONObject)(it.next())).get("symbol") + "\n";
            }
            return ret;*/
            
            OkHttpClient client = new OkHttpClient();
            
            Request request = new Request.Builder()
                    .url("http://api.marketstack.com/v1/tickers")
                    .build();
            
            Response response = client.newCall(request).execute();
            
            return response.body().string();

        } catch (Exception ex) {
            //TODO add more error hadnling
            return ex.toString() + " Response code = " + repsoneCode + " " + idek;
        }
    }

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !!!";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllSymbols")
    public Vector getAllSymbols(@WebParam(name = "Limit") int Limit) {
        //http://api.marketstack.com/v1/tickers?access_key=e9b83f867fd578d5c5379ef351781eaf

        Vector<String> symbols = new Vector<String>();
        
        String[] companies = getAllCompanyData().split("\n");
        
        for (int i = 0; i < companies.length; i++)
        {
            symbols.add(companies[i]);
        }
        
        /*symbols.add("AAPL");
        symbols.add("MSFT");
        symbols.add("AMZN");
        symbols.add("GOOG");
        symbols.add("GOOGL");
        symbols.add("FB");
        symbols.add("VOD");*/

        return symbols;
    }

}
