<%-- 
    Document   : inicio
    Created on : 21-07-2020, 20:36:45
    Author     : pparedes
--%>

<%@page import="modelos.Pedido"%>
<%@page import="dao.PedidoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Producto"%>
<%@page import="dao.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <center>
        <h1>Inicio de Sesion</h1>
        <form action="ControladorUsuario" method="post">
        <table>
            <tr>
                <td>Id</td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Iniciar Sesion"/></td>
            </tr>
        </table>
            <input type="hidden" name="accion" value="1"/>
            <% if(request.getParameter("msj")!= null){%>
            <h3><%= request.getParameter("msj") %></h3>
            <%}%>
         </form>
         <br>
         <table border="1" style="border-collapse: collapse;">
            <tr>
                <td>Nombre</td>
                <td>Descripcion</td>
                <td>Precio</td>
                <td>Hacer pedido</td>
            </tr>
            <%  ProductoDAO ud = new ProductoDAO();
                ArrayList<Producto> producto = ud.obtenerProductos(); 
            for(Producto p:producto){
            %>
            <tr>
                <td><%= p.getNombre() %></td>
                <td><%= p.getDescripcion() %></td>
                <td><%= p.getPrecio() %></td>
                <td><a href="realizarPedido.jsp?codigo=<%= p.getId_producto() %>">
                        <input type="button" value="Hacer pedido"/>
                    </a>
                </td>
            <% } %>
        </table>
        <br>
        <table border="1" style="border-collapse: collapse;">
            <tr>
                <td>Id</td>
                <td>Cantidad</td>
                <td>Correo</td>
                <td>Producto</td>
                <td>Seguir mi pedido</td>
            </tr>
            <%  PedidoDAO pd = new PedidoDAO();
                ArrayList<Pedido> pedido = pd.obtenerPedidos(); 
            for(Pedido ped:pedido){
            %>
            <tr>
                <td><%= ped.getId_pedido() %></td>
                <td><%= ped.getCantidad() %></td>
                <td><%= ped.getCorreo() %></td>
                <td><%= ped.getProducto() %></td>
                <td><a href="seguirPedido.jsp?codigo=<%= ped.getId_pedido() %>">
                        <input type="button" value="seguir mi pedido"/>
                    </a>
                </td>
            <% } %>
        </table>
        <% if(request.getParameter("msj")!= null){%>
        <h4><%= request.getParameter("msj") %></h4>
        <%}%>
         
    </center>
    </body>
</html>
