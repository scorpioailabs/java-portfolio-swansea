/*package InterviewQs;

/**
 * Test
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Test {
    public static void main(String[] args) {
        
        final String regex = ",(?![^\\(\\[]*[\\]\\)])";
        final String string = "Harry Potter, [and, the chamber, of secrets], Hermione, (Olivanders, Wands)";
        String str = str.split("[\\]");
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);
    
        while(matcher.find())
        {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }

}