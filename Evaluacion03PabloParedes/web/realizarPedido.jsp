<%-- 
    Document   : realizarPedido
    Created on : 22-07-2020, 13:08:43
    Author     : pparedes
--%>

<%@page import="dao.ProductoDAO"%>
<%@page import="modelos.Producto"%>
<%@page import="dao.EstadoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Estado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realize su pedido</title>
    </head>
    <body>
        <center>
        <h1>Registro de pedidos</h1>
        
        <form action="ControladorPedido" method="post">
            <table>
            <tr>
               <td>Id</td>
                <td><input type="number" name="id"/></td>
            </tr>
            <tr>
                <td>Cantidad</td>
                <td><input type="number" name="cantidad"/></td>
            </tr>
            <tr>
                <td>Total</td>
                <td><input type="number" name="total"/></td>
            </tr>
            <tr>
                <td>Correo</td>
                <td><input type="text" name="correo"/></td>
            </tr>
            <tr>
                <td>Estado</td>
                <td>
                    <select name="estado">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Estado> estado = new EstadoDAO().obternerEstados();
                            for(Estado e:estado){%>
                            <option value="<%= e.getId_estado() %>"><%= e %></option>
                            <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Producto</td>
                <td>
                    <select name="producto">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Producto> producto = new ProductoDAO().obtenerProductos();
                            for(Producto p:producto){%>
                            <option value="<%= p.getId_producto() %>"><%= p %></option>
                            <% } %>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="reset" value="Limpiar"/></td>
                <td><input type="submit" value="Guardar"/></td>
            </tr>
            
        </table>
            <input type="hidden" name="accion" value="1"/>
        </form>
        </center>
    </body>
</html>
