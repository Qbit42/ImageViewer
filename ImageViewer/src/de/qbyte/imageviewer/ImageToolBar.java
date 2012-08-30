package de.qbyte.imageviewer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import de.qbyte.imageviewer.ActionModel.ActionId;

/**
 * TODO: Qbit - describe
 * 
 * @author Qbit
 */
public class ImageToolBar extends Composite {

	/* ***** PROPERTIES ***** */

	private final ToolBar	toolBar;

	private final ToolItem	tiLoad;
	private final ToolItem	tiZoomIn;
	private final ToolItem	tiZoomOut;
	private final ToolItem	tiFit;
	private final ToolItem	tiRotate;
	private final ToolItem	tiOriginal;

	/* ***** CONSTRUCTORS ***** */

	/** Creates a new Icons */
	public ImageToolBar(Shell shell, final ActionModel actionModel) {

		// create container
		super(shell, SWT.NONE);

		GridData containerData = new GridData();
		containerData.horizontalAlignment = GridData.FILL;
		containerData.grabExcessHorizontalSpace = true;
		containerData.horizontalSpan = 2;
		this.setLayoutData(containerData);

		FormLayout containerLayout = new FormLayout();
		containerLayout.marginHeight = 3;
		containerLayout.marginWidth = 3;
		this.setLayout(containerLayout);

		// create tool bar
		this.toolBar = new ToolBar(this, SWT.FLAT);
		FormData toolBarData = new FormData();
		toolBarData.top = new FormAttachment(0);
		toolBarData.left = new FormAttachment(0);
		toolBarData.right = new FormAttachment(100);
		this.toolBar.setLayoutData(toolBarData);

		// load
		this.tiLoad = new ToolItem(this.toolBar, SWT.PUSH);
		this.tiLoad.setToolTipText("Load Image");
		this.tiLoad.setImage(ResourceLoader.getImage(ResourceLoader.ICON_LOAD));
		this.tiLoad.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				actionModel.notifyListener(ActionId.LOAD, event);
			}
		});

		// zoom in
		this.tiZoomIn = new ToolItem(this.toolBar, SWT.PUSH);
		this.tiZoomIn.setToolTipText("Zoom In");
		this.tiZoomIn.setImage(ResourceLoader.getImage(ResourceLoader.ICON_ZOOM_IN));
		this.tiZoomIn.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				actionModel.notifyListener(ActionId.ZOOM_IN, event);
			}
		});

		// zoom out
		this.tiZoomOut = new ToolItem(this.toolBar, SWT.PUSH);
		this.tiZoomOut.setToolTipText("Zoom Out");
		this.tiZoomOut.setImage(ResourceLoader.getImage(ResourceLoader.ICON_ZOOM_OUT));
		this.tiZoomOut.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				actionModel.notifyListener(ActionId.ZOOM_OUT, event);
			}
		});

		// fit
		this.tiFit = new ToolItem(this.toolBar, SWT.PUSH);
		this.tiFit.setToolTipText("Fit to Canvas");
		this.tiFit.setImage(ResourceLoader.getImage(ResourceLoader.ICON_FIT));
		this.tiFit.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				actionModel.notifyListener(ActionId.FIT, event);
			}
		});

		// original
		this.tiOriginal = new ToolItem(this.toolBar, SWT.PUSH);
		this.tiOriginal.setToolTipText("Original Size");
		this.tiOriginal.setImage(ResourceLoader.getImage(ResourceLoader.ICON_ORIGINAL));
		this.tiOriginal.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				actionModel.notifyListener(ActionId.ORIGINAL, event);
			}
		});

		// rotate
		this.tiRotate = new ToolItem(this.toolBar, SWT.PUSH);
		this.tiRotate.setToolTipText("Rotate Image");
		this.tiRotate.setImage(ResourceLoader.getImage(ResourceLoader.ICON_ROTATE));
		this.tiRotate.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				actionModel.notifyListener(ActionId.ROTATE, event);
			}
		});
		
		this.toolBar.pack();
	}

	/* ***** METHODS ***** */

}
