package stream;

import java.io.*;

/**
 * @author liubin
 * @create 2020-08-19 10:32
 * @desc
 **/
public class Stream16 {
    public static void main(final String[] args) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File("C:\\Users\\30567\\Desktop\\彩信文件\\mms.zip"));

            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);

            System.out.println(toHexFromBytes(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private final static String[] hexSymbols = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public final static int BITS_PER_HEX_DIGIT = 4;

    public static String toHexFromByte(final byte b) {
        byte leftSymbol = (byte) ((b >>> BITS_PER_HEX_DIGIT) & 0x0f);
        byte rightSymbol = (byte) (b & 0x0f);
        return (hexSymbols[leftSymbol] + hexSymbols[rightSymbol]);
    }

    public static String toHexFromBytes(final byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return ("");
        }
        // there are 2 hex digits per byte
        StringBuilder hexBuffer = new StringBuilder(bytes.length * 2);

        // for each byte, convert it to hex and append it to the buffer
        for (int i = 0; i < bytes.length; i++) {
            hexBuffer.append(toHexFromByte(bytes[i]));
        }
        return (hexBuffer.toString());
    }
}
