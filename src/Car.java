import java.util.Random;

public class Car extends Main implements Runnable {
    private String name;
    public Car(String name){
        this.name = name;
    }

    @Override
    public void run() {
        int runDistance = 0;
        long startTime = System.currentTimeMillis();
        while (runDistance < Main.DISTANCE){
            try {
                int speed = (new Random()).nextInt();
                runDistance += speed;
                String log = "|";
                int percentTravel = (runDistance*100)/ DISTANCE;
                for (int i = 0; i < DISTANCE ; i+= STEP) {
                    if(percentTravel >= i + STEP)
                        log += "=";
                    else if(percentTravel >= i && percentTravel< i + STEP)
                        log += "0";
                    else
                        log += "-";
                }
                log += "|";
                System.out.println( this.name + ": " + log + " " + Math.min(DISTANCE, runDistance) + "KM");
                Thread.sleep(1000);
            } catch (Exception e){
                System.out.println("Car "+this.name+"is broken down !");
                break;
            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
class Main{
    public static int DISTANCE = 300;

    public static int STEP = 2;
}
