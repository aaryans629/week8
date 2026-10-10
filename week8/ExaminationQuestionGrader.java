package week8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class ExamQuestion {
    private String type;
    private String questionText;
    private String correctAnswer;
    private double points;

    public ExamQuestion(String type, String questionText, String correctAnswer, double points) {
        this.type = type;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public String getType() {
        return type;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public double getPoints() {
        return points;
    }

    public abstract double grade(String studentAnswer);
}

class MultipleChoiceQuestion extends ExamQuestion {
    public MultipleChoiceQuestion(String questionText, String correctAnswer, double points) {
        super("MCQ", questionText, correctAnswer, points);
    }

    @Override
    public double grade(String studentAnswer) {
        if (studentAnswer.trim().equalsIgnoreCase(getCorrectAnswer().trim())) {
            return getPoints();
        }
        return 0.0;
    }
}

class TrueFalseQuestion extends ExamQuestion {
    public TrueFalseQuestion(String questionText, String correctAnswer, double points) {
        super("TF", questionText, correctAnswer, points);
    }

    @Override
    public double grade(String studentAnswer) {
        if (studentAnswer.trim().equalsIgnoreCase(getCorrectAnswer().trim())) {
            return getPoints();
        }
        return 0.0;
    }
}

class EssayQuestion extends ExamQuestion {
    public EssayQuestion(String questionText, String correctAnswer, double points) {
        super("ESSAY", questionText, correctAnswer, points);
    }

    @Override
    public double grade(String studentAnswer) {
        String[] keywords = getCorrectAnswer().split(",");
        int matched = 0;
        String lowerStudentAnswer = studentAnswer.toLowerCase();
        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && lowerStudentAnswer.contains(trimmedKw)) {
                matched++;
            }
        }

        if (matched >= 2) {
            return getPoints() * 0.75;
        } else if (matched == 1) {
            return getPoints() * 0.50;
        }
        return 0.0;
    }
}

public class ExaminationQuestionGrader {
    private static List<String> parseLineTokens(String line) {
        List<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                tokens.add(matcher.group(1));
            } else {
                tokens.add(matcher.group(2));
            }
        }
        return tokens;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }

        String firstLine = scanner.nextLine().trim();
        while (firstLine.isEmpty() && scanner.hasNextLine()) {
            firstLine = scanner.nextLine().trim();
        }
        if (firstLine.isEmpty()) {
            scanner.close();
            return;
        }

        int n = Integer.parseInt(firstLine);
        double totalScore = 0.0;

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            while (line.isEmpty() && scanner.hasNextLine()) {
                line = scanner.nextLine().trim();
            }

            List<String> tokens = parseLineTokens(line);
            if (tokens.size() < 5) continue;

            String type = tokens.get(0);
            String questionText = tokens.get(1);
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            double points = Double.parseDouble(tokens.get(4));

            ExamQuestion question;
            if (type.equalsIgnoreCase("MCQ")) {
                question = new MultipleChoiceQuestion(questionText, correctAnswer, points);
            } else if (type.equalsIgnoreCase("TF")) {
                question = new TrueFalseQuestion(questionText, correctAnswer, points);
            } else {
                question = new EssayQuestion(questionText, correctAnswer, points);
            }

            double score = question.grade(studentAnswer);
            System.out.printf("%s: %.2f%n", question.getType(), score);
            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);
        scanner.close();
    }
}
