/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockBrokeringWebService;

import comparitors.SharePriceComparitor;
import generated.Company;
import generated.Company.SharePrice;
import generated.CompanyList;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.util.Pair;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar; 


import org.json.*;



/**
 *
 * @author Ben
 */
@WebService(serviceName = "StockBrokeringWebService")
@Stateless()
public class StockBrokeringWebService {
    private String allCompaniesFile = "company_data.xml";
    
    private String access_key = "e9b83f867fd578d5c5379ef351781eaf";
    
    private String baseCurrencyRate = "EUR";

    
    public List<Pair<String, String>> getCompanyNamesAndSymbols() throws IOException
    {
        List<Pair<String, String>> namesAndSymbols = new ArrayList<Pair<String, String>>();
        
        byte[] arr = "".getBytes();
        String response = makeRequest("http://api.marketstack.com/v1/tickers?access_key=" + access_key, "GET");

        java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.INFO, null, "Request output" + response);
        
        JSONObject obj = new JSONObject(response); 

        JSONArray companies = obj.getJSONArray("data");

        String ret = "";

        for (int i = 0; i < companies.length(); i++)
        {
            String symbol = ((JSONObject)companies.get(i)).get("symbol").toString();
            String name = ((JSONObject)companies.get(i)).get("name").toString();

            namesAndSymbols.add(new Pair<String, String>(symbol, name));
        }

        return namesAndSymbols;
    }
    
    public List<Company> genorateRandomCompanyData()
    {
        List<Company> allCompanies = new ArrayList<Company>();
        List<Pair<String, String>> symbolsAndNames;
        try {
            symbolsAndNames = getCompanyNamesAndSymbols();
            for (Pair<String, String> nameAndSymbol: symbolsAndNames)
            {
                Company company = new Company();

                company.setCompanySymbol(nameAndSymbol.getKey());
                company.setCompanyName(nameAndSymbol.getValue());

                XMLGregorianCalendar xmlGregorianCalendar;

                xmlGregorianCalendar = DatatypeFactory.newInstance()
                        .newXMLGregorianCalendar(LocalDateTime.now().toString());

                company.setLastUpdated(xmlGregorianCalendar);
                company.setNumberOfShares(10000);

                Company.SharePrice sharePrice = new Company.SharePrice();
                sharePrice.setCurrency(baseCurrencyRate);
                float min = 10;
                float max = 10000;
                float price = (min + (float)Math.random() * (max - min));
                BigDecimal bd = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
                sharePrice.setValue(bd.floatValue());

                company.setSharePrice(sharePrice);
                
                allCompanies.add(company);
            }
        } catch (IOException ex) {
            Logger.getLogger(StockBrokeringWebService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(StockBrokeringWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return allCompanies;
    }
    


    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCompanyData")
    public java.util.List<Company> getCompanyData(@WebParam(name = "currency") String currency, @WebParam(name = "orderBy") String orderBy, @WebParam(name = "order") String order) {
        
        CompanyList allCompanies = new CompanyList();
        
        
        File file = new File(allCompaniesFile);
        
        if (!file.exists())
        {
            overwriteCompanyData(genorateRandomCompanyData());
        }
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(allCompanies.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            allCompanies = (CompanyList) unmarshaller.unmarshal(new java.io.File(allCompaniesFile)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        List<Company > companies = convertCurrencies(allCompanies.getCompanyList(), currency);
        companies = orderCompanies(companies, orderBy, order);
        
        return companies;
    }
    
    private void overwriteCompanyData(List<Company> companies)
    {
        CompanyList allCompanies = new CompanyList();
        
        allCompanies.getCompanyList().addAll(companies);
        
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(allCompanies.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            File file = new File(allCompaniesFile);
            file.setExecutable(true);
            file.setWritable(true);
            
            marshaller.marshal(allCompanies, file);
            
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        } 
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buyShare")
    public Company buyShare(@WebParam(name = "Symbol") String Symbol, @WebParam(name = "NumberOfShares") int NumberOfShares) {
        Company company = null;
        java.util.List<Company> Companies = getCompanyData(baseCurrencyRate, "", "");
        for (Company c: Companies)
        {
            if (c.getCompanySymbol().equals(Symbol))
            {
                company = c;
                break;
            }
        }
        
        company.setNumberOfShares(company.getNumberOfShares() - NumberOfShares);
        
        overwriteCompanyData(Companies);
        
        return company;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetCompaniesBySymbol")
    public List<Company> GetCompaniesBySymbol(@WebParam(name = "symbol") String symbol, @WebParam(name = "currency") String currency, String orderBy, @WebParam(name = "order") String order) {
        java.util.List<Company> allCompanies = getCompanyData(currency, orderBy, order);
        List<Company> filteredCompanies = new ArrayList<Company>();
        
        for (Company company: allCompanies)
        {
            if (company.getCompanySymbol().equals(symbol))
            {
                filteredCompanies.add(company);
            }
        }
        
        return filteredCompanies;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCompaniesByName")
    public List<Company> getCompaniesByName(@WebParam(name = "name") String name, @WebParam(name = "currency") String currency, String orderBy, @WebParam(name = "order") String order) {
        System.out.println("Point a");
        java.util.List<Company> allCompanies = getCompanyData(currency, orderBy, order);
        System.out.println("Point b");
        List<Company> filteredCompanies = new ArrayList<Company>();
        
        for (Company company: allCompanies)
        {
            if (company.getCompanyName().toLowerCase().contains(name.toLowerCase()))
            {
                filteredCompanies.add(company);
            }
        }
        
        return filteredCompanies;
    }
    
    private String makeRequest(String uri, String MethodType)
    {
        byte[] arr = "".getBytes();
        return makeRequest(uri, MethodType, arr);
    }
    
    private String makeRequest(String uri, String MethodType, byte[] input)
    {
        URL url = null;
        
        boolean bodyIsEmpty = (input.length == 0);
        
        try {
            url = new URL(uri);
        } catch (MalformedURLException ex) {
            System.out.println("An error occured " + ex.getMessage());
        }
        
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException ex) {
            System.out.println("An error occured " + ex.getMessage());
        }
        try {
            con.setRequestMethod(MethodType);
        } catch (ProtocolException ex) {
            System.out.println("An error occured " + ex.getMessage());
        }

        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        con.setRequestProperty("Accept", "application/json");

        con.setDoOutput(!bodyIsEmpty);
        
        if (!bodyIsEmpty)
        {
            try (OutputStream os = con.getOutputStream()) {
                os.write(input, 0, input.length);
            } catch (IOException ex) {
                System.out.println("An error occured " + ex.getMessage());
            }
        }
        

        String response = "";
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder responseBuilder = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                responseBuilder.append(responseLine.trim());
            }
            System.out.println(responseBuilder.toString());
            response = responseBuilder.toString();
        } catch (IOException ex) {
            System.out.println("An error occured " + ex.getMessage());
        }

        return response;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCurrencies")
    public List<String> getCurrencies() {
        //List currencies = new ArrayList<String>();
        
        String response = makeRequest("http://127.0.0.1:5000/currencies", "GET");
        
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("all_currencies");
        
        List currencies = arr.toList();
        
        return currencies;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "convertCurrencies")
    public List convertCurrencies(@WebParam(name = "companies") List<Company> companies, @WebParam(name = "currencyType") String currencyType) {
        if (currencyType.length() == 0) {
            return companies;
        }
        
        //Construct JSON body for request
        JSONArray arr = new JSONArray();
        System.out.println("Size of companies list" + companies.size());
        for (Company company : companies) {
            if (!company.getSharePrice().getCurrency().equals(currencyType)) {
                JSONObject obj = new JSONObject();

                obj.put("from", company.getSharePrice().getCurrency());
                obj.put("to", currencyType);
                obj.put("value", company.getSharePrice().getValue());

                arr.put(obj);
            }
        }

        System.out.println(arr.toString());

        if (arr.length() > 0) {
            String response = "";
            try {
                response = makeRequest(
                        "http://127.0.0.1:5000/convert", "POST",
                        arr.toString().getBytes("utf-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(StockBrokeringWebService.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Response message " + response);

            try {
                JSONObject responseObj = new JSONObject(response);
                JSONArray responseArray = responseObj.getJSONArray("values");

                for (int i = 0; i < responseArray.length(); i++) {
                    Company company = companies.get(i);
                    Company.SharePrice newSharePrice = new Company.SharePrice();

                    newSharePrice.setCurrency(currencyType);
                    newSharePrice.setValue(responseArray.getBigDecimal(i).floatValue());
                    company.setSharePrice(newSharePrice);

                    System.out.println(newSharePrice.getCurrency());
                    System.out.println(newSharePrice.getValue());

                    companies.set(i, company);
                }
            } catch (org.json.JSONException ex) {
                
            }
        }

        return companies;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "orderCompanies")
    public List<Company> orderCompanies(@WebParam(name = "companies") List<Company> companies, @WebParam(name = "orderBy") String orderBy, @WebParam(name = "order") String order) {
        List<Company> orderedCompanies = new ArrayList<Company>();
        
        switch (orderBy.toLowerCase())
        {
            case "name":
                orderedCompanies = companies.stream()
                .sorted(Comparator.comparing(Company::getCompanyName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
                break;
            
            case "symbol":
                orderedCompanies = companies.stream()
                .sorted(Comparator.comparing(Company::getCompanySymbol, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
                break;
            
            case "price":
                orderedCompanies = companies;
                Collections.sort(orderedCompanies, new SharePriceComparitor());
                break;
            
            default:
                orderedCompanies = companies;
        }
        
        
        //https://www.codebyamir.com/blog/sort-list-of-objects-by-field-java
        /*if (orderBy.toLowerCase().equals("name"))
        {
            orderedCompanies = companies.stream()
            .sorted(Comparator.comparing(Company::getCompanyName, String.CASE_INSENSITIVE_ORDER))
            .collect(Collectors.toList());
        }
        
        if (orderBy.toLowerCase().equals("symbol"))
        {
            orderedCompanies = companies.stream()
            .sorted(Comparator.comparing(Company::getCompanySymbol, String.CASE_INSENSITIVE_ORDER))
            .collect(Collectors.toList());
        }
        
        if (orderBy.toLowerCase().equals("price"))
        {
            orderedCompanies = companies;
            Collections.sort(orderedCompanies, new SharePriceComparitor());
        }*/
        
        if (order.toLowerCase().equals("desc"))
        {
            Collections.reverse(orderedCompanies);
        }
        
        return orderedCompanies;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "filterByPrice")
    public List<Company> filterByPrice(@WebParam(name = "value") float value, @WebParam(name = "operator") String operator, @WebParam(name = "currency") String currency, @WebParam(name = "orderBy") String orderBy, @WebParam(name = "order") String order) {
        List<Company> allCompanies = getCompanyData(currency, orderBy, order);
        List<Company> filteredCompanies = new ArrayList<Company>();
        
        for (Company company: allCompanies)
        {
            if (compair(company.getSharePrice().getValue(), value, operator))
            {
                filteredCompanies.add(company);
            }
        }
        
        return filteredCompanies;
    }
    
    private static boolean compair(float x, float y, String operator)
    {
        if (operator.toLowerCase().equals("less"))
        {
            return (x < y);
        }
        
        if (operator.toLowerCase().equals("greater"))
        {
            return (x > y);
        }
        
        if (operator.toLowerCase().equals("equal"))
        {
            return (x == y);
        }
        
        return false;
    }

}
