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
		this.save(newPath);

	}

	private String getPathValue(String oldValue){
		String OS = System.getProperty("os.name").toLowerCase();
		if(OS.indexOf("win") >= 0)
			return oldValue.replace(System.getProperty("line.separator"), ";");
		else if(OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") >= 0)
			return oldValue.replace(System.getProperty("line.separator"), ":");
		return "";
	}

	private void save(String p){
		String OS = System.getProperty("os.name").toLowerCase();
		if(OS.indexOf("win") >= 0){
			ProcessBuilder b = new ProcessBuilder("cmd.exe", "/C", "setx path \""+this.getPathValue(p)+"\"");
			try {
				b.start();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") >= 0){
			String cmd = "touch ~/.profile; echo 'PATH="+this.getPathValue(p) + "'>> ~/.profile; source ~/.bashrc";
			System.out.println(this.getPathValue(p));
			ProcessBuilder b = new ProcessBuilder("/bin/bash", "-c", cmd);
			try {
				b.start();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
