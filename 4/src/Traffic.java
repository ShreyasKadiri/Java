//import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Traffic
{
public static void main(String[] arg)
{
//Creating the jframe
JFrame frm= new JFrame();
frm.setTitle("Traffic");
frm.setSize(500, 500);
frm.setLayout(null);
   	
//Creating the jpanel
JPanel pnl= new JPanel();
pnl.setSize(300,300);



//Creating the text field
JTextField tf = new JTextField(10);
tf.setBounds(125,60,50,50);
   		 
//Creating the radiobuttons for respective colors
JRadioButton b1= new JRadioButton("Green");
JRadioButton b2= new JRadioButton("Yellow");
JRadioButton b3= new JRadioButton("Red");
JRadioButton b4=new JRadioButton("No Signal");
   		 
//Setting the bounds for respective buttons
b1.setBounds(100,40,30,30);
b2.setBounds(125,40, 30, 30);
b3.setBounds(150,40,30,30);
b4.setBounds(160, 40, 30, 30);
   		
//Creating the buttongroup
ButtonGroup bg= new ButtonGroup();
bg.add(b1);
bg.add(b2);
bg.add(b3);
bg.add(b4);
   		 

   		
   		 
   		 
b4.addActionListener(new ActionListener() 
{
@Override
public void actionPerformed(ActionEvent arg0)
{
tf.setText("HAHAH");
tf.setForeground(Color.BLACK);
}});
   		 
   
b1.addActionListener(new ActionListener()
{  
public void actionPerformed(ActionEvent e)
{  
tf.setText("Go");  
tf.setForeground(Color.green);
}}); 
   		  
   		 
b2.addActionListener(new ActionListener()
{  
public void actionPerformed(ActionEvent e)
{  
tf.setText("Ready");  
tf.setForeground(Color.yellow);
}});  

b3.addActionListener(new ActionListener()
{  
public void actionPerformed(ActionEvent e)
{  
tf.setText("Stop");  
tf.setForeground(Color.red);
}});

pnl.add(b1);
pnl.add(b2);
pnl.add(b3);
pnl.add(b4);
pnl.add(tf);
frm.add(pnl);
frm.setVisible(true);
   		   
   		 
   		 
   		 
}

}

	
	
	
