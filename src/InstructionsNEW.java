import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Image;

class Instructions extends JFrame{
  
    public Instructions(){
    super("Cactus Climber Instructions");
    
    //set up frame
    setSize(800,800);
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    //create panel 
    JPanel panel = new JPanel();
    
    Image image = null;
    
    try{
      //create image
      image = ImageIO.read(new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/New Cactus Climber/help.png"));
    }catch(Exception e){
      System.out.println("error loading instructions");
    }
    
    //create jlabel to display image
    JLabel label = new JLabel(new ImageIcon(image));
    
    panel.add(label);
    
    add(panel);
    
    //set visible
    setVisible(true);
  }
  
}