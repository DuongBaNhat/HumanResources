package humanresourcesmodel;

public abstract class Staff implements Comparable<Staff>, ICalculator{
    private String ma;
    private String ten;
    private double tuoi;
    private double heSoLuong;
    private String ngayVao;
    private Department boPhan;
    private double soNgayNghi;
    private double tienLuong;

    //CONTRUCTOR
    public Staff() {
    }

    public Staff(String ma, String ten, double tuoi) {
        this.ma = ma;
        this.ten = ten;
        this.tuoi = tuoi;
        
    }

    public Staff(String ma, String ten, double tuoi, double heSoLuong, String ngayVao, Department boPhan, double soNgayNghi) {
        this(ma, ten, tuoi);
        
        this.heSoLuong = heSoLuong;
        this.ngayVao = ngayVao;
        this.boPhan = boPhan;
        this.soNgayNghi = soNgayNghi;
    }

    
    //PHUONG THUC SET
    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTuoi(double tuoi) {
        this.tuoi = tuoi;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public void setNgayVao(String ngayVao) {
        this.ngayVao = ngayVao;
    }

    public void setBoPhan(Department boPhan) {
        this.boPhan = boPhan;
    }

    public void setSoNgayNghi(double soNgayNghi) {
        this.soNgayNghi = soNgayNghi;
    }

    //DUNG KHI GOI HAM TINH LUONG
    public void setTienLuong(double tienLuong) {
        this.tienLuong = tienLuong;
    }

    
    //PHUONG THUC GET
    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public double getTuoi() {
        return tuoi;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public String getNgayVao() {
        return ngayVao;
    }

    public Department getBoPhan() {
        return boPhan;
    }

    public double getSoNgayNghi() {
        return soNgayNghi;
    }

    public double getTienLuong() {
        return tienLuong;
    }

    //PHUONG THUC TINH LUONG

    @Override
    public void calculateSalary() {
    }
    
    
    //PHUONG THUC HIEN THI TRUU TUONG
    public abstract void displayinformation();

    //GHI DE PHUONG THUC COMPARETO DE SU DUNG PHUONG THUC SORT CUA COLLECTION.
    @Override
    public int compareTo(Staff o) {
        return (int)(this.tienLuong - o.getTienLuong());
    }
//***The end Staff class***
}
