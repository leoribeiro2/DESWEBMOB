package br.com.leoribeiorweb.pipocaccp3anbua;

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
        films.add(film);

        film = new Film();
        film.setName("O Dia Depois de Amanhã");
        film.setGenre("Drama");
        films.add(film);

        return films;
    }
}
