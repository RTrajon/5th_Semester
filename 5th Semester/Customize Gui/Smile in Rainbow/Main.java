
//fig-7.26
import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {
    DrawRainbow panel = new DrawRainbow();
    JFrame application = new JFrame();

    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    application.add(panel);
    application.setSize(400, 250);
    application.setVisible(true);

    
  
       // DrawSmiley panel = new DrawSmiley();
       // JFrame application = new JFrame();

        //application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //  application.add(panel);
        //application.setSize(230, 250);
       // application.setVisible(true);
    }
}
