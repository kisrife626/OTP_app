public class Customer {
    private String shopId;
    private String customerId;
    private String Name;
    private String Address;

    Customer(String shopId, String customerId, String Name, String Address) {
        this.shopId = shopId;
        this.customerId = customerId;
        this.Name = Name;
        this.Address = Address;
    }

    public String getShopId() {
        return shopId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }
}
