package test.DTO;

public class PrescriptionDTO {
    private String doctorId;
    private String doctorName;
    private String prescriptionFolio;
    private String observations;
    private String folio;
    private Boolean retained;

    //Constructor
    private PrescriptionDTO(Builder builder){
        this.doctorId = builder.doctorId;
        this.doctorName = builder.doctorName;
        this.prescriptionFolio = builder.prescriptionFolio;
        this.observations = builder.observations;
        this.folio = builder.folio;
        this.retained = builder.retained;
    }

    public static class Builder{
        private String doctorId;
        private String doctorName;
        private String prescriptionFolio;
        private String observations;
        private String folio;
        private Boolean retained;

        public Builder(String doctorId){
            this.doctorId = doctorId;
        }

        public Builder doctorName(String doctorName){
            this.doctorName = doctorName;
            return this;
        }

        public Builder prescriptionFolio(String prescriptionFolio){
            this.prescriptionFolio = prescriptionFolio;
            return this;
        }

        public Builder observations(String observations){
            this.observations = observations;
            return this;
        }

        public Builder folio(String folio){
            this.folio = folio;
            return this;
        }

        public Builder retained(Boolean retained){
            this.retained = retained;
            return this;
        }

        public PrescriptionDTO build(){
            return new PrescriptionDTO(this);
        }
    }

}
