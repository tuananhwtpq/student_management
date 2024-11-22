package UserUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class ScoreTable extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDiemTX1;
	private JTextField txtCuoiKy;
	private JTextField txtDiemTX2;
	private JTextField txtDiemGiuaKy;
	private JTextField txtTongKet;

	private JEditorPane txtMoTa;
	
	public ScoreTable(String subjectName) {
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{260, 0, 0};
		gbl_contentPane.rowHeights = new int[]{348, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel content = new JPanel();
		content.setBackground(new Color(241, 248, 232));
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.insets = new Insets(10, 10, 10, 10);
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.gridx = 1;
		gbc_content.gridy = 0;
		contentPane.add(content, gbc_content);
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[]{0, 171, 0, 228, 0};
		gbl_content.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_content.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_content.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		content.setLayout(gbl_content);
		
		JLabel lblId = new JLabel("Điểm TX1:");
		lblId.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.CENTER;
		gbc_lblId.insets = new Insets(10, 10, 10, 10);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		content.add(lblId, gbc_lblId);
		
		txtDiemTX1 = new JTextField();
		txtDiemTX1.setBackground(new Color(241, 248, 232));
		txtDiemTX1.setBorder(null);
		txtDiemTX1.setText("Xin chào");
		txtDiemTX1.setEditable(false);
		txtDiemTX1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtDiemTX1 = new GridBagConstraints();
		gbc_txtDiemTX1.anchor = GridBagConstraints.WEST;
		gbc_txtDiemTX1.insets = new Insets(10, 10, 10, 10);
		gbc_txtDiemTX1.gridx = 1;
		gbc_txtDiemTX1.gridy = 0;
		content.add(txtDiemTX1, gbc_txtDiemTX1);
		txtDiemTX1.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Điểm TX2:");
		lblAuthor.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
		gbc_lblAuthor.anchor = GridBagConstraints.WEST;
		gbc_lblAuthor.insets = new Insets(10, 10, 10, 10);
		gbc_lblAuthor.gridx = 0;
		gbc_lblAuthor.gridy = 1;
		content.add(lblAuthor, gbc_lblAuthor);
		
		txtDiemTX2 = new JTextField();
		txtDiemTX2.setBackground(new Color(241, 248, 232));
		txtDiemTX2.setText("Xin chào");
		txtDiemTX2.setBorder(null);
		txtDiemTX2.setEditable(false);
		txtDiemTX2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtDiemTX2.setColumns(10);
		GridBagConstraints gbc_txtDiemTX2 = new GridBagConstraints();
		gbc_txtDiemTX2.insets = new Insets(10, 10, 10, 10);
		gbc_txtDiemTX2.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiemTX2.gridx = 1;
		gbc_txtDiemTX2.gridy = 1;
		content.add(txtDiemTX2, gbc_txtDiemTX2);
		
		JLabel lblPrice = new JLabel("Giữa kỳ:");
		lblPrice.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.anchor = GridBagConstraints.WEST;
		gbc_lblPrice.insets = new Insets(10, 10, 10, 10);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 2;
		content.add(lblPrice, gbc_lblPrice);
		
		txtDiemGiuaKy = new JTextField();
		txtDiemGiuaKy.setBackground(new Color(241, 248, 232));
		txtDiemGiuaKy.setText("Xin chào");
		txtDiemGiuaKy.setBorder(null);
		txtDiemGiuaKy.setEditable(false);
		txtDiemGiuaKy.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtDiemGiuaKy.setColumns(10);
		GridBagConstraints gbc_txtDiemGiuaKy = new GridBagConstraints();
		gbc_txtDiemGiuaKy.insets = new Insets(10, 10, 10, 10);
		gbc_txtDiemGiuaKy.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiemGiuaKy.gridx = 1;
		gbc_txtDiemGiuaKy.gridy = 2;
		content.add(txtDiemGiuaKy, gbc_txtDiemGiuaKy);
		
		JLabel lblName = new JLabel("Cuối kỳ:");
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(10, 10, 10, 10);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 3;
		content.add(lblName, gbc_lblName);
		
		txtCuoiKy = new JTextField();
		txtCuoiKy.setBackground(new Color(241, 248, 232));
		txtCuoiKy.setText("Xin chào");
		txtCuoiKy.setBorder(null);
		txtCuoiKy.setEditable(false);
		txtCuoiKy.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		GridBagConstraints gbc_txtCuoiKy = new GridBagConstraints();
		gbc_txtCuoiKy.insets = new Insets(10, 10, 10, 10);
		gbc_txtCuoiKy.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCuoiKy.gridx = 1;
		gbc_txtCuoiKy.gridy = 3;
		content.add(txtCuoiKy, gbc_txtCuoiKy);
		txtCuoiKy.setColumns(10);
		
		JLabel lblCategories = new JLabel("Tổng kết:");
		lblCategories.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblCategories = new GridBagConstraints();
		gbc_lblCategories.anchor = GridBagConstraints.WEST;
		gbc_lblCategories.insets = new Insets(10, 10, 10, 10);
		gbc_lblCategories.gridx = 0;
		gbc_lblCategories.gridy = 4;
		content.add(lblCategories, gbc_lblCategories);
		
		txtTongKet = new JTextField();
		txtTongKet.setBackground(new Color(241, 248, 232));
		txtTongKet.setText("Xin chào");
		txtTongKet.setBorder(null);
		txtTongKet.setEditable(false);
		txtTongKet.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtTongKet.setColumns(10);
		GridBagConstraints gbc_txtTongKet = new GridBagConstraints();
		gbc_txtTongKet.insets = new Insets(10, 10, 10, 10);
		gbc_txtTongKet.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTongKet.gridx = 1;
		gbc_txtTongKet.gridy = 4;
		content.add(txtTongKet, gbc_txtTongKet);
		
		JLabel lblDiscripstion = new JLabel("Đánh giá:");
		lblDiscripstion.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_lblDiscripstion = new GridBagConstraints();
		gbc_lblDiscripstion.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDiscripstion.insets = new Insets(10, 10, 10, 10);
		gbc_lblDiscripstion.gridx = 0;
		gbc_lblDiscripstion.gridy = 5;
		content.add(lblDiscripstion, gbc_lblDiscripstion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(200, 2));
		scrollPane.setBorder(null);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(10, 10, 10, 10);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		content.add(scrollPane, gbc_scrollPane);
		
		txtMoTa = new JEditorPane();
		txtMoTa.setPreferredSize(new Dimension(200, 20));
		txtMoTa.setMargin(new Insets(10, 10, 10, 10));
		txtMoTa.setBackground(new Color(241, 248, 232));
		txtMoTa.setBorder(null);
		txtMoTa.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMoTa.setText("Xin chào");
		scrollPane.setViewportView(txtMoTa);
		txtMoTa.setEditable(false);

	}
	
	public static void main(String[] args) {
		ScoreTable scoreTable = new ScoreTable("Java");
		scoreTable.setVisible(true);
	}
}
