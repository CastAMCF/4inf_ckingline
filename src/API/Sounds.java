package API;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.*;

public class Sounds {
	
	public static void PlaySound(String path, int volume) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Clip clip;
		InputStream in = Sounds.class.getResourceAsStream(path);
		InputStream bufferedIn = new BufferedInputStream(in);
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
		clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue((float)(volume-84));
		clip.start();
    }
	
}
