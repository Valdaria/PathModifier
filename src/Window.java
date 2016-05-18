import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Window extends JFrame {
	JButton save;
	JButton lock;
	JTextArea ta;
	Window(){
		super("Path modifier");
		this.setSize(600, 250);
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		JLabel lpath = new JLabel("PATH");
		ta = new JTextArea();
		ta.setName("area");
		JScrollPane sp = new JScrollPane(ta);
		
		String pathValue = System.getenv("PATH");
		pathValue = pathValue.replace(";", System.getProperty("line.separator"));
		System.out.println(pathValue);
		ta.setText(pathValue);
		ta.setEnabled(false);
		
		//Buttons panel
		JPanel buttons = new JPanel();
		JPanel bCenter = new JPanel();
		bCenter.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttons.setLayout(new GridLayout(2,1));
		
		save = new JButton("Save");
		save.addActionListener(new SaveListener(this));
		lock = new JButton("Unlock");
		lock.addActionListener(new LockListener(this));
		bCenter.add(save);
		bCenter.add(lock);
		buttons.add(bCenter);
		
		
		c.add(lpath, BorderLayout.NORTH);
		c.add(sp, BorderLayout.CENTER);
		c.add(buttons, BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
}