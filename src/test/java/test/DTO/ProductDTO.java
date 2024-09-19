package test.DTO;

import java.util.List;

public class ProductDTO {
    private int type;
    private String uuid;
    private String sku;
    private String additionalInfo;
    private String description;
    private String unit;
    private String quantity;
    private String priceBaseTax;
    private String priceTax;
    private String amountTax;
    private double purchasePriceTax;
    private List<String> taxesIds;
    private List<Lot> lots;

    // Constructor
    private ProductDTO(Builder builder) {
        this.type = builder.type;
        this.uuid = builder.uuid;
        this.sku = builder.sku;
        this.additionalInfo = builder.additionalInfo;
        this.description = builder.description;
        this.unit = builder.unit;
        this.quantity = builder.quantity;
        this.priceBaseTax = builder.priceBaseTax;
        this.priceTax = builder.priceTax;
        this.amountTax = builder.amountTax;
        this.purchasePriceTax = builder.purchasePriceTax;
        this.taxesIds = builder.taxesIds;
        this.lots = builder.lots;
    }

    // Builder estático
    public static class Builder {
        private int type;
        private String uuid;
        private String sku;
        private String additionalInfo;
        private String description;
        private String unit;
        private String quantity;
        private String priceBaseTax;
        private String priceTax;
        private String amountTax;
        private double purchasePriceTax;
        private List<String> taxesIds;
        private List<Lot> lots;

        public Builder(String uuid){
            this.uuid = uuid;
        }
        public Builder type(int type) {
            this.type = type;
            return this;
        }

        public Builder sku(String sku) {
            this.sku = sku;
            return this;
        }

        public Builder additionalInfo(String additionalInfo) {
            this.additionalInfo = additionalInfo;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder unit(String unit) {
            this.unit = unit;
            return this;
        }

        public Builder quantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder priceBaseTax(String priceBaseTax) {
            this.priceBaseTax = priceBaseTax;
            return this;
        }

        public Builder priceTax(String priceTax) {
            this.priceTax = priceTax;
            return this;
        }

        public Builder amountTax(String amountTax) {
            this.amountTax = amountTax;
            return this;
        }

        public Builder purchasePriceTax(double purchasePriceTax) {
            this.purchasePriceTax = purchasePriceTax;
            return this;
        }

        public Builder taxesIds(List<String> taxesIds) {
            this.taxesIds = taxesIds;
            return this;
        }

        public Builder lots(List<Lot> lots) {
            this.lots = lots;
            return this;
        }

        public ProductDTO build() {
            return new ProductDTO(this);
        }
    }

    // Inner class for Lot
    public static class Lot {
        private String lotNumber;
        private String quantity;

        private Lot(Builder builder) {
            this.lotNumber = builder.lotNumber;
            this.quantity = builder.quantity;
        }

        public static class Builder{
            private String lotNumber;
            private String quantity;

            public Builder lotNumber(String lotNumber){
                this.lotNumber = lotNumber;
                return this;
            }
            public Builder quantity(String quantity){
                this.quantity = quantity;
                return this;
            }

            public Lot build(){
                return new Lot(this);
            }
        }
    }
}
