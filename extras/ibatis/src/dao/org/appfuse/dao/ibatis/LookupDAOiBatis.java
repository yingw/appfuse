package org.appfuse.dao.ibatis;

import java.util.List;

import org.appfuse.dao.LookupDAO;

/**
 * iBatis implementation of LookupDAO.
 *
 * <p>
 * <a href="LookupDAOiBatis.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class LookupDAOiBatis extends BaseDAOiBATIS implements LookupDAO {

    /**
     * @see org.appfuse.dao.LookupDAO#getRoles()
     */
    public List getRoles() {
        if (logger.isDebugEnabled()) {
            logger.debug("retrieving all role names...");
        }

        return getSqlMapClientTemplate().queryForList("getRoles", null);
    }
}
