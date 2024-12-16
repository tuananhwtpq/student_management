package UserUI;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class ButtonRenderer extends JPanel implements TableCellRenderer {
    private JButton button;

    public ButtonRenderer() {
        // Sử dụng GridBagLayout để căn giữa
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        button = new JButton();
        button.setPreferredSize(new java.awt.Dimension(80, 30)); 
        add(button, gbc); 
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        button.setText(value == null ? "Đăng ký" : value.toString()); 
        return this;
    }
}
