import javax.swing.JFrame;
import javax.swing.JPanel;

class HighScoreFrame extends JFrame{
  
  HighScoreFrame(){
    
    //call to super to set name
    super("Scores!");
    
    //settings for the jframe
    setSize(300,500);
    setResizable(false);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    //create jpanel to display the high scores
    JPanel panel = new HighScorePanel();
    
    add(panel);
    
    pack();
    
    this.setVisible(true);
    
  }
  
}