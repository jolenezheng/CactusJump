import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.*; 
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Random;

class PowerUpGeneration {
  
  BufferedImage sunImage;
  BufferedImage waterImage;
  BufferedImage transparentImage;
  Rectangle sunImageBounds = new Rectangle();
  Rectangle waterImageBounds = new Rectangle();
  int xPos1, yPos1, xPos2, yPos2;
  Random random = new Random();
  int shiftAmount = 0;
  
  //constructor
  PowerUpGeneration(){
    
    xPos1 = Math.abs(random.nextInt()) % 550 + 5;
    yPos1 = (random.nextInt()) % 1000;
    
    xPos2 = Math.abs(random.nextInt()) % 550 + 5;
    yPos2 = (random.nextInt()) % 1000;
    
    try{
      sunImage = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/sun.png"));
      waterImage = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/water.png"));   
      transparentImage = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/empty.png"));
    }catch(Exception e){
      System.out.println("error powerup image");
    }
  }
  
  public BufferedImage getTrans(){
    return transparentImage;
  }
  
  public void shift(int amount){
    yPos1 += amount;
    yPos2 += amount;
  
    if (yPos1 > 1250 || yPos2 > 1250){
      
      xPos1 = Math.abs(random.nextInt()) % 550 + 5;
      yPos1 = Math.abs(random.nextInt()) % 1000 - 1000;
      
      xPos2 = Math.abs(random.nextInt()) % 550 + 5;
      yPos2 = Math.abs(random.nextInt()) % 1000 - 1000;
      
    }
    
    sunImageBounds.setSize(sunImage.getWidth(), sunImage.getHeight());
    sunImageBounds.setLocation(xPos1, yPos1);
    waterImageBounds.setSize(waterImage.getWidth(), waterImage.getHeight());
    waterImageBounds.setLocation(xPos2, yPos2);
    
  }
  
  public void draw(Graphics g){
    g.drawImage(sunImage,xPos1,yPos1, null);
    g.drawImage(waterImage, xPos2, yPos2, null);
  }
  
  public BufferedImage getSunImage() {
    return sunImage;
  }
  
  public BufferedImage getWaterImage() {
    return waterImage;
  }
  
  public Rectangle getSunImageBounds() {
    sunImageBounds.setSize(sunImage.getWidth(), sunImage.getHeight());
    sunImageBounds.setLocation(xPos1, yPos1);
    return sunImageBounds;
  }
  
  public Rectangle getWaterImageBounds() {
    waterImageBounds.setSize(waterImage.getWidth(), waterImage.getHeight());
    waterImageBounds.setLocation(xPos2, yPos2);
    return waterImageBounds;
  }
  
  public int getSunX() {
    return xPos1;
  }
  
  public int getSunY() {
    return yPos1;
  }
  
  public int getWaterX() {
    return xPos2;
  }
  
  public int getWaterY() {
    return yPos2;
  }  
  
}