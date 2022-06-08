package ru.evant.tutorial_swing.window11_keystrokes;

import javax.swing.*;
import java.awt.event.* ;

public class KeyStrokes extends JFrame implements KeyListener {

    JPanel pnl = new JPanel( ) ;

    JTextField field = new JTextField( 38 ) ;
    JTextArea txtArea = new JTextArea( 5 , 38 ) ;

    public KeyStrokes() {
        super( "Окно Swing. KeyStrokes.java" ) ;
        setSize( 500 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

        pnl.add( field ) ;
        pnl.add( txtArea ) ;

        field.addKeyListener( this ) ;

        add( pnl ) ;
        setVisible( true ) ;
    }

    public static void main(String[] args) {

        KeyStrokes gui = new KeyStrokes() ;

    }

    // распознает нажатие клавиш
    public void keyPressed( KeyEvent event ) {
        txtArea.setText( "Нажата клавиша" ) ;
    }

    // отображает символ клавиши после того, как она нажата
    public void keyTyped( KeyEvent event ) {
        txtArea.append( "\nСимвол : " + event.getKeyChar() ) ;
    }

    //  отображает код клавиши и текст, когда клавиша отпущена
    public void keyReleased( KeyEvent event ) {
        int keyCode = event.getKeyCode() ;
        txtArea.append( "\nКод клавиши : " + event.getKeyCode() ) ;
        txtArea.append( "\nТекст клавиши : " + event.getKeyText( keyCode ) ) ;
    }
}
