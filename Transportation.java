public class Transportation {
    private String driverName;
    private String driverID;
    private String driverPhoneNumber;
    private String truckNumberPlate;

    public Transportation(String driverName, String driverID, String driverPhoneNumber, String truckNumberPlate) {
        this.driverName = driverName;
        this.driverID = driverID;
        this.driverPhoneNumber = driverPhoneNumber;
        this.truckNumberPlate = truckNumberPlate;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverID() {
        return driverID;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public String getTruckNumberPlate() {
        return truckNumberPlate;
    }
}
