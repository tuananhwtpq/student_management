package UI;

import Data.GiangVien;
import Data.Student;
import Data.TaiKhoan;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import UI.Login;
import UserUI.UserHome;
import dataManaging.TaiKhoanManaging;
//import UserUI.UserHome;
//import Manager.AccountManager;
//import Manager.UserAccountManager;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserName;
	private JTextField txtPassWord;
	private JTextField txtEmpty;
	private static Map<String, Student> sinhVienMap = new HashMap<>(); // Lưu trữ sinh viên
        private static Map<String, GiangVien> giangVienMap = new HashMap<>(); // Lưu trữ giảng viên
        private static Object userDangNhap = null;  // Lưu thông tin người dùng đang đăng nhập (SinhVien hoặc GiangVien)
        private static String MaSV = null;

    public static String getMaSV() {
        return MaSV;
    }

    public static void setMaSV(String MaSV) {
        Login.MaSV = MaSV;
    }

//	private AccountManager accountManager;
//	private UserAccountManager uam;
//	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
        
	public Login() {
		
		//AccountManager
	//	accountManager = new AccountManager();
		//uam = new UserAccountManager();
		//Commit
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 675);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setForeground(new Color(241, 248, 232));
		contentPane.setBackground(new Color(85, 173, 155));
		contentPane.setBorder(null);

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBackground(new Color(85, 173, 155));
		header.setBounds(133, 115, 291, 64);
		contentPane.add(header);
		header.setLayout(null);
		
		JLabel lblLogin = new JLabel("ĐĂNG NHẬP");
		lblLogin.setBounds(10, 0, 197, 64);
		lblLogin.setForeground(new Color(241, 248, 232));
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblLogin.setBackground(new Color(241, 248, 232));
		header.add(lblLogin);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Login.class.getResource("/Imgs/leaf.png")));
		logo.setBounds(217, 0, 64, 64);
		header.add(logo);
		logo.setIcon(new ImageIcon(Login.class.getResource("/Imgs/leaf.png")));
		
		JPanel passWord = new JPanel();
		passWord.setBackground(new Color(85, 173, 155));
		passWord.setBounds(84, 320, 389, 55);
		contentPane.add(passWord);
		passWord.setLayout(null);
		
		txtPassWord = new JPasswordField();
		txtPassWord.setBounds(42, 0, 347, 55);
		passWord.add(txtPassWord);
		txtPassWord.setText("Nhập mật khẩu");
		txtPassWord.setMargin(new Insets(10, 10, 10, 10));
		txtPassWord.setForeground(new Color(241, 248, 232));
		txtPassWord.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		txtPassWord.setColumns(10);
		txtPassWord.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(241, 248, 232)));
		txtPassWord.setBackground(new Color(85, 173, 155));
		String passwordPlaceHolder = "Nhập mật khẩu";
		txtPassWord.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassWord.getText().equalsIgnoreCase(passwordPlaceHolder)) {
					txtPassWord.setText("");
                }
			}
			@Override
            public void focusLost(FocusEvent e) {
                if (txtPassWord.getText().isEmpty()) {
                	txtPassWord.setText(passwordPlaceHolder);
                }
            }
		});
		txtPassWord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//Nhấn Enter để đăng nhập
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Login.this.handleLogin();
				}
			}
			
		});
		
		JLabel iconPassword = new JLabel("");
		iconPassword.setIcon(new ImageIcon(Login.class.getResource("/Imgs/padlock.png")));
		iconPassword.setBounds(0, 23, 32, 32);
		passWord.add(iconPassword);
//		iconPassword.setIcon(new ImageIcon(Login.class.getResource("/Imgs/padlock.png")));
		
		JPanel userName = new JPanel();
		userName.setLayout(null);
		userName.setBackground(new Color(85, 173, 155));
		userName.setBounds(84, 237, 389, 55);
		contentPane.add(userName);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(42, 0, 347, 55);
		userName.add(txtUserName);
		txtUserName.setForeground(new Color(241, 248, 232));
		txtUserName.setBackground(new Color(85, 173, 155));
		txtUserName.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(241, 248, 232)));
		txtUserName.setMargin(new Insets(10, 10, 10, 10));
		txtUserName.setText("Nhập tài khoản");
		txtUserName.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		txtUserName.setColumns(10);
		String userNamePlaceHolder = "Nhập tài khoản";
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUserName.getText().equalsIgnoreCase(userNamePlaceHolder)) {
					txtUserName.setText("");
                }
			}
			@Override
            public void focusLost(FocusEvent e) {
                if (txtUserName.getText().isEmpty()) {
                	txtUserName.setText(userNamePlaceHolder);
                }
            }
		});
		
		JLabel iconUserName = new JLabel("");
		iconUserName.setIcon(new ImageIcon(Login.class.getResource("/Imgs/user.png")));
		iconUserName.setBounds(0, 23, 32, 32);
		userName.add(iconUserName);
		iconUserName.setIconTextGap(0);
		iconUserName.setIcon(new ImageIcon(Login.class.getResource("/Imgs/user.png")));
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.setIconTextGap(10);
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/Imgs/login.png")));
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setForeground(new Color(85, 173, 155));
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnLogin.setBackground(new Color(241, 248, 232));
		btnLogin.setBounds(84, 437, 389, 55);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleLogin();
			}
		});
		
		txtEmpty = new JTextField();
		txtEmpty.setBounds(10, 25, 0, 20);
		contentPane.add(txtEmpty);
		txtEmpty.setColumns(10);
	}
	
        TaiKhoanManaging tkm = new TaiKhoanManaging();
        ArrayList<TaiKhoan> ds = new ArrayList();
	//Xử lí đăng nhập
	private void handleLogin() {
            this.ds = tkm.selectAll();
            String tk = txtUserName.getText();
            String mk = txtPassWord.getText();
            boolean loginSuccessful = false;
            for(TaiKhoan x:ds){
                if(x.getTk().equalsIgnoreCase(tk) && x.getMk().equals(mk)){
                    if(x.getRole() == 3){
                        userDangNhap = x;
                        JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                        new Home().setVisible(true);
                        dispose();
                        loginSuccessful = true;
                        
                        break;
                    }else if(x.getRole() == 4){
                        userDangNhap = x;
                        MaSV = x.getTk();
                        JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                        new UserHome().setVisible(true);
                        dispose();
                        loginSuccessful = true;
                        break;
                    }
                }
            }
            if(!loginSuccessful){
                JOptionPane.showMessageDialog(this,"Dang nhap that bai");
            }
	}
        //hàm lấy ID của đối tượng SV đang đăng nhập.
        public String getID(){
            return MaSV;
        }
    }

