package entity;

import constant.Constant;

public class Admin {
    private String bankName;
    private int adminId;
    private String username;
    private String password;

    public Admin(String bankName,int adminId, String username, String password) {
        this.bankName = bankName;
        this.adminId = adminId;
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getBankName() {
        return bankName;
    }

    public int getAdminId() {
        return adminId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Convert Admin object to CSV format string
    public String toCsv() {
        return bankName + Constant.DELIMITER +  adminId + Constant.DELIMITER + username + Constant.DELIMITER + password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                '}';
    }
}
