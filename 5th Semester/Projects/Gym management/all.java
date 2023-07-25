import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Member {
    private int id;
    private String name;
    private int age;
    private String membershipType;
    private double balance;

    public Member(int id, String name, int age, String membershipType, double balance) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public double getBalance() {
        return balance;
    }

    public void addPayment(double amount) {
        balance += amount;
    }

    public void displayBalance() {
        System.out.println("Member: " + name + ", Balance: $" + balance);
    }
}

class Gym {
    private Connection connection;

    public Gym(Connection connection) {
        this.connection = connection;
    }

    public void addMember(Member member) throws SQLException {
        String query = "INSERT INTO members (name, age, membership_type, balance) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, member.getName());
        statement.setInt(2, member.getAge());
        statement.setString(3, member.getMembershipType());
        statement.setDouble(4, member.getBalance());
        statement.executeUpdate();
        statement.close();
        System.out.println("Member added: " + member.getName());
    }

    public void removeMember(Member member) throws SQLException {
        String query = "DELETE FROM members WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, member.getId());
        statement.executeUpdate();
        statement.close();
        System.out.println("Member removed: " + member.getName());
    }

    public List<Member> getAllMembers() throws SQLException {
        List<Member> members = new ArrayList<>();
        String query = "SELECT * FROM members";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String membershipType = resultSet.getString("membership_type");
            double balance = resultSet.getDouble("balance");
            Member member = new Member(id, name, age, membershipType, balance);
            members.add(member);
        }
        resultSet.close();
        statement.close();
        return members;
    }
}

public class GymSoftware {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/gym_db";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Gym gym = new Gym(connection);
            createMembersTable(connection);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Add Member");
                System.out.println("2. Remove Member");
                System.out.println("3. Display Members");
                System.out.println("4. Add Payment");
                System.out.println("5. Check Balance");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter member name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter member age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter membership type: ");
                        String membershipType = scanner.nextLine();
                        Member member = new Member(0, name, age, membershipType, 0.0);
                        gym.addMember(member);
                        break;
                    case 2:
                        System.out.print("Enter member ID: ");
                        int memberId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Member removeMember = findMember(gym, memberId);
                        if (removeMember != null) {
                            gym.removeMember(removeMember);
                        } else {
                            System.out.println("Member not found.");
                        }
                        break;
                    case 3:
                        List<Member> members = gym.getAllMembers();
                        System.out.println("Gym Members:");
                        for (Member m : members) {
                            System.out.println("ID: " + m.getId() +
                                    ", Name: " + m.getName() +
                                    ", Age: " + m.getAge() +
                                    ", Membership Type: " + m.getMembershipType() +
                                    ", Balance: $" + m.getBalance());
                        }
                        break;
                    case 4:
                        System.out.print("Enter member ID: ");
                        int paymentMemberId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Member paymentMember = findMember(gym, paymentMemberId);
                        if (paymentMember != null) {
                            System.out.print("Enter payment amount: ");
                            double amount = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline
                            paymentMember.addPayment(amount);
                            updateMemberBalance(connection, paymentMember);
                            System.out.println("Payment of $" + amount + " added to " + paymentMember.getName() + "'s account.");
                        } else {
                            System.out.println("Member not found.");
                        }
                        break;
                    case 5:
                        System.out.print("Enter member ID: ");
                        int balanceMemberId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        Member balanceMember = findMember(gym, balanceMemberId);
                        if (balanceMember != null) {
                            System.out.println("Member: " + balanceMember.getName() + ", Balance: $" + balanceMember.getBalance());
                        } else {
                            System.out.println("Member not found.");
                        }
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createMembersTable(Connection connection) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS members (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), age INT, membership_type VARCHAR(50), balance DOUBLE)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(query);
        statement.close();
    }

    private static Member findMember(Gym gym, int memberId) throws SQLException {
        List<Member> members = gym.getAllMembers();
        for (Member member : members) {
            if (member.getId() == memberId) {
                return member;
            }
        }
        return null;
    }

    private static void updateMemberBalance(Connection connection, Member member) throws SQLException {
        String query = "UPDATE members SET balance = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDouble(1, member.getBalance());
        statement.setInt(2, member.getId());
        statement.executeUpdate();
        statement.close();
    }
}
