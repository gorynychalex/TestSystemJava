package ru.dvfu.mrcpk.java.quiz;

/**
 * Класс ВариантОтвета
 */
public class Option {

    //Текст варианта ответа
    String option;

    // Указатель правильности ответа
    boolean correct;

    // Ответ пользователя
    boolean userAnswer;


    // Конструктор класса для создания варианта ответа
    public Option(String option, boolean correct) {
        this.option = option;
        this.correct = correct;
    }
}
