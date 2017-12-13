import javax.swing.*;
import java.awt.*;
import java.awt.events.*;

public class TemperatureWindow extends JFrame implements ActionListener{
private Container pane;

 private JButton b;
 private JLabel l;
 private JTextField t;
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
     l = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
     t = new JTextField(12);
     pane.add(l);
     pane.add(ctof);
     pane.add(t);
 }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	System.out.println(event);
	if(event.equals("Convert to Farenheit")){
	    
	
    }
  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     TemperatureWindow g = new TemperatureWindow();
     g.setVisible(true);
     
  }
}
