public class CargoShip implements Ship{
    private String name;
    private int length;
    private int width;
    private int weight;

    public CargoShip(String name, int length, int width, int weight) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void showInformation() {
        System.out.println("Ship name: " + getName());
        System.out.println("Length: " + getLength());
        System.out.println("Width: " + getWidth());
        System.out.println("Weight " + getWeight());
    }
}
