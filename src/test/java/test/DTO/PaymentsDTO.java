package test.DTO;

public class PaymentsDTO {
    private String paymentId;
    private String amount;

    private PaymentsDTO(Builder builder){
        this.paymentId = builder.paymentId;
        this.amount = builder.amount;
    };

    public static class Builder{
        private String paymentId;
        private String amount;

        public Builder paymentId(String paymentId){
            this.paymentId = paymentId;
            return this;
        }
        public Builder amount(String amount){
            this.amount = amount;
            return this;
        }

        public PaymentsDTO build(){
            return new PaymentsDTO(this);
        }
    }

}
