package br.com.mr.dock.client;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Image;


public class CopyOfTesteDock extends LayoutContainer{
	private Item Item_0;
	private Item Item_1;
	private Item Item_2;
	private Item Item_3;
	private Item Item_4;
	private Item Item_5;
	private Item Item_6;
	private Item Item_7;
	private Item Item_8;
	private Item Item_9;
	List<Item> Items = new ArrayList<Item>();

	public CopyOfTesteDock() {
		setStyleName("a-dock-item2");
//		setId("dock");
		Item_0 = new Item("images/home.png");
		
		Item_1 = new Item("images/email.png");
		Item_2 = new Item("images/portfolio.png");
		Item_3 = new Item("images/music.png");
		Item_4 = new Item("images/video.png");
		Item_5 = new Item("images/history.png");
		Item_6 = new Item("images/calendar.png");
		Item_7 = new Item("images/link.png");
		Item_8 = new Item("images/rss.png");
		Item_9 = new Item("images/rss2.png");

		Item_0.setStyleName("dock-item");
		Item_1.setStyleName("dock-item");
		Item_2.setStyleName("dock-item");
		Item_3.setStyleName("dock-item");
		Item_4.setStyleName("dock-item");
		Item_5.setStyleName("dock-item");
		Item_6.setStyleName("dock-item");
		Item_7.setStyleName("dock-item");
		Item_8.setStyleName("dock-item");
		Item_9.setStyleName("dock-item");
		
		Item_0.setSize(40);
		Item_1.setSize(40);
		Item_2.setSize(40);
		Item_3.setSize(40);
		Item_4.setSize(40);
		Item_5.setSize(40);
		Item_6.setSize(40);
		Item_7.setSize(40);
		Item_8.setSize(40);
		Item_9.setSize(40);
		
		
		setLayout(new FlowLayout(0));
		add(Item_0);
		add(Item_1);
		add(Item_2);
		add(Item_3);
		add(Item_4);
		add(Item_5);
		add(Item_6);
		add(Item_7);
		add(Item_8);
		add(Item_9);

		Items.add(Item_0);
		Items.add(Item_1);
		Items.add(Item_2);
		Items.add(Item_3);
		Items.add(Item_4);
		Items.add(Item_5);
		Items.add(Item_6);
		Items.add(Item_7);
		Items.add(Item_8);
		Items.add(Item_9);
	}
	@Override
	protected void onShow() {
		super.onShow();
		positionContainer(0);
	}
//	public void setMousePosition(int x, int y){
//		for(Image im : images){
//			adjuste(im, x, y );
//		}
//	}

	private void adjuste(Image im, int x, int y) {
		int left = im.getAbsoluteLeft();
		int top  = im.getAbsoluteTop();
		int height = im.getHeight();
		int width = im.getWidth();

		//pegar o ponto do centro da imagem
		int centroX = left + width/2;   
		int centroY = top + height;


		double raio = sqrt(pow((x-centroX), 2) +  pow((y-centroY), 2));
		double diff = raio - 80.0;

		if(diff <80){
			height = (int) (64 - (64 * diff/80.0));
			width = (int) (64 - (64 * diff/80.0));
			if(width>24)
				im.setSize(width+"px", height+"px");
		}
	}

	int maxWidth = 60;
	int itemWidth = 40;
	int proximity = 80;
	String halign = "center";
	String valign = "center";
	List<Item> items = Items;

	public void adjuste(int x, int y)
	{
		//var pointer = jQuery.iUtil.getPointer(e);
		Point pointer = new Point(x, y);
		//var toAdd = 0;
		int toAdd = 0;
		int posx = 0;
		int posy = 0;
		int containerX = this.getAbsoluteLeft();
		int containerY = this.getAbsoluteTop();

		int offsetWidth = this.getOffsetWidth();
		int offsetHeight = this.getOffsetHeight();
		//if (el.fisheyeCfg.halign && el.fisheyeCfg.halign == 'center')
		if (halign.equals("center"))
			//vat posx = pointer.x - el.fisheyeCfg.pos.x - (el.offsetWidth - el.fisheyeCfg.itemWidth * el.fisheyeCfg.items.size())/2 - el.fisheyeCfg.itemWidth/2;
			posx = pointer.x - containerX - (offsetWidth - itemWidth * items.size())/2 - itemWidth/2;
		//else if (el.fisheyeCfg.halign && el.fisheyeCfg.halign == 'right')
		else if (halign.equals("right"))
			//var posx = pointer.x - el.fisheyeCfg.pos.x - el.offsetWidth + el.fisheyeCfg.itemWidth * el.fisheyeCfg.items.size();
			posx = pointer.x - containerX - offsetWidth + itemWidth * items.size();
		else 
			//var posx = pointer.x - el.fisheyeCfg.pos.x;
			posx = pointer.x - containerX;
		//var posy = Math.pow(pointer.y - el.fisheyeCfg.pos.y - el.offsetHeight/2,2);
		posy = (int) Math.pow(pointer.y - containerY - offsetHeight/2, 2);

		//		el.fisheyeCfg.items.each(
		int numItens = items.size();
		for(int nr=1; nr<=numItens;nr++){
			Image item = items.get(nr-1).getImage();

			//distance = Math.sqrt(Math.pow(posx - nr*el.fisheyeCfg.itemWidth, 2)	+ posy);
			int distance = (int) Math.sqrt(Math.pow(posx - nr * itemWidth, 2)	+ posy	);
			//distance -= el.fisheyeCfg.itemWidth/2;
			distance -= itemWidth/2;

			//distance = distance < 0 ? 0 : distance;
			distance = distance < 0 ? 0 : distance;
			//distance = distance > el.fisheyeCfg.proximity ? el.fisheyeCfg.proximity : distance;
			distance = distance > proximity ? proximity : distance;
			//distance = el.fisheyeCfg.proximity - distance;
			distance = proximity - distance;

			//extraWidth = el.fisheyeCfg.maxWidth * distance/el.fisheyeCfg.proximity;
			int extraWidth = maxWidth * distance/proximity;


			//this.style.width = el.fisheyeCfg.itemWidth + extraWidth + 'px';
			item.setWidth(itemWidth + extraWidth + "px");
			item.setHeight(itemWidth + extraWidth + "px");
			//this.style.left = el.fisheyeCfg.itemWidth * nr + toAdd + 'px';
			item.getElement().getStyle().setLeft(itemWidth * nr + toAdd,Unit.PX);

			//toAdd += extraWidth;
			toAdd += extraWidth;
		}
		positionContainer(toAdd);
	}

	private void positionContainer(int toAdd) {
		int left = this.el().getLeft();
		int top = this.el().getTop();
		if (halign!= null)
			if (halign.equals("center")){
				//el.fisheyeCfg.container.get(0).style.left = (el.offsetWidth - el.fisheyeCfg.itemWidth * el.fisheyeCfg.items.size())/2 - toAdd/2 + 'px';
				int leftLocal = left + (this.getOffsetWidth() - itemWidth * items.size())/2 - toAdd/2;
				
				this.el().setLeft(leftLocal);
			}
		this.setWidth( itemWidth * items.size() + toAdd);
	}
}
