
package com.mycompany.stockbrokerclientapplication;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StockBrokeringWebService", targetNamespace = "http://StockBrokeringWebService/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StockBrokeringWebService {


    /**
     * 
     * @param symbol
     * @param numberOfShares
     * @return
     *     returns com.mycompany.stockbrokerclientapplication.Company
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buyShare", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.BuyShare")
    @ResponseWrapper(localName = "buyShareResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.BuyShareResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/buyShareRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/buyShareResponse")
    public Company buyShare(
        @WebParam(name = "Symbol", targetNamespace = "")
        String symbol,
        @WebParam(name = "NumberOfShares", targetNamespace = "")
        int numberOfShares);

    /**
     * 
     * @return
     *     returns java.util.List<com.mycompany.stockbrokerclientapplication.Company>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "genorateRandomCompanyData", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GenorateRandomCompanyData")
    @ResponseWrapper(localName = "genorateRandomCompanyDataResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GenorateRandomCompanyDataResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/genorateRandomCompanyDataRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/genorateRandomCompanyDataResponse")
    public List<Company> genorateRandomCompanyData();

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllSymbols", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetAllSymbols")
    @ResponseWrapper(localName = "getAllSymbolsResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetAllSymbolsResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/getAllSymbolsRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/getAllSymbolsResponse")
    public List<String> getAllSymbols();

    /**
     * 
     * @param offset
     * @param limit
     * @return
     *     returns java.util.List<com.mycompany.stockbrokerclientapplication.Company>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompanyData", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompanyData")
    @ResponseWrapper(localName = "getCompanyDataResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompanyDataResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/getCompanyDataRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/getCompanyDataResponse")
    public List<Company> getCompanyData(
        @WebParam(name = "Limit", targetNamespace = "")
        int limit,
        @WebParam(name = "Offset", targetNamespace = "")
        int offset);

}