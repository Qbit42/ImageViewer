package de.qbyte.imageviewer;

import java.io.InputStream;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * TODO: Qbit - describe
 * 
 * @author bbone
 */
public final class ResourceLoader {

	/* ***** CONSTANTS ***** */

	public static final String	ICON_LOAD		= "icons/load.png";
	public static final String	ICON_ZOOM_IN	= "icons/zoom-in.png";
	public static final String	ICON_ZOOM_OUT	= "icons/zoom-out.png";
	public static final String	ICON_FIT		= "icons/zoom-fit.png";
	public static final String	ICON_ORIGINAL	= "icons/zoom-100.png";
	public static final String	ICON_ROTATE		= "icons/rotate.png";

	/* ***** CONSTRUCTORS ***** */

	// TODO: bbone - implement image cache and image dispose handler
	/** Creates a new ResourceLoader */
	private ResourceLoader() {
	}

	/* ***** METHODS ***** */

	/**
	 * TODO: Qbit - describe
	 * 
	 * @param device
	 * @param location
	 * @return
	 */
	public static Image getImage(String location) {
		InputStream is = ResourceLoader.class.getResourceAsStream(location);
		return is == null ? new Image(Display.getCurrent(), location) : new Image(Display.getCurrent(), is);
	}
}
