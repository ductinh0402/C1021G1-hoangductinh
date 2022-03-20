package model.person;

public class Customer {
    private int idCustomer;
    private String nameCustomer;
    private String customerCode;
    private String birthday;
    private boolean gender;
    private String idCard;
    private String phone;
    private String email;
    private String address;
    private int idCustomerType;
    private String nameCustomerType;

    public Customer(int idCustomer, String nameCustomer, String customerCode, String birthday, boolean gender, String idCard, String phone, String email, String address, int idCustomerType, String nameCustomerType) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.customerCode = customerCode;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.idCustomerType = idCustomerType;
        this.nameCustomerType = nameCustomerType;
    }

    public Customer(String nameCustomer, String customerCode, String birthday, boolean gender, String idCard, String phone, String email, String address, int idCustomerType) {
        this.nameCustomer = nameCustomer;
        this.customerCode = customerCode;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.idCustomerType = idCustomerType;

    }

    public Customer(int idCustomer, String nameCustomer, String customerCode, String birthday, boolean gender, String idCard, String phone, String email, String address, int idCustomerType) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.customerCode = customerCode;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.idCustomerType = idCustomerType;
    }

    public Customer() {
    }


    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(int idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }
}
