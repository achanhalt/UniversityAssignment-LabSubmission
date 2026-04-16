/**
 * Represents a university assignment job with an ID, deadline, and profit value.
 * This is the shared data class used by all team members' scheduling strategies.
 */
public class Job {
    String id;
    int deadline;
    int profit;

    public Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return String.format("Job: %s | Deadline: %d | Profit: %d", id, deadline, profit);
    }
}
