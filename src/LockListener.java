import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class LockListener implements ActionListener {
	
	Window w;
	boolean isLocked;
	LockListener(Window w){
		this.w = w;
		this.isLocked = true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.isLocked){
			 ((JButton) e.getSource()).setText("Lock");
			 w.ta.setEnabled(true);
			 isLocked=false;
		}
		else{
			 ((JButton) e.getSource()).setText("Unlock");
			 w.ta.setEnabled(false);
			 isLocked=true;
		}
	}

}
