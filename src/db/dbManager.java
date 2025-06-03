/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import javax.swing.JOptionPane;
import models.Cliente;
import models.Compras;

public class dbManager {

    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=practicaDB;encrypt=true;trustServerCertificate=true";
    private static final String USER = "helenuser";
    private static final String PASSWORD = "1234";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static boolean guardarCliente(Cliente cliente) {
        String sql = "INSERT INTO Clientes (Cedula, Nombre, Direccion, Genero, Estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCedula());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getGenero());
            stmt.setString(5, cliente.getEstado());

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            if (e.getMessage().contains("PRIMARY KEY")) {
                JOptionPane.showMessageDialog(null, "Ya existe un cliente con esa cédula.");
            } else {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar cliente: " + e.getMessage());
            }
        }

        return false;
    }

    public static boolean guardarCompras(Compras compras) {
        String sql = "INSERT INTO Compras (CedulaCliente, NombreCliente, Fecha, Vendedor, TipoCompra, Articulo, Cantidad, PrecioUnitario, Total) VALUES (?, ?, ?, ?, ?, ?, ?,?,?)";

        try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, compras.getCedulaCliente());
            stmt.setString(2, compras.getNombreCliente());
            stmt.setString(3, compras.getFecha());
            stmt.setString(4, compras.getVendedor());
            stmt.setString(5, compras.getTipoCompra());
            stmt.setString(6, compras.getArticulo());
            stmt.setInt(7, compras.getCantidad());
            stmt.setDouble(8, compras.getPrecioUnitario());
            stmt.setDouble(9, compras.getTotal());

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar la compra: " + e.getMessage());
            return false;
        }
    }
    
    public static Cliente buscarClientePorCedula(String cedula) {
    String sql = "SELECT * FROM Clientes WHERE Cedula = ?";
    
    try (Connection conn = conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, cedula);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            return new Cliente(
                rs.getString("Cedula"),
                rs.getString("Nombre"),
                rs.getString("Direccion"),
                rs.getString("Genero"),
                rs.getString("Estado")
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return null;
}
    
    
    
    
}

