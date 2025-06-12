package manager;

import constant.Constant;
import entity.Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AdminManager {
    private final List<Admin> adminList = new ArrayList<>();
    private final FileManager fileManager = new FileManager();


    public void registerAdmin(Admin admin) {
        adminList.add(admin);
        saveAdminListToFile();
    }

    public void saveAdminListToFile() {
        List<String> datas = new ArrayList<>();
        for (Admin admin : adminList) {
            datas.add(admin.toCsv());
        }
        fileManager.writeFile(Constant.ADMIN_FILE, datas);
    }

    public List<Admin> getAdminListFromFile() {
        List<String> lines = fileManager.readFile(Constant.ADMIN_FILE);
        List<Admin> admins = new ArrayList<>();
        for (String line : lines) {
            String[] data =line.split(Pattern.quote(Constant.DELIMITER));
            Admin admin = new Admin(
                    data[0],
                    Integer.parseInt(data[1]),
                    data[2],
                    data[3]
            );
            admins.add(admin);
        }
        return admins;
    }

    public boolean validateLogin(String adminBankName, String username, String password) {
        List<Admin> admins = getAdminListFromFile();
        for (Admin admin : admins) {
            if (admin.getBankName().equals(adminBankName) && admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
