
package com.mycompany.stockbrokerclientapplication;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "InvalidOperatorException", targetNamespace = "http://StockBrokeringWebService/")
public class InvalidOperatorException_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private InvalidOperatorException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public InvalidOperatorException_Exception(String message, InvalidOperatorException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public InvalidOperatorException_Exception(String message, InvalidOperatorException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.mycompany.stockbrokerclientapplication.InvalidOperatorException
     */
    public InvalidOperatorException getFaultInfo() {
        return faultInfo;
    }

}