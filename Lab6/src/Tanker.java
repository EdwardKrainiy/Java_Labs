public class Tanker extends CargoShip implements Ship{
    private int maxCargoWeight;
    private int cratesAmount;

    public Tanker(String name, int length, int width, int weight, int maxCargoWeight, int cratesAmount) {
        super(name, length, width, weight);
        this.maxCargoWeight = maxCargoWeight;
        this.cratesAmount = cratesAmount;
    }

    public int getMaxCargoWeight() {
        return maxCargoWeight;
    }

    public void setMaxCargoWeight(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    public int getCratesAmount() {
        return cratesAmount;
    }

    public void setCratesAmount(int cratesAmount) {
        this.cratesAmount = cratesAmount;
    }

    @Override
    public void showInformation() {
        System.out.println("Ship name: " + getName());
        System.out.println("Length: " + getLength());
        System.out.println("Width: " + getWidth());
        System.out.println("Weight " + getWeight());
        System.out.println("Max cargo weight: " + getMaxCargoWeight());
        System.out.println("Crates amount: " + getCratesAmount());
    }
}