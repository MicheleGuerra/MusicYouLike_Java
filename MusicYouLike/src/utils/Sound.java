package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import javax.sound.sampled.*;

/**
 * La classe Sound modella, riproduce e gestisce un suono in formato WAVE.
 *
 * @author Andrea D'Ottavio
 */
public class Sound {

    private static final Line.Info INFO = new Line.Info(Clip.class);
    private static HashMap<String, Sound> map;
    private URL soundUrl;
    private Clip readyClip;

    /**
     * Crea un nuovo suono a partire dal path assoluto di un file WAVE.
     *
     * @param path Il path assoluto di un file WAVE.
     * @throws SoundException Se il path non risulta puntare ad un corretto file
     * WAVE
     */
    public Sound(String path) throws SoundException, MalformedURLException {
        this(new URL(path));
    }

    /**
     * Crea un nuovo suono a partire da un file WAVE
     *
     * @param url Il file WAVE
     * @throws SoundException Se il file non risulta essere un corretto file
     * WAVE
     */
    public Sound(URL url) throws SoundException {
        if (url == null) {
            throw new SoundException("Cannot read " + url.getPath());
        }
        this.soundUrl = url;
        this.readyClip = this.getNewClip();
    }

    /**
     * Riproduce una volta il suono
     *
     * @return Un oggetto di tipo Clip che permette di gestire il suono
     */
    public Clip play() {
        return play(1);
    }

    /**
     * Riproduce all'infinito il suono
     *
     * @return Un oggetto di tipo Clip che permette di gestire il suono
     */
    public Clip loop() {
        return play(-1);
    }

    /**
     * Riproduce n volte il suono
     *
     * @param times Il numero di volte da riprodurre il suono (un numero
     * negativo provoca una riproduzione in loop)
     * @return Un oggetto di tipo Clip che permette di gestire il suono
     */
    public Clip play(int times) {
        Clip clip = null;
        try {
            clip = getNewClip();
        } catch (SoundException ex) {
            throw new RuntimeException(ex);
        }
        if (clip != null && times != 0) {
            clip.loop(times - 1);
        }
        return clip;
    }

    /**
     * Crea e restituisce un nuovo Clip del suono, pronto per essere riprodotto
     *
     * @return Un oggetto di tipo Clip che permette di gestire il suono
     * @throws SoundException Se non è possibile ottenere un Clip dal suono
     */
    public final Clip getNewClip() throws SoundException {
        try {
            if (this.readyClip == null) {
                this.readyClip = Sound.getNewClip(this.soundUrl);
            }
            Clip c = this.readyClip;
            this.readyClip = Sound.getNewClip(this.soundUrl);
            return c;
        } catch (SoundException ex) {
            this.readyClip = null;
            throw ex;
        }
    }

    /**
     * Restituisce una HashMap (sempre la stessa istanza) utilizzabile per
     * gestire con comodità una collezione di suoni. Ad ogni nuovo suono
     * aggiunto a tale struttura dati è necessario associare un nome mnemonico
     * per poter richiamare successivamente il suono stesso
     *
     * @return Una struttura dati di tipo HashMap per la gestione multipla di
     * suoni
     */
    public static HashMap<String, Sound> getMap() {
        if (map == null) {
            map = new HashMap<String, Sound>();
        }
        return map;
    }

    /**
     * Crea e restituisce un nuovo Clip di un file WAVE, pronto per essere
     * riprodotto
     *
     * @param clipURL Il file WAVE dal quale ottenere un Clip
     * @return Un oggetto di tipo Clip che permette di gestire il suono
     * @throws SoundException Se non è possibile ottenere un Clip dal file
     */
    public static Clip getNewClip(URL clipURL) throws SoundException {
        Clip clip = null;
        try {
            clip = (Clip) AudioSystem.getLine(INFO);
            clip.open(AudioSystem.getAudioInputStream(clipURL));
        } catch (Exception ex) {
            throw new SoundException(clipURL.getFile(), ex);
        }
        return clip;
    }
}