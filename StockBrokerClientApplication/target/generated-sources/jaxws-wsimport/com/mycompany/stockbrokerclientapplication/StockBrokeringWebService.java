
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
     * @param orderBy
     * @param currency
     * @param value
     * @param operator
     * @param order
     * @return
     *     returns java.util.List<com.mycompany.stockbrokerclientapplication.Company>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "filterByPrice", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.FilterByPrice")
    @ResponseWrapper(localName = "filterByPriceResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.FilterByPriceResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/filterByPriceRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/filterByPriceResponse")
    public List<Company> filterByPrice(
        @WebParam(name = "value", targetNamespace = "")
        float value,
        @WebParam(name = "operator", targetNamespace = "")
        String operator,
        @WebParam(name = "currency", targetNamespace = "")
        String currency,
        @WebParam(name = "orderBy", targetNamespace = "")
        String orderBy,
        @WebParam(name = "order", targetNamespace = "")
        String order);

    /**
     * 
     * @param companies
     * @param orderBy
     * @param order
     * @return
     *     returns java.util.List<com.mycompany.stockbrokerclientapplication.Company>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "orderCompanies", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.OrderCompanies")
    @ResponseWrapper(localName = "orderCompaniesResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.OrderCompaniesResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/orderCompaniesRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/orderCompaniesResponse")
    public List<Company> orderCompanies(
        @WebParam(name = "companies", targetNamespace = "")
        List<Company> companies,
        @WebParam(name = "orderBy", targetNamespace = "")
        String orderBy,
        @WebParam(name = "order", targetNamespace = "")
        String order);

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
     * @throws DatatypeConfigurationException_Exception
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompanyData", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompanyData")
    @ResponseWrapper(localName = "getCompanyDataResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GetCompanyDataResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/getCompanyDataRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/getCompanyDataResponse", fault = {
        @FaultAction(className = DatatypeConfigurationException_Exception.class, value = "http://StockBrokeringWebService/StockBrokeringWebService/getCompanyData/Fault/DatatypeConfigurationException"),
        @FaultAction(className = IOException_Exception.class, value = "http://StockBrokeringWebService/StockBrokeringWebService/getCompanyData/Fault/IOException")
    })
    public List<Company> getCompanyData(
        @WebParam(name = "currency", targetNamespace = "")
        String currency,
        @WebParam(name = "orderBy", targetNamespace = "")
        String orderBy,
        @WebParam(name = "order", targetNamespace = "")
        String order)
        throws DatatypeConfigurationException_Exception, IOException_Exception
    ;

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
     * @param currencyType
     * @param companies
     * @return
     *     returns java.util.List<com.mycompany.stockbrokerclientapplication.Company>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "convertCurrencies", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.ConvertCurrencies")
    @ResponseWrapper(localName = "convertCurrenciesResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.ConvertCurrenciesResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/convertCurrenciesRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/convertCurrenciesResponse")
    public List<Company> convertCurrencies(
        @WebParam(name = "companies", targetNamespace = "")
        List<Company> companies,
        @WebParam(name = "currencyType", targetNamespace = "")
        String currencyType);

    /**
     * 
     * @return
     *     returns java.util.List<com.mycompany.stockbrokerclientapplication.Company>
     * @throws DatatypeConfigurationException_Exception
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "genorateRandomCompanyData", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GenorateRandomCompanyData")
    @ResponseWrapper(localName = "genorateRandomCompanyDataResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.GenorateRandomCompanyDataResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/genorateRandomCompanyDataRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/genorateRandomCompanyDataResponse", fault = {
        @FaultAction(className = DatatypeConfigurationException_Exception.class, value = "http://StockBrokeringWebService/StockBrokeringWebService/genorateRandomCompanyData/Fault/DatatypeConfigurationException"),
        @FaultAction(className = IOException_Exception.class, value = "http://StockBrokeringWebService/StockBrokeringWebService/genorateRandomCompanyData/Fault/IOException")
    })
    public List<Company> genorateRandomCompanyData()
        throws DatatypeConfigurationException_Exception, IOException_Exception
    ;

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
     * @param orderBy
     * @param currency
     * @param value
     * @param operator
     * @param order
     * @return
     *     returns java.util.List<com.mycompany.stockbrokerclientapplication.Company>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "filterByAvailibleShares", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.FilterByAvailibleShares")
    @ResponseWrapper(localName = "filterByAvailibleSharesResponse", targetNamespace = "http://StockBrokeringWebService/", className = "com.mycompany.stockbrokerclientapplication.FilterByAvailibleSharesResponse")
    @Action(input = "http://StockBrokeringWebService/StockBrokeringWebService/filterByAvailibleSharesRequest", output = "http://StockBrokeringWebService/StockBrokeringWebService/filterByAvailibleSharesResponse")
    public List<Company> filterByAvailibleShares(
        @WebParam(name = "value", targetNamespace = "")
        float value,
        @WebParam(name = "operator", targetNamespace = "")
        String operator,
        @WebParam(name = "currency", targetNamespace = "")
        String currency,
        @WebParam(name = "orderBy", targetNamespace = "")
        String orderBy,
        @WebParam(name = "order", targetNamespace = "")
        String order);

}
