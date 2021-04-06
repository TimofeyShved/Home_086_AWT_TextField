package com.AWT;

import java.awt.*;
import java.awt.event.*;

public class Main {

    // создаем в классе пееменные
    private Frame mainFrame; // фрайм и 2 метки (лэйблы) и панель
    private Label headerLabel;
    private Label statusLabel;
    private Panel controlPanel;

    public Main(){ // ----------------------------------------- конструктор для нашего класса
        prepareGUI(); // и вызываемый метод prepareGUI
    }

    public static void main(String[] args){
        Main  myMainClass = new Main(); // создание наешого основного класса
        myMainClass.showTextFieldDemo(); // и вызываемый метод showListDemo
    }

    // ----------------------------------------------------- описывает основное визуальное отображение
    private void prepareGUI(){
        mainFrame = new Frame("Java AWT TextField");  // инициализация фрэйма
        mainFrame.setSize(400,400); // размеры
        mainFrame.setLayout(new GridLayout(3, 1));// расположение объектов на форме

        mainFrame.addWindowListener( new WindowAdapter() {// обработка событий
            public void windowClosing(WindowEvent windowEvent){ // принажатии на кнопку "Закрыть"
                System.exit(0);
            }
        });

        // метки
        headerLabel = new Label(); // инициализация
        headerLabel.setAlignment(Label.CENTER);// в центре
        statusLabel = new Label();// инициализация
        statusLabel.setAlignment(Label.CENTER);// в центре
        statusLabel.setSize(350,100);// размеры

        controlPanel = new Panel();// новая панель
        controlPanel.setLayout(new FlowLayout()); // расположение объектов на форме (лайаут)

        // добавление объектов на форму
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true); // видимость формы true
    }

    //----------------------------------------------------- Что будет в TextField
    private void showTextFieldDemo(){
        headerLabel.setText("Контрол в действии: TextField");

        Label  namelabel= new Label("User ID: ", Label.RIGHT); // метка, возле логина
        Label  passwordLabel = new Label("Password: ", Label.CENTER); // возле пароля

        final TextField userText = new TextField(6); // обычный текст
        final TextField passwordText = new TextField(6); // текст для пароля
        passwordText.setEchoChar('*'); // на какие символы заменить

        Button loginButton = new Button("Зайти"); // кнопка

        loginButton.addActionListener(new ActionListener() { // действие
            public void actionPerformed(ActionEvent e) {
                String data = "Username: " + userText.getText();
                data += ", Password: " + passwordText.getText();
                statusLabel.setText(data); // статусное окно
            }
        });

        // добавить на панель
        controlPanel.add(namelabel);
        controlPanel.add(userText);
        controlPanel.add(passwordLabel);
        controlPanel.add(passwordText);
        controlPanel.add(loginButton);

        // видимость формы true
        mainFrame.setVisible(true);
    }
}
