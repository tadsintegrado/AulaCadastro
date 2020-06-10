package modelo;

/**
 *
 * @author acsantana
 */
public class ProdutoModelo {
  
    private int idproduto;
    private String dsproduto;
    private int qtestoque;
    private double vlvenda;

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getDsproduto() {
        return dsproduto;
    }

    public void setDsproduto(String dsproduto) {
        this.dsproduto = dsproduto;
    }

    public int getQtestoque() {
        return qtestoque;
    }

    public void setQtestoque(int qtestoque) {
        this.qtestoque = qtestoque;
    }

    public double getVlvenda() {
        return vlvenda;
    }

    public void setVlvenda(double vlvenda) {
        this.vlvenda = vlvenda;
    }
    
    
    
}
