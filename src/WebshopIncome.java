public class WebshopIncome {
    private String shopId;
    private int cardAmount;
    private int transferAmount;

    WebshopIncome(String shopId, int cardAmount, int transferAmount) {
        this.shopId = shopId;
        this.cardAmount = cardAmount;
        this.transferAmount = transferAmount;
    }

    public String getShopId() {
        return shopId;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public int getCardAmount() {
        return cardAmount;
    }

    public void addCardAmount(int cardAmount) {
        this.cardAmount += cardAmount;
    }

    public void addTransferAmount(int transferAmount) {
        this.transferAmount += transferAmount;
    }

    public String toString(String separator) {
        return shopId + " " + separator + cardAmount + " " + separator + transferAmount;
    }
}
