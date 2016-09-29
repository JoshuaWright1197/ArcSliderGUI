package ArcSliderGUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ArcSliderGUI extends JFrame implements ChangeListener
{
	//private JFrame win;
	private Draw topCanvas;
	private JPanel bottomPanel;
	private JSlider slider;
	private int X = 70;
	private int Y =  50;
	private int W  = 250;
	private int L =  200;
	private int V = 90;
	private int A = 45;
	
	
	public ArcSliderGUI()
	{
		super("Arc Slider");
		
		slider = new JSlider();
		topCanvas= new Draw();
		bottomPanel = new JPanel();
		
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new GridLayout(2,1));
		
		slider.setMaximum(90);
		slider.setMinimum(0);
		slider.setValue(45);
		slider.setMajorTickSpacing(15);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setOpaque(false);
		slider.setSnapToTicks(true);	
		slider.addChangeListener(this);	
		
		bottomPanel.setBackground(Color.WHITE);
		bottomPanel.add(slider);
		
		topCanvas.setBackground(Color.WHITE);
		
		this.add(topCanvas);
		this.add(bottomPanel);
		
		this.setVisible(true);
	}
		
		@Override
		public void stateChanged(ChangeEvent e)
		{
			A = slider.getValue();
			V = 180 - slider.getValue()*2;
			topCanvas.repaint();
			
		}
		
	
	private class Draw extends JPanel
	{
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			g.fillArc( X, Y, W , L, A, V);
		}
	}
	
	public static void main(String[] args) 
	{
		ArcSliderGUI frame = new ArcSliderGUI();
	}

	
}
