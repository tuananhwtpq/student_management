package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import AccessDatabase.JDBCUtil;

public class AddClassroom extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtGiangVien;
	private JTextField txtTenLop;
	private JTextField txtDiaChi;
	private JTextField txtSiSo;
	private JTextField txtDateBegin;
	private JTextField txtDateEnd;
	private String UIName;
	private String CategoryTitle;

	public AddClassroom() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        setVisible(false); // Thay vì dispose(), ta sẽ chỉ ẩn cửa sổ
		    }
		});
		setBounds(100, 100, 925, 400);
		setResizable(false);
		
		// Thiết lập kích thước của cửa sổ
        int width = getBounds().width; // Chiều rộng
        int height = getBounds().height;; // Chiều cao
        setSize(width, height);
        
        // Lấy kích thước của màn hình
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Đặt vị trí của cửa sổ ứng dụng ở giữa màn hình
        int x = (screenWidth - width) / 2;
        int y = (screenHeight - height) / 2;
        setLocation(x, y);
        
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		header.setBackground(new Color(241, 248, 232));
		header.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(85, 173, 155)));
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Thêm lớp học");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
		header.add(lblTitle);
		
		JPanel content = new JPanel();
		content.setBackground(new Color(241, 248, 232));
		content.setBorder(new EmptyBorder(20, 0, 20, 0));
		contentPane.add(content, BorderLayout.EAST);
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[]{75, 270, 0, 270, 0};
		gbl_content.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_content.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_content.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		content.setLayout(gbl_content);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(10, 10, 10, 10);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		content.add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtId.setColumns(10);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.anchor = GridBagConstraints.WEST;
		gbc_txtId.insets = new Insets(10, 10, 10, 10);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 1;
		content.add(txtId, gbc_txtId);
		
		JLabel lblGiangVien = new JLabel("Giảng viên phụ trách");
		lblGiangVien.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblGiangVien = new GridBagConstraints();
		gbc_lblGiangVien.anchor = GridBagConstraints.WEST;
		gbc_lblGiangVien.insets = new Insets(10, 10, 10, 10);
		gbc_lblGiangVien.gridx = 2;
		gbc_lblGiangVien.gridy = 1;
		content.add(lblGiangVien, gbc_lblGiangVien);
		
		txtGiangVien = new JTextField();
		txtGiangVien.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtGiangVien = new GridBagConstraints();
		gbc_txtGiangVien.insets = new Insets(10, 10, 10, 10);
		gbc_txtGiangVien.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGiangVien.gridx = 3;
		gbc_txtGiangVien.gridy = 1;
		content.add(txtGiangVien, gbc_txtGiangVien);
		txtGiangVien.setColumns(10);
		
		JLabel lblTenLop = new JLabel("Tên lớp");
		lblTenLop.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblTenLop = new GridBagConstraints();
		gbc_lblTenLop.anchor = GridBagConstraints.WEST;
		gbc_lblTenLop.insets = new Insets(10, 10, 10, 10);
		gbc_lblTenLop.gridx = 0;
		gbc_lblTenLop.gridy = 3;
		content.add(lblTenLop, gbc_lblTenLop);
		
		txtTenLop = new JTextField();
		txtTenLop.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtTenLop = new GridBagConstraints();
		gbc_txtTenLop.insets = new Insets(10, 10, 10, 10);
		gbc_txtTenLop.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenLop.weightx = 1.0;
		gbc_txtTenLop.gridx = 1;
		gbc_txtTenLop.gridy = 3;
		content.add(txtTenLop, gbc_txtTenLop);
		txtTenLop.setColumns(10);
		
		JLabel lblSiSo = new JLabel("Sĩ số tối đa");
		lblSiSo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblSiSo = new GridBagConstraints();
		gbc_lblSiSo.anchor = GridBagConstraints.WEST;
		gbc_lblSiSo.insets = new Insets(10, 10, 10, 10);
		gbc_lblSiSo.gridx = 2;
		gbc_lblSiSo.gridy = 3;
		content.add(lblSiSo, gbc_lblSiSo);
		
		txtSiSo = new JTextField();
		
		txtSiSo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtSiSo = new GridBagConstraints();
		gbc_txtSiSo.insets = new Insets(10, 10, 10, 10);
		gbc_txtSiSo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSiSo.gridx = 3;
		gbc_txtSiSo.gridy = 3;
		content.add(txtSiSo, gbc_txtSiSo);
		txtSiSo.setColumns(10);
				
		JLabel lblDateBegin = new JLabel("Thời gian bắt đầu");
		lblDateBegin.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblDateBegin = new GridBagConstraints();
		gbc_lblDateBegin.anchor = GridBagConstraints.WEST;
		gbc_lblDateBegin.insets = new Insets(10, 10, 10, 10);
		gbc_lblDateBegin.gridx = 0;
		gbc_lblDateBegin.gridy = 5;
		content.add(lblDateBegin, gbc_lblDateBegin);
		
		txtDateBegin = new JTextField();
		txtDateBegin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtDateBegin = new GridBagConstraints();
		gbc_txtDateBegin.anchor = GridBagConstraints.WEST;
		gbc_txtDateBegin.insets = new Insets(10, 10, 10, 10);
		gbc_txtDateBegin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateBegin.weightx = 1.0;
		gbc_txtDateBegin.gridx = 1;
		gbc_txtDateBegin.gridy = 5;
		content.add(txtDateBegin, gbc_txtDateBegin);
		txtDateBegin.setColumns(10);
		
		JLabel lblDateEnd = new JLabel("Thời gian kết thúc");
		lblDateEnd.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblDateEnd = new GridBagConstraints();
		gbc_lblDateEnd.anchor = GridBagConstraints.WEST;
		gbc_lblDateEnd.insets = new Insets(10, 10, 10, 10);
		gbc_lblDateEnd.gridx = 2;
		gbc_lblDateEnd.gridy = 5;
		content.add(lblDateEnd, gbc_lblDateEnd);
		
		txtDateEnd = new JTextField();
		txtDateEnd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtDateEnd = new GridBagConstraints();
		gbc_txtDateEnd.anchor = GridBagConstraints.WEST;
		gbc_txtDateEnd.insets = new Insets(10, 10, 10, 10);
		gbc_txtDateEnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateEnd.gridx = 3;
		gbc_txtDateEnd.gridy = 5;
		content.add(txtDateEnd, gbc_txtDateEnd);
		txtDateEnd.setColumns(10);
		
		txtDiaChi = new JTextField();

		
		JPanel footer = new JPanel();
		footer.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(85, 173, 155)));
		footer.setBackground(new Color(241, 248, 232));
		footer.setPreferredSize(new Dimension(10, 70));
		contentPane.add(footer, BorderLayout.SOUTH);
		footer.setLayout(null);
		
		JButton btnAdd = new JButton("");
		btnAdd.setIcon(new ImageIcon(AddStudent.class.getResource("/Imgs/add.png")));
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnAdd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnAdd.setBackground(new Color(85, 173, 155));
		btnAdd.setBounds(717, 10, 134, 58);
		footer.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gọi hàm xử lí đăng nhập
				handleAdd();
			}
		});
		
		JButton btnRefresh = new JButton("");
		btnRefresh.setIcon(new ImageIcon(AddStudent.class.getResource("/Imgs/refresh.png")));
		btnRefresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefresh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnRefresh.setBackground(new Color(85, 173, 155));
		btnRefresh.setBounds(573, 10, 134, 58);
		footer.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gọi hàm refresh
				refresh();
			}
		});
	}
	
	//Xử lý add vào Database
	public void handleAdd() {
	    // Lấy thông tin từ giao diện người dùng, loại bỏ khoảng trắng dư thừa
	    String maLHP = txtId.getText().trim();                // Mã lớp học phần
	    String tenLHP = txtTenLop.getText().trim();           // Tên lớp học phần
	    String giangVien = txtGiangVien.getText().trim();     // Giảng viên phụ trách
	    String ngayBatDau = txtDateBegin.getText().trim();    // Ngày bắt đầu
	    String ngayKetThuc = txtDateEnd.getText().trim();     // Ngày kết thúc
	    String phongHoc = txtDiaChi.getText().trim();         // Phòng học

	    // Debug: In giá trị ra console để kiểm tra dữ liệu thực tế
	    System.out.println("maLHP: [" + maLHP + "]");
	    System.out.println("tenLHP: [" + tenLHP + "]");
	    System.out.println("giangVien: [" + giangVien + "]");
	    System.out.println("ngayBatDau: [" + ngayBatDau + "]");
	    System.out.println("ngayKetThuc: [" + ngayKetThuc + "]");
	    System.out.println("phongHoc: [" + phongHoc + "]");

	    // Kiểm tra dữ liệu đầu vào: loại bỏ khoảng trắng dư thừa và kiểm tra độ dài
	    if (maLHP.isBlank() || tenLHP.isBlank() || giangVien.isBlank() || 
	        ngayBatDau.isBlank() || ngayKetThuc.isBlank() || phongHoc.isBlank()) {
	        JOptionPane.showMessageDialog(this, 
	            "Vui lòng nhập đầy đủ thông tin lớp học phần (không để trống hoặc chứa toàn khoảng trắng).", 
	            "Dữ liệu không hợp lệ", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Kiểm tra định dạng ngày (ví dụ: yyyy-MM-dd)
	    if (!isValidDate(ngayBatDau) || !isValidDate(ngayKetThuc)) {
	        JOptionPane.showMessageDialog(this, 
	            "Ngày bắt đầu hoặc ngày kết thúc không đúng định dạng (yyyy-MM-dd).", 
	            "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Câu lệnh SQL thêm LopHocPhan
	    String sql = "INSERT INTO LopHocPhan (MaLHP, TenLHP, MaGVPhuTrach, NgayBatDau, NgayKetThuc, PhongHoc) " +
	                 "VALUES (?, ?, ?, ?, ?, ?)";

	    try (Connection conn = JDBCUtil.getConnection();
	         PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

	        // Gán tham số cho câu lệnh SQL
	        preparedStatement.setString(1, maLHP);
	        preparedStatement.setString(2, tenLHP);
	        preparedStatement.setString(3, giangVien);
	        preparedStatement.setString(4, ngayBatDau);
	        preparedStatement.setString(5, ngayKetThuc);
	        preparedStatement.setString(6, phongHoc);

	        // Thực thi câu lệnh SQL
	        int rowsInserted = preparedStatement.executeUpdate();

	        if (rowsInserted > 0) {
	            JOptionPane.showMessageDialog(this, 
	                "Thêm lớp học phần thành công!", 
	                "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	            refresh(); // Làm mới dữ liệu sau khi thêm thành công
	        } else {
	            JOptionPane.showMessageDialog(this, 
	                "Thêm lớp học phần thất bại. Vui lòng thử lại!", 
	                "Thất bại", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException ex) {
	        // Kiểm tra lỗi khóa chính trùng
	        if (ex.getErrorCode() == 1062) { // 1062 là mã lỗi trùng khóa chính trong MySQL
	            JOptionPane.showMessageDialog(this, 
	                "Mã lớp học phần đã tồn tại. Vui lòng nhập mã khác.", 
	                "Lỗi trùng khóa", JOptionPane.ERROR_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(this, 
	                "Lỗi khi thêm lớp học phần: " + ex.getMessage(), 
	                "Lỗi", JOptionPane.ERROR_MESSAGE);
	        }
	        ex.printStackTrace();
	    }
	}

	// Hàm kiểm tra định dạng ngày (yyyy-MM-dd)
	private boolean isValidDate(String date) {
	    try {
	        java.time.LocalDate.parse(date);
	        return true;
	    } catch (java.time.format.DateTimeParseException e) {
	        return false;
	    }
	}

	// Hàm refresh() để làm mới dữ liệu hoặc giao diện
	private void refresh() {
	    txtId.setText("");
	    txtTenLop.setText("");
	    txtGiangVien.setText("");
	    txtDateBegin.setText("");
	    txtDateEnd.setText("");
	    txtDiaChi.setText("");
	    // Cập nhật bảng dữ liệu nếu cần
	    
	}


	// Hàm refresh() để làm mới dữ liệu hoặc giao diện (tùy bạn định nghĩa)
	

	
	//Các trường trong window refresh
	
}
