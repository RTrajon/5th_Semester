import javax.swing.*;

interface Vehicle {
    void setPrice(double price);
    double getPrice();
}
interface Moveable {
    void start();
    void stop();
}
interface Flyable {
    void fly();
}

class Car implements Vehicle, Moveable {
    double price;

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public void start() {
        // Start the car
    }

    @Override
    public void stop() {
        // Stop the car
    }
}
class Airplane implements Vehicle, Moveable, Flyable {
    double price;

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public void start() {
        // Start the airplane
    }

    @Override
    public void stop() {
        // Stop the airplane
    }

    @Override
    public void fly() {
        // Fly the airplane
    }
}
public class Gui {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vehicle Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the GUI components
        JPanel panel = new JPanel();

        // Create a label for the price
        JLabel priceLabel = new JLabel("Price: ");
        panel.add(priceLabel);

        // Create a text field for the price
        JTextField priceField = new JTextField();
        panel.add(priceField);

        // Create a button to create a new vehicle
        JButton createButton = new JButton("Create");
        createButton.addActionListener(e -> {
            // Get the price from the text field
            double price = Double.parseDouble(priceField.getText());

            // Create a new vehicle
            Vehicle vehicle = null;
            if (priceField.getText().equals("100.00")) {
                vehicle = new Car();
            } else if (priceField.getText().equals("200.00")) {
                vehicle = new Airplane();
            }

            // Set the price of the vehicle
            vehicle.setPrice(price);

            // Display the price of the vehicle
            JOptionPane.showMessageDialog(frame, "The price of the vehicle is " + vehicle.getPrice());
        });
        panel.add(createButton);

        // Add the panel to the frame
        frame.add(panel);

        // Display the frame
        frame.pack();
        frame.setVisible(true);
    }
}
