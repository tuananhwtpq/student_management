package UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Point;

public class Home extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JPanel sideBar;
	private JPanel mainContent;
	private JPanel topBar;
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home frame = new Home();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	
	public Home() {
		
		//Set size of window
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1820, 1020);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        int width = getBounds().width;
        int height = getBounds().height;
        
        setSize(new Dimension(1339, 882));
        Dimension screenSizeDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSizeDimension.width;
        int screenHeight = screenSizeDimension.height;
        
        int x = (screenWidth - width) / 2;
        int y = (screenHeight - height) / 2;
        setLocation(x, y);
        
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPanel);
        contentPanel.setLayout(new BorderLayout());
        
        sideBar = new JPanel();
        sideBar.setBorder(new LineBorder(new Color(0, 0, 0)));
        sideBar.setPreferredSize(new Dimension(300, 901));
        sideBar.setBackground(new Color(241, 248, 232));
        
        topBar = new JPanel();
        topBar.setBorder(new LineBorder(new Color(0, 0, 0)));
        topBar.setPreferredSize(new Dimension(50, 50));
        topBar.setBackground(new Color(241, 248, 232));
        contentPanel.add(topBar, BorderLayout.NORTH);
        topBar.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Đại học Công Nghiệp Hà Nội");
        lblNewLabel.setLocation(new Point(50, 0));
        lblNewLabel.setPreferredSize(new Dimension(180, 13));
        lblNewLabel.setBounds(10, 0, 437, 48);
        lblNewLabel.setMinimumSize(new Dimension(180, 13));
        lblNewLabel.setMaximumSize(new Dimension(180, 13));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        topBar.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Xin chào, admin");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 26));
        lblNewLabel_1.setBounds(1281, 2, 252, 48);
        topBar.add(lblNewLabel_1);
        
        mainContent = new JPanel(new CardLayout());
        
        
        //ADD ManageAllStudent to mainContent
        
        ManageAllStudent mas = new ManageAllStudent();
        ManageSubject manageSubject = new ManageSubject();
        DasbBoardScreen dasbBoardScreen = new DasbBoardScreen(); 
        ManageClassroom manageClassroom = new ManageClassroom();
        
       	mainContent.add(dasbBoardScreen, "dashBoardScreen");
        mainContent.add(mas, "mas");
        mainContent.add(manageSubject, "manageSubject");
        mainContent.add(manageClassroom, "manageClassroom");

        
        
        contentPanel.add(sideBar, BorderLayout.WEST);
        sideBar.setLayout(new BorderLayout(0, 0));
        
        JPanel top = new JPanel();
        top.setBackground(new Color(241, 248, 232));
        top.setPreferredSize(new Dimension(10, 400));
        sideBar.add(top, BorderLayout.NORTH);
        top.setLayout(null);
        
        //First line
        
        JButton btnHome = new JButton("Trang chủ");
        btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //Add image icon
        //btnHome.setIcon(new ImageIcon(Home.class.getResource("Imgs/leaf.png")));
        btnHome.setForeground(new Color(241, 248, 232));
        //Add actionListener
        btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DasbBoardScreen dasbBoardScreen = new DasbBoardScreen();
				mainContent.add(dasbBoardScreen, "dashBoardScreen");
				CardLayout c1 = (CardLayout) mainContent.getLayout();
				c1.show(mainContent, "dashBoardScreen");
				
			}
		});
        
        btnHome.setFont(new Font("Segoe UI", Font.BOLD, 26));
        btnHome.setBackground(new Color(85, 173, 155));
        btnHome.setBounds(10, 11, 278, 45);
        top.add(btnHome);
        
        //Second line
        
        JButton manageStudentButton = new JButton("Quản lý sinh viên");
        manageStudentButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //manageStudentButton.setIcon(new ImageIcon(Home.class.getResource()));
        manageStudentButton.setForeground(new Color(241, 248, 232));
        //add action listener
        manageStudentButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				ManageAllStudent manageAllStudent = new ManageAllStudent();
				mainContent.add(manageAllStudent, "mas");
				CardLayout c1 = (CardLayout) mainContent.getLayout();
				c1.show(mainContent, "mas");
				
			}
		});
        
        
        manageStudentButton.setFont(new Font("Segoe UI", Font.BOLD, 26));
        manageStudentButton.setBackground(new Color(85, 173, 155));
        manageStudentButton.setBounds(10, 66, 278, 45);
        top.add(manageStudentButton);
        
        //Third line
        
        JButton btnThird = new JButton("Quản lý môn học");
        btnThird.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //btnSecondButton.setIcon(new ImageIcon(Home.class.getResource()));
        btnThird.setForeground(new Color(241, 248, 232));
        //add action listener
        btnThird.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ManageSubject manageSubject = new ManageSubject();
				mainContent.add(manageSubject, "manageStudent");
			
				CardLayout c1 = (CardLayout) mainContent.getLayout();
				c1.show(mainContent, "manageStudent");
				
			}
		});
        
        btnThird.setFont(new Font("Segoe UI", Font.BOLD, 26));
        btnThird.setBackground(new Color(85, 173, 155));
        btnThird.setBounds(10, 121, 278, 45);
        top.add(btnThird);
        
        //ForthLine
        
        JButton btnFourthButton  = new JButton("Quản lý lớp học");
        btnFourthButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //btnFourthButton.setIcon(new ImageIcon(Home.class.getResource()));
        btnFourthButton.setForeground(new Color(241, 248, 232));
        //add action listener
        btnFourthButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ManageClassroom manageClassroom = new ManageClassroom();
				mainContent.add(manageClassroom, "manageClassroom");
				
				CardLayout c1 = (CardLayout) mainContent.getLayout();
				c1.show(mainContent, getName());
				
			}
		});
        
        btnFourthButton.setFont(new Font("Segoe UI", Font.BOLD, 26));
        btnFourthButton.setBackground(new Color(85, 173, 155));
        btnFourthButton.setBounds(10, 176, 278, 45);
        top.add(btnFourthButton);
        
        //Fifth line
        
        JButton btnFifButton  = new JButton("Something1");
        btnFifButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //btnFifthButton.setIcon(new ImageIcon(Home.class.getResource()));
        btnFifButton.setForeground(new Color(241, 248, 232));
        //add action listener
        
        btnFifButton.setFont(new Font("Segoe UI", Font.BOLD, 26));
        btnFifButton.setBackground(new Color(85, 173, 155));
        btnFifButton.setBounds(10, 231, 278, 45);
        top.add(btnFifButton);
        
        //Sixth line
        
        JButton btnSixbuButton  = new JButton("Something1");
        btnSixbuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //btnSixthButton.setIcon(new ImageIcon(Home.class.getResource()));
        btnSixbuButton.setForeground(new Color(241, 248, 232));
        //add action listener
        
        btnSixbuButton.setFont(new Font("Segoe UI", Font.BOLD, 26));
        btnSixbuButton.setBackground(new Color(85, 173, 155));
        btnSixbuButton.setBounds(10, 286, 278, 45);
        top.add(btnSixbuButton);
        
        //Seventh Line
        
        JButton btnSeventhButton  = new JButton("Something1");
        btnSeventhButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //btnSeventhButton.setIcon(new ImageIcon(Home.class.getResource()));
        btnSeventhButton.setForeground(new Color(241, 248, 232));
        //add action listener
        
        btnSeventhButton.setFont(new Font("Segoe UI", Font.BOLD, 26));
        btnSeventhButton.setBackground(new Color(85, 173, 155));
        btnSeventhButton.setBounds(10, 341, 278, 45);
        top.add(btnSeventhButton);
        
        
        
        
        
        
       
        
        //Bottom
        JPanel  bottom = new JPanel();
        bottom.setBackground(new Color(241, 248, 232));
        bottom.setPreferredSize(new Dimension(10, 80));
        sideBar.add(bottom, BorderLayout.SOUTH);
        bottom.setLayout(null);
        
        //Btn LOg out
        JButton btnLogout = new JButton("Đăng xuất");
        btnLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLogout.setIcon(new ImageIcon(Home.class.getResource("/Imgs/log-in.png")));
        btnLogout.setForeground(new Color(241, 248, 232));
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new Login().setVisible(true);
        		dispose();
        	}
        });
        btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 26));
        btnLogout.setBackground(new Color(85, 173, 155));
        btnLogout.setBounds(10, 24, 233, 45);
        bottom.add(btnLogout);
        contentPanel.add(mainContent, BorderLayout.CENTER);
        
        
        
        
        
        
        
        
        
        
	}
}
