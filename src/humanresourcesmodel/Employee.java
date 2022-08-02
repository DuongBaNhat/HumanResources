
package humanresourcesmodel;

import java.text.NumberFormat;
import java.util.Locale;

public class Employee extends Staff implements ICalculator{
    private double soGioLamThem;
    private final int LUONG_CO_BAN = 3000000;
    private final int LUONG_TANG_CA = 200000;
    
    //KHOI TAO - CONTRUCTOR
    public Employee() {
    }

    public Employee(String ma, String ten, double tuoi) {
        super(ma, ten, tuoi);
    }

    public Employee(String ma, String ten, double tuoi, double heSoLuong, String ngayVao, Department boPhan, double soNgayNghi, double soGioLamThem) {
        super(ma, ten, tuoi, heSoLuong, ngayVao, boPhan, soNgayNghi);
        this.soGioLamThem = soGioLamThem;
    }

    //HAM SET
    public void setSoGioLamThem(double soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }
    
    //HAM HIEN THI THONG TIN NHAN VIEN
    public void displayinformation() {
        Locale lcl = new  Locale("vn", "VN");
        NumberFormat numF = NumberFormat.getInstance(lcl);
        
        System.out.println("Ma=" + super.getMa() + "; Ten=" + super.getTen()+ "; Bo phan=" + super.getBoPhan().getTen() + "; Tien luong=" + numF.format(super.getTienLuong()));
    }

    //HAM TINH LUONG NHAN VIEN
    @Override
    public void calculateSalary() {
        super.setTienLuong(super.getHeSoLuong()*LUONG_CO_BAN + soGioLamThem*LUONG_TANG_CA); 
        
    }

//the end Employee class
}