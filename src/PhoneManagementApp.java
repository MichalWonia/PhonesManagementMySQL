import java.sql.*;

public class PhoneManagementApp {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phones", "root", "root");
        showAllPhones(connection);
        connection.close();
    }

    public static void showAllPhones(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM telephones");

        System.out.println("All phones in the database are: ");
        while (resultSet.next()) {
            System.out.println(
                           "Id: " + resultSet.getString("id")
                    + ", Brand: " + resultSet.getString("brand")
                    + ", Model: " + resultSet.getString("model")
                    + ", Color: " + resultSet.getString("color"));
        }
    }
}
