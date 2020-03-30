package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author acsantana
 */
public class ConexaoPostgress {

    public static Connection ConexaoPostgress;
    public static Statement statement;
    public static ResultSet resultset;
    public int retorno = 0;

    public ConexaoPostgress() { // metodo construtor
        conecta();
    }

    public static Connection conecta() {
        if (ConexaoPostgress != null) {
            return ConexaoPostgress;
        } else {
            try {
                Class.forName("org.postgresql.Driver");
                ConexaoPostgress = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AulaJava",
                        "postgres", "acs1707$");

                System.out.println("Conectado");
                return ConexaoPostgress;

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Driver não localizado: " + ex);

                ex.printStackTrace();
                return null;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na conexão com a fonte  de dados: " + ex);
                ex.printStackTrace();
                return null;
            }
        }
    }
    public void desconecta() {
        boolean result = true;
        try {
            ConexaoPostgress.close();
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Não foi possivel fechar o banco de dados: " + "\n" + fecha);
            result = false;
        }
    }
    public void executeSQL(String sql) {
        try {
            statement = ConexaoPostgress.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
            retorno = 1;
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o registro \n" + sqlex);
        }
    }

    public static void main(String[] args) {
        ConexaoPostgress conexao = new ConexaoPostgress();

        conexao.executeSQL("SELECT COALESCE(MAX(idcidade),0) + 1 AS ULTIMO FROM CADCIDADE");

        try {
            resultset.first();
            JOptionPane.showMessageDialog(null, resultset.getString("ultimo"));
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoPostgress.class.getName()).log(Level.SEVERE, null, ex);
        }
//        String sql = "SELECT * FROM CADCIDADE";
//
//        conexao.executeSQL(sql);

//        try {
//            while (resultset.next()) {
//                JOptionPane.showMessageDialog(null, resultset.getString("dscidade"));
//            }
//        } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null, "Erro ao listar no JTable " + erro);
//        }
//        try {
//            conexao.resultset.first();
//            String teste = resultset.getString("dscidade");
//            JOptionPane.showMessageDialog(null, resultset.getString("dscidade"));
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
    }
}
