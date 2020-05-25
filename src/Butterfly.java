import java.awt.*;
import java.io.*; 
import javax.imageio.ImageIO;

class Butterfly extends Character{
  
  private int number;
  
  //constructor
  Butterfly(int x, int y) {
    
    xPos = x;
    yPos = y;
    xChange = 1;
    yChange = 1;
    
    try{
      image1 = ImageIO.read(new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/New Cactus Climber/buttrl1.png"));
      image2 = ImageIO.read(new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/New Cactus Climber/buttrl2.png"));
    }catch(Exception e){
      System.out.println("error enemy image");
    }
  }
  
  public void draw(Graphics g){
    
    if (stillAlive) {
      if(xPos >= 180) {
        xChange = -1;
      } else if (xPos <= 50) {
        xChange = 1;
      }
    }
    
    xPos += xChange;
    
    if (stillAlive) {
      if(yPos >= 180) {
        yChange = -1;
      } else if (yPos <= 50) {
        yChange = 1;
      }
    }
    
    yPos += yChange;
    
    number++;
    if((number/10)%2 == 0){
      g.drawImage(image1,xPos,yPos, null);
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