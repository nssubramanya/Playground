import java.io.StringReader;
import java.text.MessageFormat;

public class Course {
    public void StringDemo() {
        // String s1 = new String("Paul");
        // String s2 = new String("Paul");

        // String s3 = "Harry";
        // String s4 = "Harry";

        // String morning1 = "morning";
        // String morning2 = new String("morning");

        // String girl = new String("Shreya");
        // StringBuilder sBuilder = new StringBuilder("String builder");
        // String s5 = new String(sBuilder);
        // StringBuffer sb = new StringBuffer("String Buffer");
        // String s6 = new String(sb);

        // System.out.println(s1 == s2);
        // System.out.println(s3 == s4);
        // System.out.println("morning" == morning1);
        // System.out.println("morning" == morning2);

        // Note System.out.println() does not take multiple arguments
        // System.out.println("%s %s", s5, s6);

        // Various ways to Print Strings
        // System.out.println("Method 1: " + s5 + ", " + s6);
        // System.out.printf("Method 2: %s, %s\n", s5, s6);
        // System.out.println(String.format("Method 3: %s, %s", s5, s6));
        // System.out.println(MessageFormat.format("Method 4: {0}, {1}", s5, s6));
        // System.out.format("Method 5: %s, %s\n", s5, s6);

        // Characters in String
        // System.out.printf("Length of String: %d\n", girl.length());
        // for (int i = 0; i < girl.length(); i++) {
        // System.out.printf("%c", girl.charAt(i));
        // }

        // String Exceptions
        String s7 = null;
        s7 = "Sushruth" + "Subramanya";
        System.out.println(s7);

        String s8 = "Sushruth";
        s8 += "Subramanya";
        System.out.println(s8);

        // Interestingly, the above prints 'null' and not throw exception

        // System.out.println(girl.charAt(10));

    }

    public void StringBuilderDemo() {
        String o = "-";
        switch ("RED".toLowerCase()) {
        case "yellow":
            o += "y";
        case "red":
            o += "r";
        case "green":
            o += "g";
            // default:
            // o += "failed";
        }
        System.out.println(o);
    }

    public static void main(String[] args) {

        Course c = new Course();
        // c.StringDemo();
        c.StringBuilderDemo();
    }
}