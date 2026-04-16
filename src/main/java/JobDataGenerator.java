import java.util.*;

/**
 * Generates random job test data using java.util.Random.
 * Useful for stress-testing and benchmarking scheduling algorithms.
 */
public class JobDataGenerator {

    /**
     * Generates a list of random jobs.
     *
     * @param count         number of jobs to generate
     * @param maxDeadline   upper bound for job deadlines (inclusive, starting from 1)
     * @param maxProfit     upper bound for job profits (inclusive, starting from 1)
     * @return a list of randomly generated Job objects
     */
    public static List<Job> generateRandomJobs(int count, int maxDeadline, int maxProfit) {
        Random random = new Random();
        List<Job> jobs = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            String id = "Assignment" + i;
            int deadline = random.nextInt(maxDeadline) + 1;
            int profit = random.nextInt(maxProfit) + 1;
            jobs.add(new Job(id, deadline, profit));
        }
        return jobs;
    }
}
