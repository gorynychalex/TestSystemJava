package ru.dvfu.mrcpk.java.quiz;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Класс Тест. Содержит в себе вопросы.
 */
public class Quiz {

    // Название теста
    String quiz;

    // Массив вопросов
    Question[] questions;

    // Динамический массив вопросов
    //ArrayList<Question> questionsList;
    
    //Метод запуска теста
    void run(){
        //Вывод наименования теста
        System.out.println("Тест: " + quiz);

        int i=1;
        //Цикл перечисления вопросов
        for(Question question: (Question[]) questions){
            
            //Проверка наличия объекта вопроса
            if(question != null) {
                
                //Вывод номера вопроса с точкой
                System.out.print("\n" + i++ + ". ");

                //Отображение вопроса
                question.show();

                //Вывод результата
                this.result();
            }
        }
    }
    
    void result(){
    }

}
