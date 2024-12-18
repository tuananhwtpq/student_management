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
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

import java.awt.Label;

public class EditClassroom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtGiangVien;
	private JTextField txtTenLop;
	private JTextField txtDiaChi;
	private JTextField txtSiSo;
	private JTextField txtDateBegin;
	private JTextField txtDateEnd;

	
	public EditClassroom(String id, String className, String teacher, String siSo, String dateBegin, String dateEnd) {

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
		
		JLabel lblTitle = new JLabel("Sửa thông tin lớp học: " + className + " - Mã lớp học: " + id);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
		header.add(lblTitle);
		
		JPanel content = new JPanel();
		content.setBackground(new Color(241, 248, 232));
		content.setBorder(new EmptyBorder(20, 0, 20, 0));
		contentPane.add(content, BorderLayout.EAST);
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[]{75, 270, 0, 270, 0};
		gbl_content.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_content.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_content.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		content.setLayout(gbl_content);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(10, 10, 10, 10);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		content.add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		txtId.setFocusable(false);
		txtId.setEditable(false);
		txtId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtId.setColumns(10);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.anchor = GridBagConstraints.WEST;
		gbc_txtId.insets = new Insets(10, 10, 10, 10);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		content.add(txtId, gbc_txtId);
		
		JLabel lblGiangVien = new JLabel("Giảng viên phụ trách");
		lblGiangVien.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblGiangVien = new GridBagConstraints();
		gbc_lblGiangVien.anchor = GridBagConstraints.WEST;
		gbc_lblGiangVien.insets = new Insets(10, 10, 10, 10);
		gbc_lblGiangVien.gridx = 2;
		gbc_lblGiangVien.gridy = 0;
		content.add(lblGiangVien, gbc_lblGiangVien);
		
		txtGiangVien = new JTextField();
		txtGiangVien.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtGiangVien = new GridBagConstraints();
		gbc_txtGiangVien.insets = new Insets(10, 10, 10, 10);
		gbc_txtGiangVien.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGiangVien.gridx = 3;
		gbc_txtGiangVien.gridy = 0;
		content.add(txtGiangVien, gbc_txtGiangVien);
		txtGiangVien.setColumns(10);
		
		JLabel lblTenLop = new JLabel("Tên lớp");
		lblTenLop.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblTenLop = new GridBagConstraints();
		gbc_lblTenLop.anchor = GridBagConstraints.WEST;
		gbc_lblTenLop.insets = new Insets(10, 10, 10, 10);
		gbc_lblTenLop.gridx = 0;
		gbc_lblTenLop.gridy = 2;
		content.add(lblTenLop, gbc_lblTenLop);
		
		txtTenLop = new JTextField();
		txtTenLop.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtTenLop = new GridBagConstraints();
		gbc_txtTenLop.insets = new Insets(10, 10, 10, 10);
		gbc_txtTenLop.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenLop.weightx = 1.0;
		gbc_txtTenLop.gridx = 1;
		gbc_txtTenLop.gridy = 2;
		content.add(txtTenLop, gbc_txtTenLop);
		txtTenLop.setColumns(10);
		
		JLabel lblSiSo = new JLabel("Sĩ số tối đa");
		lblSiSo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblSiSo = new GridBagConstraints();
		gbc_lblSiSo.anchor = GridBagConstraints.WEST;
		gbc_lblSiSo.insets = new Insets(10, 10, 10, 10);
		gbc_lblSiSo.gridx = 2;
		gbc_lblSiSo.gridy = 2;
		content.add(lblSiSo, gbc_lblSiSo);
		
		txtSiSo = new JTextField();
		
		txtSiSo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtSiSo = new GridBagConstraints();
		gbc_txtSiSo.insets = new Insets(10, 10, 10, 10);
		gbc_txtSiSo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSiSo.gridx = 3;
		gbc_txtSiSo.gridy = 2;
		content.add(txtSiSo, gbc_txtSiSo);
		txtSiSo.setColumns(10);
				
		JLabel lblDateBegin = new JLabel("Thời gian bắt đầu");
		lblDateBegin.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblDateBegin = new GridBagConstraints();
		gbc_lblDateBegin.anchor = GridBagConstraints.WEST;
		gbc_lblDateBegin.insets = new Insets(10, 10, 10, 10);
		gbc_lblDateBegin.gridx = 0;
		gbc_lblDateBegin.gridy = 4;
		content.add(lblDateBegin, gbc_lblDateBegin);
		
		txtDateBegin = new JTextField();
		txtDateBegin.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtDateBegin = new GridBagConstraints();
		gbc_txtDateBegin.anchor = GridBagConstraints.WEST;
		gbc_txtDateBegin.insets = new Insets(10, 10, 10, 10);
		gbc_txtDateBegin.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateBegin.weightx = 1.0;
		gbc_txtDateBegin.gridx = 1;
		gbc_txtDateBegin.gridy = 4;
		content.add(txtDateBegin, gbc_txtDateBegin);
		txtDateBegin.setColumns(10);
		
		JLabel lblDateEnd = new JLabel("Thời gian kết thúc");
		lblDateEnd.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblDateEnd = new GridBagConstraints();
		gbc_lblDateEnd.anchor = GridBagConstraints.WEST;
		gbc_lblDateEnd.insets = new Insets(10, 10, 10, 10);
		gbc_lblDateEnd.gridx = 2;
		gbc_lblDateEnd.gridy = 4;
		content.add(lblDateEnd, gbc_lblDateEnd);
		
		txtDateEnd = new JTextField();
		txtDateEnd.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtDateEnd = new GridBagConstraints();
		gbc_txtDateEnd.anchor = GridBagConstraints.WEST;
		gbc_txtDateEnd.insets = new Insets(10, 10, 10, 10);
		gbc_txtDateEnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateEnd.gridx = 3;
		gbc_txtDateEnd.gridy = 4;
		content.add(txtDateEnd, gbc_txtDateEnd);
		txtDateEnd.setColumns(10);
		
		txtDiaChi = new JTextField();

		
		JPanel footer = new JPanel();
		footer.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(85, 173, 155)));
		footer.setBackground(new Color(241, 248, 232));
		footer.setPreferredSize(new Dimension(10, 70));
		contentPane.add(footer, BorderLayout.SOUTH);
		footer.setLayout(null);
		
		//Truyền dữ liệu từ 1 Classroom sang
		txtId.setText(id);
		txtGiangVien.setText(teacher);
		txtTenLop.setText(className);
		txtDateBegin.setText(dateBegin);
		txtDateEnd.setText(dateEnd);
		txtSiSo.setText(siSo);
		
		JButton btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon(EditClassroom.class.getResource("/Imgs/editing.png")));
		btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnEdit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnEdit.setBackground(new Color(85, 173, 155));
		btnEdit.setBounds(717, 10, 134, 58);
		footer.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Gọi hàm xử lí đăng nhập
				handlleEdit();
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
	public void handlleEdit() {
	    String maLHP = txtId.getText().trim();
	    String tenLHP = txtTenLop.getText().trim();
	    String maGV = txtGiangVien.getText().trim();
	    String siSoToiDa = txtSiSo.getText().trim();
	    String thoiGianBatDau = txtDateBegin.getText().trim();
	    String thoiGianKetThuc = txtDateEnd.getText().trim();

	    // Kiểm tra các trường không được để trống
	    if (maLHP.isEmpty() || tenLHP.isEmpty() || maGV.isEmpty() || siSoToiDa.isEmpty() || thoiGianBatDau.isEmpty() ||
	        thoiGianKetThuc.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
	        return;
	    }

	    // Kiểm tra định dạng Sĩ số tối đa (chỉ là số)
	    try {
	        Integer.parseInt(siSoToiDa);
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Sĩ số tối đa phải là một số nguyên!");
	        return;
	    }

	    // Kiểm tra định dạng ngày tháng hợp lệ
	    if (!isValidDate(thoiGianBatDau) || !isValidDate(thoiGianKetThuc)) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng ngày tháng (yyyy-MM-dd)!");
	        return;
	    }

	    // Cập nhật thông tin vào cơ sở dữ liệu
	    String sql = "UPDATE LopHocPhan SET TenLHP = ?, SiSoToiDa = ?, ThoiGianBatDau = ?, ThoiGianKetThuc = ? WHERE MaLHP = ?";

	    try (Connection conn = JDBCUtil.getConnection();
	         PreparedStatement statement = conn.prepareStatement(sql)) {

	        // Thiết lập giá trị cho các tham số
	        statement.setString(1, tenLHP);
	        statement.setString(2, siSoToiDa);
	        statement.setString(3, thoiGianBatDau);
	        statement.setString(4, thoiGianKetThuc);
	        statement.setString(5, maLHP);

	        // Thực thi câu lệnh cập nhật
	        int rowsUpdated = statement.executeUpdate();

	        if (rowsUpdated > 0) {
	            JOptionPane.showMessageDialog(this, "Cập nhật thông tin lớp học phần thành công!");
	            this.dispose();  // Đóng cửa sổ sau khi cập nhật thành công
	        } else {
	            JOptionPane.showMessageDialog(this, "Không tìm thấy lớp học phần với mã này!");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật dữ liệu vào cơ sở dữ liệu!");
	    }
	}

	// Phương thức kiểm tra định dạng ngày tháng
	private boolean isValidDate(String dateStr) {
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        sdf.setLenient(false);
	        sdf.parse(dateStr);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}

	
	public void refresh() {
		txtGiangVien.setText("");
		txtTenLop.setText("");
		txtDateBegin.setText("");
		txtDateEnd.setText("");
		txtSiSo.setText("");
	}
}
