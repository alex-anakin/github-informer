package org.anakin.engine;

import com.jcabi.github.Assignees;
import com.jcabi.github.Branches;
import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.Issue;
import com.jcabi.github.Issues;
import com.jcabi.github.Repo;
import com.jcabi.github.RtGithub;
import com.jcabi.github.Search;
import java.io.IOException;
import java.util.EnumMap;

public final class GitHubRepositoryStatistic implements RepositoryStatistic {
    final private Github github;
    final private Repo repo;



    public GitHubRepositoryStatistic(final String login, final String password,
        final String owner, final String repo) {
        this.github = new RtGithub(login, password);
        this.repo = this.github.repos().get(new Coordinates.Simple(owner, repo));
    }



    @Override
    public Iterable<Issue> openIssues() {
        final EnumMap<Issues.Qualifier, String> qualifiers = new EnumMap<>(Issues.Qualifier.class);
        qualifiers.put(Issues.Qualifier.STATE, Issue.OPEN_STATE);
        try {
            return this.repo.issues().search(Issues.Sort.CREATED, Search.Order.ASC, qualifiers);
        } catch (IOException e) {
            throw new GithubException(e.getMessage(), e);
        }
    }

    @Override
    public Iterable<Issue> closedIssues() {
        final EnumMap<Issues.Qualifier, String> qualifiers = new EnumMap<>(Issues.Qualifier.class);
        qualifiers.put(Issues.Qualifier.STATE, Issue.CLOSED_STATE);
        try {
            return this.repo.issues().search(Issues.Sort.CREATED, Search.Order.ASC, qualifiers);
        } catch (IOException e) {
            throw new GithubException(e.getMessage(), e);
        }
    }

    @Override
    public Branches branches() {
        return this.repo.branches();
    }

    @Override
    public Assignees assignees() {
        return this.repo.assignees();
    }
}
