public class City {
    private String name;
    private String state;
    private String country;

    public City(String name, String state, String country) {
        this.name = name;
        this.state = state;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //внутренний
    public class Quarter{
        private String street;
        private String square;
        private String avenue;

        public Quarter(String street, String square, String avenue) {
            this.street = street;
            this.square = square;
            this.avenue = avenue;
        }

        public void show() {
            System.out.println("Внутренний вложенный класс");
            System.out.println("Street: " + street);
            System.out.println("Square: " + square);
            System.out.println("Avenue: " + avenue);
        }
    }
    //вложенный статический
    static class Streets{
        private int streetAmount;
        Streets(int streetAmount){
            this.streetAmount = streetAmount;
        }
        public void showInfo() {
            System.out.println("В данном квартале " + streetAmount + " улиц.");
        }
    }

    //для анонимного класса
    public void showAnonymosClass(){
        System.out.println("Анонимный класс");
    }
}