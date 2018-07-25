import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDemo {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //1.job
        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();

        //2.时间规则表   3秒 10次
//        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).withRepeatCount(10);
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("1,3,5,6,8,59 * * * * ? *");

        //3.创建触发器（simpletriiger）
//        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(simpleScheduleBuilder).startNow().build();
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1").withSchedule(cronScheduleBuilder).startNow().build();

        //4.调度器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        scheduler.scheduleJob(job,trigger);
        scheduler.start();

        Thread.sleep(120*1000);
    }
}
