package br.com.leoribeiorweb.pipocaccp3anbua;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    public static ArrayList<String> listNames(ArrayList<Film> films) {
        ArrayList<String> names = new ArrayList<>();
        for (Film film :  films) {
            names.add(film.getName());
        }
        return names;
    }

    public static ArrayList<Film> listFilms(String genre) {
        Film[] list;
        ArrayList<Film> films = new ArrayList<>();
        for (Film film : allFilms()) {
            if (film.getGenre().equals(genre) || genre.equals("Todos")) {
                films.add(film);
            }
        }

        list = films.toArray(new Film[0]);

        Arrays.sort(list);

        films = new ArrayList<>();
        for (int i = 0; i < list.length; i ++) {
            films.add(list[i]);
        }
        return films;
    }

    private static ArrayList<Film> allFilms() {
        ArrayList<Film> films = new ArrayList<>();
        Film film;

        film = new Film();
        film.setName("Missão Impossível");
        film.setGenre("Ação");
        film.setDirector("Brian De Palma");
        film.setReleaseDate(LocalDate.of(1996, 07, 26));
        film.setDescription("An American agent, under false suspicion of disloyalty, must discover " +
                "and expose the real spy without the help of his organization.");
        films.add(film);

        film = new Film();
        film.setName("O Dia Depois de Amanhã");
        film.setGenre("Drama");
        film.setDirector("Roland Emmerich");
        film.setReleaseDate(LocalDate.of(2004, 05, 24));
        film.setDescription("Jack Hall, paleoclimatologist, must make a daring trek from Washington" +
                ", D.C. to New York City, to reach his son, trapped in the cross-hairs of a sudden" +
                " international storm which plunges the planet into a new Ice Age.");
        films.add(film);

        return films;
    }
}
