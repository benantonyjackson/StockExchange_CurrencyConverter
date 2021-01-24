/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Ben
 */
public class MarketStackAPIException extends Exception {
    public MarketStackAPIException()
    {
        super("An error occured while trying to fetch data from marketstack.com");
    }
}
