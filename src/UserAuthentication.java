import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuthentication {

    public int login (String number, String pin) {

        Connection conn = DatabaseConnection.connect();

        if (conn == null) {
            System.out.println("Unable to connect to the database.");
            return -1;
        }

        try {
            String sql = "SELECT ID, PIN FROM users WHERE Number = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, number);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPin = rs.getString("PIN");

                if (storedPin.equals(pin)) {
                    System.out.println("Logged in successfully.");

                    int storedID = rs.getInt("ID");

                    rs.close();
                    stmt.close();
                    conn.close();

                    return storedID;

                } else {
                    System.out.println("Incorrect PIN.");
                    rs.close();
                    stmt.close();
                    conn.close();
                    return -1;
                }
            } else {
                System.out.println("Phone number does not exist.");
                rs.close();
                stmt.close();
                conn.close();
                return -1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean changePin (String number, String currentPin, String newPin) {

        if (newPin.isBlank()) {
            System.out.println("PIN cannot be empty.");
            return false;
        } else if (newPin.length() != 4) {
            System.out.println("PIN must be exactly 4 digits.");
            return false;
        }

        try {
            Short.parseShort(newPin);
        } catch (NumberFormatException e) {
            System.out.println("Invalid PIN format.");
            return false;
        }

        Connection conn = DatabaseConnection.connect();

        if (conn == null) {
            System.out.println("Unable to connect to the database.");
            return false;
        }

        try {
            String sql = "SELECT * FROM users WHERE Number = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, number);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedPin = rs.getString("PIN");

                if (!storedPin.equals(currentPin)) {
                    System.out.println("Incorrect PIN.");
                    rs.close();
                    stmt.close();
                    conn.close();
                    return false;
                }
            } else {
                System.out.println("Phone number does not exist.");
                rs.close();
                stmt.close();
                conn.close();
                return false;
            }

            String updateSql = "UPDATE users SET PIN = ? WHERE Number = ?";

            PreparedStatement updateStmt = conn.prepareStatement(updateSql);

            updateStmt.setString(1, newPin);
            updateStmt.setString(2, number);

            updateStmt.executeUpdate();


            updateStmt.close();
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public boolean registerUser (String username, String email, String number, String pin) {

        if (username.isBlank()) {
            System.out.println("Username cannot be empty.");
            return false;
        }

        if (email.isBlank()) {
            System.out.println("Email cannot be empty.");
            return false;
        } else if (!isValidEmail(email)) {
            System.out.println("Invalid email format.");
            return false;
        }

        if (number.isBlank()) {
            System.out.println("Phone number cannot be empty.");
            return false;
        } else if (number.length() != 11 || !number.startsWith("09")) {
            System.out.println("Invalid phone number format.");
            return false;
        }

        try {
            Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid phone number format.");
            return false;
        }

        if (pin.isBlank()) {
            System.out.println("PIN cannot be empty.");
            return false;
        } else if (pin.length() != 4) {
            System.out.println("PIN must be exactly 4 digits.");
            return false;
        }

        try {
            Short.parseShort(pin);
        } catch (NumberFormatException e) {
            System.out.println("Invalid PIN format.");
            return false;
        }

        Connection conn = DatabaseConnection.connect();

            if (conn == null) {
                System.out.println("Unable to connect to the database.");
                return false;
            }

        try {

            if (emailExists(conn, email)) {
                System.out.println("Email already registered.");
                return false;
            }

            if (numberExists(conn, number)) {
                System.out.println("Phone number already registered.");
                return false;
            }

            String insertSql = "INSERT INTO users(User, Email, Number, PIN) VALUES (?, ?, ?, ?)";

            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, username);
            insertStmt.setString(2, email);
            insertStmt.setString(3, number);
            insertStmt.setString(4, pin);

            insertStmt.executeUpdate();

            System.out.println("User registered successfully.");

            insertStmt.close();
            conn.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void logout () {
        System.out.println("Logged out successfully.");
    }

    private boolean emailExists(Connection conn, String email) {
        try {
            String sql = "SELECT * FROM users WHERE Email = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            boolean exists = rs.next();

            rs.close();
            stmt.close();

            return exists;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean numberExists(Connection conn, String number) {
        try {
            String sql = "SELECT * FROM users WHERE Number = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, number);

            ResultSet rs = stmt.executeQuery();

            boolean exists = rs.next();

            rs.close();
            stmt.close();

            return exists;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isValidEmail(String email) {

        if (
                email.indexOf("@") != email.lastIndexOf("@") ||
                !email.contains("@") ||
                email.indexOf("@") == 0 ||
                email.indexOf("@") == email.length() - 1 ||

                !email.contains(".") ||
                email.indexOf(".") == email.indexOf("@") - 1 ||
                email.indexOf(".") == email.indexOf("@") + 1 ||
                email.indexOf(".") == email.length() - 1
        ) {
            return false;
        }

        return true;
    }

}