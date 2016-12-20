package rekoffer.models;

/**
 *
 * @author Damon
 */
public class Baggage {

    private int id;
    private String label;
    private String firstName;
    private String lastName;
    private String address;
    private String zip;
    private String country;
    private String phone;
    private String email;
    private int suitcaseType;
    private String suitcaseBrand;
    private String suitcaseModel;
    private String suitcaseColour;
    private String suitcaseOther;
    private String suitcaseImage;
    private String suitcaseNotes;
    private String airportSite;
    private String airportOrigin;
    private String additionalContactInfo;

    public Baggage() {
    }

    /**
     * Standard constructor
     *
     * @param id int
     * @param label String
     * @param firstName String
     * @param lastName String
     * @param address String
     * @param zip String
     * @param country String
     * @param phone String
     * @param email String
     * @param suitcaseType int - lost(1) found(2)
     * @param suitcaseModel String
     * @param suitcaseBrand String
     * @param suitcaseColour String
     * @param suitcaseOther String
     * @param suitcaseImage String
     * @param suitcaseNotes String
     * @param airportSite String
     * @param airportOrigin String
     * @param additionalContactInfo String
     */
    public Baggage(int id, String label, String firstName, String lastName, String address, String zip, String country, String phone, String email, int suitcaseType, String suitcaseModel, String suitcaseBrand, String suitcaseColour, String suitcaseOther, String suitcaseImage, String suitcaseNotes, String airportSite, String airportOrigin, String additionalContactInfo) {
        this.id = id;
        this.label = label;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.suitcaseType = suitcaseType;
        this.suitcaseModel = suitcaseModel;
        this.suitcaseBrand = suitcaseBrand;
        this.suitcaseColour = suitcaseColour;
        this.suitcaseOther = suitcaseOther;
        this.suitcaseImage = suitcaseImage;
        this.suitcaseNotes = suitcaseNotes;
        this.airportSite = airportSite;
        this.airportOrigin = airportOrigin;
        this.additionalContactInfo = additionalContactInfo;
    }

    /**
     * Constructor for registering missing baggage
     *
     * @param label String
     * @param firstName String
     * @param lastName String
     * @param address String
     * @param zip String
     * @param country String
     * @param phone String
     * @param email String
     * @param suitcaseType int - lost(1) found(2)
     * @param suitcaseModel String
     * @param suitcaseBrand String
     * @param suitcaseColour String
     * @param suitcaseOther String
     * @param suitcaseNotes String
     */
    public Baggage(String label, String firstName, String lastName, String address, String zip, String country, String phone, String email, int suitcaseType, String suitcaseModel, String suitcaseBrand, String suitcaseColour, String suitcaseNotes) {
        this.label = label;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.suitcaseType = suitcaseType;
        this.suitcaseModel = suitcaseModel;
        this.suitcaseBrand = suitcaseBrand;
        this.suitcaseColour = suitcaseColour;
        this.suitcaseNotes = suitcaseNotes;
    }
    
      public Baggage(int id, String label, String country, int suitcaseType, String suitcaseColour, String firstName, String lastName, String email, String suitcaseModel, String suitcaseBrand) {
        //Korte constructor voor Irwan, Moet later worden vervangen door een complete constructor met alle attributen.
        this.id = id;
        this.label = label;
        this.country = country;
        this.suitcaseType = suitcaseType;
        this.suitcaseColour = suitcaseColour;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.suitcaseModel = suitcaseModel;
        this.suitcaseBrand = suitcaseBrand;
        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSuitcaseType() {
        return suitcaseType;
    }

    public void setSuitcaseType(int suitcaseType) {
        this.suitcaseType = suitcaseType;
    }

    public String getSuitcaseBrand() {
        return suitcaseBrand;
    }

    public void setSuitcaseBrand(String suitcaseBrand) {
        this.suitcaseBrand = suitcaseBrand;
    }

    public String getSuitcaseColour() {
        return suitcaseColour;
    }

    public void setSuitcaseColour(String suitcaseColour) {
        this.suitcaseColour = suitcaseColour;
    }

    public String getSuitcaseOther() {
        return suitcaseOther;
    }

    public String getSuitcaseModel() {
        return suitcaseModel;
    }

    public void setSuitcaseOther(String suitcaseOther) {
        this.suitcaseOther = suitcaseOther;
    }

    public String getSuitcaseImage() {
        return suitcaseImage;
    }

    public void setSuitcaseImage(String suitcaseImage) {
        this.suitcaseImage = suitcaseImage;
    }

    public String getSuitcaseNotes() {
        return suitcaseNotes;
    }

    public void setSuitcaseNotes(String suitcaseNotes) {
        this.suitcaseNotes = suitcaseNotes;
    }

    public String getAirportSite() {
        return airportSite;
    }

    public void setAirportSite(String airportSite) {
        this.airportSite = airportSite;
    }

    public String getAirportOrigin() {
        return airportOrigin;
    }

    public void setAirportOrigin(String airportOrigin) {
        this.airportOrigin = airportOrigin;
    }

    public String getAdditionalContactInfo() {
        return additionalContactInfo;
    }

    public void setAdditionalContactInfo(String additionalContactInfo) {
        this.additionalContactInfo = additionalContactInfo;
    }

}
