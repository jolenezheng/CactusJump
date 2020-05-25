import java.awt.Rectangle;
class CollisionDetector {
  
  public boolean collidesWithRectangles(Rectangle rect1, Rectangle rect2) {
    if (rect1.intersects(rect2)) {
      return true;
    } else {
      return false;
    }
  }
  
  
  public boolean bulletKillsEnemy(Rectangle bullet, Rectangle enemy) { 
    if (enemy.intersects(bullet)) {
      return true;
      
    } else {
      return false;
    } 
  }
  
  
} //end of class