package ru.job4j.start;

public class StubInput implements Input {

    private String[] answers;
    private int position = 0;

    StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position];
    }
}
