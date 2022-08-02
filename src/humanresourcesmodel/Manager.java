
package humanresourcesmodel;

import java.text.NumberFormat;
import java.util.Locale;


public class Manager extends Staff implements ICalculator{
    private String chucDanh;
    
    private final int LUONG_CO_BAN = 5000000;
    private double luongTrachNhiem;
    
    //CONTRUCTOR

    public Manager() {
    }

    public Manager(String ma, String ten, double tuoi) {
        super(ma, ten, tuoi);
    }

    public Manager(String ma, String ten, double tuoi, double heSoLuong, String ngayVao, Department boPhan, double soNgayNghi, String chucDanh) {
        super(ma, ten, tuoi, heSoLuong, ngayVao, boPhan, soNgayNghi);
        this.chucDanh = chucDanh;
    }

    
    //HAM SET
    public void setChucDanh(String chucDanh){
        this.chucDanh = chucDanh;
    }
    
    //HAM HIEN THI THONG TIN QUAN LY
    @Override
    public void displayinformation() {
        Locale locale = new Locale("vn", "VN");
        NumberFormat numF = NumberFormat.getInstance(locale);

        System.out.println("Ma=" + super.getMa()+ "; Ten=" + super.getTen() + "; Bo Phan=" + super.getBoPhan().getTen() + "; Tien luong=" + numF.format(super.getTienLuong()) + "; Chuc danh=" + this.chucDanh);
    }
    
    //HAM TINH TIEN TRACH NHIEM
    private void luongTrachNhiem(){
        if(this.chucDanh.equalsIgnoreCase("Business Leader"))
            this.luongTrachNhiem = 8000000;
        else if(this.chucDanh.equalsIgnoreCase("Project Leader"))
            this.luongTrachNhiem = 5000000;
        else if(this.chucDanh.equalsIgnoreCase("Technical Leader"))
            this.luongTrachNhiem = 6000000;
    }
    
   //PHUONG THUC TINH LUONG
    @Override
    public void calculateSalary() {
        //TINH LUONG QUAN LY
        this.luongTrachNhiem();
        super.setTienLuong(super.getHeSoLuong()*LUONG_CO_BAN + this.luongTrachNhiem);
    }
    
//***The end Manager Class***
}
