import java.util.*;

/**
 * Member 1's implementation: Greedy Profit-based Job Sequencing Algorithm.
 *
 * <p><b>Algorithm Overview:</b></p>
 * <ol>
 *   <li>Sort all jobs by profit in descending order.</li>
 *   <li>Determine the maximum deadline to size the schedule.</li>
 *   <li>For each job (highest profit first), place it in the latest available
 *       time slot before its deadline.</li>
 *   <li>Collect and return all successfully scheduled jobs.</li>
 * </ol>
 *
 * <p><b>Big-O Time Complexity Analysis:</b></p>
 * <ul>
 *   <li>Sorting: O(n log n) — where n is the number of jobs.</li>
 *   <li>Greedy placement: O(n * d) — for each of the n jobs, we search up to d
 *       slots (where d is the maximum deadline). In the worst case d = n, giving O(n^2).</li>
 *   <li><b>Overall: O(n^2)</b> due to the nested slot search. The sorting step
 *       is dominated by the placement step in the worst case.</li>
 * </ul>
 *
 * <p><b>Space Complexity:</b> O(d) for the schedule and slot-tracking arrays,
 * where d is the maximum deadline.</p>
 */
public class GreedyProfitScheduler implements JobSequencingStrategy {

    @Override
    public List<Job> schedule(List<Job> jobs) {
        // 1. Sort jobs based on profit in descending order — O(n log n)
        jobs.sort((a, b) -> b.profit - a.profit);

        // 2. Find max deadline to determine schedule size — O(n)
        int maxDeadline = 0;
        for (Job j : jobs) {
            maxDeadline = Math.max(maxDeadline, j.deadline);
        }

        // 3. Initialize schedule (slots 1 to maxDeadline)
        //    Index 0 is unused; slot indices represent time units (Day 1, Day 2, etc.)
        Job[] result = new Job[maxDeadline + 1];
        boolean[] slotFilled = new boolean[maxDeadline + 1];

        // 4. Greedy placement — O(n * d), worst case O(n^2)
        //    For each job, find a free slot starting from its deadline backwards.
        //    This ensures we leave earlier slots open for jobs with tighter deadlines.
        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline, job.deadline); j > 0; j--) {
                if (!slotFilled[j]) {
                    slotFilled[j] = true;
                    result[j] = job;
                    break;
                }
            }
        }

        // 5. Collect selected jobs for output — O(d)
        List<Job> selectedJobs = new ArrayList<>();
        for (int i = 1; i <= maxDeadline; i++) {
            if (slotFilled[i]) {
                selectedJobs.add(result[i]);
            }
        }
        return selectedJobs;
    }
}
