import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.*;

public class Lab4_B {
    public static Logger log = LogManager.getLogger(Lab4_B.class.getName());

    public static class wagon implements Serializable {
        private int bag_amount;
        private int passenger_amount;
        private int comfort_lvl;

        public wagon(int b, int p) {
            setBag_amount(b);
            setPassenger_amount(p);
        }

        public wagon() {
            setPassenger_amount(0);
            setBag_amount(0);
        }

        public int getBag_amount() {
            return bag_amount;
        }

        public void setBag_amount(int bag_amount) {
            this.bag_amount = bag_amount;
        }

        public int getPassenger_amount() {
            return passenger_amount;
        }

        public void setPassenger_amount(int passenger_amount) {
            this.passenger_amount = passenger_amount;
        }

        public int getComfort_lvl() {
            return comfort_lvl;
        }

        public void setComfort_lvl(int comfort_lvl) {
            this.comfort_lvl = comfort_lvl;
        }

        void showInfo(){
            System.out.println("Usual wagon. Comfort level = " + comfort_lvl);
        }

        public wagon read() throws IOException {
            FileInputStream inputStream = new FileInputStream("text.txt");
            ObjectInputStream deserializeStream = new ObjectInputStream(inputStream);
            try {
                return (wagon)deserializeStream.readObject();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            return new wagon();
        }

        public void write() throws IOException {
            FileOutputStream fileStream = new FileOutputStream("text.txt");
            ObjectOutputStream serialStream = new ObjectOutputStream(fileStream);
            serialStream.writeObject(this);
        }
    }

    public static class businessWagon extends wagon{

        public businessWagon(int b, int p) {
            super(b, p);
            setComfort_lvl(3);
        }

        public businessWagon() {
        }

        @Override
        void showInfo(){
            System.out.println("Business wagon. Comfort level = " + getComfort_lvl());
        }

    }

    public static class economyWagon extends wagon{

        public economyWagon(int b, int p) {
            super(b, p);
            setComfort_lvl(2);
        }

        public economyWagon() {
        }

        @Override
        void showInfo(){
            System.out.println("Economy wagon. Comfort level = " + getComfort_lvl());
        }
    }

    public static class passengerWagon extends wagon{

        public passengerWagon(int b, int p) {
            super(b, p);
            setComfort_lvl(1);
        }

        public passengerWagon() {
        }

        @Override
        void showInfo(){
            System.out.println("Passenger wagon. Comfort level = " + getComfort_lvl());
        }

    }

    public static class train {
        List<wagon> wagons;

        public train(wagon[] wagons_) {
            wagons = Arrays.asList(wagons_) ;
        }

        public List<wagon> getWagons() {
            return wagons;
        }

        public void setWagons(List wagons) {
            this.wagons = wagons;
        }
    }

    public static void main(String[] args) throws IOException {
        log.info("Main.");

        wagon[] wagons = new wagon[6];
        wagons[0] = new economyWagon(50, 200);
        wagons[1] = new businessWagon(30, 150);
        wagons[2] = new economyWagon(60, 220);
        wagons[3] = new passengerWagon(20, 50);
        wagons[4] = new economyWagon(70, 150);
        wagons[5] = new wagon(3, 5);

        wagons[5].write();
        wagons[5].read().toString();


        for (int i = 0; i < wagons.length; i++){
            wagons[i].showInfo();
        }

        log.info("Wagons created.");

        train t1 = new train(wagons);
        log.info("Train created.");

        int n = 0;

        while (n != 5) {
            menu();
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите номер услуги.");
            boolean correctInput = false;
            while(!correctInput){
                try{
                  n = sc.nextInt();
                  if(n <= 0 || n > 5){
                      throw new Exception();
                  }
                  correctInput = true;
                }
                catch (Exception e){
                    log.error("Incorrect input!");
                    System.out.println("Incorrect input, try again!");
                    sc.nextLine();
                }
            }

            switch (n) {
                case 1:
                    output(wagons);
                    log.info("1st case");
                    break;

                case 2:
                    System.out.println("Общее количество пассажиров: " + bags(wagons));
                    System.out.println("Общее количество багажа: " + passengers(wagons));
                    log.info("2nd case");
                    break;

                case 3:
                    sorting(Arrays.asList(wagons));
                    output(wagons);
                    log.info("3rd case");
                    break;

                case 4:
                    int min = 0, max = 0;
                    System.out.println("Введите минимальное количество пассажиров: ");
                    Scanner sc1 = new Scanner(System.in);
                    boolean minPassenger = false;
                    while(!minPassenger){
                        try{
                            min = sc1.nextInt();
                            if(min < 0){
                                throw new Exception();
                            }
                            minPassenger = true;
                        }
                        catch (Exception e){
                            log.error("Incorrect input!");
                            System.out.println("Incorrect input, try again!");
                            sc1.nextLine();
                        }
                    }

                    System.out.println("Введите максимальное количество пассажиров: ");
                    boolean maxPassenger = false;
                    while(!maxPassenger){
                        try{
                            max = sc1.nextInt();
                            if(max < 0 || max < min){
                                throw new Exception();
                            }
                            maxPassenger = true;
                        }
                        catch (Exception e){
                            log.error("Incorrect input!");
                            System.out.println("Incorrect input, try again!");
                            sc1.nextLine();
                        }
                    }

                    System.out.print("Номера вагонов: ");
                    for (int i = 0; i < wagons.length; i++) {
                        if(wagons[i].getPassenger_amount() <= max && wagons[i].getPassenger_amount() >= min )
                        {
                            System.out.print(i + " ");
                        }
                    }
                    System.out.println();
                    System.out.println();
                    log.info("4th case");
                    break;
            }
        }
    }

    public static int bags(wagon[] wagons) {
        int bags = 0;
        for (int i = 0; i < wagons.length; i++) {
            bags = bags + wagons[i].getBag_amount();
        }
        return bags;
    }

    public static int passengers(wagon[] wagons) {
        int pas = 0;
        for (int i = 0; i < wagons.length; i++) {
            pas = pas + wagons[i].getPassenger_amount();
        }
        return pas;
    }

    public static void sorting(List<wagon> wagons) {
        for (int i = 0; i < wagons.size(); i++) {
            wagon min = wagons.get(i);
            int min_i = i;

            for (int j = i + 1; j < wagons.size(); j++) {
                if (wagons.get(j).getComfort_lvl() < min.getComfort_lvl()) {
                    min = wagons.get(j);
                    min_i = j;
                }
            }
            if (i != min_i) {
                wagon tmp = wagons.get(i);
                wagons.set(i, wagons.get(min_i));
                wagons.set(min_i, tmp);
            }
        }
    }

    public static void output(wagon[] wagons) {
        for (int i = 0; i < wagons.length; i++) {
            System.out.println("Вагон номер: " + (i + 1));
            System.out.println("Количество сумок: " + wagons[i].getBag_amount());
            System.out.println("Количество пассажиров: " + wagons[i].getPassenger_amount());
            System.out.println("Уровень комфорта: " + wagons[i].getComfort_lvl());
            System.out.println();
            System.out.println();
        }
    }

    public static void menu() throws IOException {
        System.out.println("1. Вывод вагонов данного поезда.");
        System.out.println("2. Вывод общей численности пассажиров и багажа.");
        System.out.println("3. Отсортировать вагоны поезда в порядке возрастания их уровней комфорта.");
        System.out.println("4. Вывод номеров вагона с заданным в интервале количеством пассажиров.");
        System.out.println("5. Выход из программы. "); //Доделать ввод в файл с Exception
    }
}


