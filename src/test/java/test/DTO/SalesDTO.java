package test.DTO;

import test.DTO.AgentDTO;
import test.DTO.PaymentsDTO;
import test.DTO.PrescriptionDTO;
import test.DTO.ProductDTO;

import java.util.List;

public class SalesDTO {

    private String uuid;
    private String type;
    private int decimals;
    private String isoCurrency;
    private String opMode;
    private String total;
    private String serie;
    private String timeZone;
    private String cashRegisterUuid;
    private AgentDTO agent;
    private List<ProductDTO> products;
    private List<PaymentsDTO> payments;
    private PrescriptionDTO prescription;

    // Constructor privado (solo accesible por el builder)
    private SalesDTO(Builder builder) {
        this.uuid = builder.uuid;
        this.type = builder.type;
        this.decimals = builder.decimals;
        this.isoCurrency = builder.isoCurrency;
        this.opMode = builder.opMode;
        this.total = builder.total;
        this.serie = builder.serie;
        this.timeZone = builder.timeZone;
        this.cashRegisterUuid = builder.cashRegisterUuid;
        this.agent = builder.agent;
        this.products = builder.products;
        this.payments = builder.payments;
        this.prescription = builder.prescription;
    }

    // Builder estático
    public static class Builder {
        private String uuid;
        private String type;
        private int decimals;
        private String isoCurrency;
        private String opMode;
        private String total;
        private String serie;
        private String timeZone;
        private String cashRegisterUuid;
        private AgentDTO agent;
        private List<ProductDTO> products;
        private List<PaymentsDTO> payments;
        private PrescriptionDTO prescription;

        public Builder(String uuid, String type) {
            this.uuid = uuid;
            this.type = type;
        }

        public Builder decimals(int decimals) {
            this.decimals = decimals;
            return this;
        }

        public Builder isoCurrency(String isoCurrency) {
            this.isoCurrency = isoCurrency;
            return this;
        }

        public Builder opMode(String opMode) {
            this.opMode = opMode;
            return this;
        }

        public Builder total(String total) {
            this.total = total;
            return this;
        }

        public Builder serie(String serie) {
            this.serie = serie;
            return this;
        }

        public Builder timeZone(String timeZone) {
            this.timeZone = timeZone;
            return this;
        }

        public Builder cashRegisterUuid(String cashRegisterUuid) {
            this.cashRegisterUuid = cashRegisterUuid;
            return this;
        }

        public Builder agent(AgentDTO agent) {
            this.agent = agent;
            return this;
        }

        public Builder products(List<ProductDTO> products) {
            this.products = products;
            return this;
        }

        public Builder payments(List<PaymentsDTO> payments) {
            this.payments = payments;
            return this;
        }

        public Builder prescription(PrescriptionDTO prescription) {
            this.prescription = prescription;
            return this;
        }

        public SalesDTO build() {
            return new SalesDTO(this);
        }
    }
}
