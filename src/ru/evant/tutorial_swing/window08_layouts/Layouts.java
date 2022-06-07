package ru.evant.tutorial_swing.window08_layouts;

import javax.swing.*;
import java.awt.*;

public class Layouts extends JFrame {

    Container contentPane = getContentPane() ;

    JPanel panel = new JPanel( ) ;
    JPanel grid = new JPanel( new GridLayout( 2 , 2 ) ) ;

    public Layouts() {
        super( "Окно Swing. Window.java" ) ;
        setSize( 500 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

        panel.add( new JButton( "Да" ) ) ;
        panel.add( new JButton( "Нет" ) ) ;
        panel.add( new JButton( "Отмена" ) ) ;

        grid.add( new JButton( "1" ) ) ;
        grid.add( new JButton( "2" ) ) ;
        grid.add( new JButton( "3" ) ) ;
        grid.add( new JButton( "4" ) ) ;

        contentPane.add( "North" , panel) ;
        contentPane.add( "Center" , grid ) ;
        contentPane.add( "West" , new JButton( "Запад" ) ) ;

        setVisible( true ) ;
    }

    public static void main(String[] args) {

        Layouts gui = new Layouts() ;

    }
}
