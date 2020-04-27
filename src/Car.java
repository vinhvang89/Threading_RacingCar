import java.awt.*;
import java.util.Random;

public class Car extends Main implements Runnable {
    private String name;
    public Car(String name){
        this.name = name;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int location = 0;
        while (location < DISTANCE) {
            try {
                String timeLine = "|";
                int speed = (int) (Math.random() * 10);
                location += speed;
                int percentOfDistance = location * 100 / DISTANCE;
                for (int i = 0; i < DISTANCE; i += STEP) {
                    if (percentOfDistance >= i + STEP)
                        timeLine += "=";
                    else if (percentOfDistance >= i && percentOfDistance < i + STEP)
                        timeLine += "0";
                    else if(percentOfDistance <= i + STEP)
                        timeLine += "-";
                }
                timeLine += "|";
                System.out.println(name + ": " + timeLine + " " + percentOfDistance + " km");
                Thread.sleep(1000);
        } catch(InterruptedException e){
            e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(name + " is finished at " +(end-start)/1000+ " seconds"  );

    }

}
class Main{
    public static int DISTANCE = 100;

    public static int STEP = 1;
}
