import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.io.File;

class SelectLevelPanel extends JPanel implements MouseListener{
  
  private BufferedImage background;
  private JFrame frame;
  int gender;
  
  //constructor
  SelectLevelPanel(JFrame frame, int gender){
    
    this.frame = frame;
    
    addMouseListener(this);
    
    //create images
    try{
      background = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/SelectLevel.png"));
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
    
    if(e.getX() > 0 && e.getX() < 200 && e.getY() > 40 && e.getY() < 100){
      //back button
      
      //goes back to menu
      JFrame select = new SelectFrame(gender);
      frame.dispose();
      
    }else if(e.getX() > 228 && e.getX() < 592 && e.getY() > 230 && e.getY() < 360){
      //play 1
      
    }else if(e.getX() > 228 && e.getX() < 592 && e.getY() > 376 && e.getY() < 509){
      //play 2
      
    }else if(e.getX() > 228 && e.getX() < 592 && e.getY() > 523 && e.getY() < 660){
      //play 3
      
    }
  }
  
  public void mouseEntered(MouseEvent e) {
  }
  
  public void mouseExited(MouseEvent e) {
  }
  
  public void mouseClicked(MouseEvent e) {
  }
}