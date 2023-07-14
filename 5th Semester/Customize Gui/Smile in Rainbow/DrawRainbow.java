
// Fig. 7.25
// Drawing a rainbow using arcs and an array of colors.
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawRainbow extends JPanel 
{
  // define indigo and violet
  private final static Color RED = new Color(255, 0, 0);

  private final static Color ORANGE = new Color(255, 165, 0);

  // colors to use in the rainbow, starting from the innermost
  // The two white entries result in an empty arc in the center

  private Color[] colors = { Color.WHITE, Color.WHITE, RED, ORANGE, Color.YELLOW,
      Color.GREEN, Color.BLUE, Color.BLUE, Color.MAGENTA };

  public DrawRainbow()
  {
    setBackground(Color.WHITE); // set the background to white
  }

  // draws a rainbow using concentric arcs
  /* (non-Javadoc)
   * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
   */
  public void paintComponent(Graphics g) 
  {
    super.paintComponent(g);

    int radius = 20; // radius of an arc
    // draw the rainbow near the bottom-center
    int centerX = getWidth() / 2;
    int centerY = getHeight() - 20;

    // draws filled arcs starting with the outermost
    for (int counter = colors.length; counter > 0; counter--) 
    {
      // set the color for the current arc
      g.setColor(colors[counter - 1]);

      // fill the arc from 0 to 180 degrees
      g.fillArc(centerX - counter * radius,
          centerY - counter * radius,
          counter * radius * 2, counter * radius * 2, 180, 360);

    }

    //public void paintComponent(Graphics c)
    //{
  //super.paintComponent(c);
        g.setColor(Color.YELLOW);// draw the face
        g.fillOval(142, 140, 100, 100);


        g.setColor(Color.BLACK);// draw the eyes
        g.fillOval(162, 167, 15, 15);
        g.fillOval(212, 167, 15, 15);


        g.fillOval(162, 180, 60, 30); // draw the mouth

        // "touch up" the mouth into a smile
        g.setColor(Color.YELLOW);
        g.fillRect(162, 180, 60, 15);
        g.fillOval(162, 185, 60, 20);
  }
}
