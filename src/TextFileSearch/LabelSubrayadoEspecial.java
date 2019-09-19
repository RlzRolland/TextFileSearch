/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextFileSearch;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author RlzRolland
 */
public class LabelSubrayadoEspecial extends JLabel {

    final private List<Rectangle2D> rectangulos = new ArrayList<>();
    final private Color colorSubrayado = Color.YELLOW;

    public void reset() {
        rectangulos.clear();
        repaint();
    }

    public void highlightText(String textoaSubrayar, String[] tocados, JTable jt) {
        if (textoaSubrayar == null) {
            return;
        }
        reset();

        if (textoaSubrayar.trim().length() > 0) {
            String[] patron = textoaSubrayar.split(",");
            for (String s : patron) {

                final String textaEmparejar = s.toLowerCase().trim();
                if (textaEmparejar.length() == 0) {
                    return;
                }
                s = s.trim();

                String labelText = "";
                String cad = "";

                for (int t = 0; t < jt.getColumnCount(); t++) {
                    cad = jt.getColumnName(t);
                    for (int h = 0; h < tocados.length; h++) {
                        if (cad.equals(tocados[h])) {
                            for (int r = 0; r < jt.getRowCount(); r++) {
                                labelText = getText().toLowerCase();
                                String valorcito = jt.getValueAt(r, t).toString().toLowerCase();
                                if (labelText.equals(valorcito)) {
                                    if (labelText.contains(textaEmparejar)) {
                                        FontMetrics fm = getFontMetrics(getFont());
                                        float w = -1;
                                        final float hh = fm.getHeight() - 1;
                                        int i = 0;
                                        while (true) {
                                            i = labelText.indexOf(textaEmparejar, i);
                                            if (i == -1) {
                                                break;
                                            }
                                            if (w == -1) {
                                                String matchingText = getText().substring(i, i + s.length());
                                                w = fm.stringWidth(matchingText);
                                            }
                                            String preText = getText().substring(0, i);
                                            float x = fm.stringWidth(preText);
                                            rectangulos.add(new Rectangle2D.Float(x, 1, w, hh));
                                            i = i + textaEmparejar.length();
                                        }
                                        repaint();
                                        break;
                                    }
                                } else {
                                    labelText = "";
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        if (rectangulos.size() > 0) {
            Graphics2D g2d = (Graphics2D) g;
            Color c = g2d.getColor();
            for (Rectangle2D rectangle : rectangulos) {
                g2d.setColor(colorSubrayado);
                g2d.fill(rectangle);
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.draw(rectangle);
            }
            g2d.setColor(c);
        }
        super.paintComponent(g);
    }
}
