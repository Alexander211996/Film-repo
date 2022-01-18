package ru.netology.manager;

import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

public class FilmManager {
    private int filmsQuantity;
    private Film[] films = new Film[filmsQuantity];

    FilmRepository repo = new FilmRepository ();

    public FilmManager(FilmRepository repository) {
    }

    public Film[] findAll() {
        Film[] films = repo.findAll();
        return films;
    }

    public Film[] addNewFilm(Film film) {
        repo.saveNew (film);
        return films;
    }

    public Film findById(int id) {
        Film result = repo.findById(id);
        return result;
    }

    public Film[] removeById(int id) {
        repo.removeById(id);
        return films;
    }

    public Film [] removeAll() {
        Film [] result = repo.removeAll();
        return  result;
    }

}
