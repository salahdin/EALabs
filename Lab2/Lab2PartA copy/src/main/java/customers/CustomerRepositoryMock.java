package customers;

public class CustomerRepositoryMock implements CustomerRepository {
    @Override
    public void save(Customer customer) {
        System.out.println("Test Saving customer " + customer.getName());
    }
}
