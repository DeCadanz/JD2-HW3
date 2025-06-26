package by.it_academy.jd2.Mk_JD2_111_25.HW3.storage;

import by.it_academy.jd2.Mk_JD2_111_25.HW3.dto.Vote;
import by.it_academy.jd2.Mk_JD2_111_25.HW3.storage.api.IVoteStorage;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VoteStorageDB implements IVoteStorage {
    @Override
    public void add(Vote vote) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/votebase";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        props.setProperty("ssl", "false");

        try (Connection conn = DriverManager.getConnection(url, props);
             PreparedStatement statement = conn.prepareStatement("""
                         INSERT INTO vote_app.vote(dt_create, artist, genre_1, genre_2, genre_3, genre_4, genre_5, about)
                         	VALUES (now(), ?, ?, ?, ?, ?, ?, ?);
                     """);
        ) {

            statement.setString(1, vote.getArtist());
//            statement.setString(2, vote.getGenres().get(0));
//            statement.setString(3, vote.getGenres().get(1));
//            statement.setString(4, vote.getGenres().get(2));
//            statement.setString(5, vote.getGenres().get(3));
//            statement.setString(6, vote.getGenres().get(4));

            for (int i = 2; i <= 6; i++) {
                if (i > (vote.getGenres().size() + 1)) {
                    statement.setNull(i, Types.INTEGER);
                } else {
                    statement.setString(i, vote.getGenres().get(i - 2));
                }
            }

            statement.setString(7, vote.getAbout());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vote> getAll() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/votebase";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");
        props.setProperty("ssl", "false");

        try (Connection conn = DriverManager.getConnection(url, props);
             PreparedStatement statement = conn.prepareStatement("""
                          SELECT * FROM vote_app.vote;
                     """);
        ) {
            try (ResultSet resultSet = statement.executeQuery();) {
                List<Vote> l = new ArrayList();

                while (resultSet.next()) {
                    List<String> g = new ArrayList();
                    LocalDateTime dtCreate = resultSet.getObject("dt_create", LocalDateTime.class);
                    String artist = resultSet.getString("artist");
                    g.add(resultSet.getString("genre_1"));
                    g.add(resultSet.getString("genre_2"));
                    g.add(resultSet.getString("genre_3"));
                    if (resultSet.getString("genre_4") != null) {
                        g.add(resultSet.getString("genre_4"));
                    }
                    if (resultSet.getString("genre_5") != null) {
                        g.add(resultSet.getString("genre_5"));
                    }
                    String about = resultSet.getString("about");


                    Vote v = new Vote();
                    v.setDtCreate(dtCreate);
                    v.setArtist(artist);
                    v.setGenres(g);
                    v.setAbout(about);
                    l.add(v);

                }
                return l;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
