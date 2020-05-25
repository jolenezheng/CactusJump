import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.event.MouseListener;
import java.io.File; 
import javax.imageio.ImageIO;

class SelectGenderPanel extends JPanel implements MouseListener{
  
  private int gender;
  private BufferedImage girl;
  private BufferedImage boy;
  private BufferedImage background;
  JFrame frame;
  
  //constructor
  SelectGenderPanel(JFrame frame){
    this.frame = frame;
    addMouseListener(this);
    
    //create images
    try {
      girl = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/girl.png"));
      boy = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/boy.png"));
      background = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/pick.png"));
    } catch(Exception e){
      System.out.println("error loading pick image");
    }

  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(background, 0,0, null);
    g.drawImage(girl, 140,350,null);
    g.drawImage(boy, 450,365, null);
  }

  public void mousePressed(MouseEvent e) {
  }
  
  public void mouseReleased(MouseEvent e) {
    if (e.getX() > 178 && e.getX() < 305 && e.getY() >360 && e.getY() < 626){
      gender = 1;
      System.out.println(gender);
      SelectFrame select = new SelectFrame(gender);
      frame.dispose();
      
    } else if (e.getX() > 493 && e.getX() < 615 && e.getY() >355 && e.getY() < 625){
      gender = 2;
      System.out.println(gender);
      SelectFrame select = new SelectFrame(gender);
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