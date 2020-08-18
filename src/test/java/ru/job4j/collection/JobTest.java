package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAsc() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameDesc() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityAsc() {
        Comparator<Job> cmpName = new JobAscByPriority();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityDesc() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        List<Job> jobs = new ArrayList<>();
        Job job1 = new Job("Impl task", 0);
        Job job2 = new Job("Fix bug", 1);
        Job job3 = new Job("Fix bug", 2);
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.sort(cmpNamePriority);
        Iterator<Job> it = jobs.iterator();
        assertThat(it.next(), is(job1));
        assertThat(it.next(), is(job3));
        assertThat(it.next(), is(job2));
    }

    @Test
    public void whenCompatorByNameAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        List<Job> jobs = new ArrayList<>();
        Job job1 = new Job("Impl task", 0);
        Job job2 = new Job("Fix bug", 1);
        Job job3 = new Job("Fix bug", 2);
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.sort(cmpNamePriority);
        Iterator<Job> it = jobs.iterator();
        assertThat(it.next(), is(job2));
        assertThat(it.next(), is(job3));
        assertThat(it.next(), is(job1));
    }
}