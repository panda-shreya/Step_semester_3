
import java.util.*;
import java.util.regex.*;

abstract class ExamQuestion {
    String question, correct, answer;
    double points;

    ExamQuestion(String q, String c, String a, double p) {
        question = q;
        correct = c;
        answer = a;
        points = p;
    }

    abstract double grade();

    String getType() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class MCQ extends ExamQuestion {
    MCQ(String q, String c, String a, double p) {
        super(q, c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class TF extends ExamQuestion {
    TF(String q, String c, String a, double p) {
        super(q, c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }
}

class ESSAY extends ExamQuestion {
    ESSAY(String q, String c, String a, double p) {
        super(q, c, a, p);
    }

    double grade() {
        int matches = 0;

        for (String keyword : correct.split(",")) {
            if (answer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) return points * 0.75;
        if (matches == 1) return points * 0.50;
        return 0;
    }
}

public class QuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Pattern pattern = Pattern.compile("\"([^\"]*)\"");
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.split("\\s+", 2)[0];

            Matcher matcher = pattern.matcher(line);
            List<String> fields = new ArrayList<>();

            while (matcher.find()) {
                fields.add(matcher.group(1));
            }

            double points = Double.parseDouble(
                line.substring(line.lastIndexOf('"') + 1).trim()
            );

            ExamQuestion question = switch (type) {
                case "MCQ" -> new MCQ(fields.get(0), fields.get(1),
                                     fields.get(2), points);
                case "TF" -> new TF(fields.get(0), fields.get(1),
                                   fields.get(2), points);
                case "ESSAY" -> new ESSAY(fields.get(0), fields.get(1),
                                         fields.get(2), points);
                default -> throw new IllegalArgumentException("Invalid question type");
            };

            double score = question.grade();
            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}


