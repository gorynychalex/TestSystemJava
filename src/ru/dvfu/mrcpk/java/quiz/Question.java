package ru.dvfu.mrcpk.java.quiz;

import java.util.ArrayList;

/**
 * Класс Вопрос. Содержит в себе варианты ответов
 */
public class Question {

    //Текст вопроса
    String question;

    // Массив вариантов ответов
    Option[] options;

    // Динамический массив вариантов ответов
    //ArrayList<Option> optionsList;

    // Конструктор класса для создания вопроса
    public Question(String question) {
        this.question = question;
    }
    
    void run(){
    }
    
    void result(){
    }
}
