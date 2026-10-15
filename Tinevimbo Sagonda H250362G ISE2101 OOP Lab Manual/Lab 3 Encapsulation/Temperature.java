public class Temperature {
    private double kelvin;

    public Temperature(double kelvin) {
        setKelvin(kelvin);
    }

    public void setKelvin(double kelvin) {
        if (!Double.isFinite(kelvin) || kelvin < 0) {
            throw new IllegalArgumentException(
                "Temperature cannot be below absolute zero."
            );
        }

        this.kelvin = kelvin;
    }

    public double getCelsius() {
        return kelvin - 273.15;
    }

    public double getFahrenheit() {
        return getCelsius() * 9.0 / 5.0 + 32;
    }

    public static void main(String[] args) {
        Temperature temperature = new Temperature(300);

        System.out.printf("Kelvin: %.2f K%n", 300.0);
        System.out.printf("Celsius: %.2f C%n",
                temperature.getCelsius());
        System.out.printf("Fahrenheit: %.2f F%n",
                temperature.getFahrenheit());

        try {
            temperature.setKelvin(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
