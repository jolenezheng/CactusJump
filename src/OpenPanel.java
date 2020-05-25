import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File; 
import javax.imageio.ImageIO;

class OpenPanel extends JPanel implements MouseListener{
  
  private JFrame frame;
  private int gender;
  private Image background;
  
  //constructor
  OpenPanel(JFrame frame){
    
    this.frame = frame;
    
    addMouseListener(this);
    
    //create images
    try{
    background = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/Opening.png"));
    }catch(Exception e){
      System.out.println("error loading menu image");
    }

  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(background,0,0,null);
  }
  
  public void mousePressed(MouseEvent e) {
  }
  
  public void mouseReleased(MouseEvent e) {
    if( e.getX() > 260 && e.getX() < 637 && e.getY() >450 && e.getY() < 598){
      JFrame select = new SelectGenderFrame();
      frame.dispose();
    } else if(e.getX() > 260 && e.getX() < 637 && e.getY() >620 && e.getY() < 754){
      JFrame help = new Instructions();
    }
  }
  
  public void mouseEntered(MouseEvent e) {
  }
  
  public void mouseExited(MouseEvent e) {
  }
  
  public void mouseClicked(MouseEvent e) {
  }
    
}