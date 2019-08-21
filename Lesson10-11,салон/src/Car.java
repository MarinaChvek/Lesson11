import java.util.*;
import java.util.stream.Collectors;
public abstract class Car implements Cloneable {
    private static int nextId = 1;
    private final int id = nextId++;
    private String _brand;
    private String _model;
    public CarTransmissionType TransmissionType;
    public CarEngineType EngineType;

    public Car(String _brand, String _model,
               CarTransmissionType carTransmissionType, CarEngineType carEngineType) {

        this._brand = _brand;
        this._model = _model;
        TransmissionType = carTransmissionType;
        EngineType = carEngineType;
    }

    public enum CarTransmissionType {
        Automatic,
        Manual
    }

    public enum CarEngineType {
        Diesel,
        Petrol,
        Gas,
        Electrical
    }


    public String getModel() {
        return _model;
    }
    public int getId() {
        return id;
    }
    public void setModel(String model) {
        if (model != null && model != "") {
            this._model = model;
        } else {
            System.out.println("Model can not be Null or Empty");
        }
    }

    public String getBrand() {
        return _brand;
    }

    public void setBrand(String brand) {
        if (brand != null && brand != "") {
            this._brand = brand;
        } else {
            System.out.println("Brand can not be Null or Empty");
        }
    }

    public void printInfo() {
        System.out.println("Id: " + getId());
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Transmission: " + TransmissionType);
        System.out.println("Engine: " + EngineType);
    }


        public static void printCarsByBrand(ArrayList < Car > cars,String brand){  //поиск машин через потоки
            ArrayList<Car> collect= cars.stream().filter(e -> e.getBrand() == brand).collect(Collectors.toCollection(ArrayList::new));
            for (Car car : collect) {
                car.printInfo();
        }
    }
    public static void printCarsByBrandAndModel (ArrayList < Car > cars,String brand,String model){
        ArrayList<Car> collect= cars.stream().filter(e -> (e.getBrand() == brand && e.getModel() == model)).collect(Collectors.toCollection(ArrayList::new));
        for (Car car : collect) {
            car.printInfo();
        }

    }


    public static void printCarsByEngineType(CarEngineType engineType, ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.EngineType == engineType) {
                car.printInfo();
            }

        }
    }

    public static void printCarsByTransmissionType(CarTransmissionType transmissionType, ArrayList<Car> cars) {
        for (Car car : cars) {
            if (car.TransmissionType == transmissionType) {
                car.printInfo();
            }

        }
    }

    public static void printCarDublicates(ArrayList<Car> cars, Car car) {
        int count = 1;
        ArrayList<Car> dublicates = new ArrayList<Car>();
        dublicates.add(car);
        for (int i = 0; i < cars.size(); i++) {
                if (car.equals(cars.get(i))&& cars.get(i)!=car) {
                    count++;
                    dublicates.add(cars.get(i));
                }
            }

        if (count!=1){
        System.out.println("Общее количество одинаковых машин:" + count);
        }
        else{
            System.out.println("Таких машин больше нет");
        }
        for (Car machine : dublicates) {
            machine.printInfo();
        }
}



        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return
                    Objects.equals(_brand, car._brand) &&
                            Objects.equals(_model, car._model) &&
                            TransmissionType == car.TransmissionType &&
                            EngineType == car.EngineType;
        }

        @Override
        public int hashCode () {
            return Objects.hash( _brand, _model, TransmissionType, EngineType);
        }

    }
