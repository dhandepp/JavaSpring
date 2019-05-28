package Collections.POJO;

public class HashHash {
    private double LTA;
    private double PF;
    private int empId;

    public HashHash(){}

    public HashHash(double lta, double pf, int empId){
        this.LTA = lta;
        this.PF = pf;
        this.empId = empId;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof HashHash && (((HashHash) obj).getEmpId() == empId)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return empId;
    }

    public int getEmpId(){
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setLTA(double LTA) {
        this.LTA = LTA;
    }

    public void setPF(double PF) {
        this.PF = PF;
    }
}
