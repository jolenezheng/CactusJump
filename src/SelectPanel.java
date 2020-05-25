import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.io.File;

class SelectPanel extends JPanel implements MouseListener{
  
  private BufferedImage background;
  private JFrame frame;
  private int gender;
  
  //constructor
  SelectPanel(JFrame frame, int gender){
    
    this.frame = frame;
    this.gender = gender;
    addMouseListener(this);
    
    //create images
    try{
    background = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/Select.png"));
    }catch(Exception e){
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
      JFrame menu = new OpenFrame();
      frame.dispose();
      
    }else if(e.getX() > 138 && e.getX() < 662 && e.getY() > 172 && e.getY() < 305){
      //play continuous mode
      
      JFrame game = new GameFrame(gender);
      //game.run();
      frame.dispose();
    }else if(e.getX() > 138 && e.getX() < 662 && e.getY() > 350 && e.getY() < 483){
      //create level
      
      //level editor frame
      frame.dispose();
      
    }else if(e.getX() > 138 && e.getX() < 662 && e.getY() > 523 && e.getY() < 653){
      //view list of levels
      
      //list of levels frame
      JFrame selectLevel = new SelectLevelFrame(gender);
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

