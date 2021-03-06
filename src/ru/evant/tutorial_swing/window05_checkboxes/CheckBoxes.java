package ru.evant.tutorial_swing.window05_checkboxes;

import javax.swing.*;

public class CheckBoxes extends JFrame {

    JPanel pnl = new JPanel( ) ;

    String[] langs = { "HTML" , "CSS" , "PHP" , "JAVA" } ;
    String[] styles = { "Учу" , "Знаю" , "Не нужен" } ;

    JComboBox<String> box1 = new JComboBox<String>( styles ) ;
    JList<String> lst1 = new JList<String>( langs ) ;

    JCheckBox chk1 = new JCheckBox( langs[0] ) ;
    JCheckBox chk2 = new JCheckBox( langs[1] , true ) ;
    JCheckBox chk3 = new JCheckBox( langs[2] ) ;
    JCheckBox chk4 = new JCheckBox( langs[3] ) ;

    public CheckBoxes() {
        super( "Окно Swing. CheckBoxes.java" ) ;
        setSize( 700 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

        pnl.add( chk1 ) ;
        pnl.add( chk2 ) ;
        pnl.add( chk3 ) ;
        pnl.add( chk4 ) ;

        box1.setSelectedIndex( 0 ) ;
        pnl.add( box1 ) ;
        pnl.add( lst1 ) ;

        add( pnl ) ;
        setVisible( true ) ;
    }

    public static void main(String[] args) {

        CheckBoxes gui = new CheckBoxes() ;

    }
}
