package Models;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Account {
	
	private String userName;
	private byte[] salt;
	
	private String hashedPassword;
	
	public Account() {
		
	}

	public Account(String userName, String hashedPassword) {
		this.userName = userName;
		this.hashedPassword = hashedPassword;
	}
	
	public Account(String userName, String hashedPassword, byte[] salt) {
		this.userName = userName;
		this.hashedPassword = hashedPassword;
		this.salt = salt;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	// Phương thức để set mật khẩu đã hash
    public void setPassword(String password) {
        try {
            this.salt = generateSalt();
            this.hashedPassword = hashPassword(password, this.salt);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace(); // Xử lý ngoại lệ
        }
    }
    
 // Hàm để tạo salt ngẫu nhiên bằng cách sử dụng SecureRandom
    private byte[] generateSalt() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    
 // phương thức để băm mật khẩu sử dụng thuật toán PBKDF2 với HmacSHA256.
    private String hashPassword(String password, byte[] salt)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 10000; // số vòng lặp
        int keyLength = 256; // độ dài của khóa
        char[] passwordChars = password.toCharArray();
        PBEKeySpec spec = new PBEKeySpec(passwordChars, salt, iterations, keyLength);
        //Tạo SecretKeyFactory và băm mật khẩu
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hashedPassword = keyFactory.generateSecret(spec).getEncoded();
        //Mã hóa mảng byte của mật khẩu đã được băm (hashedPassword) sang chuỗi Base64.
        return Base64.getEncoder().encodeToString(hashedPassword);
    }

    // Phương thức để xác minh mật khẩu
    public boolean verifyPassword(String password) {
        try {
            String hashedAttemptedPassword = hashPassword(password, this.salt);
            return this.hashedPassword.equals(hashedAttemptedPassword);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace(); // Xử lý ngoại lệ
            return false;
        }
    }

    // Cập nhật phương thức toString để lưu trữ salt và hashed password
    @Override
    public String toString() {
        return this.userName + "," + this.hashedPassword + "," + Base64.getEncoder().encodeToString(this.salt);
    }
	
	
	
	
	

}
