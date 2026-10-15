import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

record Learner(String name, int marks) {
    public String getGradeBand() {
        if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else {
            return "C";
        }
    }
}

public class LearnerReports {

    public static void main(String[] args) {
        Path inputFile = Path.of("learners.csv");

        try (Stream<String> lines = Files.lines(inputFile)) {

            Map<String, List<Learner>> learnersByGrade = lines
                    .skip(1)
                    .filter(line -> !line.isBlank())
                    .map(line -> line.split(",", 2))
                    .map(parts -> new Learner(
                            parts[0].trim(),
                            Integer.parseInt(parts[1].trim())
                    ))
                    .collect(Collectors.groupingBy(
                            Learner::getGradeBand
                    ));

            for (String grade : List.of("A", "B", "C")) {
                List<Learner> learners =
                        learnersByGrade.getOrDefault(grade, List.of());

                Path reportFile = Path.of("grade_" + grade + "_report.txt");

                List<String> report = learners.stream()
                        .map(learner ->
                                learner.name() + " - " + learner.marks())
                        .sorted()
                        .collect(Collectors.toList());

                Files.write(reportFile, report);

                System.out.println(
                        "Created " + reportFile + " with "
                                + learners.size() + " learner(s)."
                );
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Learner marks must be integers.");
        }
    }
}
