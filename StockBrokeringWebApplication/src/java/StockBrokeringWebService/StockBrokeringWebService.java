/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockBrokeringWebService;

import Exception.CompanyDataGenerationException;
import Exception.CompanyDataUnmarshellException;
import Exception.CompanyNotFoundException;
import Exception.CurrencyConversionException;
import Exception.InvalidNumberOfShares;
import Exception.InvalidOperatorException;
import Exception.InvalidOrderException;
import Exception.MarketStackAPIException;
import Exception.NotEnoughSharesException;
import Exception.NotSortableFieldException;
import Exception.OverwriteCompanyDataException;
import comparitors.SharePriceComparitor;
import generated.Company;
import generated.CompanyList;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javafx.util.Pair;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.lang.Exception;

import org.json.*;

/**
 *
 * @author Ben
 */
@WebService(serviceName = "StockBrokeringWebService")
@Stateless()
public class StockBrokeringWebService {

    private String allCompaniesFile = "company_data.xml";

    private String access_key = "e9b83f867fd578d5c5379ef351781eaf";

    private String baseCurrencyRate = "EUR";

    public List<Pair<String, String>> getCompanyNamesAndSymbols() throws IOException {
        List<Pair<String, String>> namesAndSymbols = new ArrayList<>();
        
        //Fetches list of companies from market stack
        String response = makeRequest("http://api.marketstack.com/v1/tickers?access_key=" + access_key, "GET");

        JSONObject obj = new JSONObject(response);
        
        //Gets array of companies from json response
        JSONArray companies = obj.getJSONArray("data");
        
        //Retrieves names and symbols from json array
        for (int i = 0; i < companies.length(); i++) {
            String symbol = ((JSONObject) companies.get(i)).get("symbol").toString();
            String name = ((JSONObject) companies.get(i)).get("name").toString();

            namesAndSymbols.add(new Pair<>(symbol, name));
        }

        return namesAndSymbols;
    }

    public List<Company> genorateRandomCompanyData() throws DatatypeConfigurationException, IOException {
        List<Company> allCompanies = new ArrayList<>();
        List<Pair<String, String>> symbolsAndNames;

        symbolsAndNames = getCompanyNamesAndSymbols();
        
        //Assigns randomly generated numbers for share price and availibilty for each company in the list
        for (Pair<String, String> nameAndSymbol : symbolsAndNames) {
            Company company = new Company();

            company.setCompanySymbol(nameAndSymbol.getKey());
            company.setCompanyName(nameAndSymbol.getValue());

            //Sets date last updated to current date
            XMLGregorianCalendar xmlGregorianCalendar;
            xmlGregorianCalendar = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(LocalDateTime.now().toString());
            company.setLastUpdated(xmlGregorianCalendar);
            
            //Sets shares availibilty
            company.setNumberOfShares(10000);
            
            //Sets randomly generated share price
            Company.SharePrice sharePrice = new Company.SharePrice();
            sharePrice.setCurrency(baseCurrencyRate);
            float min = 10;
            float max = 10000;
            float price = (min + (float) Math.random() * (max - min));
            BigDecimal bd = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
            sharePrice.setValue(bd.floatValue());
            company.setSharePrice(sharePrice);
            
            //adds constructed company to list
            allCompanies.add(company);
        }

        return allCompanies;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCompanyData")
    public java.util.List<Company> getCompanyData(@WebParam(name = "currency") String currency, @WebParam(name = "orderBy") String orderBy, @WebParam(name = "order") String order) throws MarketStackAPIException, OverwriteCompanyDataException, CompanyDataUnmarshellException, CompanyDataGenerationException {
        CompanyList allCompanies = new CompanyList();

        File file = new File(allCompaniesFile);
        
        if (!file.exists()) {
            try {
                //if the xml file does not exist, generate and write new file
                overwriteCompanyData(genorateRandomCompanyData());
            } catch (IOException ex) {
                //thrown if an error occured when fetching the company data from market stack
                throw new MarketStackAPIException();
            } catch (DatatypeConfigurationException ex) {
                //Thrown if error occurs when parsing todays date
                throw new CompanyDataGenerationException(ex.getMessage());
            }
        }
        
        //Load company data from xml file
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(allCompanies.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            allCompanies = (CompanyList) unmarshaller.unmarshal(new java.io.File(allCompaniesFile));

        } catch (JAXBException ex) {
            throw new CompanyDataUnmarshellException(ex.getMessage());
        }

        //Attempts to sort and convert company data
        //If these fucntions fail then they will be informed that these functions are not working 
        //When they initially attempt to change currency / sort criteria
        List<Company> companies = allCompanies.getCompanyList();
        try {
            companies = convertCurrencies(companies, currency);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            companies = orderCompanies(companies, orderBy, order);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return companies;
    }

    private void overwriteCompanyData(List<Company> companies) throws OverwriteCompanyDataException {
        CompanyList allCompanies = new CompanyList();
        
        allCompanies.getCompanyList().addAll(companies);

        //Writes company data to xml file
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(allCompanies.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File file = new File(allCompaniesFile);
            file.setExecutable(true);
            file.setWritable(true);

            marshaller.marshal(allCompanies, file);

        } catch (javax.xml.bind.JAXBException ex) {
            throw new OverwriteCompanyDataException();
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buyShare")
    public Company buyShare(@WebParam(name = "Symbol") String Symbol, @WebParam(name = "NumberOfShares") int numberOfShares) throws CompanyNotFoundException, NotEnoughSharesException, OverwriteCompanyDataException, MarketStackAPIException, CompanyDataUnmarshellException, CompanyDataGenerationException, InvalidNumberOfShares {
        Company company = null;

        java.util.List<Company> Companies = getCompanyData(baseCurrencyRate, "", "");
        
        //Locates company with specified symbol
        for (Company c : Companies) {
            if (c.getCompanySymbol().toLowerCase().equals(Symbol.toLowerCase())) {
                company = c;
                break;
            }
        }
        
        if (company == null) {
            throw new CompanyNotFoundException();
        }
        
        if (company.getNumberOfShares() < numberOfShares)
        {
            throw new NotEnoughSharesException();
        }
        
        if (numberOfShares <= 0)
        {
            throw new InvalidNumberOfShares();
        }
        
        //Updates number of shares availible
        company.setNumberOfShares(company.getNumberOfShares() - numberOfShares);
        overwriteCompanyData(Companies);
        
        return company;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetCompaniesBySymbol")
    public List<Company> GetCompaniesBySymbol(@WebParam(name = "symbol") String symbol, @WebParam(name = "currency") String currency, String orderBy, @WebParam(name = "order") String order) throws MarketStackAPIException, OverwriteCompanyDataException, CompanyDataUnmarshellException, CompanyDataGenerationException {
        java.util.List<Company> allCompanies = getCompanyData(currency, orderBy, order);
        List<Company> filteredCompanies = new ArrayList<>();
        
        
        for (Company company : allCompanies) {
            if (company.getCompanySymbol().toLowerCase().equals(symbol.toLowerCase())) {
                filteredCompanies.add(company);
            }
        }

        return filteredCompanies;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCompaniesByName")
    public List<Company> getCompaniesByName(@WebParam(name = "name") String name, @WebParam(name = "currency") String currency, String orderBy, @WebParam(name = "order") String order) throws MarketStackAPIException, OverwriteCompanyDataException, CompanyDataUnmarshellException, CompanyDataGenerationException {
        java.util.List<Company> allCompanies = getCompanyData(currency, orderBy, order);
        List<Company> filteredCompanies = new ArrayList<>();

        for (Company company : allCompanies) {
            if (company.getCompanyName().toLowerCase().contains(name.toLowerCase())) {
                filteredCompanies.add(company);
            }
        }

        return filteredCompanies;
    }

    private String makeRequest(String uri, String MethodType) {
        return makeRequest(uri, MethodType, "".getBytes());
    }

    private String makeRequest(String uri, String MethodType, byte[] input) {
        URL url = null;
        
        boolean bodyIsEmpty = (input.length == 0);

        try {
            url = new URL(uri);
        } catch (MalformedURLException ex) {
            System.out.println("An error occured " + ex.getMessage());
        }

        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException ex) {
            System.out.println("An error occured " + ex.getMessage());
        }
        try {
            con.setRequestMethod(MethodType);
        } catch (ProtocolException ex) {
            System.out.println("An error occured " + ex.getMessage());
        }

        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        con.setRequestProperty("Accept", "application/json");

        con.setDoOutput(!bodyIsEmpty);

        if (!bodyIsEmpty) {
            try (OutputStream os = con.getOutputStream()) {
                os.write(input, 0, input.length);
            } catch (IOException ex) {
                System.out.println("An error occured " + ex.getMessage());
            }
        }

        String response = "";
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder responseBuilder = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                responseBuilder.append(responseLine.trim());
            }
            response = responseBuilder.toString();
        } catch (IOException ex) {
            System.out.println("An error occured " + ex.getMessage());
        }

        return response;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCurrencies")
    public List<String> getCurrencies() throws CurrencyConversionException {
        //Gets list of currencies in json format
        String response = makeRequest("http://127.0.0.1:5000/currencies", "GET");
        
        //Parses json and returns list java list of currencies
        try {
            JSONObject obj = new JSONObject(response);
            JSONArray arr = obj.getJSONArray("all_currencies");

            List currencies = arr.toList();

            return currencies;
        } catch (Exception ex) {
            throw new CurrencyConversionException(ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "convertCurrencies")
    public List<Company> convertCurrencies(@WebParam(name = "companies") List<Company> companies, @WebParam(name = "currencyType") String currencyType) throws CurrencyConversionException {
        //If currency string is empty, return unconverted list of currencies
        if (currencyType.length() == 0) {
            return companies;
        }

        //Construct JSON body for request
        JSONArray arr = new JSONArray();

        for (Company company : companies) {
            //Only adds currencies that need converting to the JSON body
            if (!company.getSharePrice().getCurrency().equals(currencyType)) {
                JSONObject obj = new JSONObject();

                obj.put("from", company.getSharePrice().getCurrency());
                obj.put("to", currencyType);
                obj.put("value", company.getSharePrice().getValue());

                arr.put(obj);
            }
        }

        //skips the request if no companies need converting
        if (!arr.isEmpty()) {
            String response = "";

            try {
                response = makeRequest(
                        "http://127.0.0.1:5000/convert", "POST",
                        arr.toString().getBytes("utf-8"));
            } catch (UnsupportedEncodingException ex) {
                //This shouldn't ever be thrown as encoding standard is hard coded
            }
            
            //Parses json response and updates curreny values
            try {
                JSONObject responseObj = new JSONObject(response);
                JSONArray responseArray = responseObj.getJSONArray("values");

                for (int i = 0; i < responseArray.length(); i++) {
                    Company company = companies.get(i);
                    Company.SharePrice newSharePrice = new Company.SharePrice();

                    newSharePrice.setCurrency(currencyType);
                    newSharePrice.setValue(responseArray.getBigDecimal(i).floatValue());
                    company.setSharePrice(newSharePrice);

                    companies.set(i, company);
                }
            } catch (org.json.JSONException ex) {
                throw new CurrencyConversionException(ex.getMessage());
            }
        }

        return companies;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "orderCompanies")
    public List<Company> orderCompanies(@WebParam(name = "companies") List<Company> companies, @WebParam(name = "orderBy") String orderBy, @WebParam(name = "order") String order) throws NotSortableFieldException, InvalidOrderException {
        List<Company> orderedCompanies = new ArrayList<>();

        //https://www.codebyamir.com/blog/sort-list-of-objects-by-field-java
        //Sorts list based on orderBy paramater
        switch (orderBy.toLowerCase()) {
            case "name":
                orderedCompanies = companies.stream()
                        .sorted(Comparator.comparing(Company::getCompanyName, String.CASE_INSENSITIVE_ORDER))
                        .collect(Collectors.toList());
                break;

            case "symbol":
                orderedCompanies = companies.stream()
                        .sorted(Comparator.comparing(Company::getCompanySymbol, String.CASE_INSENSITIVE_ORDER))
                        .collect(Collectors.toList());
                break;

            case "price":
                orderedCompanies = companies;
                Collections.sort(orderedCompanies, new SharePriceComparitor());
                break;

            case "shares_availible":
                orderedCompanies = companies.stream()
                        .sorted(Comparator.comparing(Company::getNumberOfShares))
                        .collect(Collectors.toList());
                break;

            default:
                throw new NotSortableFieldException(orderBy);
        }
        
        //Reverses list if in decending order
        if (order.toLowerCase().equals("desc")) {
            Collections.reverse(orderedCompanies);
        } else if (!order.toLowerCase().equals("asc")) {
            //Throws exception if order code is invalid
            throw new InvalidOrderException(order);
        }

        return orderedCompanies;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "filterByPrice")
    public List<Company> filterByPrice(@WebParam(name = "value") float value, @WebParam(name = "operator") String operator, @WebParam(name = "currency") String currency, @WebParam(name = "orderBy") String orderBy, @WebParam(name = "order") String order) throws MarketStackAPIException, OverwriteCompanyDataException, CompanyDataUnmarshellException, CompanyDataGenerationException, InvalidOperatorException {
        List<Company> allCompanies = getCompanyData(currency, orderBy, order);
        List<Company> filteredCompanies = new ArrayList<>();

        for (Company company : allCompanies) {
            if (compare(company.getSharePrice().getValue(), value, operator)) {
                filteredCompanies.add(company);
            }
        }

        return filteredCompanies;
    }

    private static boolean compare(float x, float y, String operator) throws InvalidOperatorException {
        
        switch (operator.toLowerCase())
        {
            case "less":
                return (x < y);
            
            case "greater":
                return (x > y);
                
            case "equal":
                return (x == y);
                
            default:
                throw new InvalidOperatorException(operator);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "filterByAvailibleShares")
    public List<Company> filterByAvailibleShares(@WebParam(name = "value") float value, @WebParam(name = "operator") String operator, @WebParam(name = "currency") String currency, @WebParam(name = "orderBy") String orderBy, @WebParam(name = "order") String order) throws MarketStackAPIException, OverwriteCompanyDataException, CompanyDataUnmarshellException, CompanyDataGenerationException, InvalidOperatorException {
        List<Company> allCompanies = getCompanyData(currency, orderBy, order);
        List<Company> filteredCompanies = new ArrayList<>();

        for (Company company : allCompanies) {
            if (compare(company.getNumberOfShares(), value, operator)) {
                filteredCompanies.add(company);
            }
        }

        return filteredCompanies;
    }

}
