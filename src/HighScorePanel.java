import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import java.io.PrintWriter;
import java.util.Scanner;


class HighScorePanel extends JPanel{
  
  int highestScore = GamePanel.getScore();
  int currentScore = GamePanel.getScore();
  BufferedImage background;
  String yours;
  String high;
  String cnvrtdHighestScore;
  String cnvrtdCurrentScore;
  String yourScore;
  String highScore;
  File myFile;
  Scanner fileInput;
  
  HighScorePanel(){
    
    //setting size
    setPreferredSize(new Dimension(300,500));
    
    //setting image as background to make it look nicer
    try{
     background = ImageIO.read(new File("back.png"));
    }catch(Exception e){
      System.out.println("error loading jpanel background");
    }
    
    try{
    myFile = new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/highscores.txt");
    fileInput = new Scanner (new File ("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/highscores.txt"));
    } catch(Exception e) {
      System.out.println("couldn't load highscore files");
    }
    

    //Looping through file to find the highest score
    while (fileInput.hasNextInt()) { 
      int tempHighScore = fileInput.nextInt(); //hold current score as a temp high score
      
      if (tempHighScore > highestScore) {
        highestScore = tempHighScore;    
        
      }
      
    }
    
    cnvrtdHighestScore = Integer.toString(highestScore);
    cnvrtdCurrentScore = Integer.toString(currentScore);
    
    //create jlabels to display high scores
    highScore = new String("The Highscore is:");
    yourScore = new String("Your score was:");
    high = new String(cnvrtdHighestScore);
    yours = new String(cnvrtdCurrentScore);
    
  }
  
  //@override
  public void paintComponent(Graphics g){
    
    //settings for graphics
    g.setFont(new Font("Verdana", Font.PLAIN, 10)); 
    g.setColor(Color.WHITE);
    
    //drawing background
    g.drawImage(background,0,0,null);
    
    //draw all the strings
    g.drawString(highScore,30,50);
    
    g.drawString(high,30,65);
    
    g.drawString(yourScore,30, 80);
    
    g.drawString(yours,30, 95);
    
  }
  
}