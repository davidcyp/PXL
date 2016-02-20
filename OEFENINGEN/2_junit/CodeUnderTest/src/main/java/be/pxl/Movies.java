package be.pxl;

import java.util.ArrayList;
import java.util.Collection;

public class Movies {

    private Collection<MovieCharacter> characters = new ArrayList<>();

    public void addMovieCharacter(MovieCharacter character){
        characters.add(character);
    }

    public Collection<MovieCharacter> getAllCasts(){
        return characters;
    }

    public Collection<MovieCharacter> getCastFor(String movie){
        Collection<MovieCharacter> result = new ArrayList<>();

        for(MovieCharacter character: characters){
            if(character.getMovie().equalsIgnoreCase(movie)){
                result.add(character);
            }
        }

        return result;
    }
}
