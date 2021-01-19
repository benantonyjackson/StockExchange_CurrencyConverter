/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockBrokeringWebService;

import generated.Company;
import generated.CompanyList;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar; 
//import okhttp3.*;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import org.apache.hc.client5.http.classic.methods.HttpGet;
//import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
//import org.apache.hc.client5.http.impl.classic.HttpClients;
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
    
    

    
    public List<Pair<String, String>> getCompanyNamesAndSymbols() throws IOException
    {
        List<Pair<String, String>> namesAndSymbols = new ArrayList<Pair<String, String>>();
        
        
        URL con = new URL("http://api.marketstack.com/v1/tickers?access_key=" + access_key);
        URLConnection yc = con.openConnection();
        yc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                yc.getInputStream()));
        String inputLine = "";
        String response = "";
        while ((inputLine = in.readLine()) != null)
        {
            response += inputLine + "\n";
        }
            
        in.close();

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
                sharePrice.setCurrency("EUR");
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
    public java.util.List<Company> getCompanyData(@WebParam(name = "Limit") int Limit, @WebParam(name = "Offset") int Offset) {
        
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
        
        return allCompanies.getCompanyList();
    }
    
    void overwriteCompanyData(List<Company> companies)
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
        java.util.List<Company> Companies = getCompanyData(1000, 0);
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
    public List<Company> GetCompaniesBySymbol(@WebParam(name = "symbol") String symbol) {
        java.util.List<Company> allCompanies = getCompanyData(1000, 0);
        //java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.INFO, null, "Size " + allCompanies.size());
        List<Company> filteredCompanies = new ArrayList<Company>();
        
        for (Company company: allCompanies)
        {
            //java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.INFO, null, "Current company: " + company.getCompanySymbol());
            if (company.getCompanySymbol().equals(symbol))
            {
                java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.INFO, null, "Current company: " + company.getCompanySymbol());
                filteredCompanies.add(company);
            }
        }
        
        return filteredCompanies;
    }



}
