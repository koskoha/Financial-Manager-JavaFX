package Model;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Set;

public class DbHelper {
    public static final String DB_URL = "jdbc:sqlite:src/FM.db";
    private static DbHelper instance= null;
    private Connection connection;


    public DbHelper() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DB_URL);
            String createSQL = readResource(DbHelper.class, "/SQL/create.sql");
            String insertSQL = readResource(DbHelper.class, "/SQL/insert.sql");

            Statement statement = connection.createStatement();
            statement.executeUpdate(createSQL);
            //statement.executeUpdate(insertSQL);
            closeResource(statement);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //   closeResource(connection);
        }
    }

    private String readResource(Class<DbHelper> dbHelperClass, String path) throws URISyntaxException, IOException {
        URL resource = dbHelperClass.getResource(path);
        Path resPath = Paths.get(resource.toURI());
        return new String(Files.readAllBytes(resPath));
    }

    private void closeResource(AutoCloseable res) {
        if (res != null) {
            try {
                res.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        res = null;
    }

    public static DbHelper getInstance() {
        if (instance == null) {
            return new DbHelper();
        } else
            return instance;
    }

    public Connection getConnection() {
        return connection;
    }


    public String getResult(String query) {
        StringBuilder sb = new StringBuilder();
        try {
            connection = DriverManager.getConnection(DB_URL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("password");
                sb.append(String.format("id: %d, name: %s%n", id, name));

            }
            closeResource(resultSet);
            closeResource(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //  closeResource(connection);
        }

        return sb.toString();
    }

}
