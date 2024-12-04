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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class AddStudent extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNganh;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtNgaySinh;
	private JTextField txtEmail;
	private String UIName;
	private String CategoryTitle;
	private JTextField txtLop;
	private JTextField txtSoDienThoai;
	
	
	public AddStudent() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        setVisible(false); // Thay vì dispose(), ta sẽ chỉ ẩn cửa sổ
		    }
		});
		setBounds(100, 100, 900, 400);
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		header.setBackground(new Color(241, 248, 232));
		header.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(85, 173, 155)));
		contentPane.add(header, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Thêm sinh viên");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
		header.add(lblTitle);
		
		JPanel content = new JPanel();
		content.setBackground(new Color(241, 248, 232));
		content.setBorder(new EmptyBorder(20, 0, 20, 0));
		contentPane.add(content, BorderLayout.CENTER);
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[]{75, 260, 0, 345, 0};
		gbl_content.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_content.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_content.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblNganh = new JLabel("Ngành");
		lblNganh.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblNganh = new GridBagConstraints();
		gbc_lblNganh.anchor = GridBagConstraints.WEST;
		gbc_lblNganh.insets = new Insets(10, 10, 10, 10);
		gbc_lblNganh.gridx = 2;
		gbc_lblNganh.gridy = 1;
		content.add(lblNganh, gbc_lblNganh);
		
		txtNganh = new JTextField();
		txtNganh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtNganh = new GridBagConstraints();
		gbc_txtNganh.insets = new Insets(10, 10, 10, 10);
		gbc_txtNganh.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNganh.gridx = 3;
		gbc_txtNganh.gridy = 1;
		content.add(txtNganh, gbc_txtNganh);
		txtNganh.setColumns(10);
		
		JLabel lblHoTen = new JLabel("Họ tên");
		lblHoTen.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblHoTen = new GridBagConstraints();
		gbc_lblHoTen.anchor = GridBagConstraints.WEST;
		gbc_lblHoTen.insets = new Insets(10, 10, 10, 10);
		gbc_lblHoTen.gridx = 0;
		gbc_lblHoTen.gridy = 3;
		content.add(lblHoTen, gbc_lblHoTen);
		
		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtHoTen = new GridBagConstraints();
		gbc_txtHoTen.insets = new Insets(10, 10, 10, 10);
		gbc_txtHoTen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHoTen.gridx = 1;
		gbc_txtHoTen.gridy = 3;
		content.add(txtHoTen, gbc_txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblDiaChi = new GridBagConstraints();
		gbc_lblDiaChi.anchor = GridBagConstraints.WEST;
		gbc_lblDiaChi.insets = new Insets(10, 10, 10, 10);
		gbc_lblDiaChi.gridx = 2;
		gbc_lblDiaChi.gridy = 3;
		content.add(lblDiaChi, gbc_lblDiaChi);
		
		txtDiaChi = new JTextField();
		
		txtDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtDiaChi = new GridBagConstraints();
		gbc_txtDiaChi.insets = new Insets(10, 10, 10, 10);
		gbc_txtDiaChi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiaChi.gridx = 3;
		gbc_txtDiaChi.gridy = 3;
		content.add(txtDiaChi, gbc_txtDiaChi);
		txtDiaChi.setColumns(10);
				
		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblNgaySinh = new GridBagConstraints();
		gbc_lblNgaySinh.anchor = GridBagConstraints.WEST;
		gbc_lblNgaySinh.insets = new Insets(10, 10, 10, 10);
		gbc_lblNgaySinh.gridx = 0;
		gbc_lblNgaySinh.gridy = 5;
		content.add(lblNgaySinh, gbc_lblNgaySinh);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtNgaySinh = new GridBagConstraints();
		gbc_txtNgaySinh.anchor = GridBagConstraints.WEST;
		gbc_txtNgaySinh.insets = new Insets(10, 10, 10, 10);
		gbc_txtNgaySinh.gridx = 1;
		gbc_txtNgaySinh.gridy = 5;
		content.add(txtNgaySinh, gbc_txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(10, 10, 10, 10);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 5;
		content.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.WEST;
		gbc_txtEmail.insets = new Insets(10, 10, 10, 10);
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 5;
		content.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblLop = new JLabel("Lớp");
		lblLop.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblLop = new GridBagConstraints();
		gbc_lblLop.anchor = GridBagConstraints.WEST;
		gbc_lblLop.insets = new Insets(10, 10, 10, 10);
		gbc_lblLop.gridx = 0;
		gbc_lblLop.gridy = 7;
		content.add(lblLop, gbc_lblLop);
		
		txtLop = new JTextField();
		txtLop.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtLop.setColumns(10);
		GridBagConstraints gbc_txtLop = new GridBagConstraints();
		gbc_txtLop.insets = new Insets(10, 10, 10, 10);
		gbc_txtLop.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLop.gridx = 1;
		gbc_txtLop.gridy = 7;
		content.add(txtLop, gbc_txtLop);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblSoDienThoai = new GridBagConstraints();
		gbc_lblSoDienThoai.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblSoDienThoai.insets = new Insets(10, 10, 10, 10);
		gbc_lblSoDienThoai.gridx = 2;
		gbc_lblSoDienThoai.gridy = 7;
		content.add(lblSoDienThoai, gbc_lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSoDienThoai.setColumns(10);
		GridBagConstraints gbc_txtSoDienThoai = new GridBagConstraints();
		gbc_txtSoDienThoai.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSoDienThoai.gridx = 3;
		gbc_txtSoDienThoai.gridy = 7;
		content.add(txtSoDienThoai, gbc_txtSoDienThoai);
		
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
		btnAdd.setBounds(730, 10, 134, 58);
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
		btnRefresh.setBounds(586, 10, 134, 58);
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
		
	}
	
	//Các trường trong window refresh
	public void refresh() {
		
	}

}
