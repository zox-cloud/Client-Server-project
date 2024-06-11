public class Packet {
    private String data;
    private int serialNo;
    public Packet(int serialNo , String data){
        this.serialNo = serialNo;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public int getSerialNo() {
        return serialNo;
    }

}