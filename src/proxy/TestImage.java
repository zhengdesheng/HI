package proxy;

public class TestImage {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Image image = new ImageProxy(null);
		long end = System.currentTimeMillis();
		System.out.println("系统开销时间："+(end-start)/1000);
		image.show();
	}
}
