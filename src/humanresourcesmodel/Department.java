package humanresourcesmodel;


public class Department implements Comparable<Department>{
    private String ma;
    private String ten;
    private  int soLuong;
 
    //CONTRUCTOR
    public Department(){   
    }

    public Department(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
    
    public Department(String ma, String ten, int soLuong) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
    }
    
    //PHUONG THUC SET
    public void setMa(String ma){
        this.ma = ma;
    }
    public void setTen(String ten){
        this.ten = ten;
    }
    public void setSoLuong(int soLuong)
    {
        this.soLuong = soLuong;
    }
    
    //PHUONG THUC GET
    public String getMa(){
        return this.ma;
    }
    public String getTen(){
        return this.ten;
    }
    public int getSoLuong(){
        return this.soLuong;
    }
     
   
    public String toString(){
        return "[ma=" +this.ma + ", ten=" + this.ten + ", soLuong=" + this.soLuong +"]";
    }

    //DE DUNG PHUONG THUC CONTAINS TRONG DANH SACH BO PHAN
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj == null || obj.getClass() != getClass())
            result = false;
        else
        {
            Department boPhan = (Department)obj;
            if(boPhan.getMa().equals(this.ma) && boPhan.getTen().equals(this.ten) && boPhan.getSoLuong() == this.soLuong)
            {
                result = true;
            }
        }
        return result;
    }


    //GHI DE PHUONG THUC COMPARETO DE SU DUNG PHUONG THUC SORT CUA COLLECTION
    @Override
    public int compareTo(Department boPhan) {
        return this.ma.compareTo(boPhan.getMa());
    }
  
    
//the end
}
