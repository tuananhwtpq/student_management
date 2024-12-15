package UserUI;


import Data.Subject;
import dataManaging.SubjectManaging;


import java.awt.BorderLayout;
import java.awt.Color;
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

import java.util.ArrayList;



import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SchoolFeeWatcher extends JPanel {
	private JTable table;
	
	public SchoolFeeWatcher() {
		
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
        content_header.setLayout(null);
        GridBagConstraints gbc_content_header = new GridBagConstraints();
        gbc_content_header.insets = new Insets(0, 0, 5, 0);
        gbc_content_header.fill = GridBagConstraints.BOTH;
        gbc_content_header.gridx = 0;
        gbc_content_header.gridy = 0;
        content.add(content_header, gbc_content_header);
        
        JPanel header_left = new JPanel();
        header_left.setBounds(0, 0, 1054, 80);
        header_left.setBackground(new Color(241, 248, 232));
        header_left.setLayout(null);
        content_header.add(header_left);
        
        JButton btnThanhToan = new JButton("Thanh toán");
        btnThanhToan.setBounds(432, 9, 160, 60);
        btnThanhToan.setForeground(new Color(0, 0, 0));
        btnThanhToan.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnThanhToan.setBackground(new Color(85, 173, 155));
        header_left.add(btnThanhToan);
        
        JLabel lblNewLabel = new JLabel("Số tiền còn nợ:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(43, 10, 137, 60);
        header_left.add(lblNewLabel);
        
        double tongtien = sm.selecttonghocphi(sm.selecthocphi());
        String tong = String.valueOf(tongtien);
        txtTongTien = new JTextField();
        txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtTongTien.setText(tong);
        txtTongTien.setBounds(202, 10, 233, 60);
        header_left.add(txtTongTien);
        txtTongTien.setBorder(null);  
        txtTongTien.setBackground(new Color(241, 248, 232));
        txtTongTien.setColumns(10);
        
        
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
        	    new Object[][] {

        	    },
        	    new String[] {
        	        "STT", "Mã môn học", "Tên môn học", "Số tiền cần thanh toán"
        	    }
        	) {
        	    @Override
        	    public boolean isCellEditable(int row, int column) {
        	        return false; 
        	    }
        	});
        btnThanhToan.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
        	if(e.getClickCount() == 1) {
                    int selectedRow = table.getSelectedRow();
                    if(selectedRow != -1) {
                        String hocphi = table.getValueAt(selectedRow, 3).toString();
                        double hocphimon = Double.parseDouble(hocphi);
        		int check = sm.thanhtoanhocphi(selectedRow);
        		EventQueue.invokeLater(() ->{
                            if(check == 1){
                                JOptionPane.showMessageDialog(null, "Tài khoản không đủ tiền!");
                            }else if(check == 2){
                                double tongtien = sm.selecttonghocphi(sm.selecthocphi());
                                String tong = String.valueOf(tongtien);
                                txtTongTien.setText(tong);
                                JOptionPane.showMessageDialog(null, "Bạn đã thanh toán thành công!");
                                ViewTable();
                            }else if(check == 3){
                                JOptionPane.showMessageDialog(null, "Thanh toán thất bại!");
                            }
        		});
                    }
        	}
        	super.mouseClicked(e);
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
        					
        				});
        			}
        		}
        		
        		
        		super.mouseClicked(e);
        	}
        	
		});

        main.setViewportView(table);
        ViewTable();
    }
	SubjectManaging sm = new SubjectManaging();
        ArrayList<Subject> dsO = new ArrayList();
        private JTextField txtTongTien;
	public void ViewTable(){
            this.dsO = sm.selecthocphi();
            DefaultTableModel model = (DefaultTableModel) this.table.getModel();
            model.setNumRows(0);
            int n = 1;
            for(Subject o:dsO){
                model.addRow(new Object[] {n, o.getMaMon(), o.getTenMon(), o.getHocPhi()});
                n++;
            }
        }
        public void ViewTablecon(ArrayList<Subject> dss){
            DefaultTableModel model = (DefaultTableModel) this.table.getModel();
            model.setNumRows(0);
            int n = 1;
            for(Subject s:dss){
                model.addRow(new Object[] {n, s.getMaMon(), s.getTenMon(), s.getHocPhi()});
            }
        }

        //main.setViewportView(table);
		
}
	
	//public void handleSearch() {
		
	


