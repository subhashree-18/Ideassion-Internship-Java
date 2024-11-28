class Car {
    String color;
    String model;

    public Car(String color, String model) {
        this.color = color;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car [color=" + color + ", model=" + model + "]";
    }
}
