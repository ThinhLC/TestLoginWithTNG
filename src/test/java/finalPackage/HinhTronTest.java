package finalPackage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import finalPackage.HinhTron;

public class HinhTronTest {

	@Test
	public void testTinhDienTichWithPSTNum() {
		double R = 6.7;
		HinhTron hinhTron = new HinhTron(R);
		double expectedOutPut = Math.PI * R * R;

		System.out.println("dientich là"+hinhTron.tinhDienTich());
		double actuaOutPutDienTich = hinhTron.tinhDienTich();
		assertEquals(expectedOutPut, actuaOutPutDienTich, 0.01, "Kết quả tương thích ");
	}
	@Test
	public void testDienTichWithRzero() {
		double R = 0;
		HinhTron hinhTron = new HinhTron(R);
	

		double actuaOutPutDienTich = hinhTron.tinhDienTich();
		assertEquals(actuaOutPutDienTich, 0,"kết quả là 0");
	}


	@Test
	public void testTinhChuviWithPstNum() {
		double R = 6.7;

		HinhTron hinhTron = new HinhTron(R);
		double expectedOutPut = 2 * Math.PI * R;

		System.out.println(hinhTron.tinhChuVi());
		double actuaOutPutChuVi = hinhTron.tinhChuVi();
		assertEquals(expectedOutPut, actuaOutPutChuVi, 0.01, "Kết quả tương thích ");
	}
	@Test
	public void testChuViWithRzero() {
		double R = 0;
		HinhTron hinhTron = new HinhTron(R);

		double expectedOutPut = 0;
		double actualOutPutChuVi = hinhTron.tinhChuVi();
		assertEquals(actualOutPutChuVi, expectedOutPut,"kết quả là 0");
	}

}
