/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs v1.2.0.
 *
 * Copyright (c) 2005, 2006, 2007, 2008, 2009 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * NacaRT - Naca RunTime for Java Transcoded Cobol programs.
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Publicitas SA.
 * Licensed under LGPL (LGPL-LICENSE.txt) license.
 */
/*
 * Created on 22 f�vr. 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package nacaLib.sqlSupport;

import jlib.log.Log;
import nacaLib.base.CJMapObject;
import nacaLib.program.Paragraph;
import nacaLib.program.Section;
import nacaLib.tempCache.TempCache;
import nacaLib.tempCache.TempCacheLocator;
import nacaLib.varEx.Var;
import nacaLib.varEx.VarAndEdit;

/**
 * @author U930DI
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SQLCursorFetch
{
//	public SQLCursorFetch(VarBufferPos Working, CSQLConnection SQLConnection, String csQuery)
//	{
//	}	
	public SQLCursorFetch(boolean bOpen, SQL sql)
	{
		m_bOpen = bOpen;
		m_SQL = sql;
	}
	
//	public SQLCursorFetch fetch()
//	{
//		//if(m_bOpen && m_SQL != null)
//		{
//			// PJD ROWID Support:
//			
//			if(m_SQL.hasRowIdGenerated())
//			{
//				m_sqlItemRowId = new CSQLIntoItem();	
//				m_SQL.into(m_sqlItemRowId);
//			}
//			
//		}
//		return this;
//	}

	public SQLCursorFetch into(VarAndEdit varInto)
	{
		if(m_bOpen && m_SQL != null)
		{
			m_SQL.into(varInto, null);
		}	
		return this;
	}
	
	public SQLCursorFetch ignoredInto(VarAndEdit varInto)
	{
		// Nothing to do
		return this;
	}

	public SQLCursorFetch ignoredInto(VarAndEdit varInto, Var varIndicator)
	{
		// Nothing to do
		return this;
	}

	public SQLCursorFetch missingFetchVariables(int nNbMissingVariables)
	{
		m_SQL.missingFetchVariables(nNbMissingVariables);
		return this;
	}
	
	public SQLCursorFetch into(Var varInto, Var varIndicator)
	{
		if(m_bOpen && m_SQL != null)
			m_SQL.into(varInto, varIndicator);
		return this;
	}
	
//	public String getCursorName()	// use for updatable cusrot that use Cursor Name
//	{
//		if(m_SQL != null)
//			return m_SQL.getCursorName();
//		return null;
//	}
	
	public SQLCursorFetch onErrorGoto(Paragraph paragraphSQGErrorGoto)
	{
		m_SQL.onErrorGoto(paragraphSQGErrorGoto);
		return this;
	}
	
	public SQLCursorFetch onErrorGoto(Section section)
	{
		m_SQL.onErrorGoto(section);
		return this;
	}
	
	public SQLCursorFetch onErrorContinue()
	{
		m_SQL.onErrorContinue();
		return this;
	}

	public SQLCursorFetch onNotFoundContinue()
	{
		m_SQL.onNotFoundContinue();
		return this;
	}
	
	public SQLCursorFetch onWarningGoto(Paragraph paragraphSQGErrorGoto)
	{
		// TODO
		return this;
	}
	
	public SQLCursorFetch onWarningGoto(Section section)
	{
		// TODO
		return this;
	}
	
	public SQLCursorFetch onWarningContinue()
	{
		// TODO
		return this;
	}
	
	
	public boolean mustFillRowId()
	{
		if(m_SQL != null)
			return m_SQL.hasRowIdGenerated();
		return false;
	}
	// PJD ROWID Support:
	/*
	public ROWID getCurrentRowId()
	{
		if(m_sqlItemRowId != null)
			return m_sqlItemRowId.getRowId();
		return null;
	}
	*/
	
	public SQLCursorFetch intoGeneratedRowId()
	{		
//		if(m_sqlItemRowId == null)
//			m_sqlItemRowId = new CSQLIntoItemRowId();
		//m_SQL.intoRowId(m_sqlItemRowId);
		
		m_sqlItemRowId = m_SQL.getOrAddIntoRowId();
		m_SQL.afterIntoRowId(m_sqlItemRowId);
		return this;
	}
	
	public CSQLIntoItemRowId getGeneratedRowId()
	{
		return (CSQLIntoItemRowId)m_sqlItemRowId;		 
	}

	
	private CSQLIntoItem m_sqlItemRowId = null;	// Used for updatable cursor that use RowId
	//protected SQL m_SQL = null;
	private boolean m_bOpen = false;
	public /*must be private */SQL m_SQL = null;
}
