import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class DemoPanel extends JPanel implements MouseListener
{
	Room m;
	int ticks;
	int mX, mY, wi, he;
	boolean botton;

	private Timer t;
	private boolean objectsHaveBeenInitialized = false;

	public DemoPanel(JFrame frame)
	{      		
		t = new Timer(15, new Listener());
		t.start();

		frame.addMouseListener ( this ) ;
	}


	public void paintComponent(Graphics g)
	{   
		wi = getWidth();
		he = getHeight();
		
		if (!objectsHaveBeenInitialized){objectsHaveBeenInitialized=true;initializeObjects(wi, he);}
		
		int fontSize = getHeight() / 20;
		g.setColor(Color.BLACK);
		
		g.fillRect(0, 0, wi, he);
		ticks++;

		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Serif", Font.BOLD, he/20));
		g.drawString("Day_Of_Week, Month Day, Year" , wi/100*33, he/20*2);
		
		for(int k = 0; k < 8; k++)
		{
			g.drawString(((k*2)+7)%24 + ":00" , wi/100*(16+(k*10)), he/20*4);
		}
		
		for(int k = 0; k < 3; k++)
		{
			g.drawString("Office " + (k+1) , wi/100*(4), he/80*(24+(k*11)));
		}
		
		g.fillRect(wi/20*5, he/20*15, wi/20*10, he/20*3);
		g.setColor(Color.BLACK);
		g.drawString("Confirm", wi/20*9, he/20*17);
		
		
		for(int k = 0; k < 3; k++)
		{			
			for(int p = 0; p < 16; p++)
			{
				m.getRooms().get(k).get(p).setAxis(wi/28*4 + 60*p, he/20*5 + 80*k);
				
				m.check(mX, mY, wi, he, 1);
				
				switch(m.getRooms().get(k).get(p).isTaken())
				{
					case 0 : g.setColor(Color.GREEN);
					break;
					
					case 1 : g.setColor(Color.YELLOW);
					break;
					
					default : g.setColor(Color.GRAY);
					break;
				}
				g.fillRect(wi/28*4 + 60*p, he/20*5 + 80*k, wi/28, he/20);
			}
		}

		g.setColor(Color.GREEN);
		g.setFont(new Font("Serif", Font.BOLD, fontSize));
		g.drawString("Ticks: " + ticks, wi/100, he/20*20);
		g.drawString("X: " + mX + " Y: " + mY, wi/100*85, he/20*20);

		
		

		g.drawLine(0, he/2, wi, he/2);
		g.drawLine(wi/2, 0, wi/2, he);
	}
	
	public void initializeObjects(int width, int height)
	{  
		m = new Room(0, "Pablo");
		m.set();
		
	}
	
	public void meh()
	{
		botton = true;
	}
	
	public void nah()
	{
		botton = false;
	}

	
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){repaint();}}

	public void mouseClicked(MouseEvent e)
	{
		System.out.println("Mouse Clicked");
	}

	public void mousePressed(MouseEvent e)
	{
		System.out.println("Mouse Pressed");
		m.check(mX, mY, wi, he, 1);
	}

	public void mouseReleased(MouseEvent e)
	{
		System.out.println("Mouse Released");
		mX=e.getX();
		mY=e.getY();
		m.check(mX, mY, wi, he, 2);
	}

	public void mouseEntered(MouseEvent e)
	{
		System.out.println("Mouse Enters the Screen");
	}

	public void mouseExited(MouseEvent e)
	{
		System.out.println("Mouse Exits the Screen");
	}
}