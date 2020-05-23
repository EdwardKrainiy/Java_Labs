public class Main {
    public static void main(String[] args) {
        City.Quarter quarter = new City("Minsk", "Minsk", "Belarus").new Quarter("Oktyabr'skaya", "Victory Square", "Tiff");
        quarter.show();

        City.Streets streets = new City.Streets(12);
        streets.showInfo();

        //анонимный
        City city1 = new City("New York", "USA state", "USA"){
            @Override
            public void showAnonymosClass(){
                System.out.println("Анонимный класс City.");
            }
        };
        city1.showAnonymosClass();
    }
}
