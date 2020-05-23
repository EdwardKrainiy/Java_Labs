
public class Main {
    public static void main(String[] args) {
        CargoShip ship1 = new CargoShip("Victory", 200, 100, 15000);
        Tanker ship2 = new Tanker("TankerShip", 320, 120, 25000, 5000, 200);
        ship1.showInformation();
        System.out.println();
        ship2.showInformation();
    }
}
