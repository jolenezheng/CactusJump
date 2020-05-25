import javax.swing.JFrame;
import java.awt.Dimension;

class GameFrame extends JFrame {
  
  private GameFrame gameFrame = this;
  private int gender;
  
  public GameFrame(int gender) {
    
    //setting the title on the frame
    super("Cactus Climber!");
    //setting up size and close operations
    setPreferredSize(new Dimension(600,800));
    setResizable(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    System.out.println("game frame dimension set");
    
    this.gender = gender;    
    run();
  }
  
  void run() {
    System.out.println("got to run method");
    //creates a panel to add to frame
    GamePanel panel = new GamePanel(this, gender);
    gameFrame.dispose();
    add(panel);   
    pack();
    
    //display the frame
    setVisible(true);
    //panel.jump();
  }
  
  
}