import javax.swing.JFrame;
import javax.swing.JPanel;

class OpenFrame extends JFrame{
  
  //constructor
  OpenFrame(){
    super("Cactus Climber");
    
    JFrame frame = this;
    
    //set up frame
    setSize(896,896);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //create panel 
    JPanel panel = new OpenPanel(frame);
    
    add(panel);
    
    //set visible
    setVisible(true);
  }
  
}