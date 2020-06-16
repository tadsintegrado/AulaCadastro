package modelo;

/**
 *
 * @author acsantana
 */
public class ItensNFModelo {

    private int idnf;
    public int idproduto;
    public double vlproduto;
    public double qtdproduto;

    public double getQtdproduto() {
        return qtdproduto;
    }

    public void setQtdproduto(double qtdproduto) {
        this.qtdproduto = qtdproduto;
    }

    public int getIdnf() {
        return idnf;
    }

    public void setIdnf(int idnf) {
        this.idnf = idnf;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public double getVlproduto() {
        return vlproduto;
    }

    public void setVlproduto(double vlproduto) {
        this.vlproduto = vlproduto;
    }

}
