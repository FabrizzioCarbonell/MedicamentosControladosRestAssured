package test.Helpers;

import test.DTO.*;

import java.util.List;
import java.util.UUID;

public class SaleFunction {

    public static String generateRandomUUID() {return UUID.randomUUID().toString();}

    public static SalesDTO createSale(String doctorId, String doctorName, String prescriptionFolio, String observations, String folio, Boolean retained){
        //Consumir DTO mediante Builder
        ProductDTO.Lot lot = new ProductDTO.Lot.Builder().lotNumber("FC").quantity("1").build();

        AgentDTO agent = new AgentDTO.Builder("85e406dc-ddd3-422a-992d-9d69ed552f97")
                .name("Cliente medicamentos controlados")
                .withholdTaxes(false)
                .key("medControlled")
                .priceNumber(1)
                .build();

        ProductDTO products = new ProductDTO.Builder("2jQtfKfr4w63frsYvjCeqtdOGsM")
                .type(8)
                .sku("alpra02")
                .additionalInfo("0.5 mg")
                .description("Alprazolam 0.5 mg")
                .unit("CAJA")
                .quantity("1")
                .priceBaseTax("250.00")
                .priceTax("250.00")
                .amountTax("250.00")
                .purchasePriceTax(140)
                .taxesIds(List.of("e43621dc-748a-46e1-8a92-1e7ef7cb6f09"))
                .lots(List.of(lot))
                .build();
        PaymentsDTO payments = new PaymentsDTO.Builder()
                .paymentId("CASH")
                .amount("250")
                .build();

        PrescriptionDTO prescription = new PrescriptionDTO.Builder(doctorId) //Dinamic values to this function
                .doctorName(doctorName) //Dinamic values to this function
                .prescriptionFolio(prescriptionFolio) //Dinamic values to this function
                .observations(observations) //Dinamic values to this function
                .folio(folio) //Dinamic values to this function
                .retained(retained) //Dinamic values to this function
                .build();

        return new SalesDTO.Builder(generateRandomUUID(), "SALE")
                .decimals(2)
                .isoCurrency("MXN")
                .opMode("MX")
                .total("250")
                .serie("")
                .timeZone("America/Mexico_City")
                .cashRegisterUuid("b3934e0e-89b6-46cc-9262-7c1e2d67788a")
                .agent(agent)
                .products(List.of(products))
                .payments(List.of(payments))
                .prescription(prescription) //Without this node have to be http code: 400
                .build();

    }
}
