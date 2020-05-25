import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

class GamePanel extends JPanel implements KeyListener{
  
  CollisionDetector collisionDetector = new CollisionDetector();
  
  public int visibleHeight = 500, visibleWidth = 700;
  JFrame frame;
  boolean moveUp = false, moveDown = false;
  boolean cactusterLeft = false, cactusterRight = false;
  boolean shift = false;
  boolean gameOver = false;
  static int initialPlatform = 0;
  int hitGround = 0;
  int shiftValue = 2;
  int heightChange;
  static int score = 0; 
  
  Rectangle platformBounds = new Rectangle();
  Rectangle sunBounds = new Rectangle();
  Rectangle waterBounds = new Rectangle();
  Rectangle gameOverRect;
  Rectangle bullet;
  ArrayList<Platform> platformArrayList;
  ArrayList<PowerUpGeneration> sunArrayList;
  ArrayList<PowerUpGeneration> waterArrayList;
  ArrayList<Star> stars;
  ArrayList<Character> enemyArrayList;
  ArrayList<Rectangle> enemyRectangleArrayList;
  Random random = new Random();
  Map map;
  
  File myFile = new File("/Users/JoleneZheng/CS Side/Cactus Climber/imgs/highscores.txt");
  
  long previous = 0;
  long start = 0;
  
  int xPos = -10;
  int minPlatform;
  double xChange = 0;
  int yPos = visibleHeight;
  
  private double height = 0;
  private double speed = 10.0;
  static double gravity = 15.3;
  double delta = 0;
  double bulletY = yPos - 80*height;
  static double bulletYChange = -5;
  
  //loading ransparent image
  PowerUpGeneration transparentImage;
  
  //create an enemy array list using polymorphism. Make sure that the arrays are accessible in the update method in this class (using parameters or smth)
  Butterfly butterfly;
  Moth moth;
  Dragonfly dragonfly;
  Cactus cactus;
  Platform initialPlat;
  Timer timer;
  Timer gameTimer;
  
  //constructor
  public GamePanel(JFrame frame, int gender){
    
    //create reference to frame
    this.frame = frame;
    
    //set focus and add key listener
    addKeyListener(this);
    setFocusable(true);
    requestFocusInWindow();
    
    //create map
    map = new Map();
    
    timer = new Timer();
    gameTimer = new Timer();
    //powerUp =  new PowerUpGeneration();
    
    platformArrayList = new ArrayList<Platform>();
    sunArrayList = new ArrayList<PowerUpGeneration>();
    waterArrayList = new ArrayList<PowerUpGeneration>();    
    stars = new ArrayList<Star>();
    enemyArrayList = new ArrayList<Character>();
    enemyRectangleArrayList = new ArrayList<Rectangle>();
    
    for (int i = 0; i < 40; i ++){
      Platform plat = new Platform();
      platformArrayList.add(plat);
    }
    
    for (int i = 0; i < 1; i ++){
      PowerUpGeneration sun = new PowerUpGeneration();
      sunArrayList.add(sun);
    }      
    
    for (int i = 0; i < 1; i ++){
      PowerUpGeneration water = new PowerUpGeneration();
      waterArrayList.add(water);
    }
    
    for (int i = 0; i < 5; i ++) {
      enemyArrayList.add(nextEnemy());
    }
    
    for (int i = 0; i < 5; i ++) {
      Character characterTemp = nextEnemy();
      enemyRectangleArrayList.add(characterTemp.getBounds());
    }
    
    for (int i = 0; i < 50; i ++) {
      Star star = new Star();      
      stars.add(new Star());
    }
    
    //create cactus
    cactus = new Cactus(0,0,gender);
    gameOverRect = new Rectangle(0, 790, 600, 1);
    initialPlat = new Platform();
    jump();
    
  }
  
  public void paintComponent(Graphics g) {
    
    super.paintComponent(g); //makes sure it correctly draws panel
    bullet = new Rectangle(xPos,cactus.getY(), 10, 10);
    initialPlatform ++;

    //update
    update();
    
    gameTimer.start();

    //draw the map
    map.draw(g);

    // Draws platforms
    for (int i = 0; i < platformArrayList.size(); i ++) {     
      platformArrayList.get(i).draw(g); 
      //score += 4;
    }
    
    // Draws enemies
    for (int i = 0; i < enemyArrayList.size(); i ++) {     
      enemyArrayList.get(i).draw(g);      
    }
    
    // Draws sun powerups
    for (int i = 0; i < sunArrayList.size(); i ++) {     
      sunArrayList.get(i).draw(g);      
    }
    
    // Draws water powerup
    for (int i = 0; i < waterArrayList.size(); i ++) {     
      waterArrayList.get(i).draw(g);      
    }
    
    // Draws stars
    for (int i = 0; i < stars.size(); i ++) {    
      stars.get(i).draw(g);    
    }
    
    if (timer.getElapsedTime() > 10000) {
      gravity = 15.3;
    }
    
    cactus.draw(g, xPos, (int)(yPos - 80*height));
    jump();
    
    //bullet
    g.setColor(Color.darkGray);
    g.fillRect(xPos, (int)bulletY, 10, 10);
    
    repaint();
    
  }
  
  public void update() {
    
    
    bulletY += bulletYChange;
    //move cactuster
    if(cactusterLeft){
      cactus.xPos -= 3;
    }
    
    if(cactusterRight){
      cactus.xPos += 3;
    }
    
    if (cactus.yPos <= 290) {
      cactus.shift(8);
    }
    
    //int shiftValue = 4 + yPosDelta;
    
    // Checks whether or not the last platform that the cactus has touched is below 600 pixels on the screen
    
    if (platformArrayList.get(minPlatform).getY() < 600) { // If the platform is above 600
      
      if (cactusterLeft == true) {
        xPos -= 3;
      } else if (cactusterRight == true) {
        xPos += 3;
      }
      
      //height += 1.5;
      
      if (height > 700 || ((delta/1000000000) * speed < 0)) {        
        shift = false;       
      }
      
      for (int i = 0; i < platformArrayList.size(); i ++) {        
        platformArrayList.get(i).shift(4);     
      }
      
      for (int i = 0; i < enemyArrayList.size(); i ++) {        
        enemyArrayList.get(i).shift(3);        
      }
      
      for (int i = 0; i < 1; i ++) {        
        sunArrayList.get(i).shift(4);        
      }
      
      for (int i = 0; i < 1; i ++) {        
        waterArrayList.get(i).shift(4);        
      }
      
    }
    
    if (cactusterLeft == true) {
      xPos -= 3;
    } else if (cactusterRight == true) {
      xPos += 3;
    } else {
      //xChange = 0;
    }
    
    //COLLISION DETECTION
    if (collisionDetector.collidesWithRectangles(cactus.getBounds(), gameOverRect)) {
      hitGround ++;
    }
    
    //Check collision between bullet and enemy
    try {
      
      for (int i = 0; i < enemyRectangleArrayList.size(); i ++) {
        Character enemy = enemyArrayList.get(i);
        if (collisionDetector.collidesWithRectangles(bullet, enemy.getBounds())) {
          enemy.yChange = 8;
          enemy.stillAlive = false;
          //System.out.println("bullet killed enemy");
          //SoundEffects.playKillSound();
          break;
        }
      }

    } catch(Exception e) {}
    
    //Check collision between cactus and  sun powerup
    for (int i = 0; i < sunArrayList.size(); i ++) {
      PowerUpGeneration sunPowerUp = sunArrayList.get(i);
      if (collisionDetector.collidesWithRectangles(cactus.getBounds(), sunPowerUp.getSunImageBounds())) {
        //sunArrayList.set(i, sunArrayList.get(i).getTrans());
        gravity = 19.5;
        timer.start();
      }
    }
    
    //Check collision between cactus and water powerup
    for (int i = 0; i < waterArrayList.size(); i ++) {
      PowerUpGeneration waterPowerUp = waterArrayList.get(i);
      if (collisionDetector.collidesWithRectangles(cactus.getBounds(), waterPowerUp.getWaterImageBounds())) {
        //waterArrayList.set(i, waterArrayList.get(i).getTrans());
        gravity = 12.8;
        timer.start();
        
      }
    }
    
    //Loop through arrayList and check collision between cactus and platforms
    for (int i = 0; i < platformArrayList.size(); i++) {      
      Platform platform = platformArrayList.get(i);
      
      if (collisionDetector.collidesWithRectangles(cactus.getBounds(), platform.getBounds()) && ((delta/1000000000) * speed < 0)) {
        //if(cactus.yPos <= platform.getY() - 10) { //checks to see if platform was hit from above
        cactus.yPos = platform.getY() + 70;
        yPos = platform.getY() + 70;
        speed = 10;
        minPlatform = i;
        gameTimer.stop();
        //System.out.println(gameTimer.getElapsedTime());
        
        try {    
          SoundEffects.playJumpSound(); 
        } catch(Exception e) {}
        
        break; 
        //If it doesn't collide with any, set yPos back to bottom of frame
      } else if (!(collisionDetector.collidesWithRectangles(cactus.getBounds(), platform.getBounds()))) {        
        yPos = 750;    
      }
    }
    
    for (int i = 0; i < platformArrayList.size(); i ++) {
      score += platformArrayList.get(i).getShift();
    }    
    
    if (gameOver(hitGround) == true) {
      System.out.println("game over detected!!");
      JFrame dieFrame = new DieFrame();
      frame.dispose();
      try {
        saveScore(score, true);
      } catch(Exception e) {
        System.out.println("couldn't save score");
      }
    }
    
    score = 0;
  } //end of update
  
  public void keyPressed(KeyEvent e) {    
    
    if(e.getKeyCode() == KeyEvent.VK_LEFT){
      
      cactusterLeft = true;
      if (xPos < 0) {        
        xPos = 600;       
      }
      
    } else if(e.getKeyCode() == KeyEvent.VK_SPACE ){    

      if (bulletY <= 0) {
        bulletY = yPos - 80*height;
        bulletYChange -= 1;
      }
      try {
        SoundEffects.playBulletSound();
      } catch (Exception ex) {}

    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT ){
      cactusterRight = true;
      if (xPos > 600) {
        xPos = 0;
      }
    }
    
  }
  
  public void keyTyped(KeyEvent e){}
  
  public void keyReleased(KeyEvent e) {  
    
    if(e.getKeyCode() == KeyEvent.VK_LEFT){          
      cactusterLeft = false;
    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT ){
      cactusterRight = false;
    } else if(e.getKeyCode() == KeyEvent.VK_UP ){       
      moveUp = false; 
    }
    
  }
  
  public static double getCurrentGravity() {
    return gravity;
  }
  
  public void saveScore(int score, boolean toAppend) throws Exception {
    PrintWriter fileOutput = new PrintWriter(new FileOutputStream(myFile, toAppend));
    fileOutput.append(score + "\n");
    fileOutput.close();
  }
  
  static public int getScore() {
    return score;
  }
  
  public boolean gameOver(int hitGround) {
    
    for (int i = 0; i < enemyArrayList.size(); i ++) {
      Character enemy = enemyArrayList.get(i);
      if (collisionDetector.collidesWithRectangles(cactus.getBounds(), enemy.getBounds()) ||
          collisionDetector.collidesWithRectangles(cactus.getBounds(), enemy.getBounds()) ||
          collisionDetector.collidesWithRectangles(cactus.getBounds(), enemy.getBounds())){           
      }
      
      if (hitGround > 1) {
        return true;
      }
    }
    
    return false;
    
  }
  
  //gravity
  public void jump() {  
    
    //while(runGame) {
    
    start = System.nanoTime(); 
    
    if (previous != 0) {
      delta = start - previous;
      height += (delta/1000000000) * speed;        
      speed -= (delta/1000000000) * gravity;  
      
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } //end of try catch         
    } //end of if 
    
    if (height < 0) {
      height = 0;
      speed = 10.0; 
    } 
    
    previous = start; //reset
    
    //end of while loop  
  } // end of jump()
  
  public Character nextEnemy(){
    
    int enemyType;
    int enemyX, enemyY;
    
    enemyType = Math.abs(random.nextInt()) % 3;
    enemyX = Math.abs(random.nextInt()) % 580 + 10;
    enemyY = random.nextInt() % 1000 - 1000;
    
    if (enemyType == 0) {
      Butterfly tempEnemy = new Butterfly(enemyX, enemyY);
      return tempEnemy;
    } else if (enemyType == 1) {
      Dragonfly tempEnemy = new Dragonfly(enemyX, enemyY);
      return tempEnemy;
    } else if (enemyType == 2) {
      Moth tempEnemy = new Moth(enemyX, enemyY);
      return tempEnemy;
    }
    
    return null;
    
  }
}
