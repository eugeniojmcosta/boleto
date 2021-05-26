/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatura;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author eugenio
 */
@Path("ficha")
public class Ficha {

    /**
     *
     * @param dado
     * @return
     */
    @GET 
    @Path("/{dado}")
    @Produces("text/plain") 
    public String Ficha(@PathParam("dado") String dado) {
        return dado;
        
        
     //dado;
    }
}
