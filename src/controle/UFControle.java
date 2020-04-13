package controle;

import dao.ConexaoPostgress;
import static dao.ConexaoPostgress.resultset;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.CidadeModelo;
import modelo.UFModelo;

/**
 *
 * @author acsantana
 */
public class UFControle extends ConexaoPostgress {

    private StringBuilder sql = new StringBuilder();

    public ResultSet consultageral() {
        super.executeSQL("SELECT * FROM CADUF");
        return super.resultset;
    }

    public ResultSet consultadescricao(UFModelo modelo) {
        super.executeSQL("SELECT * FROM CADUF WHERE "
                + " DSUF LIKE '%" + modelo.getDsuf()
                + "%'");
        return super.resultset;
    }

    public ResultSet consultacodigo(UFModelo modelo) {
        super.executeSQL("SELECT * FROM CADUF WHERE "
                + " IDUF = " + modelo.getIduf());
        return super.resultset;
    }
    
    
     public void incluir(UFModelo modelo) {
        sql.delete(0, sql.length());
        sql.append("INSERT INTO CADUF (");
        sql.append("IDUF,");
        sql.append("DSUF");
        sql.append(") VALUES ('");
        sql.append(modelo.getIduf()).append("','");
        sql.append(modelo.getDsuf()).append("')");
        super.atualizarSQL(sql.toString());
    }

    public void alterar(UFModelo modelo) {
        sql.delete(0, sql.length());
        sql.append("UPDATE CADUF SET ");
        sql.append("DSUF = '").append(modelo.getDsuf()).append("' ");
        sql.append(" WHERE ");
        sql.append("IDUF = '").append(modelo.getIduf()).append("'");
        super.atualizarSQL(sql.toString());
    }

    public void excluir(UFModelo modelo) {
        sql.delete(0, sql.length());
        sql.append("DELETE FROM CADUF ");
        sql.append(" WHERE ");
        sql.append("IDUF = '").append(modelo.getIduf()).append("'");
        super.atualizarSQL(sql.toString());
    }

    public void retornadados(UFModelo modelo) {
        super.executeSQL("SELECT * FROM CADUF WHERE "
                + " IDUF = '" + modelo.getIduf() + "'");
        try {
            super.resultset.first();
            modelo.setIduf(resultset.getString("iduf"));
            modelo.setDsuf(resultset.getString("dsuf"));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    

}
