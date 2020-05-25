import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File; 
import javax.imageio.ImageIO;

class WinPanel extends JPanel implements MouseListener{
  private JFrame frame;
  private Image background;
  
  //constructor
  WinPanel(JFrame frame){
    
    this.frame = frame;
    
    addMouseListener(this);
    
    //create images
    try{
      background = ImageIO.read(new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/New Cactus Climber/Complete.png"));
    } catch(Exception e){
      System.out.println("error loading background for win");
    }
    
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(background, 0,0,null);
  }
  
  public void mousePressed(MouseEvent e) {
  }
  
  public void mouseReleased(MouseEvent e) {
    if(e.getX() > 245 && e.getX() < 553 && e.getY() > 170 && e.getY() < 305){
      JFrame menu = new OpenFrame();
      frame.dispose();
    }else if(e.getX() > 245 && e.getX() < 553 && e.getY() > 432 && e.getY() < 569){
      SelectGenderFrame select = new SelectGenderFrame();
      frame.dispose();
    }else if(e.getX() > 600 && e.getX() < 800 && e.getY() > 675 && e.getY() < 735){
      JFrame frame = new HighScoreFrame();
    }
  }
  
  public void mouseEntered(MouseEvent e) {
  }
  
  public void mouseExited(MouseEvent e) {
  }
  
  public void mouseClicked(MouseEvent e) {
  }
}