package controle;

import dao.ConexaoPostgress;
import java.sql.ResultSet;
import modelo.CidadeModelo;
import modelo.NFModelo;

/**
 *
 * @author acsantana
 */
public class NFControle extends ConexaoPostgress {

    private StringBuilder sql = new StringBuilder();

    public ResultSet consultageral() {
        super.executeSQL("SELECT * FROM NF INNER JOIN CADPESSOA ON NF.IDCLIENTE = CADPESSOA.IDPESSOA");
        return super.resultset;
    }

    public ResultSet consultacliente(String pessoa) {
        super.executeSQL("SELECT * FROM NF INNER JOIN CADPESSOA ON NF.IDCLIENTE = CADPESSOA.IDPESSOA  WHERE"
                + " DSPESSOA LIKE '%" + pessoa
                + "%'");
        return super.resultset;
    }

    public ResultSet consultacodigo(NFModelo nf) {
        super.executeSQL("SELECT * FROM NF INNER JOIN CADPESSOA ON NF.IDCLIENTE = CADPESSOA.IDPESSOA WHERE "
                + " IDNF = " + nf.getIdnf());
        return super.resultset;
    }
    
     public void incluir(NFModelo nf) {
        nf.setIdnf(super.ultimasequencia("nf", "idnf"));
        sql.delete(0, sql.length());
        sql.append("INSERT INTO NF (");
        sql.append("IDNF,");
        sql.append("IDCLIENTE,");
        sql.append("VLTOTAL");
        sql.append(") VALUES (");
        sql.append(nf.getIdnf()).append(",");
        sql.append(nf.getIdcliente()).append(",");
        sql.append(nf.getVltotal()).append(")");
        super.atualizarSQL(sql.toString());
    }
}
