import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class PhoneManagementApp {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phones", "root", "root");
        findPhonesByProperty(connection);
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

    public static void updatePhoneById(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Scanner sc = new Scanner(System.in);

        int id;
        String property;
        char answer;
        boolean isPresent = false;

        do {
            System.out.println("Which phone do you want to update ? Please enter Id:");
            id = sc.nextInt();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM telephones WHERE id=" + id);
            if (!resultSet.next()) {
                System.out.println("Phone with id = " + id + " does not exist.");
            }else {
                isPresent = true;
            }
        }while (!isPresent);

        System.out.println("Do you want to update brand ? [y/n]");

        answer = confirmation(sc);

        updateSelectedProperty(statement, id, answer, "brand");

        System.out.println("Do you want to update model ? [y/n]");

        answer = confirmation(sc);

        updateSelectedProperty(statement, id, answer, "model");

        System.out.println("Do you want to update color ? [y/n]");

        answer = confirmation(sc);

        updateSelectedProperty(statement, id, answer, "color");
    }

    private static void updateSelectedProperty(Statement statement, int id, char answer, String property) throws SQLException {
        if (answer == 'y') {
            System.out.println("Enter new brand: ");
            Scanner sc1 = new Scanner(System.in);
            String value = sc1.nextLine();
            String updateBrandQuery = "UPDATE telephones SET " + property + " = " + "'" + value + "'" + " WHERE id = " + id;
            statement.executeUpdate(updateBrandQuery);
        }
    }

    private static char confirmation(Scanner sc) {
        char answer;
        do {
            answer = sc.next().charAt(0);
            if(answer != 'n' && answer != 'y'){
                System.out.println("Please enter 'y' or 'n'");
            }
        }while(answer != 'y' && answer != 'n');
        return answer;
    }

    public static void findPhonesByProperty(Connection connection) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String property;
        String propertyValue;
        Scanner sc = new Scanner(System.in);
        System.out.println("Which property are you looking for ?");
        property = sc.nextLine().toLowerCase(Locale.ROOT);
        System.out.println("Enter the " + property + " you are looking for");
        propertyValue = sc.nextLine().toLowerCase(Locale.ROOT);

        String findByPropertyQuery = "SELECT * FROM telephones WHERE " + "`" + property + "`" + "=" + "'" + propertyValue + "'";
        ResultSet resultSet = statement.executeQuery(findByPropertyQuery);

        if (resultSet.next()) {
            resultSet.beforeFirst(); // moves the pointer of the current (ResultSet) object to the default position.
            while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getString("id")
                        + ", Brand: " + resultSet.getString("brand")
                        + ", Model: " + resultSet.getString("model")
                        + ", Color: " + resultSet.getString("color"));
            }
        } else {
            System.out.println("No such record found");
        }
    }
}
