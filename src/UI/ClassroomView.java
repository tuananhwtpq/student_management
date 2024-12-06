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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class ClassroomView extends JFrame {
	
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
	
	public ClassroomView(String maLopHoc, String tenLopHoc, String giangVien, String siSo, String TimeBatDau, String TimeKetThuc ) {
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
		
		JLabel lblTitle = new JLabel("Thông tin lớp học: " + tenLopHoc + " - Mã lớp học: " + maLopHoc);
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
		txtId.setBorder(null);
		txtId.setBackground(new Color(241, 248, 232));
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
		txtGiangVien.setBorder(null);
		txtGiangVien.setBackground(new Color(241, 248, 232));
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
		txtTenLop.setBorder(null);
		txtTenLop.setBackground(new Color(241, 248, 232));
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
		txtSiSo.setBorder(null);
		txtSiSo.setBackground(new Color(241, 248, 232));
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
		txtDateBegin.setBorder(null);
		txtDateBegin.setBackground(new Color(241, 248, 232));
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
		txtDateEnd.setBorder(null);
		txtDateEnd.setBackground(new Color(241, 248, 232));
		GridBagConstraints gbc_txtDateEnd = new GridBagConstraints();
		gbc_txtDateEnd.anchor = GridBagConstraints.WEST;
		gbc_txtDateEnd.insets = new Insets(10, 10, 10, 10);
		gbc_txtDateEnd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateEnd.gridx = 3;
		gbc_txtDateEnd.gridy = 5;
		content.add(txtDateEnd, gbc_txtDateEnd);
		txtDateEnd.setColumns(10);
		
		txtId.setText(maLopHoc);
		txtTenLop.setText(tenLopHoc);
		txtSiSo.setText(siSo);
		txtGiangVien.setText(giangVien);
		txtDateBegin.setText(TimeBatDau);
		txtDateEnd.setText(TimeKetThuc);
	}
	
	public void setClassroomDetails() {
	    
	}

}

