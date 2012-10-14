package br.com.mr.dock.client;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;

public class Desktop extends LayoutContainer {

	/** Menu em estilo dock **/
	private DockMenu dockMenu;

	private LayoutContainer dock;

	public Desktop() {
		setSize("100%", "100%");
		setLayout(new FlowLayout());
		add(getDockContainer());
	}

	public void defineDockMenu(DockMenu dockMenu) {
		this.dockMenu = dockMenu;
		dock.add(dockMenu);
	}

	private LayoutContainer getDockContainer() {
		if (dock == null) {
			dock = new LayoutContainer();
			dock.setId("dock");
			dock.setBorders(false);
		}
		return dock;
	}

	public void addWindow(Component component) {

	}
}
