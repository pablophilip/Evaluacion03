<%-- 
    Document   : verPedidos
    Created on : 22-07-2020, 13:32:21
    Author     : pparedes
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Pedido"%>
<%@page import="dao.PedidoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver pedidos</title>
    </head>
    <body>
    <center>
        <h1>Ver pedidos</h1>
        <h3>Pedidos Registrados</h3>
        <table border="1" style="border-collapse: collapse;">
            <tr>
                <td>Id</td>
                <td>Cantidad</td>
                <td>Total</td>
                <td>Correo</td>
                <td>Estado</td>
                <td>Producto</td>
                <td>Modificar estado</td>
            </tr>
            <%  PedidoDAO ed = new PedidoDAO();
                ArrayList<Pedido> pedido = ed.obtenerPedidos(); 
            for(Pedido eq:pedido){
            %>
            <tr>
                <td><%= eq.getId_pedido() %></td>
                <td><%= eq.getCantidad() %></td>
                <td><%= eq.getTotal() %></td>
                <td><%= eq.getCorreo() %></td>
                <td><%= eq.getEstado() %></td>
                <td><%= eq.getProducto() %></td>
                <td><a href="modificaEstado.jsp?id=<%= eq.getId_pedido() %>">
                        <input type="button" value="Cambiar Estado"/>
                    </a>
                </td>
            </tr>
            <% } %>
        </table>
        <% if(request.getParameter("msj")!= null){%>
        <h4><%= request.getParameter("msj") %></h4>
        <%}%>
    </center>
    </body>
</html>
