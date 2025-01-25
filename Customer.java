public class Customer {
    private String name;
    private String address;
    private String gasCompanyName;
    private String phoneNumber;

    public Customer(String name, String address, String gasCompanyName, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.gasCompanyName = gasCompanyName;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGasCompanyName() {
        return gasCompanyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
