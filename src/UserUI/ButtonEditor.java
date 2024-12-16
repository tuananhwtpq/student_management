package UserUI;

import Data.LopHocPhan;
import dataManaging.LopHocPhanManaging;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.table.TableCellEditor;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private JTable table;
    private JButton button;
    private String label;
    private int selectedRow;
    private LopHocPhan lhp; // Đối tượng LopHocPhan để quản lý thông tin lớp học phần
    
    public ButtonEditor(JTable table) {
        this.table = table;
        button = new JButton();
        button.setPreferredSize(new java.awt.Dimension(80, 20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped(); // Kết thúc chỉnh sửa sau khi nhấn nút

                // Kiểm tra xem dòng được chọn có hợp lệ không
                selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Đăng ký môn học này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        // Kiểm tra điều kiện đăng ký môn học ở đây (ví dụ kiểm tra lớp đã đầy chưa)
                        int x = new LopHocPhanManaging().checkdangkilop(lhp);
                        if (x == 1) {
                            JOptionPane.showMessageDialog(null, "Lớp học đã đầy!");
                        } else if (x == 3) {
                            JOptionPane.showMessageDialog(null, "Đăng ký thành công, vui lòng đợi kết quả!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng!");
                }
            }
        });
    }

    // Constructor nhận LopHocPhan và JTable để quản lý thông tin lớp học phần
    public ButtonEditor(LopHocPhan lhp) {
        this.lhp = lhp;  // Lưu đối tượng LopHocPhan để xử lý khi nhấn nút
        button = new JButton("Đăng ký"); // Đặt tên nút là "Đăng ký"
        button.setPreferredSize(new java.awt.Dimension(80, 20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped(); // Kết thúc chỉnh sửa

                // Kiểm tra dòng được chọn
                selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Đăng ký môn học này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        // Kiểm tra điều kiện đăng ký môn học
                        int x = new LopHocPhanManaging().checkdangkilop(lhp);
                        if (x == 1) {
                            JOptionPane.showMessageDialog(null, "Lớp học đã đầy!");
                        } else if (x == 3) {
                            JOptionPane.showMessageDialog(null, "Đăng ký thành công, vui lòng đợi kết quả!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng!");
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        selectedRow = row; // Lưu chỉ số dòng khi nút được nhấn
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return label; // Trả về giá trị của nút (nếu cần thiết)
    }
}
