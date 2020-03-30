
package controle;

import dao.ConexaoPostgress;
import java.sql.ResultSet;

/**
 *
 * @author acsantana
 */
public class CidadeControle extends ConexaoPostgress {
    
    
    public ResultSet consultageral() {
        super.executeSQL("SELECT * FROM CADCIDADE");
        return super.resultset;
    }
    
}
