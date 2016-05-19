package org.anakin.engine;

import com.jcabi.github.Assignees;
import com.jcabi.github.Branches;
import com.jcabi.github.Issue;

public interface RepositoryStatistic {
    Iterable<Issue> openIssues();
    Iterable<Issue> closedIssues();
    Branches branches();
    Assignees assignees();

}
