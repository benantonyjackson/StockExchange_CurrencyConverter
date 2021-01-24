
import com.mycompany.stockbrokerclientapplication.Company;
import com.mycompany.stockbrokerclientapplication.CompanyNotFoundException;
import com.mycompany.stockbrokerclientapplication.CompanyNotFoundException_Exception;
import com.mycompany.stockbrokerclientapplication.InvalidNumberOfShares_Exception;
import com.mycompany.stockbrokerclientapplication.NotEnoughSharesException_Exception;
import com.mycompany.stockbrokerclientapplication.StockBrokeringWebService;
import com.mycompany.stockbrokerclientapplication.StockBrokeringWebService_Service;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */
public class CompanyView extends javax.swing.JPanel {

    /**
     * Creates new form CompanyView
     */
    public CompanyView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSymbol = new javax.swing.JTextField();
        lblSymbol = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lbName = new javax.swing.JLabel();
        txtShares = new javax.swing.JTextField();
        lblShares = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblShareList = new javax.swing.JLabel();
        txtLastUpdated = new javax.swing.JTextField();
        lblLastUpdated = new javax.swing.JLabel();
        txtBuyShares = new javax.swing.JTextField();
        btnBuyShares = new javax.swing.JButton();

        txtSymbol.setToolTipText("");
        txtSymbol.setEnabled(false);

        lblSymbol.setText("Symbol:");

        txtName.setToolTipText("");
        txtName.setEnabled(false);

        lbName.setText("Name:");

        txtShares.setToolTipText("");
        txtShares.setEnabled(false);

        lblShares.setText("Shares availible:");

        txtPrice.setToolTipText("");
        txtPrice.setEnabled(false);

        lblShareList.setText("Share Price:");

        txtLastUpdated.setToolTipText("");
        txtLastUpdated.setEnabled(false);

        lblLastUpdated.setText("Last Updated:");

        txtBuyShares.setText("0");

        btnBuyShares.setText("Buy shares");
        btnBuyShares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuySharesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtLastUpdated, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuyShares, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuyShares, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                    .addComponent(lblLastUpdated)
                    .addComponent(txtSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSymbol)
                    .addComponent(txtShares, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShares)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbName)
                    .addComponent(lblShareList)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSymbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblShares)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtShares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblShareList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLastUpdated)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLastUpdated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuyShares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuyShares))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuySharesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuySharesActionPerformed
        try
        {
            int numOfShares = Integer.valueOf(txtBuyShares.getText().trim());
            buyShares(numOfShares);
        }
        catch (java.lang.NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Please enter a number", "An error occured", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnBuySharesActionPerformed
    
    void buyShares(int numberOfShares)
    {
        
        try {
            StockBrokeringWebService_Service service = new StockBrokeringWebService_Service();
            StockBrokeringWebService port = service.getStockBrokeringWebServicePort();
            
            java.lang.String symbol = txtSymbol.getText();
            
            txtShares.setText("" + port.buyShare(symbol, numberOfShares).getNumberOfShares());
        }
        catch (CompanyNotFoundException_Exception ex)
        {
            JOptionPane.showMessageDialog(this, "Company specified could not be found", "An error occured", JOptionPane.ERROR_MESSAGE);
        }
        catch (NotEnoughSharesException_Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "An error occured", JOptionPane.ERROR_MESSAGE);
        }
        catch (InvalidNumberOfShares_Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "An error occured", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex) {
            
            JOptionPane.showMessageDialog(this, "An error occured while attempting to purchase the share", "An error occured", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void updateView(Company c)
    {
        txtSymbol.setText(c.getCompanySymbol());
        txtName.setText(c.getCompanyName());
        txtPrice.setText("" + c.getSharePrice().getValue() + " " + c.getSharePrice().getCurrency());
        txtShares.setText("" + c.getNumberOfShares());
        txtLastUpdated.setText("" + c.getLastUpdated());
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuyShares;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lblLastUpdated;
    private javax.swing.JLabel lblShareList;
    private javax.swing.JLabel lblShares;
    private javax.swing.JLabel lblSymbol;
    private javax.swing.JTextField txtBuyShares;
    public javax.swing.JTextField txtLastUpdated;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtPrice;
    public javax.swing.JTextField txtShares;
    public javax.swing.JTextField txtSymbol;
    // End of variables declaration//GEN-END:variables
}
