import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {

    Connection db;

    public Data(String database) {
        try
        {
            //assuming that the connected DB is MYSQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            db = DriverManager.getConnection(database);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean beginTran() {
        try {
            //JDBC will have autocommit on by default.
            //Turning it off is the equivalent of "starting" a transaction.
            //Thus, commit and rollback can be called manually.
            db.setAutoCommit(false);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean commit() {
        System.out.println("Committing transaction");
        try {
             db.commit();
             return true;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean rollback (){
        System.out.println("Rolling back transaction");
        try {
            db.rollback();
            return true;
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public int insert(String table, Pet object) {
        System.out.println("Inserting " + object.getName() + " into table " + table);
        try {
            Statement statement = db.createStatement();
            return statement.executeUpdate(
                    "INSERT INTO " + table + " (Name, Age, FavoriteFood) VALUES ('"
                            + object.getName() +"', '" + object.getAge() + "', '" + object.getFavoriteFood() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
