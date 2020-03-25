import daos.ConnectionFactory;
import daos.Player;
import daos.PlayerDAO;

import java.sql.Connection;
import java.util.List;

public class AppRunner {


    public static void main(String[] args) {
        System.out.println("Calling getConnection()...1");
        Connection connection = ConnectionFactory.getConnection();
        System.out.println("Calling getConnection()...2");
        PlayerDAO playerDAO = new PlayerDAO(connection);
        System.out.println("Calling getConnection()...3");
        List<Player> playerList = playerDAO.findAll();

        for (Player player : playerList) {
            System.out.println(player.toString());
        }

        System.out.println("-----------------------------------------------------------");

        Player aaa = new Player(16, "AAA", "USA", 24, 500, 1);

        playerDAO.create(aaa);

        System.out.println(playerDAO.findByID(16).toString());

        System.out.println("-----------------------------------------------------------");

        aaa.setPoints(1000);
        aaa.setTourn_played(2);
        playerDAO.update(aaa);

        System.out.println(playerDAO.findByID(16).toString());

        System.out.println("-----------------------------------------------------------");

        playerList = playerDAO.findAll();

        for (Player player : playerList) {
            System.out.println(player.toString());
        }

        System.out.println("-----------------------------------------------------------");

        playerDAO.delete(16);
    }
}

