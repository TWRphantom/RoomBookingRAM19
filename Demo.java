import javax.swing.JFrame;
public class Demo
{
 public static void main(String[] args)
 {
  JFrame frame = new JFrame("Demo");
  frame.setSize(1280, 720);
  frame.setLocation(150,50);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setContentPane(new DemoPanel(frame));
  frame.setVisible(true);
  //frame.setResizable(false);
 }
}