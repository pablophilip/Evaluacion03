/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.EstadoDAO;
import dao.PedidoDAO;
import dao.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Pedido;

/**
 *
 * @author pparedes
 */
@WebServlet(name = "ControladorPedido", urlPatterns = {"/ControladorPedido"})
public class ControladorPedido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(request.getParameter("accion")!=null){
        String accion = request.getParameter("accion");
            switch(accion){
                case "1": registrar(request,response);
                    break;
                }
        }else{
            response.sendRedirect("inicio.jsp?=No tienes permitido hacer eso");
        }
    }
    
    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try{
            int id = Integer.parseInt(request.getParameter("id").trim());
            int cantidad = Integer.parseInt(request.getParameter("cantidad").trim());
            int total = Integer.parseInt(request.getParameter("total").trim());
            String correo = request.getParameter("correo").trim();
            int estado = Integer.parseInt(request.getParameter("estado").trim());
            int producto = Integer.parseInt(request.getParameter("producto").trim());
            if(id<1||cantidad<1||total<1||correo.isEmpty()||estado<1||producto<1){
            response.sendRedirect("realizarPedido.jsp?msj=valores erroneos");
            }else{
                EstadoDAO ed = new EstadoDAO();
                ProductoDAO pd = new ProductoDAO();
                Pedido nuevoPedido = new Pedido(id,cantidad,total,correo,ed.obtenerEstado(estado),pd.obtenerProducto(producto));
                PedidoDAO ped = new PedidoDAO();
                if(ped.obtenerPedido(nuevoPedido.getId_pedido())==null){
                    int respuesta = ped.registrarPedido(nuevoPedido);
                    if(respuesta==1){
                        response.sendRedirect("realizarPedido.jsp?msj=Equipo ingresado");
                    }else{
                        response.sendRedirect("realizarPedido.jsp?msj=Equipo no se puede registar");
                    }
                }else{
                    response.sendRedirect("realizarPedido.jsp?msj=Equipo ya existe");
                }
            }
        }catch(Exception e){
            response.sendRedirect("realizarPedido.jps="+e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
