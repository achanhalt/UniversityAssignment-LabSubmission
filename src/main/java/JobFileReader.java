import java.io.*;
import java.util.*;

/**
 * Reads job data from a CSV file.
 *
 * <p>Expected file format (one job per line):</p>
 * <pre>
 *   Assignment1, 2, 60
 *   Assignment2, 1, 100
 * </pre>
 * <p>Each line contains: Name, Deadline, Profit</p>
 */
public class JobFileReader {

    /**
     * Reads jobs from a CSV file.
     *
     * @param filePath path to the input CSV file
     * @return list of Job objects parsed from the file
     * @throws IOException if the file cannot be read
     */
    public static List<Job> readJobsFromFile(String filePath) throws IOException {
        List<Job> jobs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String id = parts[0].trim();
                    int deadline = Integer.parseInt(parts[1].trim());
                    int profit = Integer.parseInt(parts[2].trim());
                    jobs.add(new Job(id, deadline, profit));
                }
            }
        }
        return jobs;
    }
}
