/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextFileSearch;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author RlzRolland
 */
public class JTableColumnHeaderToolTips extends MouseMotionAdapter {
    TableColumn actCol;
    Map headerColumnTips = new HashMap();

    public void setHeaderColumnToolTip(TableColumn column, String tooltip) {
        if (tooltip == null) {
            headerColumnTips.remove(column);
        } 
        else {
            headerColumnTips.put(column, tooltip);
        }
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        JTableHeader header = (JTableHeader) event.getSource();
        JTable table = header.getTable();
        TableColumnModel colModel = table.getColumnModel();
        int colIndice = colModel.getColumnIndexAtX(event.getX());
        TableColumn columna = null;
        if (colIndice >= 0) {
            columna = colModel.getColumn(colIndice);
        }
        if (columna != actCol) {
            header.setToolTipText((String) headerColumnTips.get(columna));
            actCol = columna;
        }
    }
}
