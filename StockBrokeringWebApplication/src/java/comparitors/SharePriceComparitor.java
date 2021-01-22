/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparitors;

import generated.Company;
import java.util.Comparator;

/**
 *
 * @author Ben
 */
public class SharePriceComparitor implements Comparator<Company> {

    @Override
    public int compare(Company o1, Company o2) {
        return Float.compare(o1.getSharePrice().getValue(), o2.getSharePrice().getValue());
    }
    
}
