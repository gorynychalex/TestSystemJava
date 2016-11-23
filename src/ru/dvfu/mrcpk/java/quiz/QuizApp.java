package ru.dvfu.mrcpk.java.quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Учебное приложение для выполнения тестирования
 */
public class QuizApp {
    public static void main(String[] args) {

        //---------------------------------------------------------------------------------------

        // Внесение одного вопроса

        // Создать объект вопроса и внести в переменную класса 'question' сам вопрос
        Question question = new Question("Как стать программистом?");

        // Инициализация массива для вариантов ответов (выполнено только для упрощения понимания)
        question.options = new Option[3];

        // Внесение вариантов ответов
        question.options[0] = new Option("необходимо устроиться на работу ... грузчиком",false);
        question.options[1] = new Option("необходимо много думать и практиковаться",true);
        question.options[2] = new Option("никак",false);

        //---------------------------------------------------------------------------------------

        // Запуск теста
        // Здесь должен работать метод запуск из класса Quiz
        System.out.println("Запуск теста по дисциплине: \"Программист\"");

        // Вывод вопроса
        System.out.println(question.question);

        int num = 1;
        System.out.println("\nВопрос №" + num + ":");

        //Вывод вариантов ответов
        int i = 1;
        for(Option opt: question.options){
            // Вывод пунктов
            System.out.print(i + ") ");

            // Вывод текста варианта из объекта 'option'
            System.out.println(opt.option);

            // Увеличение значения счетчика
            i++;
        }
        System.out.println();

        //---------------------------------------------------------------------------------------
        // Ввод данных пользователя
        System.out.println("Выберите правильный вариант ответа:");

        // Переменная, в которую записывается значение ответа пользователя.
        // Принимает ответ через валидацию данных, реализованную через специальный метод.
        int userAnswer = checkCorrectInput(new Scanner(System.in), i );

        //---------------------------------------------------------------------------------------
        // Проверка правильности ответа
        if(question.options[userAnswer - 1].correct)
            System.out.println("Ответ правильный!");
        else
            System.out.println("Ответ неверный.");
    }



    // Метод для проверки корректности введенных данных.
    // Принимает в качестве параметров интерфейс Scanner и количество вариантов ответа m.
    static int checkCorrectInput(Scanner scanner, int m){

        int answer = 0;

        //Специальная переменная для применения в цикле проверки.
        boolean isCorrectOption;

        try {

            answer = scanner.nextInt();

            if(answer < 1 || answer > m) throw new IllegalArgumentException();

        } catch (InputMismatchException e) {
            System.out.println("Введена не цифра: ");
        } catch (IllegalArgumentException e){
            System.out.println("Введен не существующий вариант: ");
        }

        return answer;
    }
}
