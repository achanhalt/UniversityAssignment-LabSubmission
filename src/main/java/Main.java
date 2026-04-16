import java.io.IOException;
import java.util.*;

/**
 * Entry point demonstrating the Greedy Profit-based Job Sequencing algorithm.
 *
 * <p>Usage:</p>
 * <ul>
 *   <li>With a file argument: {@code java Main data/jobs.csv}</li>
 *   <li>Without arguments: uses randomly generated test data.</li>
 * </ul>
 */
public class Main {

    public static void main(String[] args) {
        List<Job> jobs;

        if (args.length > 0) {
            // Read jobs from file
            try {
                jobs = JobFileReader.readJobsFromFile(args[0]);
                System.out.println("Loaded " + jobs.size() + " jobs from file: " + args[0]);
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
                return;
            }
        } else {
            // Generate random test data
            jobs = JobDataGenerator.generateRandomJobs(7, 4, 100);
            System.out.println("Generated " + jobs.size() + " random jobs for testing.");
        }

        // Keep a copy of the original list to identify unselected jobs later
        List<Job> allJobs = new ArrayList<>(jobs);

        System.out.println("\n--- All Jobs ---");
        for (Job job : allJobs) {
            System.out.println("  " + job);
        }

        // Run the Greedy Profit-based Scheduler
        JobSequencingStrategy scheduler = new GreedyProfitScheduler();
        List<Job> selectedJobs = scheduler.schedule(jobs);

        // Calculate total profit
        int totalProfit = 0;
        for (Job job : selectedJobs) {
            totalProfit += job.profit;
        }

        System.out.println("\n--- Greedy Profit Scheduler Results ---");
        System.out.println("Selected Jobs (" + selectedJobs.size() + "):");
        for (Job job : selectedJobs) {
            System.out.println("  " + job);
        }
        System.out.println("Total Profit: " + totalProfit);

        // Identify unselected jobs by comparing original list to selected list
        Set<Job> selectedSet = new HashSet<>(selectedJobs);
        List<Job> unselectedJobs = new ArrayList<>();
        for (Job job : allJobs) {
            if (!selectedSet.contains(job)) {
                unselectedJobs.add(job);
            }
        }

        System.out.println("\nUnselected Jobs (" + unselectedJobs.size() + "):");
        for (Job job : unselectedJobs) {
            System.out.println("  " + job);
        }
    }
}
