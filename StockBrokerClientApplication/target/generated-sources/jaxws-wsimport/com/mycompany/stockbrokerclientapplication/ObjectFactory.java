
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

    private final static QName _GetAllSymbols_QNAME = new QName("http://StockBrokeringWebService/", "getAllSymbols");
    private final static QName _GetAllCompanyData_QNAME = new QName("http://StockBrokeringWebService/", "getAllCompanyData");
    private final static QName _GetAllCompanyDataResponse_QNAME = new QName("http://StockBrokeringWebService/", "getAllCompanyDataResponse");
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
     * Create an instance of {@link GetAllSymbols }
     * 
     */
    public GetAllSymbols createGetAllSymbols() {
        return new GetAllSymbols();
    }

    /**
     * Create an instance of {@link GetAllCompanyData }
     * 
     */
    public GetAllCompanyData createGetAllCompanyData() {
        return new GetAllCompanyData();
    }

    /**
     * Create an instance of {@link CompanyList }
     * 
     */
    public CompanyList createCompanyList() {
        return new CompanyList();
    }

    /**
     * Create an instance of {@link GenorateRandomCompanyDataResponse }
     * 
     */
    public GenorateRandomCompanyDataResponse createGenorateRandomCompanyDataResponse() {
        return new GenorateRandomCompanyDataResponse();
    }

    /**
     * Create an instance of {@link GetAllCompanyDataResponse }
     * 
     */
    public GetAllCompanyDataResponse createGetAllCompanyDataResponse() {
        return new GetAllCompanyDataResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSymbols }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getAllSymbols")
    public JAXBElement<GetAllSymbols> createGetAllSymbols(GetAllSymbols value) {
        return new JAXBElement<GetAllSymbols>(_GetAllSymbols_QNAME, GetAllSymbols.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCompanyData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getAllCompanyData")
    public JAXBElement<GetAllCompanyData> createGetAllCompanyData(GetAllCompanyData value) {
        return new JAXBElement<GetAllCompanyData>(_GetAllCompanyData_QNAME, GetAllCompanyData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCompanyDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getAllCompanyDataResponse")
    public JAXBElement<GetAllCompanyDataResponse> createGetAllCompanyDataResponse(GetAllCompanyDataResponse value) {
        return new JAXBElement<GetAllCompanyDataResponse>(_GetAllCompanyDataResponse_QNAME, GetAllCompanyDataResponse.class, null, value);
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
