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
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class SubjectView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTenMonHoc;
	private JTextField txtSoTC;
	private JTextField txtDiaChi;
	private String UIName;
	private String CategoryTitle;
	private JEditorPane txtMoTa;
	
	public SubjectView(String maMH, String tenLopHoc, String soTC, String moTa) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        setVisible(false); // Thay vì dispose(), ta sẽ chỉ ẩn cửa sổ
		    }
		});
		setBounds(100, 100, 900, 500);
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
		
		JLabel lblTitle = new JLabel("Thông tin môn học: " + tenLopHoc + " - Mã môn học: " + maMH);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
		header.add(lblTitle);
		
		JPanel content = new JPanel();
		content.setBackground(new Color(241, 248, 232));
		content.setBorder(new EmptyBorder(20, 0, 20, 0));
		contentPane.add(content, BorderLayout.CENTER);
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[]{75, 260, 0, 345, 0};
		gbl_content.rowHeights = new int[]{0, 0, 0, 0, 0, 206};
		gbl_content.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_content.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		content.setLayout(gbl_content);
		
		JLabel lblId = new JLabel("Mã môn học");
		lblId.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(10, 10, 10, 10);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		content.add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtId.setColumns(10);
		txtId.setEditable(false);
		txtId.setBorder(null);
		txtId.setBackground(new Color(241, 248, 232));
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.anchor = GridBagConstraints.WEST;
		gbc_txtId.insets = new Insets(10, 10, 10, 10);
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 1;
		content.add(txtId, gbc_txtId);
		
//		textField = new JTextField();
//		textField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//		textField.setColumns(10);
//		GridBagConstraints gbc_textField = new GridBagConstraints();
//		gbc_textField.insets = new Insets(10, 10, 10, 10);
//		gbc_textField.anchor = GridBagConstraints.WEST;
//		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField.gridx = 1;
//		gbc_textField.gridy = 1;
//		content.add(textField, gbc_textField);
		
		JLabel lblTenMonHoc = new JLabel("Tên môn học");
		lblTenMonHoc.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblTenMonHoc = new GridBagConstraints();
		gbc_lblTenMonHoc.anchor = GridBagConstraints.EAST;
		gbc_lblTenMonHoc.insets = new Insets(10, 10, 10, 10);
		gbc_lblTenMonHoc.gridx = 2;
		gbc_lblTenMonHoc.gridy = 1;
		content.add(lblTenMonHoc, gbc_lblTenMonHoc);
		
		txtTenMonHoc = new JTextField();
		txtTenMonHoc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTenMonHoc.setEditable(false);
		txtTenMonHoc.setBorder(null);
		txtTenMonHoc.setBackground(new Color(241, 248, 232));
		GridBagConstraints gbc_txtTenMonHoc = new GridBagConstraints();
		gbc_txtTenMonHoc.insets = new Insets(10, 10, 10, 10);
		gbc_txtTenMonHoc.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenMonHoc.gridx = 3;
		gbc_txtTenMonHoc.gridy = 1;
		content.add(txtTenMonHoc, gbc_txtTenMonHoc);
		txtTenMonHoc.setColumns(10);
		
//		textField_1 = new JTextField();
//		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//		textField_1.setColumns(10);
//		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
//		gbc_textField_1.insets = new Insets(10, 10, 10, 10);
//		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_1.gridx = 3;
//		gbc_textField_1.gridy = 1;
//		content.add(textField_1, gbc_textField_1);
		
		JLabel lblSoTC = new JLabel("Số tín chỉ");
		lblSoTC.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblSoTC = new GridBagConstraints();
		gbc_lblSoTC.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblSoTC.insets = new Insets(10, 10, 10, 10);
		gbc_lblSoTC.gridx = 0;
		gbc_lblSoTC.gridy = 3;
		content.add(lblSoTC, gbc_lblSoTC);
		
		txtSoTC = new JTextField();
		txtSoTC.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtSoTC.setEditable(false);
		txtSoTC.setBorder(null);
		txtSoTC.setBackground(new Color(241, 248, 232));
		GridBagConstraints gbc_txtSoTC = new GridBagConstraints();
		gbc_txtSoTC.anchor = GridBagConstraints.NORTH;
		gbc_txtSoTC.insets = new Insets(10, 10, 10, 10);
		gbc_txtSoTC.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSoTC.gridx = 1;
		gbc_txtSoTC.gridy = 3;
		content.add(txtSoTC, gbc_txtSoTC);
		txtSoTC.setColumns(10);
				
		JLabel lblMoTa = new JLabel("Mô tả");
		lblMoTa.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblMoTa = new GridBagConstraints();
		gbc_lblMoTa.anchor = GridBagConstraints.WEST;
		gbc_lblMoTa.insets = new Insets(10, 10, 10, 10);
		gbc_lblMoTa.gridx = 0;
		gbc_lblMoTa.gridy = 5;
		content.add(lblMoTa, gbc_lblMoTa);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(10, 10, 10, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		content.add(scrollPane, gbc_scrollPane);
		
		txtMoTa = new JEditorPane();
		txtMoTa.setMargin(new Insets(10, 10, 10, 10));
		txtMoTa.setBorder(null);
		txtMoTa.setEditable(false);
		txtMoTa.setBackground(new Color(241, 248, 232));
		txtMoTa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		scrollPane.setViewportView(txtMoTa);
		txtMoTa.setEditable(true);
		
		txtId.setText(maMH);
		txtTenMonHoc.setText(tenLopHoc);
		txtSoTC.setText(soTC);
		txtMoTa.setText(moTa);
		
		
		setSubjectDetails();
	}
	
	public void setSubjectDetails() {
	    
	}


}

