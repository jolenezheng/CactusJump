import javax.swing.JFrame;
import javax.swing.JPanel;

class WinFrame extends JFrame{
    //constructor
  WinFrame(){
    super("Cactus Climber");
    
    JFrame frame = this;
    
    //set up frame
    setSize(800,800);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //create panel 
    JPanel panel = new WinPanel(frame);
    
    add(panel);
    
    //set visible
    setVisible(true);
  }
  
}