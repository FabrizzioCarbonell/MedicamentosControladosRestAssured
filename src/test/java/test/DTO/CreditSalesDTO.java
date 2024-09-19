package test.DTO;

public class CreditSalesDTO {
    private String uuid;
    private String type;
    private int decimals;
    private String isoCurrency;
    private String total;
    private String serie;
    private String timeZone;
    private String creditDueDate;
    private AgentDTO agent;
    private ProductDTO products;
    private PrescriptionDTO prescription;

    //Constructor
    public CreditSalesDTO(String uuid, String type, int decimals, String isoCurrency, String total, String serie, String timeZone, String creditDueDate, AgentDTO agent, ProductDTO products, PrescriptionDTO prescription) {
        this.uuid = uuid;
        this.type = type;
        this.decimals = decimals;
        this.isoCurrency = isoCurrency;
        this.total = total;
        this.serie = serie;
        this.timeZone = timeZone;
        this.creditDueDate = creditDueDate;
        this.agent = agent;
        this.products = products;
        this.prescription = prescription;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDecimals() {
        return decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    public String getIsoCurrency() {
        return isoCurrency;
    }

    public void setIsoCurrency(String isoCurrency) {
        this.isoCurrency = isoCurrency;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getCreditDueDate() {
        return creditDueDate;
    }

    public void setCreditDueDate(String creditDueDate) {
        this.creditDueDate = creditDueDate;
    }

    public AgentDTO getAgent() {
        return agent;
    }

    public void setAgent(AgentDTO agent) {
        this.agent = agent;
    }

    public ProductDTO getProducts() {
        return products;
    }

    public void setProducts(ProductDTO products) {
        this.products = products;
    }

    public PrescriptionDTO getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionDTO prescription) {
        this.prescription = prescription;
    }
}
