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

    // Массив ответов
    Question[] questions;

    // Динамический массив вариантов ответов
    ArrayList<Question> questionsList;

}
