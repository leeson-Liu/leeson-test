package stream;

import java.io.*;

/**
 * @author liubin
 * @create 2019-01-22 11:28
 * @desc ${DESCRIPTION}
 **/
public class Stream {
    public static void main(String[] args) {
        InputStream in = null;
        OutputStream out = null;

        try {
            //得到输入流
            in = new FileInputStream("C:\\Users\\30567\\Desktop\\参数号码包  - 副本.xlsx");
            //得到输出流
            File file = new File("C:\\Users\\30567\\Desktop\\参数号码包  - 副本111.xlsx");
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new FileOutputStream(file, true);
            int i;//从输入流读取一定数量的字节，返回 0 到 255 范围内的 int 型字节值
            while ((i = in.read()) != -1) {
                out.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
