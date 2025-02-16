package API;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BookingRequest {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalNeeds;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor

    public static class Bookingdates { //как достать данные этого класса. Правильно ли я вообще сделать этот класс?
        private String checkin;
        private String checkout;
    }
}