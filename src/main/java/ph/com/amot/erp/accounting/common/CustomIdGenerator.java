package ph.com.amot.erp.accounting.common;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ph.com.amot.erp.accounting.model.Journal;
import ph.com.amot.erp.accounting.model.Ledger;

public class CustomIdGenerator
	implements IdentifierGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(CustomIdGenerator.class);
    private static final String SINGLE_QUOTE = "'";
    private static final String JOURNAL = "JOURNAL";
    private static final String LEDGER = "GENERAL_LEDGER";

    public Serializable generate(SessionImplementor sessionImpl, Object data) throws HibernateException {

	Serializable result = null;
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	StringBuilder qryBuilder = new StringBuilder();
	qryBuilder.append("SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME=");
	qryBuilder.append(SINGLE_QUOTE);
	qryBuilder.append(mapTableObject(data));
	qryBuilder.append(SINGLE_QUOTE);

	try {
	    connection = sessionImpl.connection();
	    statement = connection.createStatement();
	    resultSet = statement.executeQuery(qryBuilder.toString());

	    if (resultSet.next()) {
		int nextValue = resultSet.getInt(1);
		result = String.format("%05d", nextValue + 1);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return result;
    }

    public String mapTableObject(Object data) {
	String tableName = "";
	if (data instanceof Journal) {
	    tableName = JOURNAL;
	}
	if (data instanceof Ledger) {
	    tableName = LEDGER;
	}
	return tableName;

    }
}
