import java.awt.*;
import java.io.*; 
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

class Map {
  
  BufferedImage image = null;
  BufferedImage image2 = null;
  ArrayList<BufferedImage> stars = new ArrayList<BufferedImage>();
  boolean drawStars = false;
  boolean changed = false;
  int playerX=0;
  int playerY=0;
  
  public Map() { 
    try {
      image = ImageIO.read(new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/New Cactus Climber/background.png"));
      //image2 = ImageIO.read(new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/Cactus Climber- Rachel/stars.png"));
      playerX=image.getWidth()/2 + 100;  //place the player in the center of the map
      playerY=image.getHeight()/2;
    } catch(Exception E) { 
      System.out.println("error loading map!");
    }
  }
  
  public void updateStars(){
  }
  
  public void draw(Graphics g) { 
    
    // Background BufferedImage
    if (playerY < image.getHeight() * 2 - 500) {
      g.drawImage(image,playerX-image.getWidth(),playerY-image.getHeight(),null);
      g.drawImage(image2,playerX-image.getWidth(),playerY- ((2*image.getHeight()) - 200),null);
    } else {
      g.drawImage(image2, -500, - 500, null);
      drawStars = true;
    }
  }
}