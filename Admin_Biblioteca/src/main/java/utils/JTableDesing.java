package utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Julian
 */
public class JTableDesing extends DefaultTableCellRenderer {

    private final Color color;
    private final String estado;

    public JTableDesing(Color color, String estado) {
        this.color = color;
        this.estado = estado;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (estado.equals("DISPONIBLE")) {
            component.setBackground(color);
        }
        return component;
    }
}
