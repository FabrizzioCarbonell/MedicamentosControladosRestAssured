package test.DTO;

public class AgentDTO {
    private String uuid;
    private String name;
    private boolean withholdTaxes;
    private String key;
    private int priceNumber;

    //Constructor para el builder
    private AgentDTO(Builder builder){
        this.uuid = builder.uuid;
        this.name = builder.name;
        this.withholdTaxes = builder.withholdTaxes;
        this.key = builder.key;
        this.priceNumber = builder.priceNumber;
    }

    public static class Builder{
        private String uuid;
        private String name;
        private Boolean withholdTaxes;
        private String key;
        private int priceNumber;

        public Builder(String uuid){
            this.uuid = uuid;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder withholdTaxes(Boolean withholdTaxes){
            this.withholdTaxes = withholdTaxes;
            return this;
        }

        public Builder key(String key){
            this.key = key;
            return this;
        }

        public Builder priceNumber(int priceNumber){
            this.priceNumber = priceNumber;
            return this;
        }

        public AgentDTO build(){
            return new AgentDTO(this);
        }
    }

}
