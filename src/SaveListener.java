import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveListener implements ActionListener {
	Window w;
	
	SaveListener(Window w){
		this.w = w;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String newPath = w.ta.getText();
		if(!newPath.endsWith(System.getProperty("line.separator"))) {newPath = newPath+System.getProperty("line.separator");}
		System.out.println(System.getProperty("line.separator"));
		newPath = newPath.replace(System.getProperty("line.separator"), ";");
		ProcessBuilder b = new ProcessBuilder("cmd.exe", "/C", "setx path \""+newPath+"\"");
		try {
			b.start();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
