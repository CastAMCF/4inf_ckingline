package API;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.*;

/**
 * Tratamento dos sons
 * @author Asus
 */
public class Sounds {
	
        /**
         * Inicia um ficheiro de música pelo caminho especificado e com o volume designado
         * @param path
         * @param volume
         * @throws UnsupportedAudioFileException
         * @throws IOException
         * @throws LineUnavailableException 
         */
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
