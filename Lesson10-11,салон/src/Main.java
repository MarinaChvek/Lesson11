
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CarDealer dealer = new CarDealer();
        Car car1 = new UsedCar("BMW", "Z4", Car.CarTransmissionType.Automatic,
                Car.CarEngineType.Diesel, true, false, 37850);
        dealer.addCar(car1);
        Car car2 = new UsedCar("Mercedes", "Z4", Car.CarTransmissionType.Automatic,
                Car.CarEngineType.Diesel, true, false, 37850);
        dealer.addCar(car2);
        Car car3 = new NewCar( "BMW", "Z3", Car.CarTransmissionType.Automatic,
                Car.CarEngineType.Gas,true);
        dealer.addCar(car3);
        Car car4=new NewCar( "BMW", "Z8", Car.CarTransmissionType.Automatic, Car.CarEngineType.Diesel,true);
        dealer.addCar(car4);
        Car car5=new NewCar("BMW", "Z1", Car.CarTransmissionType.Manual, Car.CarEngineType.Diesel,true);
        dealer.addCar(car5);
        dealer.deleteCar(5);
        dealer. getInformationAboutCar(5);
        ArrayList<Car> cars = dealer.getNewCars();
        Car.printCarsByBrand(cars, "BMW");
        Car.printCarsByBrandAndModel(cars,"BMW","Z3");
        CarDealer.Countfilter(cars,e -> (e.getBrand()=="BMW"),e -> (e.getModel()=="Z3"));


/*

        Car.printCarDublicates(cars,car4);
        for(Car car : cars) //for new cars
        {
            car.printInfo();
        }

        Car.printCarsByBrandAndModel("BMW","Z4",cars);
        Car.printCarsByEngineType(Car.CarEngineType.Diesel, cars);
        Car.printCarsByTransmissionType(Car.CarTransmissionType.Automatic, cars);
        Car.printCarDublicates(2,cars);
*/



/*
        cars = dealer.getUsedCars();    //for used cars
        for (Car car : cars) {
            car.printInfo();
        }
         */


      /*
       Car.printCarsByBrand (cars,"Mercedes");
        Car.printCarsByBrandAndModel("BMW","Z4",cars);
        Car.printCarsByEngineType(Car.CarEngineType.Diesel, cars);
        Car.printCarsByTransmissionType(Car.CarTransmissionType.Automatic, cars);

*/

    }


        public static Car CreateCar ()
        {
            Scanner s = new Scanner(System.in);
            System.out.println("Введите VIN номер автомобиля (17 символов)");
            String vin = s.nextLine();
            System.out.println("Введите Марку автомобиля");
            String brand = s.nextLine();
            System.out.println("Введите Модель автомобиля");
            String model = s.nextLine();
            System.out.println("Выберите тип трансмиссии автомобиля:");
            System.out.println("1. Автоматическая");
            System.out.println("2. Механическая");
            int transmissionValue = s.nextInt();
            Car.CarTransmissionType transmission = Car.CarTransmissionType.Automatic;
            switch (transmissionValue) {
                case 1:
                    transmission = Car.CarTransmissionType.Automatic;
                    break;
                case 2:
                    transmission = Car.CarTransmissionType.Manual;
                    break;
            }

            System.out.println("Выберите тип двигателя автомобиля:");
            System.out.println("1. Дизельный");
            System.out.println("2. Бензиновый");
            System.out.println("3. Газовый");
            System.out.println("4. Электрический");
            int engineValue = s.nextInt();
            Car.CarEngineType engine = Car.CarEngineType.Diesel;
            switch (engineValue) {
                case 1:
                    engine = Car.CarEngineType.Diesel;
                    break;
                case 2:
                    engine = Car.CarEngineType.Petrol;
                    break;
                case 3:
                    engine = Car.CarEngineType.Gas;
                    break;
                case 4:
                    engine = Car.CarEngineType.Electrical;
                    break;
            }

            System.out.println("Перекрашивался ли автомобиль?");
            System.out.println("1. Да");
            System.out.println("2. Нет");
            int answerRepaint = s.nextInt();
            boolean isRepainted = false;
            switch (answerRepaint) {
                case 1:
                    isRepainted = true;
                    break;
                case 2:
                    isRepainted = false;
                    break;
            }

            System.out.println("Были ли аварии?");
            System.out.println("1. Да");
            System.out.println("2. Нет");
            int answerCrashed = s.nextInt();
            boolean isCrashed = false;
            switch (answerCrashed) {
                case 1:
                    isCrashed = true;
                    break;
                case 2:
                    isCrashed = false;
                    break;
            }

            System.out.println("Введите пробег автомобиля");
            int miles = s.nextInt();

            Car car = new UsedCar(brand, model, transmission, engine, isRepainted, isCrashed, miles);
            return car;
        }
    }
