public class PaymentsWithCustemerData extends Payments{
    private String name;
    private String address;

    PaymentsWithCustemerData(Payments p, String name, String address){
        super(p);
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
