import java.util.Scanner;
import java.util.Timer;

public class TypingTest2 {

    private double typingSpeed;
    private String text;
    private int accuracy;

    public TypingTest2(String text)
    {
        this.text = text;
    }

    public void OneMinuteMode()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Start typing the following text:\n");
        System.out.println(text + "\n");

        TimerThread timer = new TimerThread();
        timer.start();

        StringBuilder str = new StringBuilder();

        while(timer.isAlive())
        {
            if(sc.hasNextLine())
            {
                str.append(sc.nextLine());
            }
        }
        sc.close();

        int correct = 0;
        for(int i = 0; i < str.length() ; i ++)
        {
            if(i < str.length() && str.charAt(i) == text.charAt(i))
            {
                correct ++;
            }
        }

        accuracy = (int )((double) correct /str.length() * 100);
        typingSpeed = (double) correct / 60;

        results();



        System.exit(0);







    }

    public void Start()
    {
        OneMinuteMode();
    }




    public void results()
    {
        System.out.println("Typing Speed: " + typingSpeed + " characters per second");
        System.out.println("Accuracy: " + accuracy + "%");
    }


    class TimerThread extends Thread
    {
       public void run()
        {
            try {
                int timeElapsed = 3000;
                int num = 3 ;
                while(timeElapsed != 0)
                {
                    sleep(1000);
                    System.out.println(num);
                    num = num - 1;
                    timeElapsed = timeElapsed - 1000;
                }



                System.out.println("\n\nTime is up!\n");

            } catch (InterruptedException e) {
                // Thread interrupted, do nothing
            }
        }
    }

}
