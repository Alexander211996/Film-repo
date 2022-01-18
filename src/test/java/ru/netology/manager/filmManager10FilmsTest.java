package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)

public class filmManager10FilmsTest {
    @Mock
            private FilmRepository repository = Mockito.mock(FilmRepository.class);
    @InjectMocks
        private FilmManager manager = new FilmManager(repository);

        private Film first = new Film (1, "Avatar");
        private Film second = new Film (2, "Green Mile");
        private Film third = new Film(3, "Venom 2");
        private Film fourth = new Film (4, "Undisputed 4");
        private Film fifth = new Film (5, "Star Wars Episode 9");
        private Film sixth = new Film (6, "Warcraft");
        private Film seventh = new Film (7, "Supernatural");
        private Film eighth = new Film (8, "Predator");
        private Film ninth = new Film (9, "The Witcher");
        private Film tenth = new Film (10, "Thanos");
        private Film eleventh = new Film(11, "Collapse");

        @Test
        public void shouldFindAll() {
            Film[] returned = new Film[] {tenth, ninth, eighth, seventh};
            doReturn(returned).when(repository).findAll();

            Film [] expected = new Film[] {tenth, ninth, eighth, seventh};
            Film [] actual = manager.findAll();

            assertArrayEquals(expected, actual);

        }

        @Test
        public void shouldAddNewFilm() {
            repository.saveNew(eleventh);

            Film[] returned = new Film[] {eleventh, tenth, ninth, eighth, seventh};
            doReturn(returned).when(repository).findAll();

            Film [] expected = new Film[] {eleventh, tenth, ninth, eighth, seventh};
            Film [] actual = manager.findAll();

            assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldFindById() {
            int id = 3;
            Film returned = new Film (3, "Venom 2");
            doReturn(returned).when(repository).findById(id);

            Film expected = new Film(3, "Venom 2");
            Film actual = manager.findById(3);

            assertEquals(expected, actual);
        }

    @Test
    public void shouldRemoveById() {
        repository.removeById(3);

        Film[] returned = new Film[] {first, second};
        doReturn(returned).when(repository).findAll();

        Film[] expected = new Film [] {first, second} ;
        Film[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        Film[] returned = new Film[0];
        doReturn(returned).when(repository).removeAll();

        Film [] expected = new Film[0];
        Film [] actual = manager.removeAll();

        assertArrayEquals(expected, actual);

    }

};
