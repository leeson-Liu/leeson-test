//package dealBill;
//
//import com.google.common.io.Files;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.nio.charset.StandardCharsets;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author liubin
// * @create 2021-10-26 15:46
// * @desc
// **/
//public class MongoSqlMaker {
//
//    private static final BigDecimal costMinute = new BigDecimal("0.169");
//    private static final BigDecimal priceMinute = new BigDecimal("0.17");
//    private static final BigDecimal SIXTY_SECONDS = new BigDecimal("60");
//    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    public static void main(String[] args) throws IOException {
//        List<Bill> bills = readTxt();
//        List<String> mongoSqlList = new ArrayList<>();
//        for (Bill bill : bills) {
//            String s = buildMongoSql(bill);
//            mongoSqlList.add(s);
//        }
//        writeMsgTxt(mongoSqlList);
//    }
//
//    public static List<Bill> readTxt() throws IOException {
//        File file = new File("C:\\aaa\\changeMongo.txt");
//        List<String> list = Files.readLines(file, StandardCharsets.UTF_8);
//        List<Bill> result = new ArrayList<>();
//        for (String s : list) {
//            String[] a = s.split(",");
//            Bill bill = new Bill();
//            bill.setLocalMsgId(a[0]);
//            int callDuration = Integer.parseInt(a[1]);
//            bill.setTotalDuration(callDuration);
//            bill.setCallDuration(callDuration);
//            bill.setBaseCallDuration(1);
//            bill.setIncrementCallDuration(callDuration - 1);
//            LocalDateTime startTime = LocalDateTime.parse(a[2], DATE_TIME_FORMATTER);
//            bill.setStartTime(startTime);
//            bill.setEndTime(startTime.plus(callDuration, ChronoUnit.SECONDS));
//            bill.setResponseTime(bill.getEndTime());
//            bill.setPrice(priceMinute.multiply(BigDecimal.valueOf(callDuration)).divide(SIXTY_SECONDS, 6, RoundingMode.UP));
//            bill.setCost(costMinute.multiply(BigDecimal.valueOf(callDuration)).divide(SIXTY_SECONDS, 6, RoundingMode.UP));
//            bill.setCostUserCurrency(bill.getCost());
//
//            result.add(bill);
//        }
//        return result;
//    }
//
//    public static void writeMsgTxt(List<String> list) {
//        File targetFile = new File("C:\\aaa\\changeMongoOver.txt");
//        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile, true))) {
//            for (String line : list) {
//                byte[] content = line.getBytes(StandardCharsets.UTF_8);
//                outputStream.write(content);
//                outputStream.write((byte) 0x0A);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("write txt failed," + e.getMessage());
//        }
//
//    }
//
//    private static String buildMongoSql(Bill bill) {
//        String result = "db.getCollection('voiceCall').updateOne({\"localMsgId\": \"" + bill.getLocalMsgId() + "\" },\n" +
//                "    {\n" +
//                "     $currentDate: {\n" +
//                "        updateTime: true,\n" +
//                "        \"cancellation.date\": { $type: \"timestamp\" }\n" +
//                "     },\n" +
//                "     $set: {\n" +
//                "         \"callDuration\":NumberInt(" + bill.getCallDuration() + "),\n" +
//                "         \"totalDuration\":NumberInt(" + bill.getTotalDuration() + "),\n" +
//                "         \"baseCallDuration\":NumberInt(" + bill.getBaseCallDuration() + "),\n" +
//                "         \"incrementCallDuration\":NumberInt(" + bill.getIncrementCallDuration() + "),\n" +
//                "         \"price\": " + bill.getPrice() + ",\n" +
//                "         \"cost\": " + bill.getCost() + ",\n" +
//                "         \"priceMinPeriod\": 1,\n" +
//                "         \"costMinPeriod\": 1,\n" +
//                "         \"statusCode\":NumberInt(0),\n" +
//                "         \"statusMsg\":\"NORMAL_CLEARING\",\n" +
//                "         \"startTime\":ISODate(\"" + bill.getStartTime() + ".000Z\"),\n" +
//                "         \"endTime\":ISODate(\"" + bill.getEndTime() + ".000Z\"),\n" +
//                "         \"responseTime\":ISODate(\"" + bill.getResponseTime() + ".000Z\"),\n" +
//                "         \"costUserCurrency\":" + bill.getCostUserCurrency() + "\n" +
//                "     }\n" +
//                "    }\n" +
//                ");";
//        return result;
//    }
//}
//
//
