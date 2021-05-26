/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatura;

import com.google.gson.Gson;
import dao.FaturaDAO;
import dao.ViewFatsDAO;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import modelo.Fatura;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * REST Web Service
 *
 * @author Eugenio Costa
 */
@Path("fatura")
public class FaturaResource {

    public File nomeArquivo;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FaturaResource
     */
    public FaturaResource() {
    }

    @GET
    @Path("/{cpfcnpj}")
    @Produces("application/pdf")
    public Response getFaturaPDF(@PathParam("cpfcnpj") String cpfcnpj) throws JRException { //Response
        ViewFatsDAO vf = new ViewFatsDAO();
        if (!vf.temBoleto(cpfcnpj) ) {
            return Response.status(404).build();
        } else {
            byte[] pdf;
            
            String src2 = "c:\\boleto\\boletocaboweb.jasper";
            
            File nomeArquivoMariaJose;
            
            HashMap param = new HashMap();
            param.put("ParamCGCCFO", cpfcnpj);
            
            nomeArquivoMariaJose = new File("boleto_" + cpfcnpj + ".pdf");
            
            JasperPrint print = JasperFillManager.fillReport(src2, param, dao.Conexao.OpenConexao());
            pdf = JasperExportManager.exportReportToPdf(print);
            
            
            return Response.ok(pdf).type("application/pdf")
                    // faz o download do pdf
                    //.header("Content-Disposition", "attachament; filename=\""+ nomeArquivoMariaJose.getName() + "\"" )
                    // diz que mostra no browser
                    .header("Content-Disposition", "filename=\"" + nomeArquivoMariaJose.getName() + "\"")
                    //                  .header("Access-Control-Allow-Origin", wUrl)
                    //                  .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                    .header("Access-Control-Allow-Methods", "GET")
                    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With")
                    .build();

        }

    }

    /* **
    
     */
    @GET
    @Path("/{cpfcnpj}/faturas")
    @Produces("application/json")
    public String getFaturaJSON(@PathParam("cpfcnpj") String cpfcnpj) {

        Gson g = new Gson();

        try {
            List<Fatura> vf = null;
            FaturaDAO vfDAO = new FaturaDAO();
            vf = vfDAO.listar(cpfcnpj);
            return g.toJson(vf);

        } catch (Exception e) {
            return g.toJson(e.getMessage());
        }

    }

    /**
     * PUT method for updating or creating an instance of FaturaResource
     *
     * @param content representation for the resource
     */
    /*
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
     */
}
