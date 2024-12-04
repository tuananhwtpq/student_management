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
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class ManageAllStudent extends JPanel {
	
	private JTextField txtSearch;
	private JComboBox searchOptions;
	private JTable table;

	public ManageAllStudent() {
		
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

        JLabel lblHeader = new JLabel("Danh sách sinh viên");
        lblHeader.setBorder(new EmptyBorder(0, 20, 0, 0));
        lblHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 54));
        header.add(lblHeader);
        
        JPanel content = new JPanel();
        content.setBackground(new Color(241, 248, 232));
        add(content, BorderLayout.CENTER);
        GridBagLayout gbl_content = new GridBagLayout();
        gbl_content.columnWidths = new int[]{0, 0};
        gbl_content.rowHeights = new int[]{0, 0, 0};
        gbl_content.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_content.rowWeights = new double[]{0, 1.0, Double.MIN_VALUE};
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
        gbl_content_header.columnWidths = new int[]{763, 0, 0};
        gbl_content_header.rowHeights = new int[]{0, 0};
        gbl_content_header.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_content_header.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
        gbl_header_left.columnWidths = new int[]{350, 124, 124, 0};
        gbl_header_left.rowHeights = new int[]{60, 0};
        gbl_header_left.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_header_left.rowWeights = new double[]{1.0, Double.MIN_VALUE};
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
        searchOptions.setModel(new DefaultComboBoxModel(new String[] {"ID", "Họ tên", "Lớp", "Ngành"}));
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
        gbl_header_right.columnWidths = new int[]{114, 114, 114, 0};
        gbl_header_right.rowHeights = new int[]{60, 0};
        gbl_header_right.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_header_right.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        header_right.setLayout(gbl_header_right);
        
        //BTN ADD
        
        JButton btnAdd = new JButton("");
        btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAdd.setIcon(new ImageIcon(ManageAllStudent.class.getResource("/Imgs/add.png")));
        //Add listener
        btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddStudent addStudent = new AddStudent();
				addStudent.setVisible(true);
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
        
        //BTN EDIT
        
        JButton btnEdit = new JButton("");
        btnEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnEdit.setIcon(new ImageIcon(ManageAllStudent.class.getResource("/Imgs/editing.png")));
        //Add Listener
        
        btnEdit.setBackground(new Color(85, 173, 155));
        btnEdit.setFont(new Font("Segoe UI", Font.BOLD, 18));
        GridBagConstraints gbc_btnEdit = new GridBagConstraints();
        gbc_btnEdit.fill = GridBagConstraints.BOTH;
        gbc_btnEdit.insets = new Insets(0, 0, 0, 20);
        gbc_btnEdit.gridx = 1;
        gbc_btnEdit.gridy = 0;
        header_right.add(btnEdit, gbc_btnEdit);
        
        //BTN delete
        
        JButton btnDel = new JButton("");
        btnDel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDel.setIcon(new ImageIcon(ManageAllStudent.class.getResource("/Imgs/trash-bin.png")));
        //Add listener
        
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
        //Add listener
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { 
                    int row = table.getSelectedRow(); 
                    
                    String studentId = table.getValueAt(row, 0).toString();
                    String fullName = table.getValueAt(row, 1).toString();
                    String birthDate = table.getValueAt(row, 2).toString();
                    String className = table.getValueAt(row, 3).toString();
                    String major = table.getValueAt(row, 4).toString();
                    String address = table.getValueAt(row, 5).toString();
                    String email = table.getValueAt(row, 6).toString();
                    String phoneNumber = table.getValueAt(row, 7).toString();
                    
                    StudentView studentView = new StudentView(studentId, fullName, birthDate, className, major, address, email, phoneNumber);
                    studentView.setVisible(true); // Hiển thị StudentView
                }
            }
        });
        
        table.setRowHeight(30);
        table.setSelectionBackground(new Color(149, 240, 179));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"ID", "H\u1ECD t\u00EAn", "Ng\u00E0y sinh", "L\u1EDBp", "Ng\u00E0nh", "\u0110\u1ECBa ch\u1EC9", "Email", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
        	}
        	)
        	
        	{
        	    @Override
        	    public boolean isCellEditable(int row, int column) {
        	        return false; 
        	    }
        	}
        );
        
        // Thử nghiệm
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{"SV001", "Nguyễn Văn A", "2001-05-15", "KTPM01", "Công nghệ thông tin", "Hà Nội", "nguyenvana@gmail.com", "0123456789"});
        model.addRow(new Object[]{"SV002", "Trần Thị B", "2002-03-10", "KTPM02", "Kế toán", "Đà Nẵng", "tranthib@gmail.com", "0987654321"});
        model.addRow(new Object[]{"SV003", "Lê Văn C", "2000-07-22", "KTPM03", "Quản trị kinh doanh", "Hồ Chí Minh", "levanc@gmail.com", "0912345678"});
        model.addRow(new Object[]{"SV004", "Phạm Thị D", "2001-09-05", "KTPM04", "Ngôn ngữ Anh", "Cần Thơ", "phamthid@gmail.com", "0945678123"});
        model.addRow(new Object[]{"SV005", "Hoàng Văn E", "1999-12-15", "KTPM05", "Khoa học dữ liệu", "Hải Phòng", "hoangvane@gmail.com", "0965432178"});
        
        main.setViewportView(table);
        
	}
	
	private void handleSearch() {
		
	}
	
}
