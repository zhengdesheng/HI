package proxy;

public class BigImage implements Image {
	
	public BigImage(){
		try {
			Thread.sleep(3000);
			System.out.println("图片装载成功。。。。。");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void show() {
		 System.out.println("绘制实际的大图片");
	}

}
