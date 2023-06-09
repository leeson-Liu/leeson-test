package timer;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author liubin
 * @create 2019-09-23 17:22
 * @desc ${DESCRIPTION}
 **/
@Component
public class MyScheduled {

    @Scheduled(cron = "0/5 * * * * ?")
    public void execute1(){
        String curName = Thread.currentThread().getName() ;
        System.out.println("当前时间:"+ LocalDateTime.now()+"  任务execute1对应的线程名: "+curName);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void execute2(){

        String curName = Thread.currentThread().getName() ;
        System.out.println("当前时间:"+LocalDateTime.now()+"  任务execute2对应的线程名: "+curName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}