package finalPackage;

public class HinhTron {

	public double bankinh;

	public HinhTron(double bankinh) {
	
		this.bankinh = bankinh;
	}
	
	public double tinhDienTich() {
		return Math.PI * bankinh *bankinh;
	}
	public double tinhChuVi() {
		return 2 * Math.PI * bankinh;
	}
}
	