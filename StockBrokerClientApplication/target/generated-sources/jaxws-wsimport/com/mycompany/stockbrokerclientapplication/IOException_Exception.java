
package com.mycompany.stockbrokerclientapplication;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "IOException", targetNamespace = "http://StockBrokeringWebService/")
public class IOException_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private IOException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public IOException_Exception(String message, IOException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public IOException_Exception(String message, IOException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.mycompany.stockbrokerclientapplication.IOException
     */
    public IOException getFaultInfo() {
        return faultInfo;
    }

}
