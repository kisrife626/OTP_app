public class SumAmount {
    private String name;
    private String address;
    private int amount;

    SumAmount(String n, String a, int amount) {
        this.name = n;
        this.address = a;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String toString(String separator) {
        return name + " " + separator + address + " " + separator + amount;
    }
}
