package controle;

import dao.ConexaoPostgress;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.LoginModelo;

/**
 *
 * @author acsantana
 */
public class LoginControle extends ConexaoPostgress {

    private StringBuilder sql = new StringBuilder();

    public String consultaacesso(LoginModelo login) {
        super.executeSQL("SELECT * FROM CADUSUARIO WHERE "
                + " DSUSUARIO = '" + login.getDsusuario() + "' AND DSSENHA = '"
                + login.getDssenha() + "'");
        try {
            super.resultset.first();
            return (resultset.getString("NMNUSUARIO"));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return "";
    }

    public ResultSet consultageral() {
        super.executeSQL("SELECT * FROM CADUSUARIO");
        return super.resultset;
    }

    public ResultSet consultadescricao(LoginModelo login) {
        super.executeSQL("SELECT * FROM CADUSUARIO WHERE "
                + " NMNUSUARIO LIKE '%" + login.getNmusuario()
                + "%'");
        return super.resultset;
    }

    public ResultSet consultausuario(LoginModelo login) {
        super.executeSQL("SELECT * FROM CADUSUARIO WHERE "
                + " DSUSUARIO = " + login.getDsusuario());
        return super.resultset;
    }

    public void incluir(LoginModelo login) {
        sql.delete(0, sql.length());
        sql.append("INSERT INTO CADUSUARIO (");
        sql.append("DSUSUARIO,");
        sql.append("NMNUSUARIO,");
        sql.append("DSSENHA");
        sql.append(") VALUES ('");
        sql.append(login.getDsusuario()).append("','");
        sql.append(login.getNmusuario()).append("','");
        sql.append(login.getDssenha()).append("')");
        super.atualizarSQL(sql.toString());
    }

    public void alterar(LoginModelo login) {
        sql.delete(0, sql.length());
        sql.append("UPDATE CADUSUARIO SET ");
        sql.append("NMNUSUARIO = '").append(login.getNmusuario()).append("', ");
        sql.append("DSSENHA  = '").append(login.getDssenha()).append("' ");
        sql.append(" WHERE ");
        sql.append("DSUSUARIO = ").append(login.getDsusuario());
        super.atualizarSQL(sql.toString());
    }

    public void excluir(LoginModelo login) {
        sql.delete(0, sql.length());
        sql.append("DELETE FROM CADUSUARIO ");
        sql.append(" WHERE ");
        sql.append("DSUSUARIO = ").append(login.getDsusuario());
        super.atualizarSQL(sql.toString());
    }

    public void retornadados(LoginModelo login) {
        super.executeSQL("SELECT * FROM CADUSUARIO WHERE "
                + " DSUSUARIO = " + login.getDsusuario());
        try {
            super.resultset.first();
            login.setDsusuario(resultset.getString("DSUSUARIO"));
            login.setNmusuario(resultset.getString("NMNUSUARIO"));
            login.setDssenha(resultset.getString("DSSENHA"));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
