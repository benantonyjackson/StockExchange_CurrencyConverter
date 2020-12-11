
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

    private final static QName _HelloResponse_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "helloResponse");
    private final static QName _GetAllSymbols_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "getAllSymbols");
    private final static QName _GetAllSymbolsResponse_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "getAllSymbolsResponse");
    private final static QName _Hello_QNAME = new QName("http://stockbrokeringwebapplication.mycompany.com/", "hello");

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
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link GetAllSymbolsResponse }
     * 
     */
    public GetAllSymbolsResponse createGetAllSymbolsResponse() {
        return new GetAllSymbolsResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSymbols }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://stockbrokeringwebapplication.mycompany.com/", name = "getAllSymbols")
    public JAXBElement<GetAllSymbols> createGetAllSymbols(GetAllSymbols value) {
        return new JAXBElement<GetAllSymbols>(_GetAllSymbols_QNAME, GetAllSymbols.class, null, value);
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

}
