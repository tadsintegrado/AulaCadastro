package controle;

import dao.ConexaoPostgress;
import java.sql.ResultSet;
import modelo.CidadeModelo;

/**
 *
 * @author acsantana
 */
public class CidadeControle extends ConexaoPostgress {

    private StringBuilder sql = new StringBuilder();

    public ResultSet consultageral() {
        super.executeSQL("SELECT * FROM CADCIDADE");
        return super.resultset;
    }

    public void incluir(CidadeModelo cidade) {
        cidade.setIdcidade(super.ultimasequencia("cadcidade", "idcidade"));
        sql.delete(0, sql.length());
        sql.append("INSERT INTO CADCIDADE (");
        sql.append("IDCIDADE,");
        sql.append("DSCIDADE");
        sql.append(") VALUES (");
        sql.append(cidade.getIdcidade()).append(",'");
        sql.append(cidade.getDescricao()).append("')");
        super.executeSQL(sql.toString());
    }
    
    public void alterar(CidadeModelo cidade) {
        sql.delete(0, sql.length());
        sql.append("UPDATE CADCIDADE SET ");
        sql.append("DSCIDADE = '").append(cidade.getDescricao()).append("' ");
        sql.append(" WHERE ");
        sql.append("IDCIDADE = ").append(cidade.getIdcidade());
        super.executeSQL(sql.toString());
    }
    
    public void excluir(CidadeModelo cidade) {
        sql.delete(0, sql.length());
        sql.append("DELETE FROM CADCIDADE ");
        sql.append(" WHERE ");
        sql.append("IDCIDADE = ").append(cidade.getIdcidade());
        super.executeSQL(sql.toString());
    }
}
