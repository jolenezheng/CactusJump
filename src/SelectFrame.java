import javax.swing.JFrame;
import javax.swing.JPanel;

class SelectFrame extends JFrame{
  
  private int gender;
  
  //constructor
  SelectFrame(int gender){
    super("Cactus Climber");
    
    this.gender = gender;
    
    //set up frame
    setSize(800,800);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //create panel 
    JPanel panel = new SelectPanel(this, gender);
    
    add(panel);
    
    //set visible
    setVisible(true);
  }
  
}