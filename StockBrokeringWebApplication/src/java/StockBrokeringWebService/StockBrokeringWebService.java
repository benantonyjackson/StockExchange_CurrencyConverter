/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockBrokeringWebService;

import generated.Company;
import generated.CompanyList;
import java.awt.List;
import java.io.File;
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
    
    public String genorateRandomCompanyData()
    {
        Vector<String> symbols = getAllSymbols();
        
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
            
            File file = new File(allCompaniesFile);
            file.setExecutable(true);
            file.setWritable(true);
            
            marshaller.marshal(allCompanies, file);
            marshaller.marshal(allCompanies, System.out);
            
            ret += "After file write";
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }   
        
        return ret;
    }
    
    
    
    
    
    /*
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
        
        return allCompanies;
    
    */
    

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



}
