package br.com.mr.dock.client;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.ui.Image;

public class Item extends LayoutContainer{
	private Image image;

	public Item(String uri) {
		setLayout(new FitLayout());
		setSize(40,40);
		Image image = getImage();
		image.setUrl(uri);
		add(image);
	}

	public Image getImage() {
		if (image == null) {
			image = new Image();
		}
		return image;
	}

	public void setImage(String imageUrl) {
		getImage().setUrl(imageUrl);
	}

	public void setSize(int size){
		getImage().setSize(size+"px", size+"px");
	}
}
