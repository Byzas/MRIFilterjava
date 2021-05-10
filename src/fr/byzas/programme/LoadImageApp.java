package fr.byzas.programme;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class LoadImageApp extends Component{
	
	BufferedImage img;

	public LoadImageApp() {
		try {
	           img = ImageIO.read(new File("./ress/IrmTete.jpg"));
	       } catch (IOException e) {
	       }
	}
	
	public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
	


    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
	
	public void DisplayImg() {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Load Image Sample");
		
		f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    f.add(this);
    f.pack();
    f.setVisible(true);
	}

}
