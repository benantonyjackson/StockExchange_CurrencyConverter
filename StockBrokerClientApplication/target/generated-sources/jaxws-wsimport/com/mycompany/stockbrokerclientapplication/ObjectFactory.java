
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

    private final static QName _GetCompanyDataResponse_QNAME = new QName("http://StockBrokeringWebService/", "getCompanyDataResponse");
    private final static QName _BuyShare_QNAME = new QName("http://StockBrokeringWebService/", "buyShare");
    private final static QName _GetAllSymbols_QNAME = new QName("http://StockBrokeringWebService/", "getAllSymbols");
    private final static QName _GetCompanyData_QNAME = new QName("http://StockBrokeringWebService/", "getCompanyData");
    private final static QName _BuyShareResponse_QNAME = new QName("http://StockBrokeringWebService/", "buyShareResponse");
    private final static QName _GetAllSymbolsResponse_QNAME = new QName("http://StockBrokeringWebService/", "getAllSymbolsResponse");
    private final static QName _GenorateRandomCompanyData_QNAME = new QName("http://StockBrokeringWebService/", "genorateRandomCompanyData");
    private final static QName _GenorateRandomCompanyDataResponse_QNAME = new QName("http://StockBrokeringWebService/", "genorateRandomCompanyDataResponse");

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
     * Create an instance of {@link BuyShare }
     * 
     */
    public BuyShare createBuyShare() {
        return new BuyShare();
    }

    /**
     * Create an instance of {@link GetAllSymbols }
     * 
     */
    public GetAllSymbols createGetAllSymbols() {
        return new GetAllSymbols();
    }

    /**
     * Create an instance of {@link GetCompanyData }
     * 
     */
    public GetCompanyData createGetCompanyData() {
        return new GetCompanyData();
    }

    /**
     * Create an instance of {@link GetCompanyDataResponse }
     * 
     */
    public GetCompanyDataResponse createGetCompanyDataResponse() {
        return new GetCompanyDataResponse();
    }

    /**
     * Create an instance of {@link GenorateRandomCompanyDataResponse }
     * 
     */
    public GenorateRandomCompanyDataResponse createGenorateRandomCompanyDataResponse() {
        return new GenorateRandomCompanyDataResponse();
    }

    /**
     * Create an instance of {@link BuyShareResponse }
     * 
     */
    public BuyShareResponse createBuyShareResponse() {
        return new BuyShareResponse();
    }

    /**
     * Create an instance of {@link GetAllSymbolsResponse }
     * 
     */
    public GetAllSymbolsResponse createGetAllSymbolsResponse() {
        return new GetAllSymbolsResponse();
    }

    /**
     * Create an instance of {@link GenorateRandomCompanyData }
     * 
     */
    public GenorateRandomCompanyData createGenorateRandomCompanyData() {
        return new GenorateRandomCompanyData();
    }

    /**
     * Create an instance of {@link Company.SharePrice }
     * 
     */
    public Company.SharePrice createCompanySharePrice() {
        return new Company.SharePrice();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyShare }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "buyShare")
    public JAXBElement<BuyShare> createBuyShare(BuyShare value) {
        return new JAXBElement<BuyShare>(_BuyShare_QNAME, BuyShare.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSymbols }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getAllSymbols")
    public JAXBElement<GetAllSymbols> createGetAllSymbols(GetAllSymbols value) {
        return new JAXBElement<GetAllSymbols>(_GetAllSymbols_QNAME, GetAllSymbols.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyShareResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "buyShareResponse")
    public JAXBElement<BuyShareResponse> createBuyShareResponse(BuyShareResponse value) {
        return new JAXBElement<BuyShareResponse>(_BuyShareResponse_QNAME, BuyShareResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSymbolsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getAllSymbolsResponse")
    public JAXBElement<GetAllSymbolsResponse> createGetAllSymbolsResponse(GetAllSymbolsResponse value) {
        return new JAXBElement<GetAllSymbolsResponse>(_GetAllSymbolsResponse_QNAME, GetAllSymbolsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GenorateRandomCompanyDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "genorateRandomCompanyDataResponse")
    public JAXBElement<GenorateRandomCompanyDataResponse> createGenorateRandomCompanyDataResponse(GenorateRandomCompanyDataResponse value) {
        return new JAXBElement<GenorateRandomCompanyDataResponse>(_GenorateRandomCompanyDataResponse_QNAME, GenorateRandomCompanyDataResponse.class, null, value);
    }

}
