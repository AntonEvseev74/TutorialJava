package ru.evant.tutorial_swing.window01_empty;

import javax.swing.*;

public class Window extends JFrame {

    JPanel pnl = new JPanel( ) ;

    public Window() {
        super( "Окно Swing. Window.java" ) ;
        setSize( 500 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;
        add( pnl ) ;
        setVisible( true ) ;
    }

    public static void main(String[] args) {

        Window gui = new Window() ;

    }
}
