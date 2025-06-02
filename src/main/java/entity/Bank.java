package entity;

import constant.Constant;

public class Bank {
    private int code;
    private String address;
    private String name;

    public Bank(int code, String address, String name) {
        this.code = code;
        this.address = address;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toCsv() {
        return code + Constant.DELIMETER + address + Constant.DELIMETER + name;
    }

    // Readable string format
    @Override
    public String toString() {
        return "Bank{" +
                "code=" + code +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
