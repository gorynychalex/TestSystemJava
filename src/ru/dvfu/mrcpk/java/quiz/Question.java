package ru.dvfu.mrcpk.java.quiz;

import java.util.ArrayList;

/**
 * ����� ������. �������� � ���� �������� �������
 */
public class Question {

    //����� �������
    String question;

    // ������ ��������� �������
    Option[] options;

    // ������������ ������ ��������� �������
    ArrayList<Option> optionsList;

    // ����������� ������ ��� �������� �������
    public Question(String question) {
        this.question = question;
    }
}
