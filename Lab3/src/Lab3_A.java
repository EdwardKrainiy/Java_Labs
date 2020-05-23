import java.util.Scanner;

public class Lab3_A {
    public static class Car {
        private int id;
        private String brand;
        private String model;
        private int year;
        private String color;
        private double price;
        private String reg_number;

        public Car(int id, String brand, String model, int year, String color, double price, String reg_number) {
            this.id = id;
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.color = color;
            this.price = price;
            this.reg_number = reg_number;
        }

        public Car() {
            this.id = 0;
            this.brand = "-";
            this.model = "-";
            this.year = 0;
            this.color = "-";
            this.price = 0;
            this.reg_number = "-";
        }

        public int getId() {
            return id;
        }

        public double getPrice() {
            return price;
        }

        public int getYear() {
            return year;
        }

        public String getBrand() {
            return brand;
        }

        public String getColor() {
            return color;
        }

        public String getModel() {
            return model;
        }

        public String getReg_number() {
            return reg_number;
        }

        public String toString() {
            if (this.color == "-" && this.reg_number == "-" && this.price == 0 && this.brand == "-" && this.id == 0 && this.model == "-" && this.year == 0) {
                return ("Информации об этой машине не существует.");
            } else {
                return ("ID автомобиля: " + this.id + ", марка автомобиля: " + this.brand + ", модель автомобиля: " + this.model + ", год выпуска: " + this.year + ", цвет автомобиля: " + this.color + ", стоимость(в у.е.): " + this.price + ", регистрационный номер: " + this.reg_number);
            }
        }
    }


    public static void main(String[] args) {
        Car Cars_array[] = new Car[6];
        Cars_array[0] = new Car(1, "BMW", "X5", 2004, "Yellow", 23500, "x455yhe");
        Cars_array[1] = new Car(2, "Porsche", "Cayenne Turbo", 2017, "Black", 155000, "por911e");
        Cars_array[2] = new Car(3, "Mercedes-Benz", "CL65AMG", 2019, "Dark Gray", 180000, "mer65cds");
        Cars_array[3] = new Car(4, "BMW", "M6", 2014, "Dark Red", 95000, "bm001w");
        Cars_array[4] = new Car(5, "Porsche", "Macan Turbo", 2017, "Cyan", 165000, "mac007n");
        Cars_array[5] = new Car(6, "Audi", "RS6", 2017, "Red Crystall", 140000, "aud007i");

        System.out.println("1. Вывести список автомобилей заданной марки.");
        System.out.println("2. Вывести автомобили заданной марки, которые эксплуатируются больше n лет.");
        System.out.println("3. Вывести список автомобилей заданного года выпуска, цена которых больше указанной.");
        System.out.println("4. Выход из программы. ");

        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер услуги.");
        while (!sc.hasNextInt()) {
            System.out.println("Некорректный вариант, введите еще раз!");
        }
        n = sc.nextInt();
        switch (n) {
            case 1:
                String brand_search;
                System.out.println("Введите нужную вам марку: ");
                Scanner brand = new Scanner(System.in);
                brand_search = brand.nextLine();
                for (int i = 0; i < Cars_array.length; i++) {
                    if ((Cars_array[i].getBrand()).equals(brand_search)) {
                        System.out.println(i + ". " + Cars_array[i].toString());
                    }
                }
                break;

            case 2:
                String brand_search2;
                System.out.println("Введите нужную вам марку: ");
                Scanner brand2 = new Scanner(System.in);
                brand_search2 = brand2.nextLine();

                int y;
                Scanner year = new Scanner(System.in);
                System.out.println("Введите нужный год. ");
                while (!year.hasNextInt()) {
                    System.out.println("Некорректное значение, повторите ввод.");
                    year.next();
                }
                y = year.nextInt();

                for (int i = 0; i < Cars_array.length; i++) {
                    if ((Cars_array[i].getBrand()).equals(brand_search2) && Cars_array[i].getYear() > y) {
                        System.out.println(i + ". " + Cars_array[i].toString());
                    }
                }
                break;

            case 3:
                double price;
                Scanner price_scan = new Scanner(System.in);
                System.out.println("Введите нужную цену. ");
                while (!price_scan.hasNextDouble()) {
                    System.out.println("Некорректное значение, повторите ввод.");
                    price_scan.next();
                }
                price = price_scan.nextDouble();

                int y2;
                Scanner year2 = new Scanner(System.in);
                System.out.println("Введите нужный год. ");
                while (!year2.hasNextInt()) {
                    System.out.println("Некорректное значение, повторите ввод.");
                    year2.next();
                }
                y2 = year2.nextInt();

                for (int i = 0; i < Cars_array.length; i++) {
                    if (Cars_array[i].getYear() == y2 && Cars_array[i].getPrice() > price) {
                        System.out.println(i + ". " + Cars_array[i].toString());
                    }
                }
                break;
        }
    }

}


