import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab7_A {
    public static void main(String[] args) {
        String s = "a *b* fdfd *c) *fkfkfk) (fdfdf) d e";
        String [] str = s.split(" ");
        StringBuffer sb = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter symbol1:");
        String s1 = scanner.next();

        System.out.println("Enter symbol2:");
        String s2 = scanner.next();

        Pattern p = Pattern.compile("^[" + s1 + "].*[" + s2 + "]$");
            for (int i = 0; i < str.length; i++) {
            Matcher m = p.matcher(str[i]);
            if(!m.matches()){
                sb.append(str[i]);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
