//package regex;
//
//import com.gliwka.hyperscan.wrapper.*;
//import com.google.common.io.Files;
//import com.sun.jna.Native;
//import com.sun.jna.win32.StdCallLibrary;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.util.EnumSet;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * @author liubin
// * @create 2020-08-26 17:47
// * @desc
// **/
//public class test {
//    public static void main(final String[] args) throws IOException {
//        System.load("C:/work/hs.dll");
//        LinkedList<Expression> expressions = new LinkedList<Expression>();
//
//        //the first argument in the constructor is the regular pattern, the latter one is a expression flag
//        //make sure you read the original hyperscan documentation to learn more about flags
//        //or browse the ExpressionFlag.java in this repo.
//        expressions.add(new Expression("[0-9]{5}", EnumSet.of(ExpressionFlag.SOM_LEFTMOST)));
//        expressions.add(new Expression("Test", EnumSet.of(ExpressionFlag.CASELESS)));
//
//
//        //we precompile the expression into a database.
//        //you can compile single expression instances or lists of expressions
//
//        //since we're interacting with native handles always use try-with-resources or call the close method after use
//        try(Database db = Database.compile(expressions)) {
//            //initialize scanner - one scanner per thread!
//            //same here, always use try-with-resources or call the close method after use
//            try(Scanner scanner = new Scanner())
//            {
//                //allocate scratch space matching the passed database
//                scanner.allocScratch(db);
//
//
//                //provide the database and the input string
//                //returns a list with matches
//                //synchronized method, only one execution at a time (use more scanner instances for multithreading)
//                List<Match> matches = scanner.scan(db, "12345 test string");
//
//                //matches always contain the expression causing the match and the end position of the match
//                //the start position and the matches string it self is only part of a matach if the
//                //SOM_LEFTMOST is set (for more details refer to the original hyperscan documentation)
//            }
//
//            // Save the database to the file system for later use
//            try(OutputStream out = new FileOutputStream("db")) {
//                db.save(out);
//            }
//
//            // Later, load the database back in. This is useful for large databases that take a long time to compile.
//            // You can compile them offline, save them to a file, and then quickly load them in at runtime.
//            // The load has to happen on the same type of platform as the save.
//            try (InputStream in = new FileInputStream("db");
//                 Database loadedDb = Database.load(in)) {
//                // Use the loadedDb as before.
//            }
//        }
//        catch (CompileErrorException ce) {
//            //gets thrown during  compile in case something with the expression is wrong
//            //you can retrieve the expression causing the exception like this:
//            Expression failedExpression = ce.getFailedExpression();
//        }
//        catch(IOException ie) {
//            //IO during serializing / deserializing failed
//        }
//    }
//
//
//    public static List<String> readTxt() throws IOException {
//        File file = new File("C:\\aaa\\cidian.txt");
//        return Files.readLines(file, StandardCharsets.UTF_8);
//    }
//}
