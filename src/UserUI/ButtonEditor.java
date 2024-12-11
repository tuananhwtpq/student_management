package UserUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.AbstractCellEditor;
import javax.swing.table.TableCellEditor;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {

    private JButton button;
    private String label;
    private int selectedRow;

    public ButtonEditor(JTable table) {
        button = new JButton();
        button.setPreferredSize(new java.awt.Dimension(80, 20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                if (selectedRow >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Đăng ký môn học này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Đăng thành công, vui lòng đợi kết quả!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng bấm gì đó!");
                }
            }
        });

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        selectedRow = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        return label;
    }
}

