import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

abstract class Character {
  
  Rectangle BufferedImageBounds = new Rectangle();
  SoundEffects soundEffects = new SoundEffects();
  
  BufferedImage image1;
  BufferedImage image2;
  Random random = new Random();
  boolean stillAlive = true;
  protected int xPos, yPos;
  protected int xChange = 0;
  protected int yChange = 0;
  
  public Character() {
  }
  
  //constructor
//  public Character(int x, int y) {
//    xPos = x;
//    yPos = y;
//    
//  }
  
  public void draw (Graphics g) {
  }
  
  public Rectangle getBounds() {

    BufferedImageBounds.setSize(image1.getWidth() - 10, image2.getHeight() - 10);
    BufferedImageBounds.setLocation(xPos + 5, yPos + 10);
    return BufferedImageBounds;
    
  }
  
  public void shift(int amount){}
  
}