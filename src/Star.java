import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

class Star {
  int xPos;
  int yPos;
  int yChange = 0;
  int scaledSize;
  int ySpeed;
  Random random = new Random();
  // ArrayList<Star> stars = new ArrayList<Star>();

  Star() {
    xPos = Math.abs(random.nextInt()) % 600 + 4;
    yPos = (Math.abs(random.nextInt()) % 2000) * (-1);
    scaledSize = Math.abs(random.nextInt()) % 8;
  }

  public void draw(Graphics g) {
    int randColor = Math.abs(random.nextInt()) % 200;
    int randColor2 = Math.abs(random.nextInt()) % 50 + 200;
    g.setColor(new Color(randColor2, randColor2, randColor));
    g.fillRect(xPos, yPos, this.scaledSize, this.scaledSize);
    this.fall();
  }

  void fall() {

    yChange++;

    if (yChange == 1 * (10 - scaledSize)) {
      yChange = 0;
      yPos++;
    }

    if (yPos > 1100) {
      yPos = (Math.abs(random.nextInt()) % 1000) * (-1) - 1000;
    }

  }

}