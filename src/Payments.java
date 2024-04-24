import java.util.Date;

public class Payments {
    private String shopId;
    private String customerId;
    private PaymentType paymentType;
    private Float amount;
    private String accountNumber;
    private int cardNumber;
    private Date date;

    Payments(String shopId, String customerId, PaymentType paymentType, Float amount, String accountNumber, int cardNumber, Date date) {
        this.shopId = shopId;
        this.customerId = customerId;
        this.paymentType = paymentType;
        this.amount = amount;
        this.accountNumber = accountNumber;
        this.cardNumber = cardNumber;
        this.date = date;
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

    public Float getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public Date getDate() {
        return date;
    }
}
