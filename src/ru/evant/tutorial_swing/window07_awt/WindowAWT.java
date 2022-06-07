package ru.evant.tutorial_swing.window07_awt;

import javax.swing.*;
import java.awt.* ;

public class WindowAWT extends JFrame {

    JPanel pnl = new JPanel( ) ;

    JLabel lbl1 = new JLabel( "Пользовательский задний фон" ) ;
    JLabel lbl2 = new JLabel( "Пользовательский передний фон" ) ;
    JLabel lbl3 = new JLabel( "Пользовательский шрифт" ) ;

    Color customColor = new Color( 255 , 0 , 0 ) ;
    Font customFont = new Font( "Serif" , Font.PLAIN , 32 ) ;

    public WindowAWT() {
        super( "Окно Swing. Window.java" ) ;
        setSize( 500 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

        lbl1.setOpaque( true ) ;
        lbl1.setBackground( Color.YELLOW ) ;

        lbl2.setForeground( customColor ) ;

        lbl3.setFont( customFont ) ;

        pnl.add( lbl1 ) ;
        pnl.add( lbl2 ) ;
        pnl.add( lbl3 ) ;

        add( pnl ) ;
        setVisible( true ) ;
    }

    public static void main(String[] args) {

        WindowAWT gui = new WindowAWT() ;

    }
}
