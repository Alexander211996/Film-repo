package ru.netology.manager;

import ru.netology.domain.Film;

import static java.lang.System.arraycopy;

public class FilmManager {
    private int filmsQuantity = 10;
    private Film[] films = new Film[filmsQuantity];

    public FilmManager(int filmsQuantity) {

        this.filmsQuantity = filmsQuantity;
    }

    public FilmManager() {

        this.filmsQuantity = 10;
    }

    public void addNewFilm(Film film) {
        int length = films.length + 1;
        Film[] tmp = new Film[length];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        System.arraycopy (films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Film[] getLast10Films() {
        Film[] result = new Film [filmsQuantity];
        int counter = 0;
        for (int i = 0; i < filmsQuantity; i++) {
            int index = films.length - i - 1;
            result[counter] = films[index];
            counter++;
        }

        Film[] finalResult = new Film[counter];
        arraycopy(result, 0, finalResult, 0, counter);

        return finalResult;
    }

}
