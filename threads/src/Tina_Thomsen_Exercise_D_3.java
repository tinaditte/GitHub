import java.util.ArrayList;
import java.util.Random;
    /**
     Make a thread race program, where a ThreadRace class will create an instance of 10 ThreadRaceCompetitor's.
     Then it'll run them all.
     Keep a scorecard of who finished in which place.
     When a ThreadRaceCompetitor finishes the race, it will have to inform the ThreadRaceContext his race number, and that it's done,
     so the ThreadRaceContext will inform about its arrival.
     Who'll arrive first?
     */
    public class Tina_Thomsen_Exercise_D_3 {

        Random random = new Random();
        int count = 1;
        ArrayList<RaceCar> carList = new ArrayList<>();

        public static void main(String[] args) {
            Tina_Thomsen_Exercise_D_3 basicDemo = new Tina_Thomsen_Exercise_D_3();

        }

        public Tina_Thomsen_Exercise_D_3(){
            launching ("CarA");
            launching ("CarB");
            launching ("CarC");
            launching ("CarD");
            launching ("CarE");
            launching ("CarF");
            launching ("CarG");
            launching ("CarH");
            launching ("CarI");
            launching ("CarJ");
            //10 race competitors here
        }

        public void  launching (String name){
            Tina_Thomsen_Exercise_D_3.RaceCar psmRaceCar = new Tina_Thomsen_Exercise_D_3.RaceCar(name);
            Thread psmRaceCarThread = new Thread(psmRaceCar);
            psmRaceCarThread.start();
        }

        class RaceCar implements Runnable{
            String name = "";
            int distance = 0;

            public RaceCar(String name) {
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
                if (distance == 1000){
                    for(int i = 1; i <= 1; i++){
                        System.out.println(count + " Place" + " " + name);
                        carList.add(RaceCar.this);
                        count++;
                        if(count > 10){
                            carList.toString();
                            System.out.print(carList.toString());
                        }
                    }
                }
            }
            public void get(){
                for (RaceCar raceCar : carList){
                    System.out.println(count + " " + raceCar.name);
                }
            }
        }
    }
