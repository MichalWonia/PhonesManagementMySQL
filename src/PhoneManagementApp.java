import java.sql.*;
import java.util.Scanner;

public class PhoneManagementApp {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phones", "root", "root");
        deletePhoneById(connection);
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

    public static void addNewPhone(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        String brand;
        String model;
        String color;
        System.out.println("Fill in the missing fields: ");
        System.out.println("Brand: ");
        brand = sc.nextLine();
        System.out.println("Model: ");
        model = sc.nextLine();
        System.out.println("Color: ");
        color = sc.nextLine();

        String addNewPhoneQuery = "INSERT INTO telephones (`brand`, `model`, `color`) VALUES (" + "'" + brand + "'" + ", " + "'" + model + "'" + ", " + "'" + color + "'" + ")";
        statement.executeUpdate(addNewPhoneQuery);
        System.out.println("New phone added");
    }

    public static void deletePhoneById(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);
        System.out.println("Which phone do you want to delete ? Please enter ID: ");
        int id = sc.nextInt();
        String deleteByIdQuery = "DELETE FROM telephones WHERE id = " + id;
        statement.executeUpdate(deleteByIdQuery);
        System.out.println("The phone has been deleted");
    }
}
