package br.com.mr.dock.client;

import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;

class DockComponentLayout extends AbsoluteLayout {
	public DockComponentLayout() {
		componentStyleName = "bottom-dock-item";
	}

	public DockComponentLayout(Position position) {
		this();
		switch (position) {
		case TOP:
			componentStyleName = "top-dock-item";			
			break;
		case BOTTOM:
			componentStyleName = "bottom-dock-item";			
			break;

		default:
			break;
		}
	}
}
