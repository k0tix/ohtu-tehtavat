package ohtuesimerkki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
            
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchReturnsPlayer() {
        Player p = stats.search("Kurri");
        assertEquals("Kurri", p.getName());
    }

    @Test
    public void searchReturnsNullForNonExistingPlayer() {
        Player p = stats.search(("Not real player"));
        assertNull(p);
    }

    @Test
    public void returnsCorrectTeam() {
        List<Player> team = stats.team("EDM");
        assertEquals(3, team.size());
        assertEquals("EDM", team.get(0).getTeam());
        assertEquals("EDM", team.get(1).getTeam());
        assertEquals("EDM", team.get(2).getTeam());
    }

    @Test
    public void returnsCorrectScores() {
        List<Player> scores = stats.topScorers(3);
        assertEquals(3, scores.size());
        assertEquals("Gretzky", scores.get(0).getName());
        assertEquals("Lemieux", scores.get(1).getName());
        assertEquals("Yzerman", scores.get(2).getName());
    }
}