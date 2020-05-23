
public class Lab3_C {
    public class ComplexPoint{
        private double real;
        private double imaginary;

        public ComplexPoint(double real_, double imaginary_){
            real = real_;
            imaginary = imaginary_;
        }

        public ComplexPoint(){
            real = 0;
            imaginary = 0;
        }

        public double getReal() {
            return real;
        }

        public double getImaginary(){
            return imaginary;
        }

        public String toString() {
            if(imaginary > 0)
                return("Complex number: " + real + "+ " + imaginary + "i");
            if(imaginary < 0)
                return ("Complex number: " + real + " " + imaginary + "i");
            if(imaginary == 0)
                return ("Complex number: " + real);
            if(imaginary == 0 && real == 0)
                return ("Complex number: -");
            if(real == 0)
                return ("Complex number: " + imaginary + "i");
            return("Hello");
        }

        public double distance(ComplexPoint Pnt1, ComplexPoint Pnt2){
            return(Math.sqrt(Math.pow((Pnt2.real - Pnt1.real), 2) + Math.pow((Pnt2.imaginary - Pnt1.imaginary), 2)));
        }

        public double distance_start(ComplexPoint Pnt1){
            return(Math.sqrt(Math.pow((0 - Pnt1.real), 2) + Math.pow((0 - Pnt1.imaginary), 2)));
        }
    }

    public void main(String[] args) {
        ComplexPoint Point1 = new ComplexPoint(2,3);
        ComplexPoint Point2 = new ComplexPoint(-4,-2);
        Point1.toString();
        System.out.println();
        Point2.toString();
    }
}
