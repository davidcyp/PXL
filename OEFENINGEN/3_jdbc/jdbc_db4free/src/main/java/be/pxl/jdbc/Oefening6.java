package be.pxl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Oefening6 {

    public static void main(String[] args) throws Exception {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/davidcyp", "davidcyp", "pxlpxl");
        ){
            System.err.println("We hebben een connectie");

            try(Statement statement = con.createStatement(); Statement statement2 = con.createStatement()){
                con.setAutoCommit(false);
                statement.executeUpdate("UPDATE bankrekening SET saldo = 800 WHERE rekeningnummer = 1");
                if(true) throw new Exception("Oei, de data is nog niet gecommit en er loopt iets fout");
                statement2.executeUpdate("UPDATE bankrekening SET saldo = 400 WHERE rekeningnummer = 2");
                con.commit();
            } catch (Exception e){
                System.err.println("De transactie is foutgelopen");
                con.rollback();
            }

        } catch( Exception e){
            System.err.println("Er is iets foutgelopen");
            e.printStackTrace();
        }
    }

}
