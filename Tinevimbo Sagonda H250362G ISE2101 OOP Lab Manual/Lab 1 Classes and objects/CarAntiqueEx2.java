import java.time.Year;

public class CarAntiqueEx2 {
    String brand;
    int year;
    double mileage;

    public CarAntiqueEx2(String brand, int year, double mileage) {
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }

    public boolean isAntique() {
        return Year.now().getValue() - year > 25;
    }

    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Antique: " + isAntique());
    }

    public static void main(String[] args) {
        CarAntiqueEx2 car1 = new CarAntiqueEx2("Toyota", 1990, 150000);
        CarAntiqueEx2 car2 = new CarAntiqueEx2("Honda", 2018, 62000);

        car1.display();
        car2.display();
    }
}
