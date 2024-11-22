package UserUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SubjectTable extends JFrame {

	private JTable table;
    private DefaultTableModel tableModel;
	
	public SubjectTable(String subjectName) {

		setTitle("Bảng điểm cho môn: " + subjectName);
        setSize(600, 400);
        setLocationRelativeTo(null); // Hiển thị giữa màn hình
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        Object[][] sampleData = {
            {"Mã môn học", "IT001"},
            {"Tên môn học", "Lập trình Java"},
            {"Số tín chỉ", "3"},
            {"Mô tả chi tiết", "Môn học giới thiệu về lập trình hướng đối tượng với ngôn ngữ Java."}
        };
        
        String[] columnNames = {"Trường", "Giá trị"};

        tableModel = new DefaultTableModel(sampleData, columnNames);
        table = new JTable(tableModel);

        // Đưa bảng vào JScrollPane để hỗ trợ cuộn
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

		
	}
}
