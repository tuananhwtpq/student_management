package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import AccessDatabase.JDBCUtil;
import Data.LopHocPhan;
import Data.Student;
import Data.Subject;
import dataManaging.LopHocPhanManaging;
import dataManaging.StudentManaging;

public class ManageClassroom extends JPanel {

	private JTextField txtSearch;
	private JComboBox searchOptions;
	private JTable table;

	public ManageClassroom() {

		setBounds(100, 100, 1530, 1017);
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		// Tạo header panel
		JPanel header = new JPanel();
		header.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(85, 173, 155)));
		header.setBackground(new Color(241, 248, 232));
		header.setPreferredSize(new Dimension(1810, 100));
		add(header, BorderLayout.NORTH);
		header.setLayout(new BorderLayout(0, 0));

		JLabel lblHeader = new JLabel("Danh sách lớp học\r\n");
		lblHeader.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 54));
		header.add(lblHeader);

		JPanel content = new JPanel();
		content.setBackground(new Color(241, 248, 232));
		add(content, BorderLayout.CENTER);
		GridBagLayout gbl_content = new GridBagLayout();
		gbl_content.columnWidths = new int[] { 0, 0 };
		gbl_content.rowHeights = new int[] { 0, 0, 0 };
		gbl_content.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_content.rowWeights = new double[] { 0, 1.0, Double.MIN_VALUE };
		content.setLayout(gbl_content);

		JPanel content_header = new JPanel();
		content_header.setPreferredSize(new Dimension(10, 80));
		content_header.setBackground(new Color(241, 248, 232));
		GridBagConstraints gbc_content_header = new GridBagConstraints();
		gbc_content_header.insets = new Insets(0, 0, 5, 0);
		gbc_content_header.fill = GridBagConstraints.BOTH;
		gbc_content_header.gridx = 0;
		gbc_content_header.gridy = 0;
		content.add(content_header, gbc_content_header);
		GridBagLayout gbl_content_header = new GridBagLayout();
		gbl_content_header.columnWidths = new int[] { 763, 0, 0 };
		gbl_content_header.rowHeights = new int[] { 0, 0 };
		gbl_content_header.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_content_header.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		content_header.setLayout(gbl_content_header);

		JPanel header_left = new JPanel();
		header_left.setBackground(new Color(241, 248, 232));
		GridBagConstraints gbc_header_left = new GridBagConstraints();
		gbc_header_left.insets = new Insets(0, 0, 0, 5);
		gbc_header_left.fill = GridBagConstraints.BOTH;
		gbc_header_left.gridx = 0;
		gbc_header_left.gridy = 0;
		content_header.add(header_left, gbc_header_left);
		GridBagLayout gbl_header_left = new GridBagLayout();
		gbl_header_left.columnWidths = new int[] { 350, 124, 124, 0 };
		gbl_header_left.rowHeights = new int[] { 60, 0 };
		gbl_header_left.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_header_left.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		header_left.setLayout(gbl_header_left);

		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSearch.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_txtSearch = new GridBagConstraints();
		gbc_txtSearch.fill = GridBagConstraints.BOTH;
		gbc_txtSearch.insets = new Insets(10, 10, 10, 10);
		gbc_txtSearch.gridx = 0;
		gbc_txtSearch.gridy = 0;
		header_left.add(txtSearch, gbc_txtSearch);
		txtSearch.setColumns(10);

		txtSearch.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				handleSearch();

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				handleSearch();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				handleSearch();

			}
		});

		searchOptions = new JComboBox();
		searchOptions.setForeground(new Color(0, 0, 0));
		searchOptions.setFont(new Font("Tahoma", Font.BOLD, 18));
		searchOptions.setModel(new DefaultComboBoxModel(new String[] { "Mã lớp", "Tên lớp", "Giảng viên phụ trách" }));
		searchOptions.setBackground(new Color(85, 173, 155));
		GridBagConstraints gbc_searchOptions = new GridBagConstraints();
		gbc_searchOptions.fill = GridBagConstraints.BOTH;
		gbc_searchOptions.insets = new Insets(10, 10, 10, 10);
		gbc_searchOptions.gridx = 1;
		gbc_searchOptions.gridy = 0;
		header_left.add(searchOptions, gbc_searchOptions);

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setForeground(new Color(0, 0, 0));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleSearch();
			}
		});
		btnSearch.setFont(new Font("Segoe UI", Font.BOLD, 18));
		btnSearch.setBackground(new Color(85, 173, 155));
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(10, 10, 10, 10);
		gbc_btnSearch.fill = GridBagConstraints.BOTH;
		gbc_btnSearch.gridx = 2;
		gbc_btnSearch.gridy = 0;
		header_left.add(btnSearch, gbc_btnSearch);

		JPanel header_right = new JPanel();
		header_right.setBackground(new Color(241, 248, 232));
		GridBagConstraints gbc_header_right = new GridBagConstraints();
		gbc_header_right.insets = new Insets(10, 10, 10, 10);
		gbc_header_right.anchor = GridBagConstraints.EAST;
		gbc_header_right.fill = GridBagConstraints.VERTICAL;
		gbc_header_right.gridx = 1;
		gbc_header_right.gridy = 0;
		content_header.add(header_right, gbc_header_right);
		GridBagLayout gbl_header_right = new GridBagLayout();
		gbl_header_right.columnWidths = new int[] { 114, 114, 114, 0 };
		gbl_header_right.rowHeights = new int[] { 60, 0 };
		gbl_header_right.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_header_right.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		header_right.setLayout(gbl_header_right);

		// BTN ADD

		JButton btnAdd = new JButton("");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setIcon(new ImageIcon(ManageAllStudent.class.getResource("/Imgs/add.png")));
		// Add listener
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddClassroom addClassroom = new AddClassroom();
				addClassroom.setVisible(true);
			}
		});

		btnAdd.setBackground(new Color(85, 173, 155));
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.BOTH;
		gbc_btnAdd.insets = new Insets(0, 0, 0, 20);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 0;
		header_right.add(btnAdd, gbc_btnAdd);

		// BTN EDIT

		JButton btnEdit = new JButton("");
		btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEdit.setIcon(new ImageIcon(ManageAllStudent.class.getResource("/Imgs/editing.png")));
		// Add Listener
		btnEdit.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	int selectedRow = table.getSelectedRow(); // Lấy dòng đang chọn
		        if (selectedRow == -1) { // Nếu không có dòng nào được chọn
		        	JOptionPane.showMessageDialog(null, "Vui lòng chọn một lớp học phần để chỉnh sửa!");
		        	return;
		        }
		        
		        // Lấy dữ liệu từ dòng đang chọn
		        String classId = table.getValueAt(selectedRow, 0) != null ? table.getValueAt(selectedRow, 0).toString() : "";
		        String className = table.getValueAt(selectedRow, 1) != null ? table.getValueAt(selectedRow, 1).toString() : "";
		        String maGV = table.getValueAt(selectedRow, 2) != null ? table.getValueAt(selectedRow, 2).toString() : "";
		        String siSoToiDa = table.getValueAt(selectedRow, 3) != null ? table.getValueAt(selectedRow, 3).toString() : "";
		        String thoiGianBatDau = table.getValueAt(selectedRow, 4) != null ? table.getValueAt(selectedRow, 4).toString() : "";
		        String thoiGianKetThuc = table.getValueAt(selectedRow, 5) != null ? table.getValueAt(selectedRow, 5).toString() : "";

		        
		        // Khởi tạo giao diện EditStudent và truyền dữ liệu
		        EditClassroom EditClassroom = new EditClassroom(classId, className, maGV, siSoToiDa, thoiGianBatDau, thoiGianKetThuc);
		        EditClassroom.setVisible(true);
		    }
		});


		btnEdit.setBackground(new Color(85, 173, 155));
		btnEdit.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.BOTH;
		gbc_btnEdit.insets = new Insets(0, 0, 0, 20);
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 0;
		header_right.add(btnEdit, gbc_btnEdit);

		// BTN delete

		JButton btnDel = new JButton("");
		btnDel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDel.setIcon(new ImageIcon(ManageAllStudent.class.getResource("/Imgs/trash-bin.png")));
		// Add listener
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				handleDelete();
			
			}
			

		});

		btnDel.setBackground(new Color(85, 173, 155));
		btnDel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		GridBagConstraints gbc_btnDel = new GridBagConstraints();
		gbc_btnDel.fill = GridBagConstraints.BOTH;
		gbc_btnDel.gridx = 2;
		gbc_btnDel.gridy = 0;
		header_right.add(btnDel, gbc_btnDel);

		JScrollPane main = new JScrollPane();
		main.setBackground(new Color(216, 239, 211));
		GridBagConstraints gbc_main = new GridBagConstraints();
		gbc_main.fill = GridBagConstraints.BOTH;
		gbc_main.gridx = 0;
		gbc_main.gridy = 1;
		content.add(main, gbc_main);

		table = new JTable();
		// Add listener
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int row = table.getSelectedRow();

					String classroomID = table.getValueAt(row, 0).toString();
					String className = table.getValueAt(row, 1).toString();
					String teacher = table.getValueAt(row, 2).toString();
					String siSo = table.getValueAt(row, 3).toString();
					String ngayBatDau = table.getValueAt(row, 4).toString();
					String ngayKetThuc = table.getValueAt(row, 5).toString();
//                    String email = table.getValueAt(row, 6).toString();
//                    String phoneNumber = table.getValueAt(row, 7).toString();

					ClassroomView classroomView = new ClassroomView(classroomID, className, teacher, siSo, ngayBatDau,
							ngayKetThuc);
					classroomView.setVisible(true);
				}
			}
		});

		table.setRowHeight(30);
		table.setSelectionBackground(new Color(149, 240, 179));
		table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Tên lớp", "Giảng viên phụ trách",
				"Sĩ số tối đa", "Thời gian bắt đầu", "Thời gian kết thúc" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});

		main.setViewportView(table);
		dsS = sm.sellectAll(); // Lấy dữ liệu môn học từ database
		ViewTable();

	}

	ArrayList<LopHocPhan> dsS = new ArrayList();
	LopHocPhanManaging sm = new LopHocPhanManaging();

	private void handleSearch() {
		// Lấy điều kiện tìm kiếm từ ComboBox
		String selectedOption = searchOptions.getSelectedItem().toString();

		// Tạo danh sách mới để chứa kết quả lọc
		ArrayList<LopHocPhan> filteredList = new ArrayList<>();

		// Duyệt qua danh sách môn học để lọc theo điều kiện
		for (LopHocPhan lophocphan : dsS) {
			if (selectedOption.equals("Mã lớp")) {
				if (lophocphan.getMaLHP().toLowerCase().contains(txtSearch.getText().toLowerCase())) {
					filteredList.add(lophocphan);
				}
			}
			if (selectedOption.equals("Tên tên lớp")) {
				if (lophocphan.getTenLHP().toLowerCase().contains(txtSearch.getText().toLowerCase())) {
					filteredList.add(lophocphan);
				}
			}
			if (selectedOption.equals("Giảng viên phụ trách")) {
				if (lophocphan.getMaGVPhuTrach().toLowerCase().contains(txtSearch.getText().toLowerCase())) {
					filteredList.add(lophocphan);
				}
			}

		}

		// Cập nhật bảng với danh sách đã lọc
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Xóa dữ liệu cũ

		for (LopHocPhan s : filteredList) {
			Object[] rowData = { s.getMaMon(), s.getTenLHP(), s.getMaGVPhuTrach(), s.getSiSoToiDa(),
					s.getThoiGianBatDau(), s.getThoiGianKetThuc() };
			model.addRow(rowData);
		}

		// Nếu không có kết quả, hiển thị thông báo
		if (filteredList.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả phù hợp!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void ViewTable() {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);

	    // Thêm dữ liệu từ dsS (ArrayList<Subject>) vào bảng
	    for (LopHocPhan subject : dsS) {
	        // Debug dữ liệu xem có đúng không
	        Object[] rowData = {
	            subject.getMaLHP(),
	            subject.getTenLHP(),
	            subject.getMaGVPhuTrach(),
	            subject.getSiSoToiDa(),
	            subject.getThoiGianBatDau(),
	            subject.getThoiGianKetThuc()
	        };
	        model.addRow(rowData);
	    }
	}

	public void handleDelete() {
		int selectedRow = table.getSelectedRow(); // Lấy dòng đang chọn trên bảng
		if (selectedRow == -1) { // Nếu không có dòng nào được chọn
			JOptionPane.showMessageDialog(null, "Vui lòng chọn một lớp học để xóa!");
			return;
		}

		// Lấy mã môn học từ dòng đang chọn
		String classId = table.getValueAt(selectedRow, 0).toString();

		// Xác nhận xóa
		int confirm = JOptionPane.showConfirmDialog(null,
				"Bạn có chắc chắn muốn xóa môn học có mã: " + classId + " không?", "Xác nhận xóa",
				JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {
			// Kết nối cơ sở dữ liệu và thực hiện xóa
			String sql = "DELETE FROM LopHocPhan WHERE MaLHP = ?";

			try (Connection connection = JDBCUtil.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

				preparedStatement.setString(1, classId);

				int rowsAffected = preparedStatement.executeUpdate();

				if (rowsAffected > 0) {
					JOptionPane.showMessageDialog(null, "Xóa thành công!");

					// Cập nhật lại bảng sau khi xóa
					dsS = sm.sellectAll(); // Lấy lại danh sách môn học sau khi xóa
					ViewTable(); // Hiển thị lại bảng
				} else {
					JOptionPane.showMessageDialog(null, "Không tìm thấy môn học cần xóa!");
				}
			} catch (SQLException e1) {
				// Kiểm tra ràng buộc khóa ngoại
				if (e1.getErrorCode() == 1451 || e1.getMessage().contains("foreign key constraint")) {
					JOptionPane.showMessageDialog(null,
							"Không thể xóa lớp học này vì nó đang được tham chiếu ở bảng khác!",
							"Lỗi ràng buộc", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi xóa lớp học: " + e1.getMessage(),
							"Lỗi", JOptionPane.ERROR_MESSAGE);
				}
				e1.printStackTrace();

			}
		}
	}

}
