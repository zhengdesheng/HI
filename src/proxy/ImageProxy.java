package proxy;

public class ImageProxy implements Image {

	private Image image;
	public ImageProxy(Image image){
		this.image = image;
	}
	@Override
	public void show() {
		 if(null == image){
			 image = new BigImage();
		 }
		 image.show();
	}

}
