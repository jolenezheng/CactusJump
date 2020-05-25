import javax.swing.JFrame;
import javax.swing.JPanel;

class SelectLevelFrame extends JFrame{
  
  private int gender;
  
  //constructor
  SelectLevelFrame(int gender){
    super("Cactus Climber");
    
    this.gender = gender;
    
    //set up frame
    setSize(800,800);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //create panel 
    JPanel panel = new SelectLevelPanel(this, gender);
    
    add(panel);
    
    //set visible
    setVisible(true);
  }
  
}