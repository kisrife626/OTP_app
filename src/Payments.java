import java.util.Date;

public class Payments {
    private String shopId;
    private String customerId;
    private PaymentType paymentType;
    private int amount;
    private String accountNumber;
    private String cardNumber;
    private String date;

    Payments(String shopId, String customerId, PaymentType paymentType, int amount, String accountNumber, String cardNumber, String date) {
        this.shopId = shopId;
        this.customerId = customerId;
        this.paymentType = paymentType;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.date = date;
    }
    Payments(Payments p){
        this.shopId = p.getShopId();
        this.customerId = p.getCustomerId();
        this.paymentType = p.getPaymentType();
        this.amount = p.getAmount();
        this.accountNumber = p.getAccountNumber();
        this.cardNumber = p.getCardNumber();
        this.date = p.getDate();
    }

    public String getShopId() {
        return shopId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public int getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getDate() {
        return date;
    }
}
