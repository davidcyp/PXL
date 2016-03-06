package be.pxl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

public class Oefening2 {

    public Collection<String> haalAlleTechoDeejaysOp() throws Exception {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/davidcyp", "davidcyp", "pxlpxl")){
            System.err.println("We hebben een connectie");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT naam FROM deejays WHERE genre LIKE 'techno'");
            return ResultSetUtil.mapStringFieldtToCollection(resultSet, "naam");
        }
    }
}
