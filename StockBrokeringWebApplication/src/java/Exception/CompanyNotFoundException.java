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
public class CompanyNotFoundException extends Exception {
    public CompanyNotFoundException()
    {
        super("Company specified was not found");
    }
}
