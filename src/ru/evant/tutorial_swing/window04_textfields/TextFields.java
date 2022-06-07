package ru.evant.tutorial_swing.window04_textfields;

import ru.evant.tutorial_swing.window01_empty.Window;

import javax.swing.*;

public class TextFields extends JFrame {

    JPanel pnl = new JPanel( ) ;

    JTextField txt1 = new JTextField( 38 ) ;
    JTextField txt2 = new JTextField( "Текст по умолчанию" , 38 ) ;

    JTextArea txtArea = new JTextArea( 5 , 37 ) ;

    JScrollPane pane = new JScrollPane( txtArea ) ;


    public TextFields() {
        super( "Окно Swing. Window.java" ) ;
        setSize( 500 , 200 ) ;
        setDefaultCloseOperation( EXIT_ON_CLOSE ) ;

        txtArea.setLineWrap( true ) ;
        txtArea.setWrapStyleWord( true ) ;
        txtArea.setText(bigText);
        pane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ) ;

        pnl.add( txt1 ) ;
        pnl.add( txt2 ) ;
        pnl.add( pane ) ;

        add( pnl ) ;
        setVisible( true ) ;
    }

    public static void main(String[] args) {

        TextFields gui = new TextFields() ;

    }

    String bigText = "" +
            "    В библиотеке Swing существует класс JTextField, который создает компонент графического интерфейса, " +
            "представляющий собой однострочное текстовое поле . Данный компонент позволяет отобразить на " +
            "экране редактируемый текст, с помощью которого пользователь может взаимодействовать с программой.\n" +
            "    Объект JTextField создается при помощи ключевого слова new, и его конструктор может принимать строковый аргумент, " +
            "задающий текст по умолчанию, который будет отображаться в этом поле. " +
            "В этом случае размер компонента будет подогнан в соответствии с длиной указанной строки. " +
            "В качестве альтернативного варианта аргументом может быть числовое значение, определяющее размер текстового поля. " +
            "Конструктор может также принимать и оба аргумента одновременно — для текста по умолчанию и для размера текстового поля.\n" +
            "    При помощи класса JTextArea можно создавать многострочные текстовые поля. Конструктор данного класса принимает два числовых аргумента, " +
            "определяющих число строк и ширину поля. Альтернативным вариантом является указание трех аргументов, задающих текст по умолчанию, " +
            "а также число строк и ширину. При помощи методов setLineWrap() и setWrapStyleWord() объекта JTextArea можно управлять переносом слов, " +
            "подгоняя тем самым ширину вводимого текста\n" +
            "под размер поля. Если текст, введенный в компонент JTextArea, превышает его первоначальный размер, компонент будет растягиваться. " +
            "Можно задать компоненту фиксированный размер с возможностью скроллинга. Для этого его нужно поместить в контейнер JScrollPane. " +
            "Это можно сделать при помощи ключевого слова new с использованием имени объекта JTextArea как аргумента.\n" +
            "    По умолчанию полоса прокрутки (ScrollBar) будет появляться, когда поле содержит текст, превышающий его размер. " +
            "Но можно сделать так, чтобы полоса прокрутки включалась постоянно. Для этого нужно указать константу контейнера JScrollPane в качестве " +
            "аргумента методам setVerticalScrollBarPolicy() или setHorizontalScrollBarPolicy(). Например, для того, " +
            "чтобы всегда отображать вертикальную полосу прокрутки, используйте константу JScrollPane.VERTICAL_SCROLLBAR_ALWAYS в качестве аргумента.";
}