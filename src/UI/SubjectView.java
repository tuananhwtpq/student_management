package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SubjectView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaMonHoc;
	private JTextField txtBatDau;
	private JTextField txtTenLopHoc;
	private JTextField txtKetThuc;
	private JTextField txtGiangVien;
	private JTextField txtSiSo;
	private JEditorPane txtMoTa;
	
	public SubjectView(String fullName) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        setVisible(false); 
		    }
		});
		setTitle("Thông tin môn học: " + fullName);
		setBounds(100, 100, 900, 470);
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
		
		setContentPane(contentPane);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 1}; 
		gbl_contentPane.rowHeights = new int[]{348, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0}; 
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel content = new JPanel();
		content.setBackground(new Color(241, 248, 232));
		
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.insets = new Insets(0, 0, 0, 0); 
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.gridx = 1; 
		gbc_content.gridy = 0;
		contentPane.add(content, gbc_content);
		
		
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[]{0, 171, 0, 228, 0};
		gbl_content.rowHeights = new int[]{0, 0, 0, 41, 0, 0, 0};
		gbl_content.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_content.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		content.setLayout(gbl_content);
		
		JLabel lblMaMonHoc = new JLabel("Mã môn học:");
		lblMaMonHoc.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblMaMonHoc = new GridBagConstraints();
		gbc_lblMaMonHoc.anchor = GridBagConstraints.WEST;
		gbc_lblMaMonHoc.insets = new Insets(10, 10, 10, 10);
		gbc_lblMaMonHoc.gridx = 0;
		gbc_lblMaMonHoc.gridy = 0;
		content.add(lblMaMonHoc, gbc_lblMaMonHoc);
		
		txtMaMonHoc = new JTextField();
		txtMaMonHoc.setBackground(new Color(241, 248, 232));
		txtMaMonHoc.setBorder(null);
		txtMaMonHoc.setText("Xin chào");
		txtMaMonHoc.setEditable(false);
		txtMaMonHoc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtMaMonHoc = new GridBagConstraints();
		gbc_txtMaMonHoc.anchor = GridBagConstraints.WEST;
		gbc_txtMaMonHoc.insets = new Insets(10, 10, 10, 10);
		gbc_txtMaMonHoc.gridx = 1;
		gbc_txtMaMonHoc.gridy = 0;
		content.add(txtMaMonHoc, gbc_txtMaMonHoc);
		txtMaMonHoc.setColumns(10);
		
		JLabel lblSoTinChi = new JLabel("Số tín chỉ:");
		lblSoTinChi.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblSoTinChi = new GridBagConstraints();
		gbc_lblSoTinChi.anchor = GridBagConstraints.WEST;
		gbc_lblSoTinChi.insets = new Insets(10, 10, 10, 10);
		gbc_lblSoTinChi.gridx = 2;
		gbc_lblSoTinChi.gridy = 0;
		content.add(lblSoTinChi, gbc_lblSoTinChi);
		
		txtBatDau = new JTextField();
		txtBatDau.setBackground(new Color(241, 248, 232));
		txtBatDau.setText("Xin chào");
		txtBatDau.setBorder(null);
		txtBatDau.setEditable(false);
		txtBatDau.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtBatDau = new GridBagConstraints();
		gbc_txtBatDau.insets = new Insets(10, 10, 10, 10);
		gbc_txtBatDau.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBatDau.gridx = 3;
		gbc_txtBatDau.gridy = 0;
		content.add(txtBatDau, gbc_txtBatDau);
		txtBatDau.setColumns(10);
		
		JLabel lblTenMonHoc = new JLabel("Tên môn học:");
		lblTenMonHoc.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblTenMonHoc = new GridBagConstraints();
		gbc_lblTenMonHoc.anchor = GridBagConstraints.WEST;
		gbc_lblTenMonHoc.insets = new Insets(10, 10, 10, 10);
		gbc_lblTenMonHoc.gridx = 0;
		gbc_lblTenMonHoc.gridy = 1;
		content.add(lblTenMonHoc, gbc_lblTenMonHoc);
		
		txtTenLopHoc = new JTextField();
		txtTenLopHoc.setBackground(new Color(241, 248, 232));
		txtTenLopHoc.setText("Xin chào");
		txtTenLopHoc.setBorder(null);
		txtTenLopHoc.setEditable(false);
		txtTenLopHoc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTenLopHoc.setColumns(10);
		GridBagConstraints gbc_txtTenLopHoc = new GridBagConstraints();
		gbc_txtTenLopHoc.insets = new Insets(10, 10, 10, 10);
		gbc_txtTenLopHoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenLopHoc.gridx = 1;
		gbc_txtTenLopHoc.gridy = 1;
		content.add(txtTenLopHoc, gbc_txtTenLopHoc);
		
		JLabel lblKetThuc = new JLabel("Thời gian kết thúc:");
		lblKetThuc.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblKetThuc = new GridBagConstraints();
		gbc_lblKetThuc.anchor = GridBagConstraints.WEST;
		gbc_lblKetThuc.insets = new Insets(10, 10, 10, 10);
		gbc_lblKetThuc.gridx = 2;
		gbc_lblKetThuc.gridy = 1;
		content.add(lblKetThuc, gbc_lblKetThuc);
		
		txtKetThuc = new JTextField();
		txtKetThuc.setBackground(new Color(241, 248, 232));
		txtKetThuc.setText("Xin chào");
		txtKetThuc.setBorder(null);
		txtKetThuc.setEditable(false);
		txtKetThuc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtKetThuc.setColumns(10);
		GridBagConstraints gbc_txtKetThuc = new GridBagConstraints();
		gbc_txtKetThuc.insets = new Insets(10, 10, 10, 10);
		gbc_txtKetThuc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKetThuc.gridx = 3;
		gbc_txtKetThuc.gridy = 1;
		content.add(txtKetThuc, gbc_txtKetThuc);
		
		JLabel lblGiangVien = new JLabel("Giảng viên phụ trách:");
		lblGiangVien.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblGiangVien = new GridBagConstraints();
		gbc_lblGiangVien.anchor = GridBagConstraints.WEST;
		gbc_lblGiangVien.insets = new Insets(10, 10, 10, 10);
		gbc_lblGiangVien.gridx = 0;
		gbc_lblGiangVien.gridy = 2;
		content.add(lblGiangVien, gbc_lblGiangVien);
		
		txtGiangVien = new JTextField();
		txtGiangVien.setBackground(new Color(241, 248, 232));
		txtGiangVien.setText("Xin chào");
		txtGiangVien.setBorder(null);
		txtGiangVien.setEditable(false);
		txtGiangVien.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtGiangVien.setColumns(10);
		GridBagConstraints gbc_txtGiangVien = new GridBagConstraints();
		gbc_txtGiangVien.insets = new Insets(10, 10, 10, 10);
		gbc_txtGiangVien.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGiangVien.gridx = 1;
		gbc_txtGiangVien.gridy = 2;
		content.add(txtGiangVien, gbc_txtGiangVien);
		
		JLabel lblSiSo = new JLabel("Sĩ số:");
		lblSiSo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblSiSo = new GridBagConstraints();
		gbc_lblSiSo.anchor = GridBagConstraints.WEST;
		gbc_lblSiSo.insets = new Insets(10, 10, 10, 10);
		gbc_lblSiSo.gridx = 2;
		gbc_lblSiSo.gridy = 2;
		content.add(lblSiSo, gbc_lblSiSo);
		
		txtSiSo = new JTextField();
		txtSiSo.setBackground(new Color(241, 248, 232));
		txtSiSo.setText("Xin chào");
		txtSiSo.setBorder(null);
		txtSiSo.setEditable(false);
		txtSiSo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSiSo.setColumns(10);
		GridBagConstraints gbc_txtSiSo = new GridBagConstraints();
		gbc_txtSiSo.insets = new Insets(10, 10, 10, 10);
		gbc_txtSiSo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSiSo.gridx = 3;
		gbc_txtSiSo.gridy = 2;
		content.add(txtSiSo, gbc_txtSiSo);
		
		JLabel lblMoTa = new JLabel("Mô tả chi tiết:");
		lblMoTa.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblMoTa = new GridBagConstraints();
		gbc_lblMoTa.anchor = GridBagConstraints.NORTHWEST; 
		gbc_lblMoTa.insets = new Insets(10, 10, 10, 10); 
		gbc_lblMoTa.gridx = 0;
		gbc_lblMoTa.gridy = 3; 
		content.add(lblMoTa, gbc_lblMoTa);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null); 
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH; 
		gbc_scrollPane.gridwidth = 3; 
		gbc_scrollPane.insets = new Insets(10, 10, 10, 10); 
		gbc_scrollPane.gridx = 1; 
		gbc_scrollPane.gridy = 3; 
		gbc_scrollPane.weightx = 1.0; 
		gbc_scrollPane.weighty = 1.0; 
		content.add(scrollPane, gbc_scrollPane);

		txtMoTa = new JEditorPane();
		txtMoTa.setMargin(new Insets(10, 10, 10, 10)); 
		txtMoTa.setBackground(new Color(241, 248, 232));
		txtMoTa.setBorder(null); 
		txtMoTa.setFont(new Font("Segoe UI", Font.PLAIN, 16)); 
		txtMoTa.setText("Xin chào"); 
		scrollPane.setViewportView(txtMoTa);
		txtMoTa.setEditable(false); 
		
		setSubjectDetails();
	}
	
	public void setSubjectDetails() {
	    
	}


}

