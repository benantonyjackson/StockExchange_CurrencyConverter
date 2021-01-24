
package com.mycompany.stockbrokerclientapplication;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "OverwriteCompanyDataException", targetNamespace = "http://StockBrokeringWebService/")
public class OverwriteCompanyDataException_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private OverwriteCompanyDataException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public OverwriteCompanyDataException_Exception(String message, OverwriteCompanyDataException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public OverwriteCompanyDataException_Exception(String message, OverwriteCompanyDataException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.mycompany.stockbrokerclientapplication.OverwriteCompanyDataException
     */
    public OverwriteCompanyDataException getFaultInfo() {
        return faultInfo;
    }

}
