/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockBrokeringWebService;

import generated.Company;
import generated.CompanyList;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
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
    private String allCompaniesFile = "company_data.xml";
    
    public List<Company> genorateRandomCompanyData()
    {
        Vector<String> symbols = getAllSymbols();
        
        List<Company> allCompanies = new ArrayList<Company>();
        
        for (String symbol: symbols)
        {
            try {
                Company company = new Company();

                company.setCompanySymbol(symbol);
                company.setCompanyName("Big bad corperation");

                XMLGregorianCalendar xmlGregorianCalendar;

                xmlGregorianCalendar = DatatypeFactory.newInstance()
                        .newXMLGregorianCalendar(LocalDateTime.now().toString());

                company.setLastUpdated(xmlGregorianCalendar);
                company.setNumberOfShares(10000);

                Company.SharePrice sharePrice = new Company.SharePrice();
                sharePrice.setCurrency("EUR");
                float min = 10;
                float max = 1000;
                float price = (min + (float)Math.random() * (max - min));
                BigDecimal bd = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
                sharePrice.setValue(bd.floatValue());

                company.setSharePrice(sharePrice);
                
                allCompanies.add(company);
            } catch (DatatypeConfigurationException ex) {
                Logger.getLogger(StockBrokeringWebService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        overwriteCompanyData(allCompanies);
        
        return allCompanies;
    }
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllSymbols")
    public Vector<String> getAllSymbols() {
        //http://api.marketstack.com/v1/tickers?access_key=e9b83f867fd578d5c5379ef351781eaf

        Vector<String> symbols = new Vector<String>();
        
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
    public java.util.List<Company> getCompanyData(@WebParam(name = "Limit") int Limit, @WebParam(name = "Offset") int Offset) {
        
        CompanyList allCompanies = new CompanyList();
        
        File file = new File(allCompaniesFile);
        
        if (!file.exists())
        {
            genorateRandomCompanyData();
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



}
