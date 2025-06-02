package entity;

import constant.Constant;

public class Customer {
    private int customerId;
    private String customerName;
    private String customerPhoneNumber;
    private int customerPassword;
    private String customerUserName;
    private String customerAddress;
    private String customerCard;

    public Customer(int customerId, String customerName, String customerPhoneNumber, int customerPassword, String customerUserName, String customerAddress, String customerCard) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerPassword = customerPassword;
        this.customerUserName = customerUserName;
        this.customerAddress = customerAddress;
        this.customerCard = customerCard;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public int getCustomerPassword() {
        return customerPassword;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerCard() {
        return customerCard;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void setCustomerPassword(int customerPassword) {
        this.customerPassword = customerPassword;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerCard(String customerCard) {
        this.customerCard = customerCard;
    }

    public String toCsv() {
        return customerId + Constant.DELIMETER + customerName + Constant.DELIMETER + customerAddress + Constant.DELIMETER + customerPhoneNumber + Constant.DELIMETER + customerPassword + Constant.DELIMETER + customerUserName + Constant.DELIMETER + customerCard;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", customerPassword=" + customerPassword +
                ", customerUserName='" + customerUserName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerCard='" + customerCard + '\'' +
                '}';
    }
}


