package com.kong.ltstasktracker.job;

import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;
import org.springframework.stereotype.Component;

/**
 * @author gedachao
 * @description
 * @date 2020/5/26 16:11
 */
public class JobBHandler implements JobRunner {
    public Result run(JobContext jobContext) throws Throwable {
        System.out.println("执行jobB--------------");
        return null;
    }
}
