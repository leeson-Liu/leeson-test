import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liubin
 * @create 2018-11-14 9:55
 * @desc 利用标号跳出双层for循环
 **/
@Slf4j
public class Test {

    public static final Pattern p = Pattern.compile("(<prosody rate.+?>.+?<\\/prosody>)");

//    public static void main(String[] args) throws DocumentException {
//        String data = "<prosody rate=\"1.33333\">hello world, hello world</prosody>hello，your login token is 1,2,3 <prosody rate=\"0.5\">hello world, hello world</prosody>";
//
//        String[] splitString = p.split(data);
//        Matcher m = p.matcher(data);
//        StringBuilder result = new StringBuilder();
//        result.append(splitString[0]);
//        int i = 1;
//        while (m.find()) {
//            String xmlText = m.group();
//            result.append(checkXml(xmlText));
//            if (i < splitString.length) {
//                result.append(splitString[i++]);
//            }
//        }
//        log.info("result :{}", result.toString());
//    }

    private static String checkXml(String xmlText) throws DocumentException {
        Document document = DocumentHelper.parseText(xmlText);
        Element rootElement = document.getRootElement();
        String rateString = rootElement.attribute("rate").getValue();
        System.out.println(rateString);
        BigDecimal rate = new BigDecimal(rateString);
        rootElement.addAttribute("rate", rate.setScale(1, BigDecimal.ROUND_HALF_UP).toPlainString());
        String rightRate = rootElement.attribute("rate").getValue();
        System.out.println(rightRate);
        String text = document.getRootElement().asXML();
        System.out.println(text);
        return text;
    }

    //    private static String aaa() throws  Exception{
    public static void main(String[] args) throws DocumentException {
        StringBuilder finalText = new StringBuilder();
        String s = "<prosody rate=\"0.2\">Mã kích hoạt của bạn là 6,6,6,6</prosody>";
        Matcher m = p.matcher(s);
        String[] splitText = p.split(s);
        if (splitText.length > 0 || m.matches()) {
            m.reset();
            if (splitText.length > 0) {
                finalText.append(splitText[0]);
            }
            int i = 1;
            while (m.find()) {
                String xmlText = m.group();
                finalText.append(checkXml(xmlText));
                if (i < splitText.length) {
                    finalText.append(splitText[i++]);
                }
            }
        }
        System.out.println(finalText);
    }
}
