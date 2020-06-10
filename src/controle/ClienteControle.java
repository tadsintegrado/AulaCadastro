package controle;

import dao.ConexaoPostgress;
import java.sql.ResultSet;
import modelo.ClienteModelo;


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

     public ResultSet consultacodigo(ClienteModelo cliente) {
        super.executeSQL("SELECT * FROM CADPESSOA WHERE "
                + " IDPESSOA = " + cliente.getIdpessoa());
        return super.resultset;
    } 
}
