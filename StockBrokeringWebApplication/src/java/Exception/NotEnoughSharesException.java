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
public class NotEnoughSharesException extends Exception {
    public NotEnoughSharesException()
    {
        super("You are attempting to buy more shares than there are availible for this company");
    }
}
