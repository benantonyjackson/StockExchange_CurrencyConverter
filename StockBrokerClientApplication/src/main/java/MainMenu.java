
import java.util.List;

import com.mycompany.stockbrokerclientapplication.StockBrokeringWebService_Service;
import com.mycompany.stockbrokerclientapplication.StockBrokeringWebService;
import com.mycompany.stockbrokerclientapplication.Company;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ben
 */

public class MainMenu extends javax.swing.JFrame {
    
    private List listOfCompanies = null; 
    public String orderBy = "symbol";
    public String order = "ASC";
    public String currency = "";

    
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        
        scrlPnCompanyView.getVerticalScrollBar().setUnitIncrement(20);
        
        //Used to determin which operator to use when filtering by a numberical value
        btnPriceGreaterThan.setActionCommand("greater");
        btnPriceLessThan.setActionCommand("less");
        btnPriceEqualTo.setActionCommand("equal");
        
        btnShareGreaterThan.setActionCommand("greater");
        btnShareLessThan.setActionCommand("less");
        btnShareEqualTo.setActionCommand("equal");
        
        //Loads list of currencies 
        try { 
            StockBrokeringWebService_Service service = new StockBrokeringWebService_Service();
            StockBrokeringWebService port = service.getStockBrokeringWebServicePort();
            
            List<String> result = port.getCurrencies();
            
            //Populates combo box with the list of currency codes
            for (String i: result)
            {
                cmbCurrency.addItem(i);
            }
            
            //Sets defualt select currency
            cmbCurrency.setSelectedItem("EUR");
            currency = "EUR";
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occured when attempting to fetch the list of currencies \n"
            + "For this session, currecny conversion will not be availible\n\n", "An error occured", JOptionPane.ERROR_MESSAGE);
        }

        //Loads and displays company data
        populateCompayView(getCompanyData(currency, orderBy, order));
    }
    
    private List<Company> getCompanyData(String currency, String orderBy, String order) {
        try {
            StockBrokeringWebService_Service service = new StockBrokeringWebService_Service();
            StockBrokeringWebService port = service.getStockBrokeringWebServicePort();

            return port.getCompanyData(currency, orderBy, order);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sorry, an error occured when"
                    + " trying to connect to the web service\n\n"
                    + "Full error message: " + ex.getMessage(), "An error occured", JOptionPane.ERROR_MESSAGE);

            //Returns current list of loaded companies if new list cannot be loaded
            return listOfCompanies;
        }
    }
    
    private void populateCompayView(List<Company> companies)
    {
        //Updates list of displayed companies
        listOfCompanies = companies;
        
        //Sets up components for scroll panel
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.PAGE_AXIS));
        jp.setMaximumSize(scrlPnCompanyView.getSize());
        
        //Adds list of loaded companies to the window
        for (Company c: companies)
        {
            CompanyView cv = new CompanyView();
            
            cv.updateView(c);
            
            jp.add(cv);
        }
        
        scrlPnCompanyView.setViewportView(jp);
        
        //Updates number of results
        lblNumberOfResult.setText("Results: " + companies.size());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderButtonGroup = new javax.swing.ButtonGroup();
        filterPriceButtonGroup = new javax.swing.ButtonGroup();
        fitlerSharesButtonGroup = new javax.swing.ButtonGroup();
        scrlPnCompanyView = new javax.swing.JScrollPane();
        lblNumberOfResult = new javax.swing.JLabel();
        txtFilterBySymbol = new javax.swing.JTextField();
        btnFilterBySymbol = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtFilterByName = new javax.swing.JTextField();
        btnFilterByName = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbCurrency = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnConvert = new javax.swing.JButton();
        btnSymbolAsc = new javax.swing.JRadioButton();
        btnSymbolDesc = new javax.swing.JRadioButton();
        btnNameDesc = new javax.swing.JRadioButton();
        btnNameAsc = new javax.swing.JRadioButton();
        btnPriceDesc = new javax.swing.JRadioButton();
        btnPriceAsc = new javax.swing.JRadioButton();
        txtFilterByPrice = new javax.swing.JTextField();
        btnFilterByPrice = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnPriceGreaterThan = new javax.swing.JRadioButton();
        btnPriceLessThan = new javax.swing.JRadioButton();
        btnPriceEqualTo = new javax.swing.JRadioButton();
        btnShareGreaterThan = new javax.swing.JRadioButton();
        btnShareLessThan = new javax.swing.JRadioButton();
        btnShareEqualTo = new javax.swing.JRadioButton();
        btnSharesDesc = new javax.swing.JRadioButton();
        btnSharesAsc = new javax.swing.JRadioButton();
        txtFilterByShares = new javax.swing.JTextField();
        btnFilterByShares = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrlPnCompanyView.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblNumberOfResult.setText("Results: 0");

        btnFilterBySymbol.setText("Search");
        btnFilterBySymbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterBySymbolActionPerformed(evt);
            }
        });

        jLabel1.setText("Filter by symbol");

        btnFilterByName.setText("Search");
        btnFilterByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterByNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Filter by name");
        jLabel2.setToolTipText("");

        cmbCurrency.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCurrencyItemStateChanged(evt);
            }
        });

        jLabel3.setText("Currency");

        btnConvert.setText("Convert");
        btnConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertActionPerformed(evt);
            }
        });

        orderButtonGroup.add(btnSymbolAsc);
        btnSymbolAsc.setText("Accending");
        btnSymbolAsc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnSymbolAscItemStateChanged(evt);
            }
        });

        orderButtonGroup.add(btnSymbolDesc);
        btnSymbolDesc.setText("Descending");
        btnSymbolDesc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnSymbolDescItemStateChanged(evt);
            }
        });

        orderButtonGroup.add(btnNameDesc);
        btnNameDesc.setText("Descending");
        btnNameDesc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnNameDescItemStateChanged(evt);
            }
        });

        orderButtonGroup.add(btnNameAsc);
        btnNameAsc.setText("Accending");
        btnNameAsc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnNameAscItemStateChanged(evt);
            }
        });

        orderButtonGroup.add(btnPriceDesc);
        btnPriceDesc.setText("Descending");
        btnPriceDesc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnPriceDescItemStateChanged(evt);
            }
        });

        orderButtonGroup.add(btnPriceAsc);
        btnPriceAsc.setText("Accending");
        btnPriceAsc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnPriceAscItemStateChanged(evt);
            }
        });

        btnFilterByPrice.setText("Search");
        btnFilterByPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterByPriceActionPerformed(evt);
            }
        });

        jLabel4.setText("Filter by price");
        jLabel4.setToolTipText("");

        filterPriceButtonGroup.add(btnPriceGreaterThan);
        btnPriceGreaterThan.setText("Greater Than");

        filterPriceButtonGroup.add(btnPriceLessThan);
        btnPriceLessThan.setText("Less Than");

        filterPriceButtonGroup.add(btnPriceEqualTo);
        btnPriceEqualTo.setText("Equal to");

        fitlerSharesButtonGroup.add(btnShareGreaterThan);
        btnShareGreaterThan.setText("Greater Than");

        fitlerSharesButtonGroup.add(btnShareLessThan);
        btnShareLessThan.setText("Less Than");

        fitlerSharesButtonGroup.add(btnShareEqualTo);
        btnShareEqualTo.setText("Equal to");

        orderButtonGroup.add(btnSharesDesc);
        btnSharesDesc.setText("Descending");
        btnSharesDesc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnSharesDescItemStateChanged(evt);
            }
        });

        orderButtonGroup.add(btnSharesAsc);
        btnSharesAsc.setText("Accending");
        btnSharesAsc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btnSharesAscItemStateChanged(evt);
            }
        });

        btnFilterByShares.setText("Search");
        btnFilterByShares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterBySharesActionPerformed(evt);
            }
        });

        jLabel5.setText("Filter By Shares Available");
        jLabel5.setToolTipText("");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(scrlPnCompanyView, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFilterBySymbol, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFilterBySymbol)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSymbolAsc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSymbolDesc))
                            .addComponent(lblNumberOfResult)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFilterByName, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFilterByName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNameAsc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNameDesc))
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btnConvert))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFilterByPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFilterByPrice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPriceAsc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPriceDesc))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPriceGreaterThan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPriceLessThan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPriceEqualTo))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtFilterByShares, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFilterByShares)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSharesAsc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSharesDesc))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnShareGreaterThan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnShareLessThan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnShareEqualTo))
                            .addComponent(btnClear))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrlPnCompanyView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNumberOfResult)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFilterBySymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilterBySymbol)
                    .addComponent(cmbCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSymbolAsc)
                    .addComponent(btnSymbolDesc))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnConvert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNameAsc)
                        .addComponent(btnNameDesc))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFilterByName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFilterByName)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPriceAsc)
                        .addComponent(btnPriceDesc))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFilterByPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFilterByPrice)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPriceGreaterThan)
                    .addComponent(btnPriceLessThan)
                    .addComponent(btnPriceEqualTo))
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSharesAsc)
                        .addComponent(btnSharesDesc))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFilterByShares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnFilterByShares)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShareGreaterThan)
                    .addComponent(btnShareLessThan)
                    .addComponent(btnShareEqualTo))
                .addGap(39, 39, 39)
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterBySymbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterBySymbolActionPerformed
        //Clears other text boxes used for searching
        clearSearchBoxes(txtFilterBySymbol);
        try { 
            StockBrokeringWebService_Service service = new StockBrokeringWebService_Service();
            StockBrokeringWebService port = service.getStockBrokeringWebServicePort();
            
            String symbol = txtFilterBySymbol.getText();
            
            //Loads and displays filterd list
            List<Company> companies = port.getCompaniesBySymbol(symbol, currency, orderBy, order);
            populateCompayView(companies);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occured when trying to fetch stock data.", "An error occured", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFilterBySymbolActionPerformed

    private void btnFilterByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterByNameActionPerformed
        //Clears other text boxes used for searching
        clearSearchBoxes(txtFilterByName);
        try {
            StockBrokeringWebService_Service service = new StockBrokeringWebService_Service();
            StockBrokeringWebService port = service.getStockBrokeringWebServicePort();
            
            java.lang.String name = txtFilterByName.getText();
            
            //Loads and displays filterd list
            java.util.List<Company> companies = port.getCompaniesByName(name, currency, orderBy, order);
            populateCompayView(companies);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occured when trying to fetch stock data.", "An error occured", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnFilterByNameActionPerformed

    private void btnConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertActionPerformed
        //Converts currencies and updates view
        listOfCompanies = convertDisplayedCurrencies(listOfCompanies, currency);
        populateCompayView(listOfCompanies);
    }//GEN-LAST:event_btnConvertActionPerformed

    private void btnSymbolAscItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnSymbolAscItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            orderBy = "symbol";
            order = "ASC";
            
            populateCompayView(orderCompanies(listOfCompanies, orderBy, order));
        }
    }//GEN-LAST:event_btnSymbolAscItemStateChanged

    private void btnSymbolDescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnSymbolDescItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            orderBy = "symbol";
            order = "DESC";
            
            populateCompayView(orderCompanies(listOfCompanies, orderBy, order));
        }
    }//GEN-LAST:event_btnSymbolDescItemStateChanged

    private void btnNameAscItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnNameAscItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            orderBy = "name";
            order = "ASC";
            
            populateCompayView(orderCompanies(listOfCompanies, orderBy, order));
        }
    }//GEN-LAST:event_btnNameAscItemStateChanged

    private void btnNameDescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnNameDescItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            orderBy = "name";
            order = "DESC";
            
            populateCompayView(orderCompanies(listOfCompanies, orderBy, order));
        }
    }//GEN-LAST:event_btnNameDescItemStateChanged

    private void btnPriceDescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnPriceDescItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            orderBy = "price";
            order = "DESC";
            
            populateCompayView(orderCompanies(listOfCompanies, orderBy, order));
        }
    }//GEN-LAST:event_btnPriceDescItemStateChanged

    private void btnPriceAscItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnPriceAscItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            orderBy = "price";
            order = "ASC";
            
            populateCompayView(orderCompanies(listOfCompanies, orderBy, order));
        }
    }//GEN-LAST:event_btnPriceAscItemStateChanged

    private void btnFilterByPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterByPriceActionPerformed
        //Clears other text boxes used for searching
        clearSearchBoxes(txtFilterByPrice);
        try {
            StockBrokeringWebService_Service service = new StockBrokeringWebService_Service();
            StockBrokeringWebService port = service.getStockBrokeringWebServicePort();
            
            float value = Float.valueOf(txtFilterByPrice.getText());
            String operator = filterPriceButtonGroup.getSelection().getActionCommand();
            
            //Loads and displays filterd list
            List<Company> companies = port.filterByPrice(value, operator, currency, orderBy, order);
            populateCompayView(companies);
        } 
        catch (NumberFormatException ex)  {
            //Ensures the user enters numerical data to filter numerical values
            JOptionPane.showMessageDialog(this, "Price filter only accepts numerical values", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        catch (Exception ex) {
           JOptionPane.showMessageDialog(this, "An error occured when trying to fetch stock data.", "An error occured", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnFilterByPriceActionPerformed

    private void cmbCurrencyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCurrencyItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            //Updates currently selected currency
            currency = cmbCurrency.getSelectedItem().toString();
        }
    }//GEN-LAST:event_cmbCurrencyItemStateChanged

    private void btnSharesDescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnSharesDescItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            orderBy = "shares_availible";
            order = "DESC";
            
            populateCompayView(orderCompanies(listOfCompanies, orderBy, order));
        }
    }//GEN-LAST:event_btnSharesDescItemStateChanged

    private void btnSharesAscItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btnSharesAscItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            orderBy = "shares_availible";
            order = "ASC";
            
            populateCompayView(orderCompanies(listOfCompanies, orderBy, order));
        }
    }//GEN-LAST:event_btnSharesAscItemStateChanged

    private void btnFilterBySharesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterBySharesActionPerformed
        //Clears other text boxes used for searching
        clearSearchBoxes(txtFilterByShares);
        try {
            StockBrokeringWebService_Service service = new StockBrokeringWebService_Service();
            StockBrokeringWebService port = service.getStockBrokeringWebServicePort();
            
            float value = Float.valueOf(txtFilterByShares.getText());
            String operator = fitlerSharesButtonGroup.getSelection().getActionCommand();
            
            //Loads and displays filterd list
            List<Company> companies = port.filterByAvailibleShares(value, operator, currency, orderBy, order);
            populateCompayView(companies);
            
        } 
        catch (NumberFormatException ex)  {
            //Ensures the user enters numerical data to filter numerical values
            JOptionPane.showMessageDialog(this, "Price filter only accepts numerical values", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        catch (Exception ex) {
           JOptionPane.showMessageDialog(this, "An error occured when trying to fetch stock data.", "An error occured", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFilterBySharesActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        //Loads unfiltered data
        populateCompayView(getCompanyData(currency, orderBy, order));
        
        //Clears all text boxes used for searching
        clearSearchBoxes(null);
    }//GEN-LAST:event_btnClearActionPerformed
    
    
    List<Company> convertDisplayedCurrencies(List<Company> companies, String currency) {
        try {
            StockBrokeringWebService_Service service = new StockBrokeringWebService_Service();
            StockBrokeringWebService port = service.getStockBrokeringWebServicePort();
            
            //Returns convert currecny values
            return port.convertCurrencies(companies, currency);
        } catch (Exception ex) {
            //If convert currencies cannot be fetched, current list of companies is returned instead
            JOptionPane.showMessageDialog(this, "An error occured when trying to convert currency data", "An error occured", JOptionPane.ERROR_MESSAGE);
            return companies;
        }  
    }
    
    
    List<Company> orderCompanies(List<Company> companies, String orderBy, String order)
    {
        try { 
            StockBrokeringWebService_Service service = new StockBrokeringWebService_Service();
            StockBrokeringWebService port = service.getStockBrokeringWebServicePort();
            
            //Returns sorted list of companies
            return port.orderCompanies(companies, orderBy, order);
        } catch (Exception ex) {
            //If sorted list could not be fetched, the current list is returned
            JOptionPane.showMessageDialog(this, "An error occured when trying to sort companies", "An error occured", JOptionPane.ERROR_MESSAGE);
            return companies;
        }
    }
    
    private void clearSearchBoxes(JTextField exception)
    {
        //Hard coded a list of all text fields used for searching
        List<JTextField> searchBoxes = new ArrayList<JTextField>();
        searchBoxes.add(txtFilterByName);
        searchBoxes.add(txtFilterByPrice);
        searchBoxes.add(txtFilterByShares);
        searchBoxes.add(txtFilterBySymbol);
        
        //Loops through all search boxes and resets them if they are not the specified exception
        for (JTextField box: searchBoxes)
        {
            if (!box.equals(exception))
            {
                box.setText("");
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnConvert;
    private javax.swing.JButton btnFilterByName;
    private javax.swing.JButton btnFilterByPrice;
    private javax.swing.JButton btnFilterByShares;
    private javax.swing.JButton btnFilterBySymbol;
    private javax.swing.JRadioButton btnNameAsc;
    private javax.swing.JRadioButton btnNameDesc;
    private javax.swing.JRadioButton btnPriceAsc;
    private javax.swing.JRadioButton btnPriceDesc;
    private javax.swing.JRadioButton btnPriceEqualTo;
    private javax.swing.JRadioButton btnPriceGreaterThan;
    private javax.swing.JRadioButton btnPriceLessThan;
    private javax.swing.JRadioButton btnShareEqualTo;
    private javax.swing.JRadioButton btnShareGreaterThan;
    private javax.swing.JRadioButton btnShareLessThan;
    private javax.swing.JRadioButton btnSharesAsc;
    private javax.swing.JRadioButton btnSharesDesc;
    private javax.swing.JRadioButton btnSymbolAsc;
    private javax.swing.JRadioButton btnSymbolDesc;
    private javax.swing.JComboBox<String> cmbCurrency;
    private javax.swing.ButtonGroup filterPriceButtonGroup;
    private javax.swing.ButtonGroup fitlerSharesButtonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblNumberOfResult;
    private javax.swing.ButtonGroup orderButtonGroup;
    private javax.swing.JScrollPane scrlPnCompanyView;
    private javax.swing.JTextField txtFilterByName;
    private javax.swing.JTextField txtFilterByPrice;
    private javax.swing.JTextField txtFilterByShares;
    private javax.swing.JTextField txtFilterBySymbol;
    // End of variables declaration//GEN-END:variables


}
