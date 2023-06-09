package write;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.List;
import java.util.Random;

import static jdk.nashorn.internal.ir.debug.ObjectSizeCalculator.getObjectSize;

/**
 * @author liubin
 * @create 2020-09-07 10:33
 * @desc
 **/

@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableScheduling
@SpringBootApplication
public class Txt {
    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/phone_test?autoReconnect=true&characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) throws Exception {
        writeTxt(1);
//
//        Statement statement = open();
//        Long t1 = System.currentTimeMillis();
//        long[] txt = buildPhoneList();
//        Long t2 = System.currentTimeMillis();
//        int i = 0;
//        for (long l : txt) {
//            String s = String.valueOf(l);
//            String tableName = s.substring(s.length() - 3);
//            statement.execute(buildInsertSql(tableName, s));
//            if (i % 500 == 0) {
//                System.out.println("現在存了：" + i);
//            }
//            i++;
//        }
//        Long t3 = System.currentTimeMillis();
//
//        System.out.println("write cost time :" + (t2 - t1));
//        System.out.println("save cost time :" + (t3 - t2));
    }


    public static String buildInsertSql(String table, String phone) {
        return "insert into  test" + table + " (phone) values ('" + phone + "')";
    }

    public static List<String> readTxt() throws IOException {
        File file = new File("C:\\aaa\\1yi_1.csv");
        return Files.readLines(file, StandardCharsets.UTF_8);
    }

    public static void creatTable() {
        for (int i = 0; i < 1000; i++) {
            runSql(buildSql(dealTableName(i)));
        }
    }

    public static String dealTableName(int i) {
        String s = String.valueOf(i);
        Integer length = s.length();
        if (length == 1) {
            return "00" + s;
        } else if (length == 2) {
            return "0" + s;
        } else {
            return s;
        }
    }

    public static String buildSql(String tableName) {
        String qian = "create table `test";
        String hou = "` (\n" +
                "  `id` bigint(20) not null AUTO_INCREMENT,\n" +
                "  `phone` varchar(20) DEFAULT NULL,\n" +
                "  PRIMARY KEY (id) USING BTREE\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n";
        return qian + tableName + hou;

    }


    public static boolean runSql(String sql) {
        Connection conn = null;
        Statement stmt = null;
        boolean isOk = false;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            isOk = stmt.execute(sql);
            // 完成后关闭
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                stmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            return isOk;
        }

    }

    public static Statement open() throws Exception {
        Class.forName(JDBC_DRIVER);
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
        return stmt;
    }

    public static long[] buildPhoneList() {
        Random random = new Random();
        //一千万
        long[] s = random.longs(1000000, 8610000000000L, 8699999999999L).toArray();
        return s;
    }

    public static void writeTxt(int aa) {
        long t1 = System.currentTimeMillis();
        long[] result = buildPhoneList();
        long a = getObjectSize(result);
        System.out.println(a);
        System.out.println(a / 1024);
        long t2 = System.currentTimeMillis();
        System.out.println("build data:" + (t2 - t1));
        File targetFile = new File("C:\\aaa\\1million" + aa + ".csv");
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetFile, true))) {
            byte[] title = "id,cat".getBytes(StandardCharsets.UTF_8);
            outputStream.write(title);
            outputStream.write((byte) 0x0A);
            int i = 1;
            for (long items : result) {
                byte[] content = String.valueOf(i + "," + items).getBytes(StandardCharsets.UTF_8);
                outputStream.write(content);
                outputStream.write((byte) 0x0A);
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException("store cdr failed," + e.getMessage());
        }
        long t3 = System.currentTimeMillis();
        System.out.println("write data:" + (t3 - t2));
    }
}
