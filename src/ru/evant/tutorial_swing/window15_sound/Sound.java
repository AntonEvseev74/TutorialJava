package ru.evant.tutorial_swing.window15_sound;

import javax.swing.*;
import java.awt.event.*;
import java.applet.*;

public class Sound extends JFrame implements ActionListener {

    JPanel pnl = new JPanel();

    ClassLoader ldr = this.getClass().getClassLoader();

    AudioClip audio = JApplet.newAudioClip(ldr.getResource("music.wav"));

    JButton playBtn = new JButton("Играть");
    JButton stopBtn = new JButton("Стоп");

    public Sound() {
        super("Окно Swing. Sound.java");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);

        pnl.add(playBtn);
        pnl.add(stopBtn);

        playBtn.addActionListener(this);
        stopBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == playBtn) audio.play();
        if (event.getSource() == stopBtn) audio.stop();

    }

    public static void main(String[] args) {

        Sound gui = new Sound();

    }
}
