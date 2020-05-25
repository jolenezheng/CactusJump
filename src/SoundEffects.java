import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.DataLine;

class SoundEffects {
  
  static File jumpAudioFile = new File("/Users/JoleneZheng/CS Side/Cactus Climber/sounds/jump.wav");
  
  public static void playJumpSound() throws Exception {
    try {
      if (GamePanel.getCurrentGravity() == 15.3) {
        jumpAudioFile = new File("/Users/JoleneZheng/CS Side/Cactus Climber/sounds/jump.wav");
      } else if (GamePanel.getCurrentGravity() == 19.5) {
        jumpAudioFile = new File("/Users/JoleneZheng/CS Side/Cactus Climber/sounds/SunPowerUp.wav");
      } else if (GamePanel.getCurrentGravity() == 12.8) {
        jumpAudioFile = new File("/Users/JoleneZheng/CS Side/Cactus Climber/sounds/WaterPowerUp.wav");
      }
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(jumpAudioFile);
      DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
      
      Clip clip = (Clip) AudioSystem.getLine(info);
      clip.open(audioStream);
      clip.start();   
    } catch (Exception e) {
      e.printStackTrace();
    }
  } //end of playJumpSound()
  
  
  public static void playBulletSound() throws Exception {
    try {
      File audioFile = new File("bullet.wav");
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
      DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
      
      Clip clip = (Clip) AudioSystem.getLine(info);
      clip.open(audioStream);
      clip.start();   
    } catch (Exception e) {
      e.printStackTrace();
    }
  } //end of playBulletSound()
  
  
//  public static void playSunJumpSound() throws Exception {
//    try {
//      File audioFile = new File("/Users/JoleneZheng/Codes/Grade 11  AP CompSci/Cactus Climber- Rachel/mario.wav");
//      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
//      DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
//      
//      Clip clip = (Clip) AudioSystem.getLine(info);
//      clip.open(audioStream);
//      clip.start();   
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  } //end of playHeavyPowerUpSound()
  
  public static void playKillSound() throws Exception {
    try {
      File audioFile = new File("pada.wav");
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
      DataLine.Info info = new DataLine.Info(Clip.class, audioStream.getFormat());
      
      Clip clip = (Clip) AudioSystem.getLine(info);
      clip.open(audioStream);
      clip.start();   
    } catch (Exception e) {
      e.printStackTrace();
    }
  } //end of playKillSound()
  
}