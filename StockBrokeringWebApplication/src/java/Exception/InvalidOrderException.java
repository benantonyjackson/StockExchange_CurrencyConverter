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
public class InvalidOrderException extends Exception {
    
    public InvalidOrderException(String orderCode)
    {
        super("Results can only be sorted in ASC or DESC order. Order code " + orderCode + " is invalid");
    }
}
