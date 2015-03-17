import java.util.ArrayList;

/**
 * Created by Tom on 17/03/2015.
 */
public class Main {

   static long othertime;
    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        //m.StartThread();
        m.SplitString();
        //long time = System.nanoTime();
        //System.out.println((time - othertime));
        //System.out.println("Thread:" + Thread.currentThread().getId() + "Finished At " + System.nanoTime());
    }
    public void StartThread() throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                SplitString();
                //System.out.println("Thread:" + Thread.currentThread().getId() + "Finished At " + System.nanoTime());
                othertime = System.nanoTime();
            }
        });
        newThread.start();
        newThread.join();
    }
    private synchronized void SplitString() {
        String str = "{id = 1 \n trailid = 2 \n description = test description}"; // starting string
        str = str.substring(1,str.length() - 1); // remove braces
        String[] splitstr = str.split("\\\n"); // remove and split on newlines
        ArrayList<String> FinalStrings = new ArrayList<String>();
        for(int i = 0; i < splitstr.length; i++) // for each of the split strings
        {
            //splitstr[0] += ":";
            ArrayList<Character> temp = StringManipulator.StringSpliter(splitstr[i]);
            StringBuilder sp = new StringBuilder();
            for(char c : temp)
            {
                sp.append(c);
            }
            FinalStrings.add(sp.toString());
            sp = new StringBuilder();
        }
        for(String s : FinalStrings)
        {
            if(s.startsWith(" "))
            {
                s = s.substring(1,s.length());
            }
            String[] split = s.split("\\:");
            for(int i = 0; i < split.length; i++)
            {
                if(split[i].endsWith(" "))
                {
                    split[i] = split[i].substring(0, split[i].length() - 1);
                }
                System.out.println(split[i]); // Print Correct String You thought you could outsmart me Java well DID YA!
            }

        }
    }
}
