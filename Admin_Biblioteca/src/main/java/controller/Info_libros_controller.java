package controller;

import connection.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julian
 */
public class Info_libros_controller {

    public List<Object[]> getInfoLibros() {
        ConnectionDB con = new ConnectionDB();
        List<Object[]> infoLibros = new ArrayList<>();
        String sql = "SELECT id_libro,\n"
                + "		lib.titulo,\n"
                + "		au.nombres + ' ' + au.apellidos AS autor,\n"
                + "		lib.genero,\n"
                + "		el.descripcion AS estado\n"
                + "FROM info_libros il\n"
                + "INNER JOIN libro lib ON lib.codigo_libro = il.id_libro\n"
                + "INNER JOIN autor au ON au.id = lib.id_autor\n"
                + "INNER JOIN estado_libro el ON el.id = il.id_estado_libro";
        CallableStatement cst;
        try {
            cst = con.getConnection().prepareCall(sql);
            cst.execute();
            ResultSet rs = cst.getResultSet();
            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                infoLibros.add(row);
            }
        } catch (SQLException ex) {
            System.out.println("Info_libros_controller -> getInfoLibros().error01 = " + ex.getMessage());
        }
        return infoLibros;
    }
}
