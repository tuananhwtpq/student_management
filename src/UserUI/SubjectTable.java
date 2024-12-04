package UserUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SubjectTable extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;


    public SubjectTable(String a, String b, String c, String d) {

        setTitle("Thông tin chi tiết môn học: " + b);

//         setTitle("Thông tin chi tiết môn học: " + subjectName);

        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[] { 100, 400 };
        layout.rowHeights = new int[] { 40, 40, 40, 100 };
        layout.columnWeights = new double[] { 0.0, 1.0 };
        layout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0 };
        contentPane.setLayout(layout);
        contentPane.setBackground(new Color(241, 248, 232));

        // Mã môn học
        JLabel lblMaMonHoc = new JLabel("Mã môn học:");
        lblMaMonHoc.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_lblMaMonHoc = new GridBagConstraints();
        gbc_lblMaMonHoc.anchor = GridBagConstraints.WEST;
        gbc_lblMaMonHoc.insets = new Insets(10, 10, 10, 10);
        gbc_lblMaMonHoc.gridx = 0;
        gbc_lblMaMonHoc.gridy = 0;
        contentPane.add(lblMaMonHoc, gbc_lblMaMonHoc);

        JTextField txtMaMonHoc = new JTextField(a);

//         JTextField txtMaMonHoc = new JTextField("IT001");

        txtMaMonHoc.setBorder(null);
        txtMaMonHoc.setFocusable(false);
        txtMaMonHoc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtMaMonHoc.setEditable(false); 
        txtMaMonHoc.setBackground(new Color(241, 248, 232));
        GridBagConstraints gbc_txtMaMonHoc = new GridBagConstraints();
        gbc_txtMaMonHoc.anchor = GridBagConstraints.WEST;
        gbc_txtMaMonHoc.insets = new Insets(10, 10, 10, 10);
        gbc_txtMaMonHoc.gridx = 1;
        gbc_txtMaMonHoc.gridy = 0;
        contentPane.add(txtMaMonHoc, gbc_txtMaMonHoc);

        // Tên môn học
        JLabel lblTenMonHoc = new JLabel("Tên môn học:");
        lblTenMonHoc.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_lblTenMonHoc = new GridBagConstraints();
        gbc_lblTenMonHoc.anchor = GridBagConstraints.WEST;
        gbc_lblTenMonHoc.insets = new Insets(10, 10, 10, 10);
        gbc_lblTenMonHoc.gridx = 0;
        gbc_lblTenMonHoc.gridy = 1;
        contentPane.add(lblTenMonHoc, gbc_lblTenMonHoc);

        JTextField txtTenMonHoc = new JTextField(b);

//         JTextField txtTenMonHoc = new JTextField("Lập trình Java");
        txtTenMonHoc.setBorder(null);
        txtTenMonHoc.setFocusable(false);
        txtTenMonHoc.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtTenMonHoc.setEditable(false); 
        txtTenMonHoc.setBackground(new Color(241, 248, 232));
        GridBagConstraints gbc_txtTenMonHoc = new GridBagConstraints();
        gbc_txtTenMonHoc.anchor = GridBagConstraints.WEST;
        gbc_txtTenMonHoc.insets = new Insets(10, 10, 10, 10);
        gbc_txtTenMonHoc.gridx = 1;
        gbc_txtTenMonHoc.gridy = 1;
        contentPane.add(txtTenMonHoc, gbc_txtTenMonHoc);

        // Số tín chỉ
        JLabel lblSoTinChi = new JLabel("Số tín chỉ:");
        lblSoTinChi.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_lblSoTinChi = new GridBagConstraints();
        gbc_lblSoTinChi.anchor = GridBagConstraints.WEST;
        gbc_lblSoTinChi.insets = new Insets(10, 10, 10, 10);
        gbc_lblSoTinChi.gridx = 0;
        gbc_lblSoTinChi.gridy = 2;
        contentPane.add(lblSoTinChi, gbc_lblSoTinChi);


        JTextField txtSoTinChi = new JTextField(c);

//         JTextField txtSoTinChi = new JTextField("3");

        txtSoTinChi.setBorder(null);
        txtSoTinChi.setFocusable(false);
        txtSoTinChi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtSoTinChi.setEditable(false);
        txtSoTinChi.setBackground(new Color(241, 248, 232));
        GridBagConstraints gbc_txtSoTinChi = new GridBagConstraints();
        gbc_txtSoTinChi.anchor = GridBagConstraints.WEST;
        gbc_txtSoTinChi.insets = new Insets(10, 10, 10, 10);
        gbc_txtSoTinChi.gridx = 1;
        gbc_txtSoTinChi.gridy = 2;
        contentPane.add(txtSoTinChi, gbc_txtSoTinChi);

        // Mô tả chi tiết
        JLabel lblMoTaChiTiet = new JLabel("Mô tả chi tiết:");
        lblMoTaChiTiet.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_lblMoTaChiTiet = new GridBagConstraints();
        gbc_lblMoTaChiTiet.anchor = GridBagConstraints.WEST;
        gbc_lblMoTaChiTiet.insets = new Insets(10, 10, 10, 10);
        gbc_lblMoTaChiTiet.gridx = 0;
        gbc_lblMoTaChiTiet.gridy = 3;
        contentPane.add(lblMoTaChiTiet, gbc_lblMoTaChiTiet);

        JTextArea txtMoTaChiTiet = new JTextArea(d);

//         JTextArea txtMoTaChiTiet = new JTextArea("Môn học giới thiệu về lập trình hướng đối tượng với ngôn ngữ Java.");

        txtMoTaChiTiet.setFocusable(false);
        txtMoTaChiTiet.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtMoTaChiTiet.setLineWrap(true);
        txtMoTaChiTiet.setWrapStyleWord(true);
        txtMoTaChiTiet.setEditable(false);
        txtMoTaChiTiet.setBackground(new Color(241, 248, 232));
        txtMoTaChiTiet.setBorder(null);
        GridBagConstraints gbc_txtMoTaChiTiet = new GridBagConstraints();
        gbc_txtMoTaChiTiet.insets = new Insets(10, 10, 10, 10);
        gbc_txtMoTaChiTiet.fill = GridBagConstraints.BOTH;
        gbc_txtMoTaChiTiet.gridx = 1;
        gbc_txtMoTaChiTiet.gridy = 3;
        contentPane.add(txtMoTaChiTiet, gbc_txtMoTaChiTiet);
    

}
}

