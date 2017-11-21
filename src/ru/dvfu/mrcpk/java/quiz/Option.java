package ru.dvfu.mrcpk.java.quiz;

/**
 * Класс Варианты ответа
 */
public class Option {

    //Текст варианта ответа
    String textOption;

    // Указатель правильности ответа
    boolean correct;

    // Ответ пользователя
    boolean userAnswer;


    // Конструктор класса для создания варианта ответа
    public Option(String option, boolean correct) {
        this.textOption = option;
        this.correct = correct;
    }
    
    void run(){
    }
    
    void result(){
        
    }
}
