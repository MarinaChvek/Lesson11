import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarDealer {
    private ArrayList<Car> _cars = new ArrayList<Car>();

    public final ArrayList<Car> getCars() {
        return _cars;
    }

    public boolean getIdFromList(Car car, int carInd) throws CarNotFoundException {

        if (car.getId() == carInd) {
            return true;
        } else {
            throw new CarNotFoundException("Машины нет в базе данных");
        }

    }

    public void getInformationAboutCar(int carInd) {
        Iterator<Car> iterator = _cars.iterator();
        try {
            while (iterator.hasNext()) {
                Car next = iterator.next();

                if (getIdFromList(next, carInd)) {
                    next.printInfo();
                }
            }
        } catch (CarNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    static void  Countfilter(ArrayList<Car> cars, Predicate<? super Car>... predicate) {   //метод подсчета машин с веденными параметрами
        ArrayList<Car> collect1;
        for (Predicate<? super Car> x : predicate) {
            collect1=cars.stream()
                    .filter(x)
                    .collect(Collectors.toCollection(ArrayList::new));
            cars=collect1;
        }
        System.out.println(cars.size());
    }



        public void addCar(Car car) {
        if (car != null) {
            _cars.add(car);
            System.out.println("Car added");
            return;
        } else {
            System.out.println("Car can not be Null");
            return;
        }
    }

    public ArrayList<Car> getUsedCars() {
        ArrayList<Car> cars = new ArrayList<Car>();
        for (Car car : getCars()) {
            if (car.getClass().getName() == "UsedCar")
                cars.add(car);
        }
        return cars;
    }

    public ArrayList<Car> getNewCars() {
        ArrayList<Car> cars = new ArrayList<Car>();
        for (Car car : getCars()) {
            if (car.getClass().getName() == "NewCar")
                cars.add(car);
        }
        return cars;
    }

    public void editCar(Car currentCar, Car editedCar) {
        if (currentCar != null && editedCar != null) {
            int currentCarIndex = _cars.indexOf(currentCar);
            if (currentCarIndex != -1) {
                _cars.set(currentCarIndex, editedCar);
                System.out.println("Replaced");
                return;
            } else {
                System.out.println("Current car not found");
                return;
            }
        } else {
            System.out.println("Input not Null values please");
            return;
        }
    }

    public void deleteCar(int carInd) {

        _cars.removeIf(p -> p.getId() == carInd);
        System.out.println("Car successfully deleted");

    }




    }


