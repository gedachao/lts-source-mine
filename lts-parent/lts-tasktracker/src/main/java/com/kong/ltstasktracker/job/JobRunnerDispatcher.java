package com.kong.ltstasktracker.job;

import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.spring.boot.annotation.JobRunner4TaskTracker;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gedachao
 * @description
 * @date 2020/5/26 16:15
 */
@JobRunner4TaskTracker
public class JobRunnerDispatcher implements JobRunner {

    private static final ConcurrentHashMap<String, JobRunner> JOB_RUNNER_MAP = new ConcurrentHashMap<String, JobRunner>();
    static{
        JOB_RUNNER_MAP.put("aType",new JobAHandler());
        JOB_RUNNER_MAP.put("bType",new JobBHandler());
    }


    @Override
    public Result run(JobContext jobContext) throws Throwable {
        Job job = jobContext.getJob();
        String type = job.getParam("type");
        return JOB_RUNNER_MAP.get(type).run(jobContext);
    }
}
