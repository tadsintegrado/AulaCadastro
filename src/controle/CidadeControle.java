package controle;

import dao.ConexaoPostgress;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public ResultSet consultadescricao(CidadeModelo cidade) {
        super.executeSQL("SELECT * FROM CADCIDADE WHERE "
                + " DSCIDADE LIKE '%" + cidade.getDescricao()
                + "%'");
        return super.resultset;
    }

    public ResultSet consultacodigo(CidadeModelo cidade) {
        super.executeSQL("SELECT * FROM CADCIDADE WHERE "
                + " IDCIDADE = " + cidade.getIdcidade());
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
        super.atualizarSQL(sql.toString());
    }

    public void alterar(CidadeModelo cidade) {
        sql.delete(0, sql.length());
        sql.append("UPDATE CADCIDADE SET ");
        sql.append("DSCIDADE = '").append(cidade.getDescricao()).append("' ");
        sql.append(" WHERE ");
        sql.append("IDCIDADE = ").append(cidade.getIdcidade());
        super.atualizarSQL(sql.toString());
    }

    public void excluir(CidadeModelo cidade) {
        sql.delete(0, sql.length());
        sql.append("DELETE FROM CADCIDADE ");
        sql.append(" WHERE ");
        sql.append("IDCIDADE = ").append(cidade.getIdcidade());
        super.atualizarSQL(sql.toString());
    }

    public void retornadados(CidadeModelo cidade) {
        super.executeSQL("SELECT * FROM CADCIDADE WHERE "
                + " IDCIDADE = " + cidade.getIdcidade());
        try {
            super.resultset.first();
            cidade.setIdcidade(resultset.getInt("idcidade"));
            cidade.setDescricao(resultset.getString("dscidade"));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
