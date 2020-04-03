package org.example;
import java.sql.*;

    public class App {
        public static void main(String beterrabas[]) {
            Connection conn=null;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                String db= "controle_frequencia";
                String url = "jdbc:mysql://localhost:3306/controle_frequencia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                String user = "root";
                String psw = "";

                conn = DriverManager.getConnection(url,user,psw);
                String sql = "Select * FROM controle";
                PreparedStatement pstm = conn.prepareStatement(sql);

                ResultSet rs = pstm.executeQuery();
                while (rs.next()){
                    String nome= rs.getString("nome");
                    int tia = rs.getInt("TIA");
                    Date Horario_Saida = rs.getDate("Horario_Saida");
                    Date Horario_Entrada = rs.getDate("Horario_Entrada");
                    System.out.println("Aluno - "+nome+":   "+ tia + ":   " + Horario_Entrada + ":   " + Horario_Saida );
                }
                rs.close();
                conn.close();

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("SQL Exception");
                e.printStackTrace();
            }
        }
        }
