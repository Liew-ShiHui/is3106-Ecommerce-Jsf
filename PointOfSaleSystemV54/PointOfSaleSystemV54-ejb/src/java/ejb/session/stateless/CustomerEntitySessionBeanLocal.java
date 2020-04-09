package ejb.session.stateless;

import entity.CustomerEntity;
import util.exception.CustomerEmailExistsException;
import util.exception.CustomerNotFoundException;
import util.exception.InputDataValidationException;
import util.exception.InvalidLoginCredentialException;
import util.exception.UnknownPersistenceException;



public interface CustomerEntitySessionBeanLocal
{

    public CustomerEntity registerCustomer(CustomerEntity newCustomer) throws InputDataValidationException, UnknownPersistenceException, CustomerEmailExistsException;

    public CustomerEntity customerLogin(String email, String password) throws InvalidLoginCredentialException;

    public CustomerEntity retrieveCustomerByEmail(String email) throws CustomerNotFoundException;

    public CustomerEntity retrieveCustomerById(Long id) throws CustomerNotFoundException;
    
         
}
