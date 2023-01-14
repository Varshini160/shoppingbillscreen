import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Shoping extends JFrame implements ActionListener
{	
	JLabel iname,runit,discount,tamount,namount,quantity,hshop;
	JTextField name,rate,dis,namt,totamt,quan;
	JRadioButton plat,gold,silver;
	JButton cal,close;
	ButtonGroup Bg=new ButtonGroup();
	public Shoping()
	{	
		setLayout(null);
		JPanel p=new JPanel();
		p.setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Happy Shopping Label
		hshop=new JLabel("Happy Shopping");
		hshop.setFont(new Font("Arial", Font.BOLD, 18)); 
		add(hshop);
		hshop.setBounds(120,15,150,25);

		//Item Name
		iname=new JLabel("Item Name:");
		name=new JTextField();
		add(iname);
		add(name);
		iname.setBounds(20,50,90,20);
		name.setBounds(100,50,120,20);
		
		//Rate 
		runit=new JLabel("Rate(per unit):");
		rate=new JTextField();
		add(runit);
		add(rate);
		runit.setBounds(20,80,90,20);
		rate.setBounds(110,80,80,20);

		//Quantity
		quantity=new JLabel("Quantity:");
		quan=new JTextField();
		add(quantity);
		add(quan);
		quantity.setBounds(20,110,80,20);
		quan.setBounds(105,110,80,20);

		//Total Amount 
		tamount=new JLabel("Total Amount:");
		totamt=new JTextField();
		totamt.setEditable(false);
		add(tamount);
		add(totamt);
		tamount.setBounds(20,140,100,20);
		totamt.setBounds(105,140,80,20);

		//Discount
		discount=new JLabel("Discount:");
		dis=new JTextField();
		dis.setEditable(false);
		add(discount);
		add(dis);
		discount.setBounds(20,170,80,20);
		dis.setBounds(105,170,80,20);

		//Net Amount
		namount=new JLabel("Net Amount:");
		namt=new JTextField();
		namt.setEditable(false);
		add(namount);
		add(namt);
		namount.setBounds(20,200,100,20);
		namt.setBounds(105,200,80,20);

		//Member Card
		plat=new JRadioButton("Platinum");
		gold=new JRadioButton("Gold");
		silver=new JRadioButton("Silver");
		p.add(plat);p.add(gold);p.add(silver);
		plat.setBounds(20,25,80,20);    
		gold.setBounds(20,45,80,20); 
		silver.setBounds(20,65,80,20); 
		Bg.add(plat);Bg.add(gold);Bg.add(silver);
		p.setBorder(new TitledBorder(new EtchedBorder(),"Membership card"));

		//Calculate
		cal=new JButton("Calculate");
		add(cal);
		cal.setBounds(220,185,90,25);
		cal.addActionListener(this);

		//Close
		close=new JButton("Close");
		add(close);
		close.addActionListener(this);
		close.setBounds(220,215,75,25);

		add(p);
		p.setBounds(220,75,125,100);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String c=ae.getActionCommand();
		
		if(c.equals("Close"))
		{
			JFrame jf=new JFrame();
			int result = JOptionPane.showConfirmDialog(jf,"Are you sure? You want to exit?", "Close",
              				 JOptionPane.YES_NO_OPTION,
               				 JOptionPane.WARNING_MESSAGE);
			if(result == JOptionPane.YES_OPTION)
			{
				System.exit(0);
           		                 }
		}
		else
		{
			if(name.getText().isEmpty())
			{
				 JOptionPane.showMessageDialog(new JFrame(),"Enter Item Name", "Warning",
               				 JOptionPane.ERROR_MESSAGE);
			}
			else if(rate.getText().isEmpty())
			{
				rate.requestFocus(true);
			}
			else if(quan.getText().isEmpty())
			{
				quan.requestFocus(true);
			}
			else
			{
				try
				{
					int r=Integer.parseInt(rate.getText());
					int q=Integer.parseInt(quan.getText());
					float amt=(float)r*q;
					float d=0;
					if(plat.isSelected())
					{
						d=amt*0.1f;
						dis.setText(""+String.format("%.1f",d));
						namt.setText(""+String.format("%.1f",(amt-d)));
						totamt.setText(""+String.format("%.1f",amt));
					}
					else if(gold.isSelected())
					{
						d=amt*0.06f;
						dis.setText(""+String.format("%.1f",d));
						namt.setText(""+String.format("%.1f",(amt-d)));
						totamt.setText(""+String.format("%.1f",amt));
					}
					else if(silver.isSelected())
					{
						d=amt*0.03f;
						dis.setText(""+String.format("%.1f",d));
						namt.setText(""+String.format("%.1f",(amt-d)));
						totamt.setText(""+String.format("%.1f",amt));
					}
					else
					{
						plat.requestFocus(true);
					}
				}
				catch(Exception e)
				{
					quan.setText("");
					rate.setText("");
					rate.requestFocus(true);
				}
			}
		}
	}
	public static void main(String args[])
	{
		Shoping s=new Shoping();
		s.setSize(400,300);
		s.setVisible(true);
		s.setResizable(false);
		s.setLocationRelativeTo(null);
	}
}