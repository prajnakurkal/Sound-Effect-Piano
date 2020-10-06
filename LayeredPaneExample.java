import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
  
class LayeredPaneExample extends JFrame implements ActionListener
{
JLayeredPane pane;
JButton [] white = new JButton [8];
JButton [] black = new JButton [5];
String [] whiteSounds = {"drum_roll_rimshot.wav", "hit_with_frying_pan_y.wav", "glass_shatter2.wav", "fart_z.wav", 
                         "gasp_ohhh.wav", "fanfare_x.wav","honk_x.wav", "scream_x.wav"};
String [] blackSounds = {"hammer_anvil3.wav", "doorbell_x.wav","quick_fart_x.wav", "gun_44mag_11.wav", "gurgle_x.wav"};

   public LayeredPaneExample() 
   {  
      super("LayeredPane Example");  
      setSize(1600, 800);  
      pane = getLayeredPane();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      setResizable(false);
      whiteKeys();
      blackKeys(); 
   }  
   public void whiteKeys()
   {
      for(int i = 0; i < 1600; i += 200)
      {
         JButton whiteKey = new JButton();  
         whiteKey.setBackground(Color.white);  
         whiteKey.setBounds(i, 0, 200, 1600);
         whiteKey.addActionListener(this);
         white[i/200] = whiteKey;
         pane.add(whiteKey, new Integer(0));
      }
   }
   public void blackKeys()
   {
      for(int i = 150; i < 1400; i += 200)
      {  
         JButton blackKey = new JButton();  
         blackKey.setBackground(Color.black);
         blackKey.addActionListener(this);
         if(i != 550 && i != 1350)
         {
            blackKey.setBounds(i, 0, 100, 350);
            black[i/280] = blackKey;
            pane.add(blackKey, new Integer(1));
         }
      }

   }
   public void actionPerformed(ActionEvent e) 
   {
      for(int i = 0; i < 8; i++)
      {
         if(e.getSource() == white[i])
            StdAudio.play(whiteSounds[i]);
      }
      for(int i = 0; i < 5; i++)
      {
         if(e.getSource() == black[i])
            StdAudio.play(blackSounds[i]);
      }
   }
   public static void main(String[] args) 
   {  
      LayeredPaneExample panel = new  LayeredPaneExample();  
      panel.setVisible(true);  
   }  
}     