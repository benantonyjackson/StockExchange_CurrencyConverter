
package com.mycompany.stockbrokeringwebapplication;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.stockbrokeringwebapplication package. 
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

    private final static QName _GetCompanyDataResponse_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "getCompanyDataResponse");
    private final static QName _HelloResponse_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "helloResponse");
    private final static QName _GetAllCompanyData_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "getAllCompanyData");
    private final static QName _GetAllSymbols_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "getAllSymbols");
    private final static QName _GetCompanyData_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "getCompanyData");
    private final static QName _GenorateRandomCompanyData_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "genorateRandomCompanyData");
    private final static QName _GetAllCompanyDataResponse_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "getAllCompanyDataResponse");
    private final static QName _GetAllSymbolsResponse_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "getAllSymbolsResponse");
    private final static QName _Hello_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "hello");
    private final static QName _GenorateRandomCompanyDataResponse_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "genorateRandomCompanyDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.stockbrokeringwebapplication
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link GetAllCompanyData }
     * 
     */
    public GetAllCompanyData createGetAllCompanyData() {
        return new GetAllCompanyData();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
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
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stockbrokeringwebapplication.mycompany.com/", name = "getCompanyDataResponse")
    public JAXBElement<GetCompanyDataResponse> createGetCompanyDataResponse(GetCompanyDataResponse value) {
        return new JAXBElement<GetCompanyDataResponse>(_GetCompanyDataResponse_QNAME, GetCompanyDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stockbrokeringwebapplication.mycompany.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCompanyData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stockbrokeringwebapplication.mycompany.com/", name = "getAllCompanyData")
    public JAXBElement<GetAllCompanyData> createGetAllCompanyData(GetAllCompanyData value) {
        return new JAXBElement<GetAllCompanyData>(_GetAllCompanyData_QNAME, GetAllCompanyData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSymbols }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stockbrokeringwebapplication.mycompany.com/", name = "getAllSymbols")
    public JAXBElement<GetAllSymbols> createGetAllSymbols(GetAllSymbols value) {
        return new JAXBElement<GetAllSymbols>(_GetAllSymbols_QNAME, GetAllSymbols.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stockbrokeringwebapplication.mycompany.com/", name = "getCompanyData")
    public JAXBElement<GetCompanyData> createGetCompanyData(GetCompanyData value) {
        return new JAXBElement<GetCompanyData>(_GetCompanyData_QNAME, GetCompanyData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenorateRandomCompanyData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stockbrokeringwebapplication.mycompany.com/", name = "genorateRandomCompanyData")
    public JAXBElement<GenorateRandomCompanyData> createGenorateRandomCompanyData(GenorateRandomCompanyData value) {
        return new JAXBElement<GenorateRandomCompanyData>(_GenorateRandomCompanyData_QNAME, GenorateRandomCompanyData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllCompanyDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stockbrokeringwebapplication.mycompany.com/", name = "getAllCompanyDataResponse")
    public JAXBElement<GetAllCompanyDataResponse> createGetAllCompanyDataResponse(GetAllCompanyDataResponse value) {
        return new JAXBElement<GetAllCompanyDataResponse>(_GetAllCompanyDataResponse_QNAME, GetAllCompanyDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSymbolsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stockbrokeringwebapplication.mycompany.com/", name = "getAllSymbolsResponse")
    public JAXBElement<GetAllSymbolsResponse> createGetAllSymbolsResponse(GetAllSymbolsResponse value) {
        return new JAXBElement<GetAllSymbolsResponse>(_GetAllSymbolsResponse_QNAME, GetAllSymbolsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stockbrokeringwebapplication.mycompany.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenorateRandomCompanyDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stockbrokeringwebapplication.mycompany.com/", name = "genorateRandomCompanyDataResponse")
    public JAXBElement<GenorateRandomCompanyDataResponse> createGenorateRandomCompanyDataResponse(GenorateRandomCompanyDataResponse value) {
        return new JAXBElement<GenorateRandomCompanyDataResponse>(_GenorateRandomCompanyDataResponse_QNAME, GenorateRandomCompanyDataResponse.class, null, value);
    }

}
