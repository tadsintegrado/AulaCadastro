package controle;

import dao.ConexaoPostgress;
import java.sql.ResultSet;
import modelo.ItensNFModelo;

/**
 *
 * @author acsantana
 */
public class ItensNFControle extends ConexaoPostgress {

    private StringBuilder sql = new StringBuilder();

    public ResultSet consultacodigo(ItensNFModelo itensnf) {
        super.executeSQL("SELECT NF.IDNF,NF.IDCLIENTE,NF.VLTOTAL AS TOTALNF, "
                + "ITENSDANF.IDPRODUTO,ITENSDANF.VLPRODUTO,ITENSDANF.QTDPRODUTO, "
                + "(ITENSDANF.QTDPRODUTO * ITENSDANF.VLPRODUTO) AS TOTALPRODUTO, "
                + "CADPRODUTO.DSPRODUTO "
                + "FROM ITENSDANF INNER JOIN NF ON ITENSDANF.IDNF = NF.IDNF "
                + "INNER JOIN CADPRODUTO ON CADPRODUTO.IDPRODUTO = ITENSDANF.IDPRODUTO "
                + "WHERE NF.IDNF =  " + itensnf.getIdnf());
        return super.resultset;
    }

     public void incluir(ItensNFModelo itens) {
        sql.delete(0, sql.length());
        sql.append("INSERT INTO ITENSDANF (");
        sql.append("IDNF,");
        sql.append("IDPRODUTO,");
        sql.append("VLPRODUTO,");
        sql.append("QTDPRODUTO");
        sql.append(") VALUES (");
        sql.append(itens.getIdnf()).append(",");
        sql.append(itens.getIdproduto()).append(",");
        sql.append(itens.getVlproduto()).append(",");
        sql.append(itens.getQtdproduto()).append(")");
        super.atualizarSQL(sql.toString());
    }
    
    
}
