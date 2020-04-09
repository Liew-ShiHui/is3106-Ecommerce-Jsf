/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.managedbean;

import ejb.session.stateless.CustomerEntitySessionBeanLocal;
import entity.CustomerEntity;
import entity.SaleTransactionEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import util.exception.CustomerNotFoundException;

/**
 *
 * @author User
 */
@Named(value = "viewSaleTransactionsManagedBean")
@ViewScoped
public class ViewSaleTransactionsManagedBean implements Serializable {

    @EJB(name = "CustomerEntitySessionBeanLocal")
    private CustomerEntitySessionBeanLocal customerEntitySessionBeanLocal;

    private CustomerEntity currentCustomer;
    private List<SaleTransactionEntity> saleTransactions;

    /**
     * Creates a new instance of ViewSaleTransactionsManagedBean
     */
    public ViewSaleTransactionsManagedBean() {
        System.out.println("********* 1");
        saleTransactions = new ArrayList<>();
        currentCustomer = new CustomerEntity();
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("********* 2");
        currentCustomer = (CustomerEntity)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("currentCustomer");
        System.out.println(">>>>>> Customer name: " + currentCustomer.getFirstName());
        CustomerEntity customer;
        try {
            customer = customerEntitySessionBeanLocal.retrieveCustomerById(currentCustomer.getCustomerId());
            saleTransactions = customer.getSaleTransactionEntities();
        } catch (CustomerNotFoundException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Customer not found" + ex.getMessage(), null));
        }
    }

    /**
     * @return the currentCustomer 
     */
    public CustomerEntity getCurrentCustomer() {
        return currentCustomer;
    }

    /**
     * @param currentCustomer the currentCustomer to set
     */
    public void setCurrentCustomer(CustomerEntity currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    /**
     * @return the saleTransactions
     */
    public List<SaleTransactionEntity> getSaleTransactions() {
        return saleTransactions;
    }

    /**
     * @param saleTransactions the saleTransactions to set
     */
    public void setSaleTransactions(List<SaleTransactionEntity> saleTransactions) {
        this.saleTransactions = saleTransactions;
    }
}
