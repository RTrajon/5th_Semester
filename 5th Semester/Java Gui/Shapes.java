// chapters 5.27

import java.awt.Graphics;
import javax.swing.JPanel;

public class Shapes extends JPanel
{
   private int choice; 


    public Shapes(int userChoice)
    {
       choice = userChoice;
    }

    public void paintComponent(Graphics g)
    {
       super.paintComponent(g);

        for (int i = 0; i < 10; i++)
       {
          switch (choice)
           {
              case 1: 


              break;
              case 2:


              break;
            }
        }
    }
 } 