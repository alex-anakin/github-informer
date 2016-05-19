package org.anakin.engine;

import com.jcabi.github.Assignees;
import com.jcabi.github.Branch;
import com.jcabi.github.Branches;
import com.jcabi.github.Issue;
import com.jcabi.github.User;
import java.util.Iterator;
import org.junit.Test;

public class GitHubStatisticTest {

    // use credentials of existing user:
    private final String login = "github_user_login";
    private final String password = "github_user_password";

    // owner - name of organization or person which own repository
    private final String owner = "JuniorsJava";
    // repo - name of repository
    private final String repo = "itevents";

    private final RepositoryStatistic statistic = new GitHubRepositoryStatistic(login, password, owner, repo);


    @Test
    public void shouldGetRepositoryOpenIssues() throws Exception {
        final Iterable<Issue> openIssues = statistic.openIssues();

        System.out.println("Repo has " + this.iterableSize(openIssues) + " open issues");
        for (Issue issue : openIssues) {
            System.out.println(issue);
        }
        System.out.println("========================================");
    }

    @Test
    public void shouldGetRepositoryClosedIssues() throws Exception {
        final Iterable<Issue> closedIssues = statistic.closedIssues();

        System.out.println("Repo has " + this.iterableSize(closedIssues) + " closed issues");
        for (Issue issue : closedIssues) {
            System.out.println(issue);
        }
        System.out.println("========================================");
    }

    @Test
    public void shouldGetRepositoryBranches() throws Exception {
        final Branches branches = statistic.branches();

        System.out.println("Repo has such branches:");
        for (Branch branch : branches.iterate()) {
            System.out.println(branch.name());
        }
        System.out.println("========================================");
    }

    @Test
    public void shouldGetRepositoryAssignees() throws Exception {
        final Assignees assignees = statistic.assignees();

        System.out.println("Repo has such assignees:");
        for (User user : assignees.iterate()) {
            System.out.println(user);
        }
    }

    private int iterableSize(final Iterable<?> iterable) {
        int size = 0;
        final Iterator<?> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }
}
