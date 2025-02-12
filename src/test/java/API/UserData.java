package API;

public class UserData {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;

    public class Bookingdates {
        private String checkin;
        private String checkout;

        public Bookingdates(String checkin, String checkout) {
            this.checkin = checkin;
            this.checkout = checkout;
        }

        public String getCheckin() {
            return checkin;
        }

        public String getCheckout() {
            return checkout;
        }
    }

    public UserData(String additionalneeds, Bookingdates bookingdates, Boolean depositpaid, String firstname, String lastname, Integer totalprice) {
        this.additionalneeds = additionalneeds;
        this.bookingdates = bookingdates;
        this.depositpaid = depositpaid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }
}
