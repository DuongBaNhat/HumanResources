package humanresources;

import humanresourcesmodel.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class HumanResources {

    //MENU
    public static void menu(ArrayList<Staff> listNhanVien, ArrayList<Department> listBoPhan, ArrayList<String> listChucDanh){
    try
    {
        do
        {
            System.out.println("===MENU===");
            
            System.out.println("1. Danh sách nhân viên");
            System.out.println("2. Danh sách bộ phận");
            System.out.println("3. Nhân viên bộ phận");
            System.out.println("4. Thêm nhân viên");
            System.out.println("5. Tìm nhân viên (theo tên/mã)");
            System.out.println("6. Bảng lương tăng dần");
            System.out.println("7. Bảng lương giảm dần");
            System.out.println("8. Thoát");

            System.out.print("Mời chọn chức năng: ");
            Scanner sc = new Scanner(System.in);
            int chon = (int)inputNumber(sc);
              
            switch(chon){
                case 1:
                    danhSachNhanVien(listNhanVien);  
                    break;
                case 2:
                    danhSachBoPhan(listBoPhan);
                    break;
                case 3:
                    nhanVienBoPhan(listNhanVien,listBoPhan);
                    break;
                case 4:
                    themNhanVien(listNhanVien,listBoPhan,listChucDanh);
                    break;
                case 5:
                    timNhanVien(listNhanVien);
                    break;
                case 6:
                    bangLuongTang(listNhanVien);
                    break;
                case 7:
                    bangLuongGiam(listNhanVien);
                    break;
                case 8:
                    //THOAT CHUONG TRINH
                    System.err.println("Cảm ơn bạn đã dùng chương trình!");
                    System.exit(0);
                default:
                    System.err.println("Mời chọn lại chức năng");
                    break;
            }
            System.out.println("");
        }
        while(true);
    }
    catch(NumberFormatException ex)
    {
        ex.printStackTrace();
    }
       
    }
    public static void main(String[] args) {
        //CHAY CHUONG TRINH QUAN LY NHAN VIEN
        ArrayList<Staff> listNhanVien = new ArrayList<Staff>();
        ArrayList<Department> listBoPhan = new ArrayList<Department>();
        ArrayList<String> listChucDanh = new ArrayList<String>();
        
        khoiTaoNhanVien(listNhanVien, listBoPhan, listChucDanh);
        while(true)
        {
            menu(listNhanVien, listBoPhan, listChucDanh);
        }
    }

    
    //1. HAM HIEN THI DANH SACH NHAN VIEN
    private static void danhSachNhanVien(ArrayList<Staff> listNhanVien) {
  
        System.out.println("\nDanh sách nhân viên");
        int num = 0;
        for(Staff sf : listNhanVien)
        {
            num++;
            System.out.print(num + ". ");
            sf.displayinformation();   
        }
    }

    //2. HAM HIEN THI DANH SACH BO PHAN
    private static void danhSachBoPhan(ArrayList<Department> listBoPhan) {
        
        //SAP XEP DANH SACH BO PHAN THEO THU TU TANG DAN CUA MA BO PHAN
        Collections.sort(listBoPhan);
        
        //HIEN THI DANH SACH BO PHAN
        System.out.println("\nDanh sách bộ phận:");
        int num = 0;
        for(Department bp : listBoPhan)
        {
            num++;
            System.out.print(num + ". ");
            System.out.println(bp.toString());
        }
    }

    //3. HAM HIEN THI DANH SACH NHAN VIEN THEO BO PHAN
    private static void nhanVienBoPhan(ArrayList<Staff> listNhanVien, ArrayList<Department> listBoPhan) 
    {
        //SAP XEP BO PHAN THEO THU TU TANG DAN CUA MA:
        Collections.sort(listBoPhan);
        
        //IN DANH SACH NHAN VIEN THEO TUNG BO PHAN
        for(Department bp : listBoPhan)
        {
            System.out.println("\nDanh sách nhân viên bộ phận: " + bp.getTen());
            int num = 0;
            for(Staff sf : listNhanVien)
            {
                
                if(bp.getMa().equals(sf.getBoPhan().getMa()) == true)
                {
                    num++;
                    System.out.print(num + ". ");
                    sf.displayinformation();
                }
            }
        }
    }

    //4. HAM THEM NHAN VIEN
     private static void themNhanVien(ArrayList<Staff> listNhanVien, ArrayList<Department> listBoPhan, ArrayList<String> listChucDanh) {
       
        System.out.println("1. Nhân viên bình thường");
        System.out.println("2. Quản lý");
        System.out.print("Mời bạn chọn: ");

        Scanner sc = new Scanner(System.in);
        int chon = (int)inputNumber(sc);
       
        //NHAP THONG TIN NHAN VIEN, TINH LUONG, THEM VAO DANH SACH NHAN VIEN
        if(chon == 1)
        {
            //NHAP THONG TIN NHAN VIEN
            Employee nhanVien = new Employee();
  
            String ma = inputStaffID(listNhanVien, sc);
            nhanVien.setMa(ma);
            
            System.out.print("Tên: ");
            String ten = sc.nextLine();
            nhanVien.setTen(ten);
            
            System.out.print("Tuổi: ");
            double tuoi = inputNumber(sc);
            nhanVien.setTuoi(tuoi);
            
            System.out.print("Hệ số lương: ");
            double heSoLuong = inputNumber(sc);
            nhanVien.setHeSoLuong(heSoLuong);
            
            System.out.print("Ngày vào làm (dd/MM/yyyy): ");
            String ngayVao = sc.nextLine();
            nhanVien.setNgayVao(ngayVao);
            
            //CHON BO PHAN
            setBoPhan(listBoPhan, nhanVien);
            
            System.out.print("Số ngày nghỉ phép: ");
            double soNgayNghi = inputNumber(sc);
            nhanVien.setSoNgayNghi(soNgayNghi);
           
            System.out.print("Số giờ làm thêm: ");
            double soGioLamThem = inputNumber(sc);
            nhanVien.setSoGioLamThem(soGioLamThem);
           
            //THEM NHAN VIEN VAO DANH SACH
            listNhanVien.add(nhanVien);
          
          
        }
        //NHAP THONG TIN QUAN LY, TINH LUONG VA THEM VAO DANH SACH
        else if(chon == 2)
        {
            //NHAP THONG TIN QUAN LY
            Manager nhanVien = new Manager();
            
            //NHAP MA
            String ma = inputStaffID(listNhanVien, sc);
            nhanVien.setMa(ma);
            
            System.out.print("Tên: ");
            String ten = sc.nextLine();
            nhanVien.setTen(ten);
            
            System.out.print("Tuổi: ");
            double tuoi = inputNumber(sc);
            nhanVien.setTuoi(tuoi);
            
            System.out.print("Hệ số lương: ");
            double heSoLuong = inputNumber(sc);
            nhanVien.setHeSoLuong(heSoLuong);
            
            System.out.print("Ngày vào làm (dd/MM/yyyy): ");
            String ngayVao = sc.nextLine();
            nhanVien.setNgayVao(ngayVao);
            
            //CHON BO PHAN
            setBoPhan(listBoPhan, nhanVien);
            
            System.out.print("Số ngày nghỉ phép: ");
            double soNgayNghi = inputNumber(sc);
            nhanVien.setSoNgayNghi(soNgayNghi);
            
            //CHON CHUC DANH
            setChucDanh(listChucDanh, nhanVien);
            
            //THEM QUAN LY VAO DANH SACH
            listNhanVien.add(nhanVien);
        }
        else
             System.err.println("Bạn chọn sai chức năng");
        
    }
    
    //5. HAM TIM NHAN VIEN THEO TEN/MA
    private static void timNhanVien(ArrayList<Staff> listNhanVien) {
        System.out.println("1. Tìm theo mã");
        System.out.println("2. Tìm theo tên");
        System.out.print("Mời chọn: ");
        Scanner sc = new Scanner(System.in);
        double chon = inputNumber(sc);
        
        //NEU TIM THEO MA
        if(chon ==1)
        {
            System.out.print("Mời nhập mã: ");
            String ma = sc.nextLine();
            
            boolean check = false;
            System.out.println("\nNhân viên có mã [" + ma + "]:");
            for(Staff nhanVien : listNhanVien)
            {
                if(nhanVien.getMa().equals(ma))
                {
                    nhanVien.displayinformation();
                    check = true;
                }
            }
          
            if(check == false)
                System.out.println("Không tìm thấy!");
        }
        
        //NEU TIM THEO TEN(CO THE TIM THEO TEN KHONG DAY DU
        else if(chon == 2)
        {
            System.out.print("Mời nhập tên: ");
            String ten = sc.nextLine();
            
            System.out.println("Nhân viên có tên [" + ten +"]:");
            
            ten = ten.toLowerCase();  
            int num = 0;
            for(Staff nhanVien : listNhanVien)
            {
                if(nhanVien.getTen().toLowerCase().contains(ten))
                {
                    num++;
                    System.out.print(num + ". ");
                    nhanVien.displayinformation();
                }
            }
            if(num < 1)
                System.out.println("Không tìm thấy!");
        }
        else
            System.err.println("Bạn chọn sai chức năng");
    }

    //6 BANG LUONG TANG DAN
    private static void bangLuongTang(ArrayList<Staff> listNhanVien) {

        //TINH LUONG
        for(Staff nhanVien : listNhanVien)
        {
            nhanVien.calculateSalary();
        }
        
        //SAP XEP TANG DAN THEO LUONG
        Collections.sort(listNhanVien);
        
        //HIEN THI BANG LUONG THEO THU TU TANG DAN CUA LUONG
        System.out.println("\nBảng lương tăng dần");
        int num = 0;
        for(Staff nhanVien : listNhanVien)
        {
           
            nhanVien.calculateSalary();
            num++;
            System.out.print(num + ". ");
            nhanVien.displayinformation(); 
        }
    }

    //7. BANG LUONG GIAM DAN
    private static void bangLuongGiam(ArrayList<Staff> listNhanVien) {
        //TINH LUONG
        for(Staff nhanVien : listNhanVien)
        {
            nhanVien.calculateSalary();
        }
        
        //SAP XEP TANG DAN
        Collections.sort(listNhanVien);
        
        //SAP XEP GIAM DAN
        Collections.reverse(listNhanVien);
        
        //HIEN THI DANH SACH NHAN VIEN THEO THU TU GIAM DAN CUA LUONG
        System.out.println("\nBảng lương giảm dần");
        int num = 0;
        for(Staff nhanVien : listNhanVien)
        {
            num++;
            System.out.print(num + ". ");
            nhanVien.displayinformation();
        }
    }

   
    
    //01. HAM NHAP SO
    private static double inputNumber(Scanner sc)
    {
        double number = 0.0;
        boolean check = false;
        while(check == false)
        {
             try
             {
                number = Double.parseDouble(sc.nextLine());
                check = true;
             }
             catch(IllegalArgumentException iae)
             {
                 System.err.print("Bạn phải nhập số: ");
             }
        }     
     return number;   
    }
    
    //02. HAM KIEM TRA TRUNG MA NHAN VIEN
    private static String inputStaffID(ArrayList<Staff> listNhanVien, Scanner sc)
    {
        String ma = "";
        boolean check = false;
        while(check == false)
        {
            System.out.print("Mã: ");
            ma = sc.nextLine();
            
            //KIEM TRA MA DA TON TAI CHUA(PHAN BIET CHU HOA/CHU THUONG)
            check = true;
            for(Staff nv : listNhanVien)
            {   
                if(nv.getMa().equalsIgnoreCase(ma))
                {
                    check = false;
                    System.err.println("Mã đã tồn tại");
                    break;
                }
            }
        }
        return ma;
    }
      
    //03. HAM SET BO BO PHAN
    private static void setBoPhan(ArrayList<Department> listBoPhan, Staff nhanVien)
    {
        danhSachBoPhan(listBoPhan);
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        while(check == false)
        {
            System.out.print("Mời chọn bộ phận(theo mã): ");
            String maBoPhan = sc.nextLine();

            for(Department bp : listBoPhan)
            {
                if(bp.getMa().equals(maBoPhan))
                {
                   nhanVien.setBoPhan(bp);
                   bp.setSoLuong(bp.getSoLuong() + 1);
                   check = true;
                }
            }
            if(check == false)
                System.err.println("Bạn chọn chưa đúng mã (Có phân biệt chữ hoa/ chữ thuong)");
        }
    }
    
    //04. HAM SET CHUC VU
    private static void setChucDanh(ArrayList<String> listChucDanh, Manager nhanVien)
    {
        int num = 0;
        System.out.println("");
        System.out.println("Danh sách chức danh:");
        //HIEN THI DANH SACH CHUC DAH
        for(String chucDanh : listChucDanh)
        {
            num++;
            System.out.print(num + ". ");
            System.out.println(chucDanh);
        }
        
       //NHAP CHUC DANH
        boolean check = false;
        Scanner sc = new Scanner(System.in);
        String chucDanh;
        while(check == false)
        {
            System.out.print("Mời nhập chức danh(trong danh sách trên): ");
            chucDanh = sc.nextLine();
            for(String cd : listChucDanh)
            {
                if(cd.equalsIgnoreCase(chucDanh))
                {
                    nhanVien.setChucDanh(chucDanh);
                    check = true;
                }
            }
            if(check == false)
                System.err.println("Cần nhập đúng chức danh!");
        }
    }
    
    //05. HAM KHOI TAO NHAN VIEN KHI CHUONG TRINH CHAY
    private static void khoiTaoNhanVien(ArrayList<Staff> listNhanVien, ArrayList<Department> listBoPhan, ArrayList<String> listChucDanh)
    {
         //KHOI TAO TRUOC NHAN VIEN
        //DANH SACH CHUC DANH
        listChucDanh.add("Business Leader");
        listChucDanh.add("Project Leader");
        listChucDanh.add("Technical Leader");
    
        //DANH SACH BO PHAN
        Department kt = new Department("kt", "Kế Toán",2);
        Department ns = new Department("ns", "Nhân Sự",3);
        listBoPhan.add(kt);
        listBoPhan.add(ns);
        
        //DANH SACH NHAN VIEN
        Employee nv1 = new Employee("nv1", "Nguyen Van A", 32, 2, "9/12/2019", kt, 2,10);
        Employee nv2 = new Employee("nv2", "Tran Van B", 42, 3, "9/12/2019", kt, 2,5);
        listNhanVien.add(nv1);
        listNhanVien.add(nv2);
        
        //DANH SACH QUAN LY
        Manager nv3 = new Manager("nv3", "Le Cong Danh", 30, 4, "9/12/2019", ns, 2, listChucDanh.get(0));
        Manager nv4 = new Manager("nv4", "Pham Thi C", 33, 6, "9/12/2019", ns, 2, listChucDanh.get(1));
        Manager nv5 = new Manager("nv5", "Phan Quynh Nhu", 25, 3, "9/12/2010", ns, 2, listChucDanh.get(2));
        listNhanVien.add(nv3);
        listNhanVien.add(nv4);
        listNhanVien.add(nv5);
    }
    
    
//***The end HumanResource Class***
}
