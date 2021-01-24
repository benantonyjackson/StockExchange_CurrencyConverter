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
public class InvalidOperatorException extends Exception {
    public InvalidOperatorException(String operator)
    {
        super(" This method only accepts greater, less and equal as operators. " + operator + " is invalid");
    }
}
