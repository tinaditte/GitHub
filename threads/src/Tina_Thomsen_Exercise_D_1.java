import java.util.Random;

public class Tina_Thomsen_Exercise_D_1 {

    Random random = new Random();

        public static void main(String[] args) {
            Tina_Thomsen_Exercise_D_1 basicDemo = new Tina_Thomsen_Exercise_D_1();
        }

        public Tina_Thomsen_Exercise_D_1() {
            launchBoat("Princesse Marie");
            launchBoat("Princesse Mary");
        }


        public void launchBoat(String name) {
            Boat psmBoat = new Boat(name);
            Thread psmBoatThread = new Thread(psmBoat);
            psmBoatThread.start();
        }


        class Boat implements Runnable {
            String name = "";
            int distance = 0;

            public Boat(String name) {
                this.name = name;
            }

            public void run() {
                while (distance < 1000) {
                    distance += 50;
                    try {
                        Thread.sleep(random.nextInt(500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(name + " " + distance);
                }
            }
    }
}
