package UserUI;


import Data.LopHocPhan;
import Data.Subject;
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

import java.util.ArrayList;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class Registration extends JPanel {
        public static String mamon = null;
        public static String thu = null;

    public static String getThu() {
        return thu;
    }

    public static void setThu(String thu) {
        Registration.thu = thu;
    }
        
    public static String getMamon() {
        return mamon;
    }

    public static void setMamon(String mamon) {
        Registration.mamon = mamon;
    }
        
	private JTable table;
        ArrayList<LopHocPhan> ds = new ArrayList();
        LopHocPhanManaging lhpm = new LopHocPhanManaging();

// public class Registration extends JPanel {
// 	private JTable table;


	public Registration() {
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
        
        JLabel lblNewLabel = new JLabel("Đăng ký ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        header_left.add(lblNewLabel, gbc_lblNewLabel);
        
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

//         	        "STT", "Mã học phần", "Tên học phần", "TC lý thuyết", "TC thực hành", "TC BTL/TT", "TC Online", "Tổng số TC", "Học kì"

        	        "STT", "Mã học phần", "Tên học phần", "Số tín chỉ", "Học kỳ", "Học phí", "TG bắt đầu học"

//         	        "STT", "Mã học phần", "Tên học phần", "TC lý thuyết", "TC thực hành", "TC BTL/TT", "TC Online", "Tổng số TC", "Học kì", "Đăng ký"


        	    }
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

        				String subjectid = table.getValueAt(selectedRow, 1).toString();
        				//LopHocPhan lhp = lhpm.sellectAll();
                                        mamon = table.getValueAt(selectedRow, 1).toString();
        				EventQueue.invokeLater(() ->{
                                            RegistrationInfor registrationInfor = new RegistrationInfor(subjectid);
                                            registrationInfor.setVisible(true);

//         				String subjectName = table.getValueAt(selectedRow, 2).toString();
        				
//         				EventQueue.invokeLater(() ->{
   

//         					RegistrationInfor registrationInfor = new RegistrationInfor(subjectName);
//         					registrationInfor.setVisible(true);



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
        ArrayList<Subject> dsS = new ArrayList();
	public void ViewTable(){
<<<<<<< HEAD
            this.dsS = sm.selectSubjectforDKHP(); 
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int n =1;
            for(Subject s:dsS){
                model.addRow(new Object[] {n, s.getMaMon(), s.getTenMon(), s.getStc(), s.getHocKy(), s.getHocPhi(), s.getNgayBanHanh()});
=======
            this.dsS = sm.selectSubjectforDKHP();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int n =1;
            for(Subject s:dsS){
                model.addRow(new Object[] {n, s.getMaMon(), s.getTenMon(), s.getStc(), s.getHocKy(), s.getHocPhi(), s.getNgaybatDau()});
>>>>>>> 33b4665e235ed7302b0e7746fbca271a8134dc35
                n+=1;
            }
        }
        public String getsubjectID(){
            return mamon;
        }

<<<<<<< HEAD
		

=======
>>>>>>> 33b4665e235ed7302b0e7746fbca271a8134dc35
        //Thử nghiệm
//         DefaultTableModel model = (DefaultTableModel) table.getModel();
//         model.addRow(new Object[] {1, "IT6060", "Java", "3.0", "0.0", "0.0", "0.0", "3.0", "3", "Đăng ký"});
//         model.addRow(new Object[] {2, "IT6060", "Java", "3.0", "0.0", "0.0", "0.0", "3.0", "3", ""});
//         model.addRow(new Object[] {3, "IT6060", "Java", "3.0", "0.0", "0.0", "0.0", "3.0", "3", "Đăng ký"});
//         model.addRow(new Object[] {4, "IT6060", "Java", "3.0", "0.0", "0.0", "0.0", "3.0", "3", ""});
//         model.addRow(new Object[] {5, "IT6060", "Java", "3.0", "0.0", "0.0", "0.0", "3.0", "3", "Đăng ký"});
//         model.addRow(new Object[] {6, "IT6060", "Java", "3.0", "0.0", "0.0", "0.0", "3.0", "3", ""});
//         model.addRow(new Object[] {7, "IT6060", "Java", "3.0", "0.0", "0.0", "0.0", "3.0", "3", "Đăng ký"});
        
        

        
//         main.setViewportView(table);
		
		
		
		
		
// 	}
	

<<<<<<< HEAD
}
=======
}
>>>>>>> 33b4665e235ed7302b0e7746fbca271a8134dc35
