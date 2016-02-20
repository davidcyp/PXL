package be.pxl;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MovieCharacterAssertJTest {

    private final static String K3_THE_MOVIE = "K3 The Movie";
    private final static String DARDENNEN = "D'Ardennen";
    private final static String KLAASJE = "Klaasje";
    private final static String MARTHE = "Marthe";
    private final static String HANNE = "Hanne";
    private final static String KEVIN = "Kevin Janssens";
    private final static String VEERLE = "Veerle Baetens";

    private MovieCharacter Klaasje = new MovieCharacter(KLAASJE, K3_THE_MOVIE);
    private MovieCharacter Marthe = new MovieCharacter(MARTHE, K3_THE_MOVIE);
    private MovieCharacter Hanne = new MovieCharacter(HANNE, K3_THE_MOVIE);
    private MovieCharacter Kevin = new MovieCharacter(KEVIN, DARDENNEN);
    private MovieCharacter Veerle = new MovieCharacter(VEERLE, DARDENNEN);

    @InjectMocks private Movies movies;

    @Before
    public void before(){
        movies.addMovieCharacter(Klaasje);
        movies.addMovieCharacter(Marthe);
        movies.addMovieCharacter(Hanne);
        movies.addMovieCharacter(Kevin);
        movies.addMovieCharacter(Veerle);
    }

    @Test
    public void moviesCastForK3TheMovie(){
        Assertions.assertThat(movies.getAllCasts())
                .filteredOn("movie", K3_THE_MOVIE)
                .containsOnly(Marthe, Hanne, Klaasje);
    }

}
