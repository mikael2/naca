/*
 * JLib - Publicitas Java library v1.2.0.
 *
 * Copyright (c) 2005, 2006, 2007, 2008, 2009 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * JLib - Publicitas Java library.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/**
 * 
 */
package jlib.polling;

import java.io.File;
import java.util.ArrayList;

import jlib.misc.FileSystem;

/**
 *
 * @author Pierre-Jean Ditscheid, Consultas SA
 * @version $Id$
 */
public abstract class BaseDirectoryPoller
{
	private String m_csPath;						// Path polled; the sub dir are not polled
	public MaskFileFilter m_maskFileFilter = null; 
		
	public BaseDirectoryPoller(String csPath)
	{
		m_csPath = FileSystem.normalizePath(csPath);
	}
	
	// Pass a list of ; separated file masks e.g. *.xml;*.pdf
	public void setMasks(String csMasks)
	{
		String arr[] = csMasks.split(";");
		for(int n=0; n<arr.length; n++)
			addSingleMask(arr[n]);
	}

	public void addSingleMask(String csMask)
	{
		if(m_maskFileFilter == null)
			m_maskFileFilter = new MaskFileFilter();
		m_maskFileFilter.add(csMask);
	}

	public void poll()
	{
		File path = new File(m_csPath);
		File[] files = path.listFiles(m_maskFileFilter);
		if (files != null)
		{
			ArrayList<File> arr = new ArrayList<File>();
			for(int n=0; n<files.length; n++)
			{
				arr.add(files[n]);
			}
			handlePolledFiles(arr);
		}
	}
	
	protected abstract void handlePolledFiles(ArrayList<File> arrFiles);
}
