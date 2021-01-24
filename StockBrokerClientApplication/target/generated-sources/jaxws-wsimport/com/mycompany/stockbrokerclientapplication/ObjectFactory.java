
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

    private final static QName _FilterByPrice_QNAME = new QName("http://StockBrokeringWebService/", "filterByPrice");
    private final static QName _BuyShare_QNAME = new QName("http://StockBrokeringWebService/", "buyShare");
    private final static QName _GetCompanyData_QNAME = new QName("http://StockBrokeringWebService/", "getCompanyData");
    private final static QName _InvalidOrderException_QNAME = new QName("http://StockBrokeringWebService/", "InvalidOrderException");
    private final static QName _BuyShareResponse_QNAME = new QName("http://StockBrokeringWebService/", "buyShareResponse");
    private final static QName _ConvertCurrenciesResponse_QNAME = new QName("http://StockBrokeringWebService/", "convertCurrenciesResponse");
    private final static QName _CompanyDataGenerationException_QNAME = new QName("http://StockBrokeringWebService/", "CompanyDataGenerationException");
    private final static QName _GetCompanyDataResponse_QNAME = new QName("http://StockBrokeringWebService/", "getCompanyDataResponse");
    private final static QName _NotSortableFieldException_QNAME = new QName("http://StockBrokeringWebService/", "NotSortableFieldException");
    private final static QName _ConvertCurrencies_QNAME = new QName("http://StockBrokeringWebService/", "convertCurrencies");
    private final static QName _OverwriteCompanyDataException_QNAME = new QName("http://StockBrokeringWebService/", "OverwriteCompanyDataException");
    private final static QName _GetCompaniesBySymbol_QNAME = new QName("http://StockBrokeringWebService/", "GetCompaniesBySymbol");
    private final static QName _CompanyNotFoundException_QNAME = new QName("http://StockBrokeringWebService/", "CompanyNotFoundException");
    private final static QName _MarketStackAPIException_QNAME = new QName("http://StockBrokeringWebService/", "MarketStackAPIException");
    private final static QName _GetCompanyNamesAndSymbols_QNAME = new QName("http://StockBrokeringWebService/", "getCompanyNamesAndSymbols");
    private final static QName _GetCurrencies_QNAME = new QName("http://StockBrokeringWebService/", "getCurrencies");
    private final static QName _OrderCompaniesResponse_QNAME = new QName("http://StockBrokeringWebService/", "orderCompaniesResponse");
    private final static QName _DatatypeConfigurationException_QNAME = new QName("http://StockBrokeringWebService/", "DatatypeConfigurationException");
    private final static QName _GetCompaniesByNameResponse_QNAME = new QName("http://StockBrokeringWebService/", "getCompaniesByNameResponse");
    private final static QName _GetCompanyNamesAndSymbolsResponse_QNAME = new QName("http://StockBrokeringWebService/", "getCompanyNamesAndSymbolsResponse");
    private final static QName _OrderCompanies_QNAME = new QName("http://StockBrokeringWebService/", "orderCompanies");
    private final static QName _FilterByPriceResponse_QNAME = new QName("http://StockBrokeringWebService/", "filterByPriceResponse");
    private final static QName _GetCompaniesByName_QNAME = new QName("http://StockBrokeringWebService/", "getCompaniesByName");
    private final static QName _FilterByAvailibleShares_QNAME = new QName("http://StockBrokeringWebService/", "filterByAvailibleShares");
    private final static QName _CurrencyConversionException_QNAME = new QName("http://StockBrokeringWebService/", "CurrencyConversionException");
    private final static QName _Exception_QNAME = new QName("http://StockBrokeringWebService/", "Exception");
    private final static QName _GenorateRandomCompanyData_QNAME = new QName("http://StockBrokeringWebService/", "genorateRandomCompanyData");
    private final static QName _GetCurrenciesResponse_QNAME = new QName("http://StockBrokeringWebService/", "getCurrenciesResponse");
    private final static QName _GetCompaniesBySymbolResponse_QNAME = new QName("http://StockBrokeringWebService/", "GetCompaniesBySymbolResponse");
    private final static QName _UnsupportedEncodingException_QNAME = new QName("http://StockBrokeringWebService/", "UnsupportedEncodingException");
    private final static QName _FilterByAvailibleSharesResponse_QNAME = new QName("http://StockBrokeringWebService/", "filterByAvailibleSharesResponse");
    private final static QName _CompanyDataUnmarshellException_QNAME = new QName("http://StockBrokeringWebService/", "CompanyDataUnmarshellException");
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
     * Create an instance of {@link NotSortableFieldException }
     * 
     */
    public NotSortableFieldException createNotSortableFieldException() {
        return new NotSortableFieldException();
    }

    /**
     * Create an instance of {@link ConvertCurrencies }
     * 
     */
    public ConvertCurrencies createConvertCurrencies() {
        return new ConvertCurrencies();
    }

    /**
     * Create an instance of {@link OverwriteCompanyDataException }
     * 
     */
    public OverwriteCompanyDataException createOverwriteCompanyDataException() {
        return new OverwriteCompanyDataException();
    }

    /**
     * Create an instance of {@link GetCompanyDataResponse }
     * 
     */
    public GetCompanyDataResponse createGetCompanyDataResponse() {
        return new GetCompanyDataResponse();
    }

    /**
     * Create an instance of {@link CompanyNotFoundException }
     * 
     */
    public CompanyNotFoundException createCompanyNotFoundException() {
        return new CompanyNotFoundException();
    }

    /**
     * Create an instance of {@link MarketStackAPIException }
     * 
     */
    public MarketStackAPIException createMarketStackAPIException() {
        return new MarketStackAPIException();
    }

    /**
     * Create an instance of {@link GetCompaniesBySymbol }
     * 
     */
    public GetCompaniesBySymbol createGetCompaniesBySymbol() {
        return new GetCompaniesBySymbol();
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
     * Create an instance of {@link InvalidOrderException }
     * 
     */
    public InvalidOrderException createInvalidOrderException() {
        return new InvalidOrderException();
    }

    /**
     * Create an instance of {@link FilterByPrice }
     * 
     */
    public FilterByPrice createFilterByPrice() {
        return new FilterByPrice();
    }

    /**
     * Create an instance of {@link CompanyDataGenerationException }
     * 
     */
    public CompanyDataGenerationException createCompanyDataGenerationException() {
        return new CompanyDataGenerationException();
    }

    /**
     * Create an instance of {@link BuyShareResponse }
     * 
     */
    public BuyShareResponse createBuyShareResponse() {
        return new BuyShareResponse();
    }

    /**
     * Create an instance of {@link ConvertCurrenciesResponse }
     * 
     */
    public ConvertCurrenciesResponse createConvertCurrenciesResponse() {
        return new ConvertCurrenciesResponse();
    }

    /**
     * Create an instance of {@link FilterByAvailibleShares }
     * 
     */
    public FilterByAvailibleShares createFilterByAvailibleShares() {
        return new FilterByAvailibleShares();
    }

    /**
     * Create an instance of {@link GetCompaniesByName }
     * 
     */
    public GetCompaniesByName createGetCompaniesByName() {
        return new GetCompaniesByName();
    }

    /**
     * Create an instance of {@link GetCompaniesBySymbolResponse }
     * 
     */
    public GetCompaniesBySymbolResponse createGetCompaniesBySymbolResponse() {
        return new GetCompaniesBySymbolResponse();
    }

    /**
     * Create an instance of {@link UnsupportedEncodingException }
     * 
     */
    public UnsupportedEncodingException createUnsupportedEncodingException() {
        return new UnsupportedEncodingException();
    }

    /**
     * Create an instance of {@link FilterByAvailibleSharesResponse }
     * 
     */
    public FilterByAvailibleSharesResponse createFilterByAvailibleSharesResponse() {
        return new FilterByAvailibleSharesResponse();
    }

    /**
     * Create an instance of {@link CompanyDataUnmarshellException }
     * 
     */
    public CompanyDataUnmarshellException createCompanyDataUnmarshellException() {
        return new CompanyDataUnmarshellException();
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
     * Create an instance of {@link CurrencyConversionException }
     * 
     */
    public CurrencyConversionException createCurrencyConversionException() {
        return new CurrencyConversionException();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
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
     * Create an instance of {@link DatatypeConfigurationException }
     * 
     */
    public DatatypeConfigurationException createDatatypeConfigurationException() {
        return new DatatypeConfigurationException();
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
     * Create an instance of {@link OrderCompaniesResponse }
     * 
     */
    public OrderCompaniesResponse createOrderCompaniesResponse() {
        return new OrderCompaniesResponse();
    }

    /**
     * Create an instance of {@link FilterByPriceResponse }
     * 
     */
    public FilterByPriceResponse createFilterByPriceResponse() {
        return new FilterByPriceResponse();
    }

    /**
     * Create an instance of {@link GetCompanyNamesAndSymbolsResponse }
     * 
     */
    public GetCompanyNamesAndSymbolsResponse createGetCompanyNamesAndSymbolsResponse() {
        return new GetCompanyNamesAndSymbolsResponse();
    }

    /**
     * Create an instance of {@link OrderCompanies }
     * 
     */
    public OrderCompanies createOrderCompanies() {
        return new OrderCompanies();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "filterByPrice")
    public JAXBElement<FilterByPrice> createFilterByPrice(FilterByPrice value) {
        return new JAXBElement<FilterByPrice>(_FilterByPrice_QNAME, FilterByPrice.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidOrderException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "InvalidOrderException")
    public JAXBElement<InvalidOrderException> createInvalidOrderException(InvalidOrderException value) {
        return new JAXBElement<InvalidOrderException>(_InvalidOrderException_QNAME, InvalidOrderException.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertCurrenciesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "convertCurrenciesResponse")
    public JAXBElement<ConvertCurrenciesResponse> createConvertCurrenciesResponse(ConvertCurrenciesResponse value) {
        return new JAXBElement<ConvertCurrenciesResponse>(_ConvertCurrenciesResponse_QNAME, ConvertCurrenciesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompanyDataGenerationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "CompanyDataGenerationException")
    public JAXBElement<CompanyDataGenerationException> createCompanyDataGenerationException(CompanyDataGenerationException value) {
        return new JAXBElement<CompanyDataGenerationException>(_CompanyDataGenerationException_QNAME, CompanyDataGenerationException.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link NotSortableFieldException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "NotSortableFieldException")
    public JAXBElement<NotSortableFieldException> createNotSortableFieldException(NotSortableFieldException value) {
        return new JAXBElement<NotSortableFieldException>(_NotSortableFieldException_QNAME, NotSortableFieldException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConvertCurrencies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "convertCurrencies")
    public JAXBElement<ConvertCurrencies> createConvertCurrencies(ConvertCurrencies value) {
        return new JAXBElement<ConvertCurrencies>(_ConvertCurrencies_QNAME, ConvertCurrencies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OverwriteCompanyDataException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "OverwriteCompanyDataException")
    public JAXBElement<OverwriteCompanyDataException> createOverwriteCompanyDataException(OverwriteCompanyDataException value) {
        return new JAXBElement<OverwriteCompanyDataException>(_OverwriteCompanyDataException_QNAME, OverwriteCompanyDataException.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CompanyNotFoundException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "CompanyNotFoundException")
    public JAXBElement<CompanyNotFoundException> createCompanyNotFoundException(CompanyNotFoundException value) {
        return new JAXBElement<CompanyNotFoundException>(_CompanyNotFoundException_QNAME, CompanyNotFoundException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarketStackAPIException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "MarketStackAPIException")
    public JAXBElement<MarketStackAPIException> createMarketStackAPIException(MarketStackAPIException value) {
        return new JAXBElement<MarketStackAPIException>(_MarketStackAPIException_QNAME, MarketStackAPIException.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCompaniesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "orderCompaniesResponse")
    public JAXBElement<OrderCompaniesResponse> createOrderCompaniesResponse(OrderCompaniesResponse value) {
        return new JAXBElement<OrderCompaniesResponse>(_OrderCompaniesResponse_QNAME, OrderCompaniesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatatypeConfigurationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "DatatypeConfigurationException")
    public JAXBElement<DatatypeConfigurationException> createDatatypeConfigurationException(DatatypeConfigurationException value) {
        return new JAXBElement<DatatypeConfigurationException>(_DatatypeConfigurationException_QNAME, DatatypeConfigurationException.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyNamesAndSymbolsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "getCompanyNamesAndSymbolsResponse")
    public JAXBElement<GetCompanyNamesAndSymbolsResponse> createGetCompanyNamesAndSymbolsResponse(GetCompanyNamesAndSymbolsResponse value) {
        return new JAXBElement<GetCompanyNamesAndSymbolsResponse>(_GetCompanyNamesAndSymbolsResponse_QNAME, GetCompanyNamesAndSymbolsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCompanies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "orderCompanies")
    public JAXBElement<OrderCompanies> createOrderCompanies(OrderCompanies value) {
        return new JAXBElement<OrderCompanies>(_OrderCompanies_QNAME, OrderCompanies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "filterByPriceResponse")
    public JAXBElement<FilterByPriceResponse> createFilterByPriceResponse(FilterByPriceResponse value) {
        return new JAXBElement<FilterByPriceResponse>(_FilterByPriceResponse_QNAME, FilterByPriceResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByAvailibleShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "filterByAvailibleShares")
    public JAXBElement<FilterByAvailibleShares> createFilterByAvailibleShares(FilterByAvailibleShares value) {
        return new JAXBElement<FilterByAvailibleShares>(_FilterByAvailibleShares_QNAME, FilterByAvailibleShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyConversionException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "CurrencyConversionException")
    public JAXBElement<CurrencyConversionException> createCurrencyConversionException(CurrencyConversionException value) {
        return new JAXBElement<CurrencyConversionException>(_CurrencyConversionException_QNAME, CurrencyConversionException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link UnsupportedEncodingException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "UnsupportedEncodingException")
    public JAXBElement<UnsupportedEncodingException> createUnsupportedEncodingException(UnsupportedEncodingException value) {
        return new JAXBElement<UnsupportedEncodingException>(_UnsupportedEncodingException_QNAME, UnsupportedEncodingException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilterByAvailibleSharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "filterByAvailibleSharesResponse")
    public JAXBElement<FilterByAvailibleSharesResponse> createFilterByAvailibleSharesResponse(FilterByAvailibleSharesResponse value) {
        return new JAXBElement<FilterByAvailibleSharesResponse>(_FilterByAvailibleSharesResponse_QNAME, FilterByAvailibleSharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompanyDataUnmarshellException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://StockBrokeringWebService/", name = "CompanyDataUnmarshellException")
    public JAXBElement<CompanyDataUnmarshellException> createCompanyDataUnmarshellException(CompanyDataUnmarshellException value) {
        return new JAXBElement<CompanyDataUnmarshellException>(_CompanyDataUnmarshellException_QNAME, CompanyDataUnmarshellException.class, null, value);
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
