package date;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author liubin
 * @create 2019-03-11 13:35
 * @desc ${DESCRIPTION}
 **/
public class dateTest {
    public static void main(String[] args){
        LocalDate endDate = LocalDate.parse("2019-03-02");
        LocalDate startDate = endDate.minusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(startDate.toString());
        System.out.println(endDate.toString());
    }
}
