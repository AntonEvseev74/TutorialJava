package ru.evant.tutorial_swing.window12_mouse;

import javax.swing.*;
import java.awt.event.* ;

public class Mouse extends JFrame implements MouseListener, MouseMotionListener {

    JPanel pnl = new JPanel( ) ;

    JTextArea txtArea = new JTextArea( 8 , 38 ) ;
    int x , y ;

    public Mouse() {
        super( "Окно Swing. Mouse.java" ) ;
        setSize( 500 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

        pnl.add( txtArea ) ;
        txtArea.addMouseMotionListener( this ) ;
        txtArea.addMouseListener( this ) ;

        add( pnl ) ;
        setVisible( true ) ;
    }

    public void mouseMoved( MouseEvent event ) {
        x = event.getX() ;
        y = event.getY() ;
    }

    public void mouseDragged( MouseEvent event ) { }

    public void mouseEntered( MouseEvent event ) {
        txtArea.setText( "\nНажата кнопка мыши" ) ;
    }

    public void mousePressed( MouseEvent event ) {
        txtArea.append( "\nКнопка нажата, когда указатель в позиции X: " +x+ ", Y: " +y ) ;
    }

    public void mouseReleased( MouseEvent event ) {
        txtArea.append( "\nКнопка мыши отпущена" ) ;
    }

    public void mouseClicked(MouseEvent event ) { }

    public void mouseExited(MouseEvent event ) { }

    public static void main(String[] args) {

        Mouse gui = new Mouse() ;

    }
}
