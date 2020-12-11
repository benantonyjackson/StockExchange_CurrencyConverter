/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stockbrokeringwebapplication;

import java.util.Vector;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Ben
 */
@WebService(serviceName = "StockBrokeringWebService")
@Stateless()
public class StockBrokeringWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !!!";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllSymbols")
    public Vector getAllSymbols(@WebParam(name = "Limit") int Limit) {
        //http://api.marketstack.com/v1/tickers?access_key=e9b83f867fd578d5c5379ef351781eaf
        
        Vector<String> symbols = new Vector<String>();
        
        symbols.add("AAPL");
        symbols.add("MSFT");
        symbols.add("AMZN");
        symbols.add("GOOG");
        symbols.add("GOOGL");
        symbols.add("FB");
        symbols.add("VOD");
        
        return symbols;
    }
}
