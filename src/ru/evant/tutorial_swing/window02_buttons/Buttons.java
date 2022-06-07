package ru.evant.tutorial_swing.window02_buttons;

import javax.swing.*;

public class Buttons extends JFrame {

    JPanel pnl = new JPanel( ) ;

    ImageIcon tick = new ImageIcon( "assets/tick.png" ) ;
    ImageIcon cross = new ImageIcon( "assets/cross.png" ) ;

    JButton btn = new JButton( "Нажми меня" ) ;
    JButton tickBtn = new JButton( tick ) ;
    JButton crossBtn = new JButton( "СТОП" , cross ) ;

    public Buttons() {
        super( "Окно Swing. Buttons.java" ) ;
        setSize( 500 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

        pnl.add( btn ) ;
        pnl.add( tickBtn ) ;
        pnl.add( crossBtn ) ;

        add( pnl ) ;
        setVisible( true ) ;
    }

    public static void main(String[] args) {

        Buttons gui = new Buttons() ;

    }
}
