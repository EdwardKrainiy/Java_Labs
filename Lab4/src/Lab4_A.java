import java.util.Objects;

import org.apache.logging.log4j.*;

public class Lab4_A {
    public static Logger log = LogManager.getLogger(Lab4_A.class.getName());
    public static class Point{
        private double P_x;
        private double P_y;

        public double getP_x() {
            return P_x;
        }

        public void setP_x(double p_x) {
            P_x = p_x;
        }

        public double getP_y() {
            return P_y;
        }

        public void setP_y(double p_y) {
            P_y = p_y;
        }

        public Point(double x_, double y_){
            setP_x(x_);
            setP_y(y_);
        }

        public Point(){
            setP_x(0);
            setP_y(0);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return P_x == point.P_x &&
                    P_y == point.P_y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(P_x, P_y);
        }

        @Override
        public String toString() {
            return "x=" + P_x + "; y=" + P_y + "\n";
        }
    }

    public static class Side{
        private Point P1;
        private Point P2;

        public Point getP1() {
            return P1;
        }

        public void setP1(Point p1) {
            P1 = p1;
        }

        public Point getP2() {
            return P2;
        }

        public void setP2(Point p2) {
            P2 = p2;
        }

        public void setP1(double x_, double y_){
            P1.P_x = x_;
            P1.P_y = y_;
        }

        public void setP2(double x_, double y_){
            P2.setP_x(x_);
            P2.setP_y(y_);
        }

        public Side(double x1, double y1, double x2, double y2){
            P1 = new Point(x1, y1);
            P2 = new Point(x2, y2);
        }

        public Side(Point P1, Point P2){
            P1 = new Point(P1.P_x, P1.P_y);
            P2 = new Point(P2.P_x, P2.P_y);
        }

        public Side(){
            Point P1 = new Point(0, 0);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Side side = (Side) o;
            return Objects.equals(P1, side.P1) &&
                    Objects.equals(P2, side.P2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(P1, P2);
        }

        @Override
        public String toString() {
            return "P1: " + P1 + "P2: " + P2;
        }
    }

    public static class Square{
        private Side Side1;
        String color = "-";

        public Side getSide1() {
            return Side1;
        }

        public void setSide1(Side side1) {
            Side1 = side1;
        }

        public void SetColor(String expectedColor) throws ColorException{ //
            try{
                if(expectedColor.equals("")) {
                    throw new ColorException("Invalid color", "");
                }
                this.color = expectedColor;
            }
            catch(ColorException color){
                System.out.println(color.getMessage());
            }
        }


        public Square(){
            Side1 = new Side(0, 0, 0, 0);
        }

        public Square(Side side1){
            Side1 = new Side(side1.P1.getP_x(), side1.P1.getP_y(), side1.P2.getP_x(), side1.P2.getP_y());
        };

        public Square(Point Point1, Point Point2){
            Side1 = new Side(Point1.getP_x(), Point1.getP_y(), Point2.getP_x(), Point2.getP_y());
        };

        public Square(double x1_, double y1_, double x2_, double y2_){
            Side1 = new Side(x1_, y1_, x2_, y2_);
        };


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Square square = (Square) o;
            return Objects.equals(Side1, square.Side1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(Side1);
        }

        @Override
        public String toString() {
            return "Side: " + Math.sqrt(Math.pow((Side1.P2.P_x - Side1.P1.P_x), 2) + Math.pow((Side1.P2.P_y - Side1.P1.P_y), 2)) + "\n" + Side1 + "Color: " + color + ";"+ "\n";
        }

        public Square Compression(double koef){
            Square S = new Square(Side1.P1.getP_x() * koef, Side1.P1.getP_y() * koef, Side1.P2.getP_x() * koef, Side1.P2.getP_y() * koef);
            return S;
        }

        public Square Rotation(double angle){ //Против часовой стрелки
            double x1_new = Side1.P1.getP_x() * Math.cos(Math.toRadians(angle)) - Side1.P1.getP_y() * Math.sin(Math.toRadians(angle));
            double y1_new = Side1.P1.getP_x() * Math.sin(Math.toRadians(angle)) + Side1.P1.getP_y() * Math.cos(Math.toRadians(angle));

            double x2_new = Side1.P2.getP_x() * Math.cos(Math.toRadians(angle)) - Side1.P2.getP_y() * Math.sin(Math.toRadians(angle));
            double y2_new = Side1.P2.getP_x() * Math.sin(Math.toRadians(angle)) + Side1.P2.getP_y() * Math.cos(Math.toRadians(angle));

            Square S = new Square(x1_new, y1_new, x2_new, y2_new);
            return(S);
        }

        public Square Coloring(String Color) throws ColorException {
            Square S = new Square(Side1.P1.getP_x(), Side1.P1.getP_y(), Side1.P2.getP_x(), Side1.P2.getP_y());
            S.SetColor(Color);
            return S;
        }
    }

    public static void main(String[] args) throws ColorException {
        log.info("Successful!");

        Point Point1 = new Point(10, 65);
        Side Side1 = new Side(2, 2, 15, 31);
        Square Square1 = new Square(1, 2, 5, 2);
        Square Square2 = new Square(4, 3, 6, 9);

        System.out.println("Point: " + "\n");
        System.out.println(Point1.toString());
        log.info("Point");

        System.out.println("Side: " + "\n");
        System.out.println(Side1.toString());
        log.info("Side");

        System.out.println("Square: " + "\n");
        System.out.println(Square1.toString());
        log.info("Square");

        System.out.println("Rotation 45: " + "\n");
        System.out.println(Square1.Rotation(45).toString());

        System.out.println("Compressing: " + "\n");
        System.out.println(Square1.Compression(0.5).toString());

        System.out.println("Coloring: " + "\n");
        System.out.println(Square1.Coloring(""));

        System.out.println("Is Square1 equals Square2? ");
        System.out.println(Square1.equals(Square2) + "\n");

        System.out.println("HashCode of Square1: ");
        System.out.println(Square1.hashCode());


        log.info("End");
    }
}

