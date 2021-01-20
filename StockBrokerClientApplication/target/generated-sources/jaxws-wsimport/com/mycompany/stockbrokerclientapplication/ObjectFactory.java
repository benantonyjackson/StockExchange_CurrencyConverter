
package com.mycompany.stockbrokerclientapplication;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.stockbrokerclientapplication package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCompanyNamesAndSymbols_QNAME = new QName("http://StockBrokeringWebService/", "getCompanyNamesAndSymbols");
    private final static QName _GetCurrencies_QNAME = new QName("http://StockBrokeringWebService/", "getCurrencies");
    private final static QName _BuyShare_QNAME = new QName("http://StockBrokeringWebService/", "buyShare");
    private final static QName _GetCompanyData_QNAME = new QName("http://StockBrokeringWebService/", "getCompanyData");
    private final static QName _GetCompaniesByNameResponse_QNAME = new QName("http://StockBrokeringWebService/", "getCompaniesByNameResponse");
    private final static QName _BuyShareResponse_QNAME = new QName("http://StockBrokeringWebService/", "buyShareResponse");
    private final static QName _GetCompanyNamesAndSymbolsResponse_QNAME = new QName("http://StockBrokeringWebService/", "getCompanyNamesAndSymbolsResponse");
    private final static QName _GetCompaniesByName_QNAME = new QName("http://StockBrokeringWebService/", "getCompaniesByName");
    private final static QName _GetCompanyDataResponse_QNAME = new QName("http://StockBrokeringWebService/", "getCompanyDataResponse");
    private final static QName _GetCompaniesBySymbol_QNAME = new QName("http://StockBrokeringWebService/", "GetCompaniesBySymbol");
    private final static QName _GenorateRandomCompanyData_QNAME = new QName("http://StockBrokeringWebService/", "genorateRandomCompanyData");
    private final static QName _GetCurrenciesResponse_QNAME = new QName("http://StockBrokeringWebService/", "getCurrenciesResponse");
    private final static QName _GetCompaniesBySymbolResponse_QNAME = new QName("http://StockBrokeringWebService/", "GetCompaniesBySymbolResponse");
    private final static QName _GenorateRandomCompanyDataResponse_QNAME = new QName("http://StockBrokeringWebService/", "genorateRandomCompanyDataResponse");
    private final static QName _IOException_QNAME = new QName("http://StockBrokeringWebService/", "IOException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.stockbrokerclientapplication
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Company }
     * 
     */
    public Company createCompany() {
        return new Company();
    }

    /**
     * Create an instance of {@link GetCompaniesByName }
     * 
     */
    public GetCompaniesByName createGetCompaniesByName() {
        return new GetCompaniesByName();
    }

    /**
     * Create an instance of {@link GetCompanyDataResponse }
     * 
     */
    public GetCompanyDataResponse createGetCompanyDataResponse() {
        return new GetCompanyDataResponse();
    }

    /**
     * Create an instance of {@link GetCompaniesBySymbolResponse }
     * 
     */
    public GetCompaniesBySymbolResponse createGetCompaniesBySymbolResponse() {
        return new GetCompaniesBySymbolResponse();
    }

    /**
     * Create an instance of {@link GenorateRandomCompanyDataResponse }
     * 
     */
    public GenorateRandomCompanyDataResponse createGenorateRandomCompanyDataResponse() {
        return new GenorateRandomCompanyDataResponse();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link GetCompaniesBySymbol }
     * 
     */
    public GetCompaniesBySymbol createGetCompaniesBySymbol() {
        return new GetCompaniesBySymbol();
    }

    /**
     * Create an instance of {@link GenorateRandomCompanyData }
     * 
     */
    public GenorateRandomCompanyData createGenorateRandomCompanyData() {
        return new GenorateRandomCompanyData();
    }

    /**
     * Create an instance of {@link GetCurrenciesResponse }
     * 
     */
    public GetCurrenciesResponse createGetCurrenciesResponse() {
        return new GetCurrenciesResponse();
    }

    /**
     * Create an instance of {@link BuyShare }
     * 
     */
    public BuyShare createBuyShare() {
        return new BuyShare();
    }

    /**
     * Create an instance of {@link GetCompanyData }
     * 
     */
    public GetCompanyData createGetCompanyData() {
        return new GetCompanyData();
    }

    /**
     * Create an instance of {@link GetCompaniesByNameResponse }
     * 
     */
    public GetCompaniesByNameResponse createGetCompaniesByNameResponse() {
        return new GetCompaniesByNameResponse();
    }

    /**
     * Create an instance of {@link GetCompanyNamesAndSymbols }
     * 
     */
    public GetCompanyNamesAndSymbols createGetCompanyNamesAndSymbols() {
        return new GetCompanyNamesAndSymbols();
    }

    /**
     * Create an instance of {@link GetCurrencies }
     * 
     */
    public GetCurrencies createGetCurrencies() {
        return new GetCurrencies();
    }

    /**
     * Create an instance of {@link BuyShareResponse }
     * 
     */
    public BuyShareResponse createBuyShareResponse() {
        return new BuyShareResponse();
    }

    /**
     * Create an instance of {@link GetCompanyNamesAndSymbolsResponse }
     * 
     */
    public GetCompanyNamesAndSymbolsResponse createGetCompanyNamesAndSymbolsResponse() {
        return new GetCompanyNamesAndSymbolsResponse();
    }

    /**
     * Create an instance of {@link Pair }
     * 
     */
    public Pair createPair() {
        return new Pair();
    }

    /**
     * Create an instance of {@link Company.SharePrice }
     * 
     */
    public Company.SharePrice createCompanySharePrice() {
        return new Company.SharePrice();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyNamesAndSymbols }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getCompanyNamesAndSymbols")
    public JAXBElement<GetCompanyNamesAndSymbols> createGetCompanyNamesAndSymbols(GetCompanyNamesAndSymbols value) {
        return new JAXBElement<GetCompanyNamesAndSymbols>(_GetCompanyNamesAndSymbols_QNAME, GetCompanyNamesAndSymbols.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getCurrencies")
    public JAXBElement<GetCurrencies> createGetCurrencies(GetCurrencies value) {
        return new JAXBElement<GetCurrencies>(_GetCurrencies_QNAME, GetCurrencies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyShare }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "buyShare")
    public JAXBElement<BuyShare> createBuyShare(BuyShare value) {
        return new JAXBElement<BuyShare>(_BuyShare_QNAME, BuyShare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getCompanyData")
    public JAXBElement<GetCompanyData> createGetCompanyData(GetCompanyData value) {
        return new JAXBElement<GetCompanyData>(_GetCompanyData_QNAME, GetCompanyData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompaniesByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getCompaniesByNameResponse")
    public JAXBElement<GetCompaniesByNameResponse> createGetCompaniesByNameResponse(GetCompaniesByNameResponse value) {
        return new JAXBElement<GetCompaniesByNameResponse>(_GetCompaniesByNameResponse_QNAME, GetCompaniesByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyShareResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "buyShareResponse")
    public JAXBElement<BuyShareResponse> createBuyShareResponse(BuyShareResponse value) {
        return new JAXBElement<BuyShareResponse>(_BuyShareResponse_QNAME, BuyShareResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyNamesAndSymbolsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getCompanyNamesAndSymbolsResponse")
    public JAXBElement<GetCompanyNamesAndSymbolsResponse> createGetCompanyNamesAndSymbolsResponse(GetCompanyNamesAndSymbolsResponse value) {
        return new JAXBElement<GetCompanyNamesAndSymbolsResponse>(_GetCompanyNamesAndSymbolsResponse_QNAME, GetCompanyNamesAndSymbolsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompaniesByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getCompaniesByName")
    public JAXBElement<GetCompaniesByName> createGetCompaniesByName(GetCompaniesByName value) {
        return new JAXBElement<GetCompaniesByName>(_GetCompaniesByName_QNAME, GetCompaniesByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getCompanyDataResponse")
    public JAXBElement<GetCompanyDataResponse> createGetCompanyDataResponse(GetCompanyDataResponse value) {
        return new JAXBElement<GetCompanyDataResponse>(_GetCompanyDataResponse_QNAME, GetCompanyDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompaniesBySymbol }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "GetCompaniesBySymbol")
    public JAXBElement<GetCompaniesBySymbol> createGetCompaniesBySymbol(GetCompaniesBySymbol value) {
        return new JAXBElement<GetCompaniesBySymbol>(_GetCompaniesBySymbol_QNAME, GetCompaniesBySymbol.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenorateRandomCompanyData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "genorateRandomCompanyData")
    public JAXBElement<GenorateRandomCompanyData> createGenorateRandomCompanyData(GenorateRandomCompanyData value) {
        return new JAXBElement<GenorateRandomCompanyData>(_GenorateRandomCompanyData_QNAME, GenorateRandomCompanyData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrenciesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getCurrenciesResponse")
    public JAXBElement<GetCurrenciesResponse> createGetCurrenciesResponse(GetCurrenciesResponse value) {
        return new JAXBElement<GetCurrenciesResponse>(_GetCurrenciesResponse_QNAME, GetCurrenciesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompaniesBySymbolResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "GetCompaniesBySymbolResponse")
    public JAXBElement<GetCompaniesBySymbolResponse> createGetCompaniesBySymbolResponse(GetCompaniesBySymbolResponse value) {
        return new JAXBElement<GetCompaniesBySymbolResponse>(_GetCompaniesBySymbolResponse_QNAME, GetCompaniesBySymbolResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenorateRandomCompanyDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "genorateRandomCompanyDataResponse")
    public JAXBElement<GenorateRandomCompanyDataResponse> createGenorateRandomCompanyDataResponse(GenorateRandomCompanyDataResponse value) {
        return new JAXBElement<GenorateRandomCompanyDataResponse>(_GenorateRandomCompanyDataResponse_QNAME, GenorateRandomCompanyDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

}
