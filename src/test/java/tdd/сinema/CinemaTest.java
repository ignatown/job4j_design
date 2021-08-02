package tdd.сinema;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Test
    public void whenBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test(expected = NullPointerException.class)
    public void whenNotBuy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 15, 11, date);
    }

    @Test
    public void whenFind() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test(expected = NullPointerException.class)
    public void whenNotFail() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> false);
    }

    @Test
    public void whenAdd() {
        Cinema newCinema = new Cinema3D();
        Session3D newSession = new Session3D();
        newCinema.add(newSession);
        List<Session> sessions = newCinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(newSession)));
    }


}