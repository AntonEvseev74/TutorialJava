package ru.evant.tutorial_swing.window06_radiobuttons;

import ru.evant.tutorial_swing.window01_empty.Window;

import javax.swing.*;

public class RadioButtons extends JFrame {

    JPanel pnl = new JPanel( ) ;

    JRadioButton rad1 = new JRadioButton( "Красное" , true ) ;
    JRadioButton rad2 = new JRadioButton( "Розовое" ) ;
    JRadioButton rad3 = new JRadioButton( "Белое" ) ;

    ButtonGroup wines = new ButtonGroup() ;


    public RadioButtons() {
        super( "Окно Swing. Window.java" ) ;
        setSize( 500 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

        wines.add( rad1 ) ;
        wines.add( rad2 ) ;
        wines.add( rad3 ) ;

        pnl.add( rad1 ) ;
        pnl.add( rad2 ) ;
        pnl.add( rad3 ) ;

        add( pnl ) ;
        setVisible( true ) ;
    }

    public static void main(String[] args) {

        RadioButtons gui = new RadioButtons() ;

    }
}
