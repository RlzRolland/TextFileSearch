/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextFileSearch;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author RlzRolland
 */
public class TablaSubrayada extends DefaultTableCellRenderer {

    final private JTextField busqueda;

    public TablaSubrayada(JTextField busqueda) {
        this.busqueda = busqueda;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, selected, hasFocus, row, column);
        JLabel original = (JLabel) c;
        LabelSubrayado label = new LabelSubrayado();
        label.setFont(original.getFont());
        label.setText(original.getText());
        label.setBackground(original.getBackground());
        label.setForeground(original.getForeground());
        label.setHorizontalTextPosition(original.getHorizontalTextPosition());
        label.highlightText(busqueda.getText());
        return label;
    }
}
