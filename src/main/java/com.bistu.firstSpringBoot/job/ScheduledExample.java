package com.bistu.firstSpringBoot.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @author Super-Zhang
 * @date 2021-07-01 16:04
 *  定时任务，利用corn表达式可以很好解决。
 *
 *  @Scheduled注解是spring boot提供的用于定时任务控制的注解,主要用于控制任务在某个指定时间执行,或者每隔一段时间执行.
 *  注意需要配合@EnableScheduling使用,配置@Scheduled主要有三种配置执行时间的方式,cron,fixedRate,fixedDelay.
 *
 *  Cron表达式是一个字符串，字符串以5或6个空格隔开，分为6或7个域，每一个域代表一个含义，Cron有如下两种语法格式：
 *
 * 1.Seconds Minutes Hours DayofMonth Month DayofWeek Year
 * 2.Seconds Minutes Hours DayofMonth Month DayofWeek
 *
 * 每一个域都使用数字，但还可以出现如下特殊字符，它们的含义是：
 *
 *     (1) *：表示匹配该域的任意值，假如在Minutes域使用*, 即表示每分钟都会触发事件。
 *     (2) ?：只能用在DayofMonth和DayofWeek两个域。它也匹配域的任意值，但实际不会。因为DayofMonth和 DayofWeek会相互影响。例如想在每月的20日触发调度，不管20日到底是星期几，则只能使用如下写法： 13 13 15 20 * ?, 其中最后一位只能用？，而不能使用*，如果使用*表示不管星期几都会触发，实际上并不是这样。
 *     (3) L：表示最后，只能出现在DayofWeek和DayofMonth域，如果在DayofWeek域使用5L,意味着在最后的一个星期四触发。
 *
 */
//  举例：
//    每隔5秒执行一次："*/5****?"
//    每隔1分钟执行一次："0 */1 * * * ?"
//    每天23点执行一次："0 0 23 * * ?"
//    每天凌晨1点执行一次："0 0 1 * * ?"
//    每月1号凌晨1点执行一次："0 0 1 1 * ?"
//    每天的0点、13点、18点、21点都执行一次："0 0 0,13,18,21 * * ?"
//        依次为 秒， 分， 时， 天  用空格间隔，*表示任意。


@Component
public class ScheduledExample {
    // @Scheduled(fixedRate = 5000)
    // 上一次开始执行时间点之后5秒再执行
    public void job1() {
        System.out.println(Thread.currentThread() + " now is " + LocalTime.now());
    }
    // @Scheduled(fixedDelay = 5000)
    // 上一次执行完毕时间点之后5秒再执行
    public void job2() {
        System.out.println(Thread.currentThread() + " now is " + LocalTime.now());
    }
    // @Scheduled(initialDelay = 1000, fixedRate = 5000)
    // 第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
    public void job3() {
        System.out.println( Thread.currentThread() + " now is " +  LocalTime.now());
    }
    @Scheduled(cron = "0/3 * * * * ?")
    // cron表达式
    public void job4() {
        System.out.println( Thread.currentThread() + " now is " + LocalTime.now());
    }
}