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
public class TablaEspecial extends DefaultTableCellRenderer {

    final private JTextField busqueda;
    final private String[] tocados;
    final private JTable jt;

    public TablaEspecial(JTextField busqueda, String[] tocados, JTable jt) {
        this.busqueda = busqueda;
        this.tocados = tocados;
        this.jt = jt;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, selected, hasFocus, row, column);
        JLabel original = (JLabel) c;
        LabelSubrayadoEspecial label = new LabelSubrayadoEspecial();
        label.setFont(original.getFont());
        label.setText(original.getText());
        label.setBackground(original.getBackground());
        label.setForeground(original.getForeground());
        label.setHorizontalTextPosition(original.getHorizontalTextPosition());
        label.highlightText(busqueda.getText(), tocados, jt);
        return label;
    }
}
