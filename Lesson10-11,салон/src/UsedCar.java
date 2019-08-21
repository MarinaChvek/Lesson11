
public class UsedCar extends Car {

    private static final int MAX_MILEAGE  = 10000000;
    private static final int MIN_MILEAGE = 0;
    private boolean IsRepainted = false;
    private boolean IsAfterCrash = false;
    private Integer _mileage = 0;

    public UsedCar(String _brand, String _model,
                   CarTransmissionType carTransmissionType, CarEngineType carEngineType,
                   boolean isRepainted, boolean isAfterCrash, Integer _mileage)
    {
        super(_brand, _model, carTransmissionType, carEngineType);
        this.IsRepainted = isRepainted;
        this.IsAfterCrash = isAfterCrash;
        this._mileage = _mileage;
    }


    public Integer getMileage()
    {
        return  _mileage;
    }

    public void setMileage(Integer mileage)
    {
        if(mileage!=null && mileage>=MIN_MILEAGE && mileage<=MAX_MILEAGE)
        {
            this._mileage = mileage;
        }
        else
        {
            System.out.println("Mileage value should be more than "+MIN_MILEAGE+" and less than "+MAX_MILEAGE);
        }
    }

    @Override
    public void printInfo(){
        super.printInfo();

        System.out.println("Is Repainted: "+IsRepainted);
        System.out.println("Is After Crash: "+IsAfterCrash);
        System.out.println("Mileage: "+getMileage());

    }

}
