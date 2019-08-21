import java.util.Objects;

public class NewCar extends Car {

    public boolean IsCanAddAdditionalOptions;

    public NewCar(String _brand, String _model,
                  CarTransmissionType carTransmissionType, CarEngineType carEngineType,
                  boolean isCanAddAdditionalOptions ) {
        super(_brand, _model, carTransmissionType, carEngineType);
        this.IsCanAddAdditionalOptions = isCanAddAdditionalOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NewCar newCar = (NewCar) o;
        return IsCanAddAdditionalOptions == newCar.IsCanAddAdditionalOptions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), IsCanAddAdditionalOptions);
    }
}