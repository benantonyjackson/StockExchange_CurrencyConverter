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
public class NotSortableFieldException extends Exception {
    public NotSortableFieldException(String fieldName)
    {
        super("Results cannot be filtered by field " + fieldName);
    }
}
