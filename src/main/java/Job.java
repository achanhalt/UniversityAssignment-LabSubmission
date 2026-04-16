import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return deadline == job.deadline && profit == job.profit && Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deadline, profit);
    }
}
