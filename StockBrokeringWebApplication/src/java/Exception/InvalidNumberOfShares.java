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
public class InvalidNumberOfShares extends Exception {
    public InvalidNumberOfShares()
    {
        super("Number of shares purchased must be greater than 1");
    }
}
