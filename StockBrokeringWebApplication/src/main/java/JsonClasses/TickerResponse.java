/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Ben
 */
public class TickerResponse {
    public Ticker[] data; 
    
    public TickerResponse(@JsonProperty("data") Ticker[] data)
    {
        this.data = data;
    }
    
    
    
}
