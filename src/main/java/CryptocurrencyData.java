public class CryptocurrencyData {

    private String chartName;

    private CurrencyBPI EurBpi;
    private CurrencyBPI GbpBpi;
    private CurrencyBPI UsdBpi;
    private Time time;

    private String disclaimer;

    public CryptocurrencyData(String chartName, CurrencyBPI eurBpi, CurrencyBPI gbpBpi, CurrencyBPI usdBpi, Time time) {
        this.chartName = chartName;
        EurBpi = eurBpi;
        GbpBpi = gbpBpi;
        UsdBpi = usdBpi;
        this.time = time;
    }

    public CryptocurrencyData(String chartName, CurrencyBPI eurBpi, CurrencyBPI gbpBpi, CurrencyBPI usdBpi, Time time, String disclaimer) {
        this.chartName = chartName;
        EurBpi = eurBpi;
        GbpBpi = gbpBpi;
        UsdBpi = usdBpi;
        this.time = time;
        this.disclaimer = disclaimer;
    }

    public String getChartName() {
        return chartName;
    }

    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    public CurrencyBPI getEurBpi() {
        return EurBpi;
    }

    public void setEurBpi(CurrencyBPI eurBpi) {
        EurBpi = eurBpi;
    }

    public CurrencyBPI getGbpBpi() {
        return GbpBpi;
    }

    public void setGbpBpi(CurrencyBPI gbpBpi) {
        GbpBpi = gbpBpi;
    }

    public CurrencyBPI getUsdBpi() {
        return UsdBpi;
    }

    public void setUsdBpi(CurrencyBPI usdBpi) {
        UsdBpi = usdBpi;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "CryptocurrencyData{" +
                "chartName='" + chartName + '\'' +
                ", EurBpi=" + EurBpi.toString() +
                ", GbpBpi=" + GbpBpi.toString() +
                ", UsdBpi=" + UsdBpi.toString() +
                ", time=" + time.toString() +
                ", disclaimer='" + disclaimer + '\'' +
                '}';
    }
}