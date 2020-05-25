
import java.awt.*;
import java.io.*; 
import javax.imageio.ImageIO;

class Cactus extends Character{
  
  int number;
  double ground = 760;
  
  //constructor
  Cactus(int x, int y, int gender) {
    
    xPos = x;
    yPos = y;
    
    if(gender == 2){
      try{
        image1 = ImageIO.read(new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/New Cactus Climber/cactus1.png"));
        image2 = ImageIO.read(new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/New Cactus Climber/cactus2.png"));
      } catch(Exception e) {
        System.out.println("error char image");
      }
    } else if(gender == 1){
      try{
        image1 = ImageIO.read(new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/New Cactus Climber/cactusf1.png"));
        image2 = ImageIO.read(new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/New Cactus Climber/cactusf2.png"));
      } catch(Exception e) {
        System.out.println("error char image");
      }
    }
  }
  
  public void draw(Graphics g, int x, int y) {
    
    xPos = x;
    yPos = y;
    
    number++;
    if((number/15)%2 == 0){
      g.drawImage(image1,x, y, null);
    } else{
      g.drawImage(image2, x, y, null);
    }
  }
  
  public void shift(int amount){
    
    yPos += amount;
  
    BufferedImageBounds.setSize(image1.getWidth(), image1.getHeight());
    BufferedImageBounds.setLocation(xPos, yPos);
      
  }
  
  public int getY() {
    return yPos;
  }
  
//  public void disposeCactus(Graphics g, BufferedImage image1, BufferedImage image2) {
//    g.dispose(image1);
//    g.dispose(image2);
//  }

}