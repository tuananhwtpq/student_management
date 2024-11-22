package UserUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

import UI.ManageAllStudent;

public class SubjectWatcher extends JPanel {

	private JTextField txtSearch;
	private JComboBox searchOptions;
	private JTable table;
	
	public SubjectWatcher() {
		
        setBounds(100, 100, 1530, 1017);
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        
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
        searchOptions.setModel(new DefaultComboBoxModel(new String[] {"Mã môn học", "Tên môn học", ""}));
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
        
        
        JScrollPane main = new JScrollPane();
        main.setBackground(new Color(216, 239, 211));
        GridBagConstraints gbc_main = new GridBagConstraints();
        gbc_main.fill = GridBagConstraints.BOTH;
        gbc_main.gridx = 0;
        gbc_main.gridy = 1;
        content.add(main, gbc_main);
        
        table = new JTable();
        //Add listener
        
        table.setRowHeight(30);
        table.setSelectionBackground(new Color(149, 240, 179));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"STT", "Mã môn học", "Tên môn học", "Số tín chỉ", "Mô tả"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
        table.addMouseListener( new MouseAdapter() {
        	
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// TODO Auto-generated method stub
        		if(e.getClickCount() == 2) {
        			int selectedRow = table.getSelectedRow();
        			if(selectedRow != -1) {
        				String subjectName = table.getValueAt(selectedRow, 2).toString();
        				
        				EventQueue.invokeLater(() ->{
        					new SubjectTable(subjectName).setVisible(true);
        				});
        			}
        		}
        		
        		
        		super.mouseClicked(e);
        	}
        	
		});
        
        //Thử nghiệm
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[] {1, "IT0098", "Lập trình Java",1, "Học kỳ 1"});
        model.addRow(new Object[] {2,"IT7823","Cấu trúc dữ liệu",2, "Học kỳ 2"});
        model.addRow(new Object[] {3,"iT88263","Hệ điều hành",4, "Học kỳ 3"});
        
        main.setViewportView(table);
        
	}
	
	private void handleSearch() {
		
	}
	
}
