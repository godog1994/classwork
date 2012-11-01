import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
/**
 * A scale resizable USA flag. Window can be dragged to change size. 
 * @author Alex Love
 *APCS per 2
 */

public class Flagv2 extends JFrame {
	
	
	private static final long serialVersionUID = 1;

	public Flagv2()
	{
        init();
	}
	
	public void init() {
		setSize(500, 300);
		setBackground(Color.WHITE);
		setContentPane(new FlagPane());
		repaint();
	}
    
    class FlagPane extends JPanel {
        
     
		private static final long serialVersionUID = 1;

		public void paint(Graphics g) {
        	
        	
            
            int flagLength;
            int flagWidth;
            if ( getWidth()/getHeight()> 1.9)//keep aspect ratio of flag
            {
            	flagWidth = getHeight();
            	flagLength = (int) (flagWidth*1.9);
            }
            else 
            {
            	flagLength = getWidth();
            	flagWidth = (int) (flagLength/1.9);
            }
            int unionWidth = 7*flagWidth/13; //blue union width
            int unionLength = (int)19*flagWidth/25; //blue union length
            int redStripeWidth = flagWidth/13; //width of one red stripe
            int widthInc = (int)63*flagWidth/1000;//increment between stars
            int lengthInc = (int)27*flagWidth/500;//increment between stars
            int starRadius = 77*flagWidth/2500;//radius of 1 star- to make stars bigger or smaller, increase/decrease
            
            g.setColor(Color.RED);
            for (int i = 0; i < 7; i++)//7 red stripes- to increase number of stripes make i less than or greater to a number
            {
                g.fillRect(0, redStripeWidth*2*i, flagLength, redStripeWidth);
            }
            
            // Turn on anti-aliasing to make the stars look nicer- delete this statement to make less nice
            ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, unionLength , unionWidth);//the blue union rectangle- increase or decrease unionLength & unionWidth to change size of this rectangle
            g.setColor(Color.WHITE);
            
            int[] xPoints = new int[10];// x points array for star
            int[] yPoints = new int[10];// y points array for star
            for (int i = 0; i < 10; i++)
            {
                if( i % 2 == 0) //if even
                {
                    xPoints[i] = (int) (starRadius*Math.sin(i *Math.PI/5)/2);//divided by 2 for the shorter star lines
                    yPoints[i] = (int) (starRadius*Math.cos(i *Math.PI/5)/2);
                }
                else//odd
                {
                    xPoints[i] = (int) (starRadius*Math.sin(i *Math.PI/5));//regular radius length
                    yPoints[i] = (int) (starRadius*Math.cos(i *Math.PI/5));
                }
                
                
                
            }
            
            for (int i = 0; i< 5; i++)//5 columns of stars- for more/less stars increase of decrease what i <> to
            {
                
                for (int j = 0; j<6; j++)// 6 rows per column
                {                    
                    int[] customxPoints = new int[10];
                    int[] customyPoints = new int[10];
                    for (int k = 0; k < 10; k++)//assign points to new array to extra width and length location each time
                    {
                        customxPoints[k] = (2*j+1)*widthInc + xPoints[k];
                        customyPoints[k] = (2*i+1)*lengthInc + yPoints[k];
                        
                    }
                    
                    g.fillPolygon(customxPoints, customyPoints, 10);//adding stars
                }
            }
            
            for (int i = 0; i< 4; i++)//4 columns of stars- for more or less, change what i is less than or greater to
            {
                
                for (int j = 0; j<5; j++)// 5 rows per column
                {
                    
                    
                    int[] customxPoints = new int[10];
                    int[] customyPoints = new int[10];
                    for (int k = 0; k < 10; k++)//assign points to new array to extra width and length location each time
                    {
                        customxPoints[k] = (2*j+2)*widthInc + xPoints[k];
                        customyPoints[k] = (2*i+2)*lengthInc + yPoints[k];
                        
                    }
                    g.fillPolygon(customxPoints, customyPoints, 10);//adding stars
                }
            }
            
        }
    }
    
	public static void main(String[] args) {
		
        Flagv2 flagv2 = new Flagv2();//make a new flag
        flagv2.setVisible(true);//make sure window is visible
        
        flagv2.setDefaultCloseOperation(EXIT_ON_CLOSE);//stop running when closed
	}
    
}