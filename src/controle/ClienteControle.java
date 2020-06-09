package controle;

import dao.ConexaoPostgress;
import java.sql.ResultSet;


/**
 *
 * @author acsantana
 */
public class ClienteControle extends ConexaoPostgress {

    private StringBuilder sql = new StringBuilder();

    public ResultSet consultageral() {
        super.executeSQL("SELECT * FROM CADPESSOA");
        return super.resultset;
    }

}
