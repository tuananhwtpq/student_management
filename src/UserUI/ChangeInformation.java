package UserUI;

import UI.Login;
import dataManaging.StudentManaging;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChangeInformation extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtCuoiKy;
    private JTextField txtDiemGiuaKy;
    private JTextField txtTongKet;
    private JTextField txtDanhGia;
    private JTextField txtHoten;
    private JLabel lblPhone;
    private GridBagConstraints gbc_lblPhone;
    private GridBagConstraints gbc_txtPhone;
    private JLabel lblDiaChi;
    private JButton btnLuuThongTin;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    public ChangeInformation() {

        setBackground(new Color(255, 255, 255));
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());

        JPanel content = new JPanel();
        content.setBackground(new Color(241, 248, 232));
        add(content, BorderLayout.CENTER);

        GridBagLayout gbl_content = new GridBagLayout();
        gbl_content.columnWidths = new int[] { 0, 171, 0, 228, 0 };
        gbl_content.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_content.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
        gbl_content.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
        content.setLayout(gbl_content);

        // Tạo các Label và TextField như ban đầu
        JLabel lblHoTen = new JLabel("Họ tên:");
        lblHoTen.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_lblHoTen = new GridBagConstraints();
        gbc_lblHoTen.anchor = GridBagConstraints.EAST;
        gbc_lblHoTen.insets = new Insets(10, 10, 10, 10);
        gbc_lblHoTen.gridx = 0;
        gbc_lblHoTen.gridy = 0;
        content.add(lblHoTen, gbc_lblHoTen);

        txtHoten = new JTextField();
        txtHoten.setPreferredSize(new Dimension(7, 35));
        txtHoten.setFocusable(false);
        txtHoten.setEditable(false);
        txtHoten.setBackground(new Color(241, 248, 232));
        txtHoten.setBorder(null);
        txtHoten.setText("Xin chào");
        txtHoten.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        GridBagConstraints gbc_txtHoten = new GridBagConstraints();
        gbc_txtHoten.anchor = GridBagConstraints.WEST;
        gbc_txtHoten.insets = new Insets(10, 10, 10, 10);
        gbc_txtHoten.gridx = 1;
        gbc_txtHoten.gridy = 0;
        content.add(txtHoten, gbc_txtHoten);
        txtHoten.setColumns(10);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_lblEmail = new GridBagConstraints();
        gbc_lblEmail.anchor = GridBagConstraints.EAST;
        gbc_lblEmail.insets = new Insets(10, 10, 10, 10);
        gbc_lblEmail.gridx = 0;
        gbc_lblEmail.gridy = 1;
        content.add(lblEmail, gbc_lblEmail);
        
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(7, 35));
        textField.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        textField.setAlignmentX(Component.RIGHT_ALIGNMENT);
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 1;
        content.add(textField, gbc_textField);
        textField.setColumns(10);

        lblPhone = new JLabel("Điện thoại:");
        lblPhone.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_lblPhone = new GridBagConstraints();
        gbc_lblPhone.anchor = GridBagConstraints.EAST;
        gbc_lblPhone.insets = new Insets(10, 10, 10, 10);
        gbc_lblPhone.gridx = 0;
        gbc_lblPhone.gridy = 2;
        content.add(lblPhone, gbc_lblPhone);
        
        textField_1 = new JTextField();
        textField_1.setPreferredSize(new Dimension(7, 35));
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.insets = new Insets(0, 0, 5, 5);
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 1;
        gbc_textField_1.gridy = 2;
        content.add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        
        // Sửa phần Địa chỉ
        lblDiaChi = new JLabel("Địa chỉ:");
        lblDiaChi.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_lblDiaChi = new GridBagConstraints();
        gbc_lblDiaChi.anchor = GridBagConstraints.EAST;  
        gbc_lblDiaChi.insets = new Insets(10, 10, 10, 10);
        gbc_lblDiaChi.gridx = 0;
        gbc_lblDiaChi.gridy = 3;
        content.add(lblDiaChi, gbc_lblDiaChi);
        
        textField_2 = new JTextField();
        textField_2.setPreferredSize(new Dimension(7, 35));
        GridBagConstraints gbc_textField_2 = new GridBagConstraints();
        gbc_textField_2.insets = new Insets(0, 0, 5, 5);
        gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_2.gridx = 1;
        gbc_textField_2.gridy = 3;
        content.add(textField_2, gbc_textField_2);
        textField_2.setColumns(10);
        
        btnLuuThongTin = new JButton("Lưu thông tin");
        btnLuuThongTin.setMaximumSize(new Dimension(95, 35));
        btnLuuThongTin.setSize(new Dimension(2, 0));
        btnLuuThongTin.setPreferredSize(new Dimension(150, 40));
        GridBagConstraints gbc_btnLuuThongTin = new GridBagConstraints();
        gbc_btnLuuThongTin.insets = new Insets(0, 0, 5, 5);
        gbc_btnLuuThongTin.gridx = 1;
        gbc_btnLuuThongTin.anchor = GridBagConstraints.WEST;
        gbc_btnLuuThongTin.gridy = 4;
        content.add(btnLuuThongTin, gbc_btnLuuThongTin);
        btnLuuThongTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleUpdate();
			}
		});
    }
    StudentManaging sm = new StudentManaging();
    Login lg = new Login();
    private void handleUpdate() {
        String a = this.textField.getText();
        String b = this.textField_1.getText();
        String c = this.textField_2.getText();
        String id = lg.getID();
        sm.update(id, a, b, c);
        JOptionPane.showMessageDialog(this, "Gửi yêu cầu cập nhật thông tin thành công");
    }
}