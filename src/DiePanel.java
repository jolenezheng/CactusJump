import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File; 
import javax.imageio.ImageIO;

class DiePanel extends JPanel implements MouseListener{
  
  private JFrame frame;
  private Image background;
  
  //constructor
  DiePanel(JFrame frame){
    
    this.frame = frame;
    
    addMouseListener(this);
    
    
    //create images
    try{
    background = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/Oops.png"));
    }catch(Exception e){
      System.out.println("error loading background for lose");
    }
    
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(background, 0,0,null);
  }
  
  public void mousePressed(MouseEvent e) {
  }
  
  public void mouseReleased(MouseEvent e) {
    if(e.getX() > 200 && e.getX() < 710 && e.getY() > 350 && e.getY() < 460){
      SelectGenderFrame select = new SelectGenderFrame();
      frame.dispose();
    }else if(e.getX() > 275 && e.getX() < 650 && e.getY() >480 && e.getY() < 612){
      JFrame menu = new OpenFrame();
      frame.dispose();
    }
  }
  
  public void mouseEntered(MouseEvent e) {
  }
  
  public void mouseExited(MouseEvent e) {
  }
  
  public void mouseClicked(MouseEvent e) {
  }
}