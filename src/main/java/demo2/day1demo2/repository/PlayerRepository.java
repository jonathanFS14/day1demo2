package demo2.day1demo2.repository;

import demo2.day1demo2.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    Player findByName(String player);
    Player findByNameLike(String player);

}
