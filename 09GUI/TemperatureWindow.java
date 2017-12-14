import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
private Container pane;

 private JButton ctof;
 private JButton ftoc;
 private JLabel l;
 private JTextField text;
 private JCheckBox c;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public TemperatureWindow() {
     this.setTitle("My first GUI");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
     ctof = new JButton("Convert to Farenheit");
     ftoc = new JButton("Convert to Celcius");
     l = new JLabel("Converting Temperatures",null,JLabel.CENTER);
     text = new JTextField(12);
     pane.add(l);
     pane.add(ctof);
     pane.add(ftoc);
     pane.add(text);
 }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	System.out.println(event); //prints the actions
	if(event.equals("Convert to Farenheit")){
	    text.setText(String.valueOf(CtoF(Double.parseDouble(text.getText()))));
	
	}
	if(event.equals("Convert to Celsius")){
	    text.setText(String.valueOf(FtoC(Double.parseDouble(text.getText()))));
	
	}
	
    }

    public static double CtoF(double t){
	return (t * 1.8) + 32;
    }

    public static double FtoC(double t){
	return (t - 32) / 1.8;
    }

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     TemperatureWindow g = new TemperatureWindow();
     g.setVisible(true);
     
  }
}
