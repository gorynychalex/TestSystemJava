package quiz;

/**
 * ����� �������������
 */
public class Option {

    //����� �������� ������
    String option;

    // ��������� ������������ ������
    boolean correct;

    // ����� ������������
    boolean userAnswer;


    // ����������� ������ ��� �������� �������� ������
    public Option(String option, boolean correct) {
        this.option = option;
        this.correct = correct;
    }
}
