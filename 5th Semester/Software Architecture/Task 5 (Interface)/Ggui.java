import javax.swing.*;
public class Ggui {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vehicle Builder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the GUI components
        JPanel panel = new JPanel();

        // Create a label for the price
        JLabel priceLabel = new JLabel("Price: ");
        panel.add(priceLabel);

        // Add the panel to the frame
        frame.add(panel);

        // Display the frame
        frame.pack();
        frame.setVisible(true);

    }
}