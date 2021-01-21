
package com.mycompany.stockbrokerclientapplication;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
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
     * @param currencyType
     * @param companies
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "convertCurrencies", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.ConvertCurrencies")
    @ResponseWrapper(localName = "convertCurrenciesResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.ConvertCurrenciesResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/convertCurrenciesRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/convertCurrenciesResponse")
    public List<Object> convertCurrencies(
        @WebParam(name = "companies", targetNamespace = "")
        List<Company> companies,
        @WebParam(name = "currencyType", targetNamespace = "")
        String currencyType);

    /**
     * 
     * @param symbol
     * @param arg2
     * @param currency
     * @param order
     * @return
     *     returns java.util.List<com.mycompany.stockbrokerclientapplication.Company>
     */
    @WebMethod(operationName = "GetCompaniesBySymbol")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetCompaniesBySymbol", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompaniesBySymbol")
    @ResponseWrapper(localName = "GetCompaniesBySymbolResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompaniesBySymbolResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/GetCompaniesBySymbolRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/GetCompaniesBySymbolResponse")
    public List<Company> getCompaniesBySymbol(
        @WebParam(name = "symbol", targetNamespace = "")
        String symbol,
        @WebParam(name = "currency", targetNamespace = "")
        String currency,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "order", targetNamespace = "")
        String order);

    /**
     * 
     * @return
     *     returns java.util.List<com.mycompany.stockbrokerclientapplication.Pair>
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompanyNamesAndSymbols", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompanyNamesAndSymbols")
    @ResponseWrapper(localName = "getCompanyNamesAndSymbolsResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompanyNamesAndSymbolsResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/getCompanyNamesAndSymbolsRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/getCompanyNamesAndSymbolsResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://StockBrokeringWebService/StockBrokeringWebService/getCompanyNamesAndSymbols/Fault/IOException")
    })
    public List<Pair> getCompanyNamesAndSymbols()
        throws IOException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param name
     * @param currency
     * @param order
     * @return
     *     returns java.util.List<com.mycompany.stockbrokerclientapplication.Company>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompaniesByName", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompaniesByName")
    @ResponseWrapper(localName = "getCompaniesByNameResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompaniesByNameResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/getCompaniesByNameRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/getCompaniesByNameResponse")
    public List<Company> getCompaniesByName(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "currency", targetNamespace = "")
        String currency,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "order", targetNamespace = "")
        String order);

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
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCurrencies", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCurrencies")
    @ResponseWrapper(localName = "getCurrenciesResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCurrenciesResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/getCurrenciesRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/getCurrenciesResponse")
    public List<String> getCurrencies();

    /**
     * 
     * @param orderBy
     * @param currency
     * @param order
     * @return
     *     returns java.util.List<com.mycompany.stockbrokerclientapplication.Company>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompanyData", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompanyData")
    @ResponseWrapper(localName = "getCompanyDataResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompanyDataResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/getCompanyDataRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/getCompanyDataResponse")
    public List<Company> getCompanyData(
        @WebParam(name = "currency", targetNamespace = "")
        String currency,
        @WebParam(name = "orderBy", targetNamespace = "")
        String orderBy,
        @WebParam(name = "order", targetNamespace = "")
        String order);

}
