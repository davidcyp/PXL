package be.pxl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Oefening1 {

    public int maakConnectie(){
        try (Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/davidcyp", "davidcyp", "pxlpxl")){
            System.err.println("We hebben een connectie");

            Statement statement = con.createStatement();
            int resultaat = statement.executeUpdate("INSERT INTO leerlingen (naam) VALUES ('David')");
            return resultaat;
        }
        catch (Exception e){
            System.err.println("Er heeft zich een fout voorgedaan");
            System.err.println(e);
        }
        return 0;
    }
}
