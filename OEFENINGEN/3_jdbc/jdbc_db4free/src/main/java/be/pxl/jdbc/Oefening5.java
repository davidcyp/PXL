package be.pxl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;

public class Oefening5 {

    private static class Deejay {
        String naam, genre;
        public Deejay(String naam, String genre){
            this.naam = naam;
            this.genre = genre;
        }

        public String getNaam() {
            return naam;
        }

        public String getGenre() {
            return genre;
        }
    }

    /**
     * Dit is een mogelijke oplossing voor oefening 5
     */

    public static void main(String[] args) throws Exception {

        List<Deejay> nieuweDeejays = Arrays.asList(new Deejay("Sven Vath", "techno"), new Deejay("Dave Clarke", "techno"),
                new Deejay("Dj Anton","apres-ski"));

        try (Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net/davidcyp", "davidcyp", "pxlpxl");
             PreparedStatement ps = con.prepareStatement("INSERT INTO deejays (naam,genre) VALUES (? , ?)")){
            System.err.println("We hebben een connectie");

            for(Deejay dj: nieuweDeejays){
                ps.setString(1, dj.getNaam());
                ps.setString(2, dj.getGenre());
                int result = ps.executeUpdate();
                System.err.println("De query heeft " + result + " aantal rijen aangepast in de database");
            }
        }
    }
}
