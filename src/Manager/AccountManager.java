package Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Base64;

import Models.Account;

public class AccountManager {
	
	private static final String FILE_PATH = "src/Bin/Account.bin";
	
	public static void main(String[] args) {
		AccountManager accountManager = new AccountManager();
		
		accountManager.createAccounts("admin", "123");
		accountManager.createAccounts("hieu", "123");
		accountManager.createAccounts("son", "123");
		accountManager.createAccounts("linh", "123");
		accountManager.createAccounts("quyen", "123");
		accountManager.createAccounts("tuananh", "123");
		
	}

    // Tạo tài khoản mới và lưu vào file
    public void createAccounts(String userName, String passWord) {
        Account newAcc = new Account(userName, passWord);
        saveAccountToFile(newAcc);
    }

    // Lưu tài khoản vào file
    private void saveAccountToFile(Account account) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true));
            bw.write(account.toString());
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Đọc tài khoản từ file
    public ArrayList<Account> getAccountsFromFile() {
        ArrayList<Account> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String userName = data[0].trim();
                    String hashedPassword = data[1].trim();
                    byte[] salt = Base64.getDecoder().decode(data[2].trim());
                    Account account = new Account(userName, hashedPassword, salt);
                    list.add(account);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Kiểm tra tài khoản đăng nhập
    public boolean validateLogin(String userName, String passWord) {
        ArrayList<Account> list = this.getAccountsFromFile();
        for (Account ac : list) {
            if (ac.getUserName().equals(userName) && ac.verifyPassword(passWord)) {
                return true;
            }
        }
        return false;
    }

    // Kiểm tra xem tài khoản đã được đăng ký hay chưa
    public boolean isAccountRegistered(String userName) {
        ArrayList<Account> list = this.getAccountsFromFile();
        for (Account ac : list) {
            if (ac.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

}
