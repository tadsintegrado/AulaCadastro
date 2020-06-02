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

}
