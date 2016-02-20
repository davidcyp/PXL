package be.pxl;

public class MovieCharacter {

    private String name;
    private String movie;

    public MovieCharacter(String name, String movie){
        this.name = name;
        this.movie = movie;
    }

    public String getName() {
        return name;
    }

    public String getMovie() {
        return movie;
    }
}
