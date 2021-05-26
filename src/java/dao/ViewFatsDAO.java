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
import modelo.ViewFats;

/**
 *
 * @author eugenio
 */
public class ViewFatsDAO {

    public List<ViewFats> listar_envio(String p_cgccfo) {

        String sql = "select"
                + " t.nome, "
                + " t.cgccfo, "
                + " t.rua, "
                + " t.numero, "
                + " t.complemento, "
                + " t.perimetro, "
                + " t.bairro, "
                + " t.cidade, "
                + " t.cep, "
                + " t.codetd, "
                + " t.fat_codcoligada, "
                + " t.fat_idlan, "
                + " t.fat_arquivo, "
                + " t.col_logo, "
                + " t.emissao_data, "
                + " t.emissao_hora, "
                + " t.cxa_codcxa, "
                + " t.cxa_descricao, "
                + " t.cxa_numbanco, "
                + " t.cxa_numagencia, "
                + " t.age_digag, "
                + " t.cxa_nroconta, "
                + " t.cta_digconta, "
                + " t.cxa_codmoeda, "
                + " t.cta_convenio, "
                + " t.cta_carteira, "
                + " t.cta_tipocob, "
                + " t.age_codbenef, "
                + " t.cli_rua, "
                + " t.cli_complemento, "
                + " t.cli_cep, "
                + " t.segundonumero, "
                + " t.historico, "
                + " t.detalhe, "
                + " t.ipte, "
                + " t.cnabbanco, "
                + " t.cnabmoeda, "
                + " t.bco_nome, "
                + " t.bco_numbanco, "
                + " t.bco_logo, "
                + " t.bco_digbanco, "
                + " t.cnabnumbanco, "
                + " t.cnab_localpagamento, "
                + " t.estado, "
                + " t.valororiginal, "
                + " t.vw_multa, "
                + " t.vw_mora, "
                + " t.instrucao01, "
                + " t.numerodocumento, "
                + " t.numerofatura, "
                + " t.codtb1flx, "
                + " t.datavencimento, "
                + " t.datavencimento_masc, "
                + " t.datacriacao, "
                + " t.dataemissao, "
                + " t.cnabcarteira, "
                + " t.cnabnossonumero, "
                + " t.nossonumero, "
                + " t.codigobarra, "
                + " t.codfilial, "
                + " t.codtb2flx, "
                + " t.ipte2, "
                + " t.num_dias_vencidos, "
                + " t.vl_multa, "
                + " t.vl_multa_masc, "
                + " t.vl_mora, "
                + " t.vl_mora_masc, "
                + " t.vl_para_hoje_masc, "
                + " t.vl_para_hoje, "
                + " t.posicao_01_03, "
                + " t.posicao_04_04, "
                + " t.posicao_05_09, "
                + " t.posicao_10_10, "
                + " t.posicao_11_20, "
                + " t.posicao_21_21, "
                + " t.posicao_22_31, "
                + " t.posicao_32_32, "
                + " t.posicao_33_33, "
                + " t.posicao_34_37, "
                + " t.posicao_38_47, "
                + " t.dv_codbar, "
                + " t.newipte, "
                + " t.ipte3, "
                + " t.newcodbar, "
                + " t.mensagemboleto, "
                + " t.ipte3_datavencimento, "
                + " t.texto_multa, "
                + " t.multa_mora_masc, "
                + " t.eugenio, "
                + " t.col_nome, "
                + " t.col_cgc, "
                + " t.col_rua, "
                + " t.col_cep, "
                + " t.va_nome, "
                + " t.va_nome_curto, "
                + " t.va_email, "
                + " t.va_nrcontrato "
                + " from ormcabo.view_fats_20092020 t "
                + " WHERE replace(replace(replace(t.CGCCFO,'.',''),'/',''),'-','') =   replace(replace(replace('" + p_cgccfo + "','.',''),'/',''),'-','') "
                //+ " t.check_email = 'SUCCESS' AND t.va_email IS NOT NULL "
                //+ " and t.fat_idlan in (1406734,1406756,1406757,1406758,1406759,1406760,1406761) "
                //+" and rownum <= 10"
                //+ " and ((fat_codcoligada = 41 and fat_idlan = 5618 ) or (fat_codcoligada = 9 and fat_idlan = 1405086 )) "
                //+" and t.DATAVENCIMENTO = to_date('25/02/2021','dd/mm/rrrr') "

                //+" and (fat_codcoligada = 9 and fat_idlan = 1410995 ) "
                + " order by t.fat_codcoligada, t.fat_idlan ";

        List<ViewFats> retorno = new ArrayList<ViewFats>();
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                ViewFats vf = new ViewFats();
                vf.setNOME(res.getString("NOME"));
                vf.setNOME(res.getString("nome"));
                vf.setCGCCFO(res.getString("cgccfo"));
                vf.setRUA(res.getString("rua"));
                vf.setNUMERO(res.getString("numero"));
                vf.setCOMPLEMENTO(res.getString("complemento"));
                vf.setPERIMETRO(res.getString("perimetro"));
                vf.setBAIRRO(res.getString("bairro"));
                vf.setCIDADE(res.getString("cidade"));
                vf.setCEP(res.getString("cep"));
                vf.setCODETD(res.getString("codetd"));
                vf.setFAT_CODCOLIGADA(res.getString("fat_codcoligada"));
                vf.setFAT_IDLAN(res.getString("fat_idlan"));
                vf.setFAT_ARQUIVO(res.getString("fat_arquivo"));
                vf.setCOL_LOGO(res.getString("col_logo"));
                vf.setEMISSAO_DATA(res.getString("emissao_data"));
                vf.setEMISSAO_HORA(res.getString("emissao_hora"));
                vf.setCXA_CODCXA(res.getString("cxa_codcxa"));
                vf.setCXA_DESCRICAO(res.getString("cxa_descricao"));
                vf.setCXA_NUMBANCO(res.getString("cxa_numbanco"));
                vf.setCXA_NUMAGENCIA(res.getString("cxa_numagencia"));
                vf.setAGE_DIGAG(res.getString("age_digag"));
                vf.setCXA_NROCONTA(res.getString("cxa_nroconta"));
                vf.setCTA_DIGCONTA(res.getString("cta_digconta"));
                vf.setCXA_CODMOEDA(res.getString("cxa_codmoeda"));
                vf.setCTA_CONVENIO(res.getString("cta_convenio"));
                vf.setCTA_CARTEIRA(res.getString("cta_carteira"));
                vf.setCTA_TIPOCOB(res.getString("cta_tipocob"));
                vf.setAGE_CODBENEF(res.getString("age_codbenef"));
                vf.setCLI_RUA(res.getString("cli_rua"));
                vf.setCLI_COMPLEMENTO(res.getString("cli_complemento"));
                vf.setCLI_CEP(res.getString("cli_cep"));
                vf.setSEGUNDONUMERO(res.getString("segundonumero"));
                vf.setHISTORICO(res.getString("historico"));
                vf.setDETALHE(res.getString("detalhe"));
                vf.setIPTE(res.getString("ipte"));
                vf.setCNABBANCO(res.getString("cnabbanco"));
                vf.setCNABMOEDA(res.getString("cnabmoeda"));
                vf.setBCO_NOME(res.getString("bco_nome"));
                vf.setBCO_NUMBANCO(res.getString("bco_numbanco"));
                vf.setBCO_LOGO(res.getString("bco_logo"));
                vf.setBCO_DIGBANCO(res.getString("bco_digbanco"));
                vf.setCNABNUMBANCO(res.getString("cnabnumbanco"));
                vf.setCNAB_LOCALPAGAMENTO(res.getString("cnab_localpagamento"));
                vf.setESTADO(res.getString("estado"));
                vf.setVALORORIGINAL(res.getString("valororiginal"));
                vf.setVW_MULTA(res.getString("vw_multa"));
                vf.setVW_MORA(res.getString("vw_mora"));
                vf.setINSTRUCAO01(res.getString("instrucao01"));
                vf.setNUMERODOCUMENTO(res.getString("numerodocumento"));
                vf.setNUMEROFATURA(res.getString("numerofatura"));
                vf.setCODTB1FLX(res.getString("codtb1flx"));
                vf.setDATAVENCIMENTO(res.getString("datavencimento"));
                vf.setDATAVENCIMENTO_MASC(res.getString("datavencimento_masc"));
                vf.setDATACRIACAO(res.getString("datacriacao"));
                vf.setDATAEMISSAO(res.getString("dataemissao"));
                vf.setCNABCARTEIRA(res.getString("cnabcarteira"));
                vf.setCNABNOSSONUMERO(res.getString("cnabnossonumero"));
                vf.setNOSSONUMERO(res.getString("nossonumero"));
                vf.setCODIGOBARRA(res.getString("codigobarra"));
                vf.setCODFILIAL(res.getString("codfilial"));
                vf.setCODTB2FLX(res.getString("codtb2flx"));
                vf.setIPTE2(res.getString("ipte2"));
                vf.setNUM_DIAS_VENCIDOS(res.getString("num_dias_vencidos"));
                vf.setVL_MULTA(res.getString("vl_multa"));
                vf.setVL_MULTA_MASC(res.getString("vl_multa_masc"));
                vf.setVL_MORA(res.getString("vl_mora"));
                vf.setVL_MORA_MASC(res.getString("vl_mora_masc"));
                vf.setVL_PARA_HOJE_MASC(res.getString("vl_para_hoje_masc"));
                vf.setVL_PARA_HOJE(res.getString("vl_para_hoje"));
                vf.setPOSICAO_01_03(res.getString("posicao_01_03"));
                vf.setPOSICAO_04_04(res.getString("posicao_04_04"));
                vf.setPOSICAO_05_09(res.getString("posicao_05_09"));
                vf.setPOSICAO_10_10(res.getString("posicao_10_10"));
                vf.setPOSICAO_11_20(res.getString("posicao_11_20"));
                vf.setPOSICAO_21_21(res.getString("posicao_21_21"));
                vf.setPOSICAO_22_31(res.getString("posicao_22_31"));
                vf.setPOSICAO_32_32(res.getString("posicao_32_32"));
                vf.setPOSICAO_33_33(res.getString("posicao_33_33"));
                vf.setPOSICAO_34_37(res.getString("posicao_34_37"));
                vf.setPOSICAO_38_47(res.getString("posicao_38_47"));
                vf.setDV_CODBAR(res.getString("dv_codbar"));
                vf.setNEWIPTE(res.getString("newipte"));
                vf.setIPTE3(res.getString("ipte3"));
                vf.setNEWCODBAR(res.getString("newcodbar"));
                vf.setMENSAGEMBOLETO(res.getString("mensagemboleto"));
                vf.setIPTE3_DATAVENCIMENTO(res.getString("ipte3_datavencimento"));
                vf.setTEXTO_MULTA(res.getString("texto_multa"));
                vf.setMULTA_MORA_MASC(res.getString("multa_mora_masc"));
                vf.setEUGENIO(res.getString("eugenio"));
                vf.setCOL_NOME(res.getString("col_nome"));
                vf.setCOL_CGC(res.getString("col_cgc"));
                vf.setCOL_RUA(res.getString("col_rua"));
                vf.setCOL_CEP(res.getString("col_cep"));
                vf.setVA_NOME(res.getString("va_nome"));
                vf.setVA_NOME_CURTO(res.getString("va_nome_curto"));
                vf.setVA_EMAIL(res.getString("va_email"));
                vf.setVA_NRCONTRATO(res.getString("va_nrcontrato"));

                retorno.add(vf);
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewFatsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewFats.class.getName()).log(Level.SEVERE, null, ex);
        }
        Conexao.CloseConexao();

        return retorno;
    }

    public  boolean temBoleto (String p_cgccfo) {
        
        Integer qtdboletos = 0;
        String sql = "select"
                + " count(*) qtdBoletos "
                + " from ormcabo.view_fats_20092020 t "
                + " WHERE replace(replace(replace(t.CGCCFO,'.',''),'/',''),'-','') =   replace(replace(replace('" + p_cgccfo + "','.',''),'/',''),'-','') "
                + " ";
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                qtdboletos = res.getInt("qtdBoletos");
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewFatsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewFats.class.getName()).log(Level.SEVERE, null, ex);
        }
        Conexao.CloseConexao();
        
        if (qtdboletos >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<ViewFats> listar_envio() {
        throw new UnsupportedOperationException("Não suportado ainda."); //To change body of generated methods, choose Tools | Templates.
    }

}
