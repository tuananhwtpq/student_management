	package UserUI;
	


import Data.LopHocPhan;
import Data.Subject;
import UI.Login;
import dataManaging.LopHocPhanManaging;
import dataManaging.SubjectManaging;

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.Insets;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;

	
// 	import javax.swing.JFrame;
// 	import javax.swing.JLabel;

        import java.util.ArrayList;
	
	import javax.swing.JFrame;
	import javax.swing.JLabel;
import javax.swing.JOptionPane;

	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;
	
	public class RegistrationInfor extends JFrame {

		
// 		private JTable table;
	
// 		public RegistrationInfor(String subjectName) {
// 			setBounds(100, 100, 1000, 600);
// 	        getContentPane().setLayout(new BorderLayout());
// 	        setBackground(Color.WHITE);
	        
// 	        setTitle("Đăng ký môn " + subjectName);

            
            private JTable table;
            
            public RegistrationInfor(String x) {
                SubjectManaging sm = new SubjectManaging();
                Subject subject = sm.selectSubjectbyID(x);
                LopHocPhanManaging lhp = new LopHocPhanManaging();
                ArrayList<LopHocPhan> dsLHP = lhp.selectbyID(x);
                Login login = new Login();
                Registration regis = new Registration();
                
                
                setBounds(100, 100, 1000, 600);
	        getContentPane().setLayout(new BorderLayout());
	        setBackground(Color.WHITE);
                
                setTitle("Đăng ký môn " + subject.getTenMon());

	        setLocationRelativeTo(null);
	        
	        JPanel content = new JPanel();
	        content.setBackground(new Color(241, 248, 232));
	        getContentPane().add(content, BorderLayout.CENTER);
	        GridBagLayout gbl_content = new GridBagLayout();
	        gbl_content.columnWidths = new int[]{0, 0};
	        gbl_content.rowHeights = new int[]{0, 0, 0,};
	        gbl_content.columnWeights = new double[]{1.0, Double.MIN_VALUE};
	        gbl_content.rowWeights = new double[]{0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
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

	        
// 	        JLabel lblNewLabel = new JLabel("Đăng ký môn " + subjectName);

                
                JLabel lblNewLabel = new JLabel("Đăng ký môn " + subject.getTenMon());

	        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
	        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	        gbc_lblNewLabel.gridwidth = 2;
	        gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
	        gbc_lblNewLabel.gridx = 0;
	        gbc_lblNewLabel.gridy = 0;
	        header_left.add(lblNewLabel, gbc_lblNewLabel);
	        
	        JScrollPane main = new JScrollPane();
	        main.setBackground(new Color(216, 239, 211));
	        GridBagConstraints gbc_main = new GridBagConstraints();
	        gbc_main.insets = new Insets(0, 0, 5, 0);
	        gbc_main.fill = GridBagConstraints.BOTH;
	        gbc_main.gridx = 0;
	        gbc_main.gridy = 1;
	        content.add(main, gbc_main);
	        
	        table = new JTable();
	        //Add listener
	        
	        table.setRowHeight(40);
	        table.setSelectionBackground(new Color(149, 240, 179));
	        table.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	        table.setModel(new DefaultTableModel(
	        	    new Object[][] {
	
	        	    },
	        	    new String[] {

// 	        	        "STT", "Mã học phần", "Tên học phần", "Giảng viên giảng dạy", "Thời gian học", "Đăng ký"

	        	        "STT", "Mã lớp học phân", "Tên lớp học phần", "Giảng viên giảng dạy", "Thời gian học", "Số lượng sinh viên đăng ký", "Số lượng tối đa", "Đăng ký"

	        	    }
	        	) {
	        	    @Override
	        	    public boolean isCellEditable(int row, int column) {

// 	        	    	return column == 5; 
// 	        	    }
// 	        	});
	        
// 	        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
// 	        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(table));
// 	        table.getColumnModel().getColumn(5).setMinWidth(120); 

	        	    	return column == 7; 
	        	    }
	        	});
                int index = table.getSelectedRow();
                int m = 1;
                LopHocPhan ll = new LopHocPhan();
	        
	        table.getColumnModel().getColumn(7).setMinWidth(120); 


	        table.getColumnModel().getColumn(0).setPreferredWidth(50);  
	        table.getColumnModel().getColumn(1).setPreferredWidth(100); 
	        table.getColumnModel().getColumn(2).setPreferredWidth(200); 
	        table.getColumnModel().getColumn(3).setPreferredWidth(150); 
	        table.getColumnModel().getColumn(4).setPreferredWidth(200); 

// 	        table.getColumnModel().getColumn(5).setPreferredWidth(120); 


	        table.getColumnModel().getColumn(7).setPreferredWidth(120); 
                
                

	
	        
	        table.addMouseListener( new MouseAdapter() {
	        	
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		// TODO Auto-generated method stub
	        		if(e.getClickCount() == 2) {
	        			int selectedRow = table.getSelectedRow();
	        			if(selectedRow != -1) {
	        				String subjectName = table.getValueAt(selectedRow, 2).toString();

	        				
// 	        				EventQueue.invokeLater(() ->{
	   

	        				ll.setMaLHP((String) table.getValueAt(selectedRow, 1));
                				ll.setTenLHP((String) table.getValueAt(selectedRow, 2));
                				ll.setSiSoToiDa((int) table.getValueAt(selectedRow, 6));
                				ll.setThoiGianBatDau( table.getValueAt(selectedRow, 0).toString());
                				ll.setThoiGianKetThuc(table.getValueAt(selectedRow, 0).toString());
                				ll.setMaMon(regis.getsubjectID());
                				ll.setMaGVPhuTrach(table.getValueAt(selectedRow, 3).toString());
                				ll.setSoLuongSinhVien((int) table.getValueAt(selectedRow, 5));
                                                ll.setTiet(table.getValueAt(selectedRow, 4).toString());
	        				EventQueue.invokeLater(() ->{
                                                     if (selectedRow >= 0) {
                                                         int confirm = JOptionPane.showConfirmDialog(null, "Đăng ký môn học này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                                                         if (confirm == JOptionPane.YES_OPTION) {
                                                             // Kiểm tra điều kiện đăng ký môn học
                                                             int x = new LopHocPhanManaging().checkdangkilop(ll);
                                                             if (x == 1) {
                                                                 JOptionPane.showMessageDialog(null, "Lớp học đã đầy!");
                                                             } else if(x == 2){
                                                                 JOptionPane.showMessageDialog(null, "Trùng lịch học, vui lòng chọn lớp khác!");
                                                             } else if (x == 3) {
                                                                 lhp.DangKyLHP(x, login.getID(), ll);
                                                                 JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
                                                                 lhp.updatesoluongsv(x, ll);
                                                             }else if(x == 4){
                                                                 JOptionPane.showMessageDialog(null, "Bạn đã đăng ký môn học này!");
                                                             }
                                                         }
                                                     } else {
                                                         JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng!");
                                                     }

	        				});
	        			}
	        		}
	        		
	        		
	        		super.mouseClicked(e);
	        	}
	        	
			});
	        

	        //Thử nghiệm
// 	        DefaultTableModel model = (DefaultTableModel) table.getModel();
// 	        model.addRow(new Object[] {1, "IT6060", "Java", "TRần Tuấn Anh", "(7,8,9) Phòng 401 - A8", "Đăng ký"});
// 	        model.addRow(new Object[] {1, "IT6060", "Java", "TRần Tuấn Anh", "(7,8,9) Phòng 401 - A8", "Đăng ký"});
	
// 	        model.addRow(new Object[] {1, "IT6060", "Java", "TRần Tuấn Anh", "(7,8,9) Phòng 401 - A8", "Đăng ký"});
	
// 	        model.addRow(new Object[] {1, "IT6060", "Java", "TRần Tuấn Anh", "(7,8,9) Phòng 401 - A8", "Đăng ký"});
	
// 	        model.addRow(new Object[] {1, "IT6060", "Java", "TRần Tuấn Anh", "(7,8,9) Phòng 401 - A8", "Đăng ký"});
	
	
	        
	        
	
	        
// 	        main.setViewportView(table);
			
			
			
			
			

	        main.setViewportView(table);
		
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int n =1;
                for(LopHocPhan l:dsLHP){
                    model.addRow(new Object[] {n, l.getMaLHP(), l.getTenLHP(), l.getMaGVPhuTrach(), l.getTiet()+" "+l.getThu(), l.getSoLuongSinhVien(), l.getSiSoToiDa()});
                    n+=1;
                }
                

		}
	}
