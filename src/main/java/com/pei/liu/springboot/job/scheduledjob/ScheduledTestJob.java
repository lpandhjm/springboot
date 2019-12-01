package com.pei.liu.springboot.job.scheduledjob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author liupei
 */
@Component
public class ScheduledTestJob {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron="0 0/1 * * * ? ")
    public void testJob(){
        logger.info("开始任务了----------");

    }

}
