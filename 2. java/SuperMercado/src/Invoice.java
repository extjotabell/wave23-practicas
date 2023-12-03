import java.util.List;

public class Invoice {
    private Customer customer;
    private List<Product> products;
    private int total;

    public Invoice(Customer customer, List<Product> products, int total) {
        this.customer = customer;
        this.products = products;
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
