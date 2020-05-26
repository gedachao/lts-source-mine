package com.kong.lts.ltsjobclient.controller;

import com.github.ltsopensource.core.commons.utils.DateUtils;
import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.core.exception.JobSubmitException;
import com.github.ltsopensource.jobclient.JobClient;
import com.github.ltsopensource.jobclient.domain.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gedachao
 * @description
 * @date 2020/5/26 14:48
 */
@Controller
@Slf4j
@ResponseBody
public class ControllerTest {

    @Autowired
    private JobClient jobClient;

    @GetMapping("/test001")
    public Map<String, Object> test01(){
        Job job = new Job();
        job.setTaskId("task-AAAAA");
        job.setCronExpression("0/3 * * * * ?");
        job.setParam("type","aType");
        job.setNeedFeedback(true);

        //设置触发时间,如果设置了cron,则该设置无效
//        job.setTriggerTime(DateUtils.addDay(new Date(),1).getTime());

        //任务执行节点组,与模块lts-tasktracker[application.properties]中的lts.tasktracker.cluster-name相同
        job.setTaskTrackerNodeGroup("tasktracker-group-test");

        //当任务队列中已存在这个任务时,是否替换更新
        job.setReplaceOnExist(false);

        HashMap<String, Object> submitResult = new HashMap<String, Object>(4);
        try {
            Response response = jobClient.submitJob(job);
            submitResult.put("success",response.isSuccess());
            submitResult.put("msg",response.getMsg());
            submitResult.put("code",response.getCode());
        } catch (JobSubmitException e) {
            log.error("提交任务失败",e);
            throw new RuntimeException("提交任务失败");
        }
        return submitResult;

    }

    @GetMapping("/test002")
    public Map<String, Object> test02(){
        Job job = new Job();
        job.setTaskId("task-BBBBB");
        job.setCronExpression("0/6 * * * * ?");
        job.setParam("type","bType");
        job.setNeedFeedback(true);

        //设置触发时间,如果设置了cron,则该设置无效
        job.setTriggerTime(DateUtils.addDay(new Date(),1).getTime());

        //任务执行节点组,与模块lts-tasktracker[application.properties]中的lts.tasktracker.cluster-name相同
        job.setTaskTrackerNodeGroup("tasktracker-group-test");

        //当任务队列中已存在这个任务时,是否替换更新
        job.setReplaceOnExist(false);

        HashMap<String, Object> submitResult = new HashMap<String, Object>(4);
        try {
            Response response = jobClient.submitJob(job);
            submitResult.put("success",response.isSuccess());
            submitResult.put("msg",response.getMsg());
            submitResult.put("code",response.getCode());
        } catch (JobSubmitException e) {
            log.error("提交任务失败",e);
            throw new RuntimeException("提交任务失败");
        }
        return submitResult;

    }

}
