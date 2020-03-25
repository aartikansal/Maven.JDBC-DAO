package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO extends DAO<Player> {

    private static final String INSERT = "INSERT INTO myNewDB.players" +
            "(name, country, age, points, tourn_played)" +
            "VALUES(?,?,?,?,?)";
    private static final String GET_ONE = "SELECT * FROM myNewDB.players WHERE id = ?";
    private static final String GET_ALL = "SELECT * FROM myNewDB.players";
    private static final String UPDATE = "UPDATE myNewDB.players SET name = ?, country = ?, age = ?, points = ?, tourn_played = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM myNewDB.players WHERE id = ?";

    public PlayerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Player findByID(int id) {
        Player player = null;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(GET_ONE);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                player = new Player(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getInt("age"),
                        resultSet.getInt("points"),
                        resultSet.getInt("tourn_played")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    public ArrayList<Player> findAll() {
        ArrayList<Player> players = new ArrayList<Player>();
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(GET_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Player player = new Player(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country"),
                        resultSet.getInt("age"),
                        resultSet.getInt("points"),
                        resultSet.getInt("tourn_played")
                );
                players.add(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return players;
    }

    public Player update(Player dto) {
        Player player = null;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(UPDATE);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getCountry());
            ps.setInt(3, dto.getAge());
            ps.setInt(4, dto.getPoints());
            ps.setInt(5, dto.getTourn_played());
            ps.setInt(6, dto.getId());
            ps.executeUpdate();
            player = this.findByID(dto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    public Player create(Player dto) {
        Player player = null;
        try {
            PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(INSERT);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getCountry());
            ps.setInt(3, dto.getAge());
            ps.setInt(4, dto.getPoints());
            ps.setInt(5, dto.getTourn_played());
            ps.executeUpdate();

            ArrayList<Player> players = findAll();
            player = players.get(players.size() - 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return player;
    }

    public void delete(int id) {
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

