package UserUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ChangeInformation extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtCuoiKy;
    private JTextField txtEmail;
    private JTextField txtDiemGiuaKy;
    private JTextField txtPhone;
    private JTextField txtTongKet;
    private JTextField txtDanhGia;
    private JTextField txtHoten;
    private JLabel lblPhone;
    private GridBagConstraints gbc_lblPhone;
    private GridBagConstraints gbc_txtPhone;
    private JLabel lblDiaChi;
    private JTextField txtDiaChi;
    private JButton btnLuuThongTin;

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
        gbc_lblHoTen.anchor = GridBagConstraints.WEST;
        gbc_lblHoTen.insets = new Insets(10, 10, 10, 10);
        gbc_lblHoTen.gridx = 0;
        gbc_lblHoTen.gridy = 0;
        content.add(lblHoTen, gbc_lblHoTen);

        txtHoten = new JTextField();
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
        gbc_lblEmail.anchor = GridBagConstraints.WEST;
        gbc_lblEmail.insets = new Insets(10, 10, 10, 10);
        gbc_lblEmail.gridx = 0;
        gbc_lblEmail.gridy = 1;
        content.add(lblEmail, gbc_lblEmail);

        txtEmail = new JTextField();
        txtEmail.setFocusable(false);
        txtEmail.setBackground(new Color(241, 248, 232));
        txtEmail.setText("Xin chào");
        txtEmail.setBorder(null);
        txtEmail.setEditable(false);
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtEmail.setColumns(10);
        GridBagConstraints gbc_txtEmail = new GridBagConstraints();
        gbc_txtEmail.insets = new Insets(10, 10, 10, 10);
        gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtEmail.gridx = 1;
        gbc_txtEmail.gridy = 1;
        content.add(txtEmail, gbc_txtEmail);

        lblPhone = new JLabel("Điện thoại:");
        lblPhone.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_lblPhone = new GridBagConstraints();
        gbc_lblPhone.anchor = GridBagConstraints.WEST;
        gbc_lblPhone.insets = new Insets(10, 10, 10, 10);
        gbc_lblPhone.gridx = 0;
        gbc_lblPhone.gridy = 2;
        content.add(lblPhone, gbc_lblPhone);

        txtPhone = new JTextField();
        txtPhone.setFocusable(false);
        txtPhone.setBackground(new Color(241, 248, 232));
        txtPhone.setText("Xin chào");
        txtPhone.setBorder(null);
        txtPhone.setEditable(false);
        txtPhone.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtPhone.setColumns(10);
        GridBagConstraints gbc_txtPhone = new GridBagConstraints();
        gbc_txtPhone.insets = new Insets(10, 10, 10, 10);
        gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPhone.gridx = 1;
        gbc_txtPhone.gridy = 2;
        content.add(txtPhone, gbc_txtPhone);
        
        // Sửa phần Địa chỉ
        lblDiaChi = new JLabel("Địa chỉ:");
        lblDiaChi.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_lblDiaChi = new GridBagConstraints();
        gbc_lblDiaChi.anchor = GridBagConstraints.WEST;  
        gbc_lblDiaChi.insets = new Insets(10, 10, 10, 10);
        gbc_lblDiaChi.gridx = 0;
        gbc_lblDiaChi.gridy = 3;
        content.add(lblDiaChi, gbc_lblDiaChi);

        txtDiaChi = new JTextField();
        txtDiaChi.setText("Xin chào");
        txtDiaChi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtDiaChi.setFocusable(false);
        txtDiaChi.setEditable(false);
        txtDiaChi.setColumns(10);
        txtDiaChi.setBorder(null);
        txtDiaChi.setBackground(new Color(241, 248, 232));
        GridBagConstraints gbc_txtDiaChi = new GridBagConstraints();
        gbc_txtDiaChi.insets = new Insets(10, 10, 10, 10);
        gbc_txtDiaChi.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtDiaChi.gridx = 1;
        gbc_txtDiaChi.gridy = 3;
        content.add(txtDiaChi, gbc_txtDiaChi);
        
        btnLuuThongTin = new JButton("Lưu thông tin");
        GridBagConstraints gbc_btnLuuThongTin = new GridBagConstraints();
        gbc_btnLuuThongTin.insets = new Insets(0, 0, 5, 5);
        gbc_btnLuuThongTin.gridx = 1;
        gbc_btnLuuThongTin.anchor = GridBagConstraints.WEST;
        gbc_btnLuuThongTin.gridy = 4;
        content.add(btnLuuThongTin, gbc_btnLuuThongTin);
    }
}
