/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Fatura;


/**
 *
 * @author Eugenio Costa
 */
public class FaturaDAO {

    public FaturaDAO() {

    }

    public List<Fatura> listar(String p_cgccfo) {

        String sql = "select vf.cgccfo, "
                  + " vf.codcoligada, "
                  + " vf.idlan, "
                  + " vf.numerodocumento, "
                  + " vf.datavencimento, "
                  + " vf.valororiginal, "
                  + " vf.observacao"
                  + " from ormcabo.view_faturas_20092020 vf"
                 + " WHERE replace(replace(replace(vf.CGCCFO,'.',''),'/',''),'-','') =   replace(replace(replace('" + p_cgccfo + "','.',''),'/',''),'-','') "
                 + " and nvl('"+p_cgccfo+"','-1') <> '-1' "
                 + " order by vf.codcoligada, vf.idlan ";


        List<Fatura> retorno = new ArrayList<Fatura>();
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            ResultSet res = pst.executeQuery();
            while (res.next()) {

                Fatura vf = new Fatura();

                vf.setNumeroempresa(res.getString("codcoligada"));
                vf.setNumerofatura(res.getString("idlan"));
                vf.setNumerodocumento(res.getString("numerodocumento"));
                vf.setDatavencimento(res.getString("datavencimento"));
                vf.setValororiginal(res.getString("valororiginal"));
                vf.setObservacao(res.getString("observacao"));

                retorno.add(vf);
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(FaturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Fatura.class.getName()).log(Level.SEVERE, null, ex);
        }
        Conexao.CloseConexao();

        return retorno;
    }

    public List<Fatura> listar_envio() {
        throw new UnsupportedOperationException("Ainda não suportado."); //To change body of generated methods, choose Tools | Templates.
    }

}
