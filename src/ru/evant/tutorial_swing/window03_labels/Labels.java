package ru.evant.tutorial_swing.window03_labels;

import javax.swing.*;

public class Labels extends JFrame {

    JPanel pnl = new JPanel( ) ;

    ImageIcon duke = new ImageIcon( "assets/duke.png" ) ;

    JLabel lbl1 = new JLabel( duke ) ;
    JLabel lbl2 = new JLabel( "Дюк — талисман технологии Java." ) ;
    JLabel lbl3 = new JLabel( "Дюк" , duke , JLabel.CENTER ) ;

    public Labels() {
        super( "Окно Swing. Labels.java" ) ;
        setSize( 500 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

        lbl1.setToolTipText( "Дюк — талисман Java" ) ;

        lbl3.setHorizontalTextPosition( JLabel.CENTER ) ;
        lbl3.setVerticalTextPosition( JLabel.BOTTOM ) ;

        pnl.add( lbl1 ) ;
        pnl.add( lbl2 ) ;
        pnl.add( lbl3 ) ;

        add( pnl ) ;
        setVisible( true ) ;
    }

    public static void main(String[] args) {

        Labels gui = new Labels() ;

    }
}
