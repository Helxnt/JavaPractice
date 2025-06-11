/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public class Compras {

    //variables
    private String CedulaCliente;
    private String NombreCliente;
    private String fecha;
    private String vendedor;
    private String tipoCompra;
    private String articulo;
    private int cantidad;
    private double precioUnitario;

    //constructor
    public Compras(String CedulaCliente, String NombreCliente, String fecha, String vendedor, String tipoCompra,
            String articulo, int cantidad, double precioUnitario) {
        this.CedulaCliente = CedulaCliente;
        this.NombreCliente = NombreCliente;
        this.fecha = fecha;
        this.vendedor = vendedor;
        this.tipoCompra = tipoCompra;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double getTotal() {
        return cantidad * precioUnitario;
    }

    public String getCedulaCliente() {
        return CedulaCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public String getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

}
