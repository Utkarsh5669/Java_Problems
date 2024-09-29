import java.util.Scanner;
import javax.swing.*;

class Competitor extends Thread {
String name;
int breakTime;
int pace;
int currentPos;
public int getCurrentPos() {
    return currentPos;
}
    public void run ()
    {
     int steps =0;
    try{
   for(currentPos =0 ; currentPos<tortoroise_hare_Game.distance ; currentPos+=pace)
   {
    Thread.sleep(tortoroise_hare_Game.difficultyLevel*tortoroise_hare_Game.difficultyLevelTime);
    steps++;
    if(steps%10==0)
    {
        Thread.sleep(breakTime);
    }
   }
}
catch(Exception e){
    System.out.println("Cannot continue game for " + name);
    return;
    }
}
}
class Tortoise extends Competitor{
    Tortoise()
    {
        this.name="Tortoise";
        this.pace=2;
        this.breakTime =300;

    }

}
class Rabbit extends Competitor{
    Rabbit(){
        this.name = "Rabbit";
        this.pace = 5;
        this.breakTime =3500;
    }
}
public class tortoroise_hare_Game extends JFrame {
    public static int distance = 100;
    public static int difficultyLevel = 1;
    public static int difficultyLevelTime = 50;

    static JFrame frame;
    static JProgressBar progressBarR, progressBarT;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        frame = new JFrame();
        JPanel panel = new JPanel();
        progressBarR = new JProgressBar();
        progressBarT = new JProgressBar();
        progressBarR.setValue(0);
        progressBarR.setString("Rabbit");
        progressBarR.setStringPainted(true);
        progressBarT.setValue(0);
        progressBarT.setString("Tortoise");
        progressBarT.setStringPainted(true);
        panel.add(progressBarR);
        panel.add(progressBarT);
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setVisible(true);

        char choice = 'Y';
        do {
            System.out.print("\nEnter difficulty level: ");
            difficultyLevel = sc.nextInt();
            sc.nextLine();

            // Game

            Rabbit rabbit = new Rabbit();
            Tortoise tortoise = new Tortoise();

            progressBarR.setValue(0);
            progressBarT.setValue(0);

            rabbit.start();
            tortoise.start();

            while (rabbit.isAlive() || tortoise.isAlive()) {
                int rabbitPosition = rabbit.getCurrentPos();
                int tortoisePosition = tortoise.getCurrentPos();
                progressBarR.setValue(rabbitPosition);
                progressBarT.setValue(tortoisePosition);

                if (rabbitPosition == tortoroise_hare_Game.distance) {
                    progressBarR.setString("Rabbit (Finished)");
                } else {
                    progressBarR.setString("Rabbit: " + rabbitPosition + "%");
                }
                if (tortoisePosition == tortoroise_hare_Game.distance) {
                    progressBarT.setString("Tortoise (Finished)");
                } else {
                    progressBarT.setString("Tortoise: " + tortoisePosition + "%");
                }

            }
            progressBarR.setString("Rabbit (Finished)");
            progressBarT.setString("Tortoise (Finished)");
            // Asking user's choice
            System.out.print("Do you wish to continue: ");
            choice = sc.next().charAt(0);
            sc.nextLine();
        } while (choice != 'N' || choice != 'n');
        sc.close();
    }
}
