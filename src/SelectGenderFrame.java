import javax.swing.JFrame;
import javax.swing.JPanel;

class SelectGenderFrame extends JFrame{
  
  //constructor
  SelectGenderFrame(){
    super("Cactus Climber");
    
    //set up frame
    setSize(800,800);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //create panel 
    JPanel panel = new SelectGenderPanel(this);
    
    add(panel);
    
    //set visible
    setVisible(true);
  }
  
}