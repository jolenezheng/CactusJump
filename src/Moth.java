import java.awt.Graphics;
import java.io.*; 
import javax.imageio.ImageIO;
import java.awt.Rectangle;

class Moth extends Character{
  
  int number;
  
  //constructor
  Moth(int x, int y) {
    
    xPos = x;
    yPos = y;
    
    xChange = 1;
    
    try{
      image1 = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/mothr1.png"));
      image2 = ImageIO.read(new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/mothr2.png"));
    }catch(Exception e){
      System.out.println("error enemy BufferedImage");
    }
  }
  
  public void draw(Graphics g){
    
    if (stillAlive) {
      
      if(xPos >= 600) {
        xChange = -1;
      } else if (xPos <= 0) {
        xChange = 1;
      }
      
    }
    xPos += xChange;
    
    number++;
    if((number/10)%2 == 0){
      g.drawImage(image1, xPos, yPos, null);
    } else{
      g.drawImage(image2, xPos, yPos, null);
    }
  }
  

  
  public void shift(int amount){
    
    yPos += amount;
  
    
    
    if (yPos > 1250){
      
      xPos = Math.abs(random.nextInt()) % 550 + 5;
      yPos = Math.abs(random.nextInt()) % 1000 - 1000;
      
    }
    BufferedImageBounds.setSize(image1.getWidth(), image1.getHeight());
    BufferedImageBounds.setLocation(xPos, yPos);
    
    
  }
}