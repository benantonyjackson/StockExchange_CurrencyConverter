/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockbrokeringwebapplication;


import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.json.JSONArray;
import com.squareup.okhttp.*;
import generated.Company;
import generated.CompanyList;
import java.io.File;
import java.time.LocalDate;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;




/**
 *
 * @author Ben
 */


@WebService(serviceName = "StockBrokeringWebService")
@Stateless()
public class StockBrokeringWebService {

    private String access_key = "e9b83f867fd578d5c5379ef351781eaf";
    
    public String getAllCompanyData() {
        int repsoneCode = 0;
        String idek = "";
        
        try {
            
            OkHttpClient client = new OkHttpClient();
            
            Request request = new Request.Builder()
                    .url("http://api.marketstack.com/v1/tickers?access_key=" + access_key)
                    .build();
            
            Response response = client.newCall(request).execute();
            
            JSONObject obj = new JSONObject(response.body().string()); 
            
            //String companiesListString = obj.get("data").toString();
            
            JSONArray companies = obj.getJSONArray("data");
            
            String ret = "";
            
            for (int i = 0; i < companies.length(); i++)
            {
                ret += ((JSONObject)companies.get(i)).get("symbol")+ "\n";
            }
            
            return ret;

        } catch (Exception ex) {
            //TODO add more error hadnling
            return ex.toString() + " Response code = " + repsoneCode + " " + idek;
        }
    }

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !!!";
    }
    
    public String genorateRandomCompanyData()
    {
        Vector<String> symbols = getAllSymbols(100);
        
        CompanyList allCompanies = new CompanyList();
        
        String ret = "Sup\n";
        
        for (String symbol: symbols)
        {
            try {
                Company company = new Company();

                company.setCompanySymbol(symbol);
                company.setCompanyName("Big bad corperation");

                XMLGregorianCalendar xmlGregorianCalendar;

                xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar("2019-04-25");

                company.setLastUpdated(xmlGregorianCalendar);
                company.setNumberOfShares(10000);

                Company.SharePrice sharePrice = new Company.SharePrice();
                sharePrice.setCurrency("GBP");
                sharePrice.setValue((float) 50.51);

                company.setSharePrice(sharePrice);
                
                allCompanies.getCompanyList().add(company);
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(StockBrokeringWebService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(allCompanies.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            ret += "Before file write\n";
            File file = new File("E:\\repo\\Cloud\\StockBrokeringWebApplication\\company_data.xml");
            file.setExecutable(true);
            file.setWritable(true);
            
            marshaller.marshal(allCompanies, file);
            marshaller.marshal(allCompanies, System.out);
            
            ret += "After file write";
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            ret += "Errors be occuring\n";
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
            ret += "Errors be occuring\n";
        }   
        
        return ret;
    }
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllSymbols")
    public Vector getAllSymbols(@WebParam(name = "Limit") int Limit) {
        //http://api.marketstack.com/v1/tickers?access_key=e9b83f867fd578d5c5379ef351781eaf

        Vector<String> symbols = new Vector<String>();
        
        /*String[] companies = getAllCompanyData().split("\n");
        
        for (int i = 0; i < companies.length; i++)
        {
            symbols.add(companies[i]);
        }*/
        
        symbols.add("AAPL");
        symbols.add("MSFT");
        symbols.add("AMZN");
        symbols.add("GOOG");
        symbols.add("GOOGL");
        symbols.add("FB");
        symbols.add("VOD");

        return symbols;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCompanyData")
    public String getCompanyData() {
        return genorateRandomCompanyData();
    }

}
