package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class StudentView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaSV;
	private JTextField txtLop;
	private JTextField txtHoTen;
	private JTextField txtNganh;
	private JTextField txtNgaySinh;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtPhone;

	
	public StudentView(String studentId, String fullName, String birthDate, String className, String major, String address, String email, String phoneNumber) {		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        setVisible(false); 
		    }
		});
		
		setTitle("Thông tin sinh viên: " + fullName);
		setBounds(100, 100, 1000, 470);
		setResizable(false);

        int width = getBounds().width; 
        int height = getBounds().height;; 
        setSize(width, height);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Đặt vị trí của cửa sổ ứng dụng ở giữa màn hình
        int x = (screenWidth - width) / 2;
        int y = (screenHeight - height) / 2;
        setLocation(x, y);
        
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout cho contentPane
		setContentPane(contentPane);
		
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0}; 
		gbl_contentPane.rowHeights = new int[]{348, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE}; 
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		
		JPanel content = new JPanel();
		content.setBackground(new Color(241, 248, 232));
		
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.insets = new Insets(10, 10, 10, 10);
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.gridx = 0; // Đặt tại cột 0
		gbc_content.gridy = 0;
		contentPane.add(content, gbc_content);

		
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[]{0, 171, 0, 228, 0};
		gbl_content.rowHeights = new int[]{0, 0, 0, 41, 0, 0, 0};
		gbl_content.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_content.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		content.setLayout(gbl_content);
		
		
		
		JLabel lblMaSV = new JLabel("Mã SV:");
		lblMaSV.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblMaSV = new GridBagConstraints();
		gbc_lblMaSV.anchor = GridBagConstraints.WEST;
		gbc_lblMaSV.insets = new Insets(10, 10, 10, 10);
		gbc_lblMaSV.gridx = 0;
		gbc_lblMaSV.gridy = 0;
		content.add(lblMaSV, gbc_lblMaSV);
		
		txtMaSV = new JTextField();
		txtMaSV.setBackground(new Color(241, 248, 232));
		txtMaSV.setBorder(null);
		txtMaSV.setText("Xin chào");
		txtMaSV.setEditable(false);
		txtMaSV.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtMaSV = new GridBagConstraints();
		gbc_txtMaSV.anchor = GridBagConstraints.WEST;
		gbc_txtMaSV.insets = new Insets(10, 10, 10, 10);
		gbc_txtMaSV.gridx = 1;
		gbc_txtMaSV.gridy = 0;
		content.add(txtMaSV, gbc_txtMaSV);
		txtMaSV.setColumns(10);
		
		JLabel lblLop = new JLabel("Lớp:");
		lblLop.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblLop = new GridBagConstraints();
		gbc_lblLop.anchor = GridBagConstraints.WEST;
		gbc_lblLop.insets = new Insets(10, 10, 10, 10);
		gbc_lblLop.gridx = 2;
		gbc_lblLop.gridy = 0;
		content.add(lblLop, gbc_lblLop);
		
		txtLop = new JTextField();
		txtLop.setBackground(new Color(241, 248, 232));
		txtLop.setText("Xin chào");
		txtLop.setBorder(null);
		txtLop.setEditable(false);
		txtLop.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtLop = new GridBagConstraints();
		gbc_txtLop.insets = new Insets(10, 10, 10, 10);
		gbc_txtLop.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLop.gridx = 3;
		gbc_txtLop.gridy = 0;
		content.add(txtLop, gbc_txtLop);
		txtLop.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ Tên:");
		lblHoTen.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblHoTen = new GridBagConstraints();
		gbc_lblHoTen.anchor = GridBagConstraints.WEST;
		gbc_lblHoTen.insets = new Insets(10, 10, 10, 10);
		gbc_lblHoTen.gridx = 0;
		gbc_lblHoTen.gridy = 1;
		content.add(lblHoTen, gbc_lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setBackground(new Color(241, 248, 232));
		txtHoTen.setText("Xin chào");
		txtHoTen.setBorder(null);
		txtHoTen.setEditable(false);
		txtHoTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtHoTen.setColumns(10);
		GridBagConstraints gbc_txtHoTen = new GridBagConstraints();
		gbc_txtHoTen.insets = new Insets(10, 10, 10, 10);
		gbc_txtHoTen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoTen.gridx = 1;
		gbc_txtHoTen.gridy = 1;
		content.add(txtHoTen, gbc_txtHoTen);
		
		JLabel lblNganh = new JLabel("Ngành:");
		lblNganh.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblNganh = new GridBagConstraints();
		gbc_lblNganh.anchor = GridBagConstraints.WEST;
		gbc_lblNganh.insets = new Insets(10, 10, 10, 10);
		gbc_lblNganh.gridx = 2;
		gbc_lblNganh.gridy = 1;
		content.add(lblNganh, gbc_lblNganh);
		
		txtNganh = new JTextField();
		txtNganh.setBackground(new Color(241, 248, 232));
		txtNganh.setText("Xin chào");
		txtNganh.setBorder(null);
		txtNganh.setEditable(false);
		txtNganh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtNganh.setColumns(10);
		GridBagConstraints gbc_txtNganh = new GridBagConstraints();
		gbc_txtNganh.insets = new Insets(10, 10, 10, 10);
		gbc_txtNganh.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNganh.gridx = 3;
		gbc_txtNganh.gridy = 1;
		content.add(txtNganh, gbc_txtNganh);
		
		JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblNgaySinh = new GridBagConstraints();
		gbc_lblNgaySinh.anchor = GridBagConstraints.WEST;
		gbc_lblNgaySinh.insets = new Insets(10, 10, 10, 10);
		gbc_lblNgaySinh.gridx = 0;
		gbc_lblNgaySinh.gridy = 2;
		content.add(lblNgaySinh, gbc_lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setBackground(new Color(241, 248, 232));
		txtNgaySinh.setText("Xin chào");
		txtNgaySinh.setBorder(null);
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtNgaySinh.setColumns(10);
		GridBagConstraints gbc_txtNgaySinh = new GridBagConstraints();
		gbc_txtNgaySinh.insets = new Insets(10, 10, 10, 10);
		gbc_txtNgaySinh.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNgaySinh.gridx = 1;
		gbc_txtNgaySinh.gridy = 2;
		content.add(txtNgaySinh, gbc_txtNgaySinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblDiaChi = new GridBagConstraints();
		gbc_lblDiaChi.anchor = GridBagConstraints.WEST;
		gbc_lblDiaChi.insets = new Insets(10, 10, 10, 10);
		gbc_lblDiaChi.gridx = 2;
		gbc_lblDiaChi.gridy = 2;
		content.add(lblDiaChi, gbc_lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBackground(new Color(241, 248, 232));
		txtDiaChi.setText("Xin chào");
		txtDiaChi.setBorder(null);
		txtDiaChi.setEditable(false);
		txtDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtDiaChi.setColumns(10);
		GridBagConstraints gbc_txtDiaChi = new GridBagConstraints();
		gbc_txtDiaChi.insets = new Insets(10, 10, 10, 10);
		gbc_txtDiaChi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiaChi.gridx = 3;
		gbc_txtDiaChi.gridy = 2;
		content.add(txtDiaChi, gbc_txtDiaChi);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;  // Căn trái
		gbc_lblEmail.insets = new Insets(10, 10, 10, 10);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		content.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setText("Xin chào");
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(241, 248, 232));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 3;
		content.add(txtEmail, gbc_txtEmail);
		
		JLabel lblPhone = new JLabel("Số điện thoại:");  
		lblPhone.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;  
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 2;
		gbc_lblPhone.gridy = 3;
		content.add(lblPhone, gbc_lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setText("Xin chào");
		txtPhone.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtPhone.setEditable(false);
		txtPhone.setColumns(10);
		txtPhone.setBorder(null);
		txtPhone.setBackground(new Color(241, 248, 232));
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.insets = new Insets(0, 0, 5, 0);
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.gridx = 3;
		gbc_txtPhone.gridy = 3;
		content.add(txtPhone, gbc_txtPhone);
		setStudentDetails();
	}
	
	public void setStudentDetails() {
	    
	}
	
//	public void reloadBookDetails() {
//		txtId.setText(String.valueOf(newBook.getBook_id()));
//	    txtName.setText(newBook.getBook_name());
//	    txtAuthor.setText(newBook.getBook_author());
//	    txtCategories.setText(newBook.getBook_category());
//	    txtPrice.setText(String.valueOf(newBook.getBook_price()));
//	    txtTotal.setText(String.valueOf(newBook.getBook_total()));
//	    txtMoTa.setText(String.valueOf(newBook.getBook_description())); 
//	    
//	 // Giải mã chuỗi Base64 và hiển thị ảnh mới
//        String imageBase64 = newBook.getBook_image_path();
//        if (imageBase64 != null && !imageBase64.isEmpty()) {
//            try {
//                byte[] imageBytes = Base64.getDecoder().decode(imageBase64);
//                BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
//                if (img != null) {
//                    Image scaledImg = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
//                    ImageIcon icon = new ImageIcon(scaledImg);
//                    lblImage.setIcon(icon);
//                } else {
//                    lblImage.setIcon(null);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                lblImage.setIcon(null);
//            }
//        } else {
//            lblImage.setIcon(null);
//        }
//	}
	
}
