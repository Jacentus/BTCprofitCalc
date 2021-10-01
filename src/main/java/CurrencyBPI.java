public class CurrencyBPI {

private String symbol;
private Float rate_float;
private String code;
private String rate;
private String description;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Float getRate_float() {
        return rate_float;
    }

    public void setRate_float(Float rate_float) {
        this.rate_float = rate_float;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CurrencyBPI{" +
                "symbol='" + symbol + '\'' +
                ", rate_float=" + rate_float +
                ", code='" + code + '\'' +
                ", rate='" + rate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
