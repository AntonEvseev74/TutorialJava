package ru.evant.tutorial_swing.window14_inputdialog;

import javax.swing.*;
import java.awt.event.* ;

public class InputDialog extends JFrame  implements ActionListener {

    JPanel pnl = new JPanel( ) ;

    JTextField field = new JTextField( 38 ) ;
    JButton btn1 = new JButton( "Запрос подтверждения" ) ;
    JButton btn2 = new JButton( "Запрос ввода" ) ;

    public InputDialog() {
        super( "Окно Swing. InputDialog.java" ) ;
        setSize( 500 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

        pnl.add( field ) ;
        pnl.add( btn1 ) ;
        pnl.add( btn2 ) ;

        btn1.addActionListener( this ) ;
        btn2.addActionListener( this ) ;

        add( pnl ) ;
        setVisible( true ) ;
    }

    public void actionPerformed( ActionEvent event ) {
        if ( event.getSource() == btn1 )
        {
            int n = JOptionPane.showConfirmDialog( this ,
                    "Вы согласны?" , "Диалог подтверждения" ,
                    JOptionPane.YES_NO_CANCEL_OPTION ) ;
            switch( n )
            {
                case 0 : field.setText( "Согласен" ) ; break ;
                case 1 : field.setText( "Не согласен" ) ; break ;
                case 2 : field.setText( "Отменено" ) ; break ;
            }
        }

        if ( event.getSource() == btn2 )
            field.setText( JOptionPane.showInputDialog( this ,
                    "Введите ваш комментарий" , "Диалог ввода" ,
                    JOptionPane.PLAIN_MESSAGE ) ) ;
    }

    public static void main(String[] args) {

        InputDialog gui = new InputDialog() ;

    }
}
