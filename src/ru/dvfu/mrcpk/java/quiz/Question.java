package ru.dvfu.mrcpk.java.quiz;

import java.util.ArrayList;

/**
 * Класс Вопрос. Содержит в себе варианты ответов
 */
public class Question {

    //Текст вопроса
    String textQuestion;

    // Массив вариантов ответов
    Option[] options;

    // Динамический массив вариантов ответов
    //ArrayList<Option> optionsList;

    // Конструктор класса для создания вопроса
    public Question(String textQuestion) {
        this.textQuestion = textQuestion;
    }
    
    //Отображение вопроса
    public void show() {
        //Текст вопроса
        System.out.println(textQuestion);
        int i=1;
        for(Option option: (Option[]) options){
            System.out.println("\t" + i++ + ") " + option.textOptions);
        }

    }
    
    void result(){
    }
}
