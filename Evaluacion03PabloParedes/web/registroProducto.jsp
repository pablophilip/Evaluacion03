<%-- 
    Document   : registroProducto
    Created on : 21-07-2020, 22:04:55
    Author     : pparedes
--%>

<%@page import="dao.EstadoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelos.Estado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registaro de productos</title>
    </head>
    <body>
        <center>
        <h1>Productos</h1>
        <menu >
            <a href="registroProducto.jsp">
            <menuitem >Productos</menuitem>
            </a> |
            
        </menu>
        <form action="ControladorProducto" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="number" name="id"/></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <td>Descripcion</td>
                    <td><input type="text" name="descripcion"/></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="number" name="precio"/></td>
                </tr>
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Guardar"/></td>
                    <input type="hidden" name="accion" value="1"/>
                </tr>
            </table>
               <% if(request.getParameter("msj")!= null){%>
               <h4><%= request.getParameter("msj") %></h4>
               <%}%>
        </form>       
        </center>
    </body>
</html>
