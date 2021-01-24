
package com.mycompany.stockbrokerclientapplication;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "Exception", targetNamespace = "http://StockBrokeringWebService/")
public class Exception_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private com.mycompany.stockbrokerclientapplication.Exception faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public Exception_Exception(String message, com.mycompany.stockbrokerclientapplication.Exception faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public Exception_Exception(String message, com.mycompany.stockbrokerclientapplication.Exception faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.mycompany.stockbrokerclientapplication.Exception
     */
    public com.mycompany.stockbrokerclientapplication.Exception getFaultInfo() {
        return faultInfo;
    }

}
