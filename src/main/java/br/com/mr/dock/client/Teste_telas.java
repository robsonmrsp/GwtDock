package br.com.mr.dock.client;

import com.extjs.gxt.ui.client.widget.Window;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Teste_telas implements EntryPoint {

	// testes de janelas
	private Window email = new Window();
	private DockMenu dockMenu;
	{
		email.setHeading("Google Mail");
		email.setModal(false);
		email.setSize(600, 400);
		email.setMaximizable(true);
		email.setToolTip("Google Mail");
		email.setUrl("http://mail.google.com");
	}

	public void onModuleLoad() {

//		Desktop desktop = new Desktop();
//		DockMenu dockMenu = createDockMenu();
//
//		desktop.defineDockMenu(dockMenu);
		// // rootPanel.add(desktop);
		//
		RootPanel rootPanel = RootPanel.get();
		
//
		rootPanel.add(new TelaInicial());
//		dockMenu.setSize("484px", "50px");
//		rootPanel.setWidgetPosition(dockMenu, 117, 420);
//		dockMenu.setSize("243px", "50px");
	}

	private DockMenu createDockMenu() {
		dockMenu = new DockMenu();
		dockMenu.setProximity(80);
		dockMenu.setMaxWidth(60);
		dockMenu.setItemWidth(40);

		
		dockMenu.addItem("images/portfolio.png", "Portfolio");
		dockMenu.addItem("images/music.png", "Musicas");
		
		dockMenu.addItem("images/video.png", "Videos");
		dockMenu.addItem("images/history.png", "Historico");
		dockMenu.addItem("images/calendar.png", "Calendario");
		dockMenu.addItem("images/link.png", "Links");
		dockMenu.addItem("images/rss.png", "Rss");
		dockMenu.addItem("images/rss2.png", "Rss novos");

//		
//		DockItem dockItemHome = new DockItem("images/home.png", "Home");
//
//		DockItem dockItemEmail = new DockItem("images/email.png", "Email");
//		dockItemEmail.addSelectionAction(new DockSelectionAction() {
//			public void action() {
//				email.show();
//			}
//		});
//
//		DockItem dockItemPortFolio = new DockItem("images/portfolio.png", "Portfolio");
//		DockItem dockItemMusic = new DockItem("images/music.png", "Musicas");
//		DockItem dockItemVideo = new DockItem("images/video.png", "Videos");
//		DockItem dockItemHistory = new DockItem("images/history.png", "Historico");
//		DockItem dockItemCalendar = new DockItem("images/calendar.png", "Calendario");
//		DockItem dockItemLink = new DockItem("images/link.png", "Links");
//		DockItem dockItemRss = new DockItem("images/rss.png", "Rss");
//		DockItem dockItemRss2 = new DockItem("images/rss2.png", "Rss novos");
//
//		dockMenu.addItem(dockItemHome);
//		dockMenu.addItem(dockItemEmail);
//		dockMenu.addItem(dockItemPortFolio);
//		dockMenu.addItem(dockItemMusic);
//		dockMenu.addItem(dockItemVideo);
//		dockMenu.addItem(dockItemHistory);
//		dockMenu.addItem(dockItemCalendar);
//		dockMenu.addItem(dockItemLink);
//		dockMenu.addItem(dockItemRss);
//		dockMenu.addItem(dockItemRss2);

		return dockMenu;
	}
}
