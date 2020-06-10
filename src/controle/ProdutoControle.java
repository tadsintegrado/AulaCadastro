
package controle;

import dao.ConexaoPostgress;
import static dao.ConexaoPostgress.resultset;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.CidadeModelo;
import modelo.ProdutoModelo;

/**
 *
 * @author acsantana
 */
public class ProdutoControle extends  ConexaoPostgress{
    
    private StringBuilder sql = new StringBuilder();

    
    public ResultSet consultacodigo(ProdutoModelo produto) {
        super.executeSQL("SELECT * FROM CADPRODUTO WHERE "
                + " IDPRODUTO = " + produto.getIdproduto());
        return super.resultset;
    } 
    
    
    
    public void retornadados(ProdutoModelo produto) {
        super.executeSQL("SELECT * FROM CADPRODUTO WHERE "
                + " IDPRODUTO = " + produto.getIdproduto());
        try {
            super.resultset.first();
            produto.setIdproduto(resultset.getInt("idproduto"));
            produto.setDsproduto(resultset.getString("dsproduto"));
            produto.setQtestoque(resultset.getInt("qtestoque"));
            produto.setVlvenda(resultset.getDouble("vlvenda"));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
