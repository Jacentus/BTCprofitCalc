public class ProfitCalculator {

    private float amount;
    private float purchase_rate;
    private float current_rate;
    private float profit;
    private FiatCurrency currency;

    public ProfitCalculator(float amount, float purchase_rate, FiatCurrency currency) {
        this.amount = amount;
        this.purchase_rate = purchase_rate;
        this.currency = currency;
    }

    public ProfitCalculator() {
    }

    protected void calculateProfit(){
        Float purchaseValue = this.amount*this.purchase_rate;
        Float currentValue = this.amount*this.current_rate;
        Float profit = currentValue-purchaseValue;

        System.out.println("Calculations: " + currentValue + " - " + purchaseValue);
        this.setProfit(profit);
    }

    /////////////////////////////////////////// AUTO GENERATED GETTERS AND SETTERS ///////////////////////////////

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPurchase_rate() {
        return purchase_rate;
    }

    public void setPurchase_rate(float purchase_rate) {
        this.purchase_rate = purchase_rate;
    }

    public float getCurrent_rate() {
        return current_rate;
    }

    public void setCurrent_rate(float current_rate) {
        this.current_rate = current_rate;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public FiatCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(FiatCurrency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "profitCalculator{" +
                "amount=" + amount +
                ", purchase_rate=" + purchase_rate +
                ", current_rate=" + current_rate +
                ", profit=" + profit +
                ", currency=" + currency +
                '}';
    }
}
