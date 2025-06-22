package entity;

import constant.Constant;

public class ATM {
    private int atmId;
    private String location;
    private int bankCode;

    public ATM(int atmId, String location, int bankCode) {
        this.atmId = atmId;
        this.location = location;
        this.bankCode = bankCode;
    }

    public int getAtmId() {
        return atmId;
    }
    public int getAtmId() {
        return atmId;
    }

    public void setAtmId(int atmId) {
        this.atmId = atmId;
    }

    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public String toCsv() {
        return atmId + Constant.DELIMITER + location + Constant.DELIMITER + bankCode;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "atmId=" + atmId +
                ", location='" + location + '\'' +
                ", bankCode=" + bankCode +
                '}';
    }
}
