package bsu.rfe.java.group8.lab6.Dubezhinskiy.var9A;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Field extends JPanel {
    // Флаг приостановленности движения
    private boolean paused;
    private boolean paused1;
    public Color color1=Color.RED;
    // Динамический список скачущих мячей
    private ArrayList<BouncingBall> balls = new ArrayList<BouncingBall>(10);
    private ArrayList<BouncingBall> redBalls = new ArrayList<BouncingBall>(10);
    // Класс таймер отвечает за регулярную генерацию событий ActionEvent
    // При создании его экземпляра используется анонимный класс,
    // реализующий интерфейс ActionListener
    private Timer repaintTimer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ev) {
            //Задача обработчика события ActionEvent - перерисовка окна
            repaint();
        }
    });
    // Конструктор класса BouncingBall
    public Field(){
        // Установить цвет заднего фона белым
        setBackground(Color.WHITE);
        // Запустить таймер
        repaintTimer.start();
    }
    //Унаследованный от JPanel метод перерисовки компонента
    public void paintComponent(Graphics g){
        // Вызвать версию метода, унаследованную от предка
        super.paintComponent(g);
        Graphics2D canvas = (Graphics2D) g;
        // Последовательно запросить прорисовку от всех мячей из списка
        for(BouncingBall ball: balls){
            ball.paint(canvas);
        }
    }
    //Метод добавления нового мяча в список
    public void addBall(){
        //Заключается в добавлении в список нового экземпляра BouncingBall
        // Всю инициализацию положения, скорости, размера, цвета
        // BouncingBall выполняет сам в конструкторе
        balls.add(new BouncingBall(this));
    }