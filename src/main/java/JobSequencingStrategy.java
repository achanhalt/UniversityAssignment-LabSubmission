import java.util.List;

/**
 * Strategy interface for job sequencing algorithms.
 * All team members' algorithms must implement this interface to ensure
 * a consistent structure across different scheduling strategies.
 */
public interface JobSequencingStrategy {
    /**
     * Schedules jobs and returns the list of selected jobs in their scheduled order.
     *
     * @param jobs the list of jobs to schedule
     * @return the list of selected (scheduled) jobs
     */
    List<Job> schedule(List<Job> jobs);
}
