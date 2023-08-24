package demo2.day1demo2.repository;

import demo2.day1demo2.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    PlayerRepository playerRepository;

    boolean isInitialized = false;


    @BeforeEach
    void setUp() {
        if (!isInitialized){
            playerRepository.save(new Player("Lionel Messi","argentina","attacker"));
            playerRepository.save(new Player("ronaldo","portugal","attacker"));
            isInitialized = true;
        }
    }

    @Test
    public void deleteAll (){
        playerRepository.deleteAll();
        assertEquals(0, playerRepository.count());
    }

    @Test
    public void testAll(){
        long count = playerRepository.count();
        assertEquals(2, count);
    }

    @Test
    void findByName() {
        Player p1 = playerRepository.findByName("ronaldo");
        assertEquals("ronaldo", p1.getName());
    }


    @Test
    void findByNameLike() {
        Player p = playerRepository.findByNameLike("%Messi%");
        assertEquals("Lionel Messi", p.getName());
    }

}