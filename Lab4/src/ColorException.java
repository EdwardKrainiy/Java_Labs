public class ColorException extends Exception {
    private String color;

    private String getColor(){
        return color;
    }

    public ColorException(String message, String col){
        super(message);
        color = col;
    }
}
