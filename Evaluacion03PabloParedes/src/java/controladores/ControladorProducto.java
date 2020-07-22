/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Producto;

/**
 *
 * @author pparedes
 */
@WebServlet(name = "ControladorProducto", urlPatterns = {"/ControladorProducto"})
public class ControladorProducto extends HttpServlet {

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
            response.sendRedirect("registroProducto.jsp?=No tienes permitido hacer eso");
        }
    }
    
    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
       try{
        int id = Integer.parseInt(request.getParameter("id").trim());
        String nombre = request.getParameter("nombre").trim();
        String descripcion = request.getParameter("descripcion").trim();
        int precio = Integer.parseInt(request.getParameter("precio").trim());
        if(id<1||nombre.isEmpty()||descripcion.isEmpty()||precio<1){
            response.sendRedirect("registroProducto.jsp?msj=valores erroneos");
        }else{
            Producto nuevoProducto = new Producto(id,nombre,descripcion,precio);
            ProductoDAO pd = new ProductoDAO();
            if(pd.obtenerProducto(nuevoProducto.getId_producto())==null){
                int respuesta = pd.registrarProducto(nuevoProducto);
                if(respuesta==1){
                    response.sendRedirect("registroProducto.jsp?msj=Producto registrado");
                        
                }else{
                    response.sendRedirect("registroProducto.jsp?msj=Producto no se puede ser registrado");
                }
            }else{
                response.sendRedirect("registroProducto.jsp?msj=Producto ya existe");
            }
        }
       }catch(Exception e){
           response.sendRedirect("registroProducto.jps="+e.getMessage());
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
