import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Random;

class Platform {
  
  BufferedImage platImage;
  Rectangle platImageBounds = new Rectangle();
  int xPos, yPos;
  Random random = new Random();
  static int timesShifted = 0;
  
  //constructor
  Platform(){
    
    if (GamePanel.initialPlatform == 1) {
      
      xPos = 30;
      yPos = 700;
      
    }
    
    xPos = Math.abs(random.nextInt()) % 550 + 5;
    yPos = (random.nextInt()) % 1000;
    try{
      platImage = ImageIO.read(new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/New Cactus Climber/platform.png"));
    }catch(Exception e){
      System.out.println("error platform image");
    }
  }
  
  public void shift(int amount){
    
    yPos += amount;
    
    if (yPos > 1250){
      
      timesShifted ++;
      
      xPos = Math.abs(random.nextInt()) % 550 + 5;
      yPos = Math.abs(random.nextInt()) % 1000 - 1000;
      
    }
    platImageBounds.setSize(platImage.getWidth(), platImage.getHeight());
    platImageBounds.setLocation(xPos, yPos);
    
    
  }
  
  public void draw(Graphics g){
    g.drawImage(platImage,xPos,yPos, null);
  }
  
  public BufferedImage getPlatImage() {
    return platImage;
  }
  
  public Rectangle getBounds() {
    
    if (yPos > 0){
      platImageBounds.setSize(platImage.getWidth(), platImage.getHeight());
      platImageBounds.setLocation(xPos, yPos);
    } else {
      
      platImageBounds.setLocation(-100, -100);
      
    }
    
    return platImageBounds;
    
  }
  
  public int getX() {
    return xPos;
  }
  
  public int getY() {
    return yPos;
  }
  
  public static int getShift() {
    return timesShifted;
  }
  
}