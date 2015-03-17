import java.util.ArrayList;

/**
 * Created by Tom on 17/03/2015.
 */
public class StringManipulator {

    public static ArrayList<Character> StringSpliter(String str)
    {
       // str += ":";
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> characterArrayList = new ArrayList<Character>();
        char[] chars = str.toCharArray();
        char prevchar = '\0';
        int colons = 0;
        for(char ch : chars)
        {
            if((ch == ' ' && prevchar == '=') || (ch == '=' && prevchar == ' ') )
            {
                prevchar = ch;
                if(colons == 0)
                {
                    characterArrayList.add(':');
                }
                colons++;

            }
            else
            {
                characterArrayList.add(ch);
                prevchar = ch;
                colons = 0;
            }
        }
        return characterArrayList;
    }

}
