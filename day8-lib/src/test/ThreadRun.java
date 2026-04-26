package test;



import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.util.Date;

public class ThreadRun extends JFrame {
    JLabel top = new JLabel("1"); //전역변수, 글로벌변수
    JLabel center = new JLabel("2");
    JLabel sub = new JLabel("3");

    public ThreadRun() {
        getContentPane().setBackground(Color.GREEN);
        setTitle("나의 멀티스레드");
        setSize(875, 360);

        top.setFont(new Font("Arial Narrow", Font.BOLD, 65));
        getContentPane().add(top, BorderLayout.NORTH);

        center.setFont(new Font("굴림", Font.PLAIN, 54));
        getContentPane().add(center, BorderLayout.CENTER);

        sub.setFont(new Font("Arial Narrow", Font.BOLD, 50));
        getContentPane().add(sub, BorderLayout.SOUTH);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setForeground(Color.GREEN);
        lblNewLabel.setFont(new Font("굴림", Font.BOLD, 35));
        getContentPane().add(lblNewLabel, BorderLayout.WEST);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setForeground(Color.GREEN);
        lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 35));
        getContentPane().add(lblNewLabel_1, BorderLayout.EAST);

        CounterThread2 counter = new CounterThread2();
        TimerThread2 timer = new TimerThread2();
        ImgThread2 img = new ImgThread2();
        counter.start();
        timer.start();
        img.start();




        setVisible(true);
    }

    //내부클래스(inner class)
    //변수를 다른 클래스와 공유할 목적
    //단점: 내부클래스는 독립적으로 사용 불가
    public class CounterThread2 extends Thread {
        @Override
        public void run() {
            for (int i = 500; i > 0; i--) {
                top.setText("Counter: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class ImgThread2 extends Thread {
        @Override //재정의
        public void run() {
            String[] img = {"1.png", "2.png", "3.png", "4.png", "5.png"};
            for (int i = 0; i < img.length; i++) {
//                center.setText("이미지: " + img[i]);
                ImageIcon icon = new ImageIcon(img[i]);
                center.setIcon(icon);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class TimerThread2 extends Thread {
        //@ => hera@naver.com(at, -에)
        //@ => Annotation(표시, 표기) :기능없음.지워도됨
        //    어노테이션
        //@Component => 기능있음. new!객체생성
        @Override //오버라이드, 재정의
        public void run() {
            for (int i = 0; i < 300; i++) {
                Date date = new Date();
                sub.setText(String.valueOf(date));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadRun t = new ThreadRun();
    }

}