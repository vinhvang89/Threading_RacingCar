public class Test {
    public static void main(String[] args) {
        Car carA = new Car("Công nông đầu dọc");
        Car carB = new Car("Công nông đầu ngang");
        Car carC = new Car("Máy cày");

        Thread thread1 = new Thread(carA);
        Thread thread2 = new Thread(carB);
        Thread thread3 = new Thread(carC);
        System.out.println("Distance = 300 km ");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
