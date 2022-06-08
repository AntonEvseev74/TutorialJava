package ru.evant.tutorial_swing.window13_messages;

import javax.swing.*;
import java.awt.event.* ;

public class Messages extends JFrame implements ActionListener {

    JPanel pnl = new JPanel( ) ;

    JButton btn1= new JButton( "Показать информационное сообщение" ) ;
    JButton btn2= new JButton( "Показать предупреждение" ) ;
    JButton btn3= new JButton( "Показать сообщение об ошибке" ) ;

    public Messages() {
        super( "Окно Swing. Messages.java" ) ;
        setSize( 500 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

        pnl.add( btn1 ) ;
        pnl.add( btn2 ) ;
        pnl.add( btn3 ) ;

        btn1.addActionListener( this ) ;
        btn2.addActionListener( this ) ;
        btn3.addActionListener( this ) ;

        add( pnl ) ;
        setVisible( true ) ;
    }

    public void actionPerformed( ActionEvent event ) {
        if ( event.getSource() == btn1 )
            JOptionPane.showMessageDialog( this , "Информация..." ,
                    "Информационное диалоговое сообщение", JOptionPane.INFORMATION_MESSAGE ) ;

        if ( event.getSource() == btn2 )
            JOptionPane.showMessageDialog( this , "Предупреждение..." ,
                    "Предупреждающее диалоговое сообщение" , JOptionPane.WARNING_MESSAGE ) ;

        if ( event.getSource() == btn3 )
            JOptionPane.showMessageDialog( this , "Ошибка..." ,
                    "Диалоговое сообщение об ошибке" , JOptionPane.ERROR_MESSAGE ) ;
    }

    public static void main(String[] args) {

        Messages gui = new Messages() ;

    }
}
