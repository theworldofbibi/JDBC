package org.example;

import java.sql.*;
public class JDBC {
    public static void main (String[] args) {
        Connection connection = null;
        try {
            Class.forName ("com.mysql.cj.jdbc.Driver").newInstance();

            String db = "Entregável";
            String url = "jdbc:mysql://127.0.0.1/" + db;
            String user = "root";
            String password = " ";

            connection = DriverManager.getConnection(url,user,password);

            String inserir = "INSERT INTO controle_frequencia VALUES (1,'31745547','7:30','10:55')";
            PreparedStatement pstm = connection.prepareStatement(inserir);
            pstm.execute();
            System.out.println ("Seus dados foram inseridos com sucesso!");

            String sql = "SELECT * FROM controle_frequencia";
            PreparedStatement pstm1 = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                String pk = rs.getString("PK");
                String tia = rs.getString("TIA");
                String horarioEntrada = rs.getString("Horário de Entrada");
                String horarioSaida = rs.getString("Horário de Saída");

                System.out.println ("#" + pk + " " + tia + "-" + horarioEntrada + "-" + horarioSaida);
            }
            rs.close();
            connection.close();

        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            System.out.println("SQL EXCEPTION");
            e.printStackTrace();
        }
    }
}