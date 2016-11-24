package ru.dvfu.mrcpk.java.quiz;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Учебное приложение для выполнения тестирования
 */
public class QuizApp {

    static Question question;
    static int userAnswer;
    static boolean userResult;


    public static void main(String[] args) {

        //---------------------------------------------------------------------------------------

        // Внесение одного вопроса

        // Создать объект вопроса и внести в переменную класса 'question' сам вопрос
        question = new Question("Как стать программистом?");

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
        userAnswer = checkCorrectInput(new Scanner(System.in), i );

        //---------------------------------------------------------------------------------------
        // Проверка правильности ответа
        if(question.options[userAnswer - 1].correct) {
            System.out.println("Ответ правильный!");
            userResult = true;
        } else {
            System.out.println("Ответ неверный.");
            userResult = false;
        }

        //---------------------------------------------------------------------------------------
        // Сохранение результатов
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("c:/test/quiz-save.txt");

            // Запуск метода по сохранению данных
            save(fileOutputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    // Метод сохранения данных в файл
    public static void save (OutputStream outputStream) throws Exception{

        //Инициализация интерфейса с потоком вывода в файл
        PrintWriter printWriter = new PrintWriter(outputStream);

        int i = 1;

        // Запуск сохранения данных: вопрос, варианты ответов, правильный ответ, ответ пользователя
        if(question != null) {
            //Сохранение самого вопроса
            printWriter.println("Вопрос №");
            printWriter.println(question.question);

            //Сохранение результатов ответов
            printWriter.println("N)\t[уст]\t[польз]\t Описание ответа");
            for(Option option: question.options){
                printWriter.print(i + ")\t");
                printWriter.print("[" + option.correct + "]\t");
                //Внесение ответа пользователя
                if(i == userAnswer )
                    printWriter.print("[true]\t");
                else
                    printWriter.print("[    ]\t");

                printWriter.println(option.option);
                i++;
            }

            if(userResult) {
                printWriter.println("Пользователь ответил верно.");
                printWriter.println("Оценка 5");
            }else {
                printWriter.println("Ответ пользователя неверен.");
                printWriter.println("Оценка 2");
            }
        }

        printWriter.close();
    }
}
