import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author liubin
 * @create 2019-02-01 16:35
 * @desc ${DESCRIPTION}
 **/
public class ScheduledTest {

    @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
    public void myTest(){
        System.out.println("进入测试");
    }

//    public static void main(String[] args) {
//        ScheduledTest s = new ScheduledTest();
//        s.print();
//    }
//
//    @Scheduled(cron = "0/5 * * * * ? ")
//    public void print() {
//        Integer i = 0;
//        System.out.println("输出:" + i);
//    }
}
