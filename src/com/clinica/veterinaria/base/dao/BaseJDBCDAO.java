package com.clinica.veterinaria.base.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import com.clinica.veterinaria.util.PropertiesConfigurator;

public class BaseJDBCDAO<T> {

	private String driver = null;
	private String url = null;
	private String username = null;
	private String pasword = null;
	private Properties props = null;
	
	/**
	 * Creacion del DAO
	 */
	public BaseJDBCDAO(){
		try {
			props = PropertiesConfigurator.getInstance();
			driver = props.getProperty("jdbc.driverClassName");
			url = props.getProperty("jdbc.url");
			username = props.getProperty("jdbc.username");
			pasword = props.getProperty("jdbc.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Realiza la conexion con la base de datos usando el Datasource definido, 
	 * si este falla intenta realizar la conexion directa
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, pasword);
		} catch (Throwable e1) {
			throw new SQLException(e1);
		}	
		return conn;
	}
	/**
	 * Ejecuta la actualizacion o insercion en base de datos usando el sql y los
	 * parametros
	 * 
	 * @param sql
	 *            SQL de insercion o actualizacion
	 * @param params
	 *            Listado de parametros a usar en el SQL
	 * @return
	 * @throws SQLException
	 */
	protected int update(String sql, Object[] params) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;

		try {

			connection = getConnection();

			ps = connection.prepareStatement(sql);

			setParameters(params, ps);

			int result = ps.executeUpdate();
			return result;
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	/**
	 * Ejecuta la actualizacion o insercion en base de datos usando el sql y los
	 * parametros
	 * 
	 * @param sql
	 *            SQL de insercion o actualizacion
	 * @param params
	 *            Mapa de parametros a usar en el SQL
	 * @return
	 * @throws SQLException
	 */
	protected int update(String sql, Map<String, Object> params) throws SQLException {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();

			Map<String, List<Integer>> paramIndex = new HashMap<String, List<Integer>>();

			String parsedQuery = parse(sql, paramIndex);

			ps = connection.prepareStatement(parsedQuery);

			setParameters(params, paramIndex, ps);

			int result = ps.executeUpdate();
			return result;
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	/**
	 * Ejecuta la consulta a la base de datos de la query y retorna un listado
	 * de Objetos del tipo usando en el rowMapper
	 * 
	 * @param sql
	 *            SQL a ejecutar
	 * @param rowMapper
	 *            Utilitario de extraccion de los datos del ResultSet y volcado
	 *            sobre un objeto
	 * @param params
	 *            Listado de parametros
	 * @return
	 * @throws SQLException
	 */
	protected List<T> queryForModelList(String sql, RowMapper<T> rowMapper,
			Object[] params) throws SQLException {
		List<T> models = new ArrayList<T>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try (Connection connection = getConnection()){

			ps = connection.prepareStatement(sql);

			setParameters(params, ps);

			rs = ps.executeQuery();
			while (rs.next()) {
				T model = rowMapper.mapRow(rs);
				models.add(model);
			}

			return models;

		} finally {
			try {
				if (rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("Error Close RS:");
			}

			if (ps != null){
				ps.close();
			}

		}
	}

	/**
	 * Realiza la asignacion de los parametros en el PreparedStatement
	 * 
	 * @param params
	 *            listado de parametros
	 * @param ps
	 *            PreparedStatement
	 * @throws SQLException
	 */
	private void setParameters(Object[] params, PreparedStatement ps)
			throws SQLException {
		if (params != null && params.length > 0) {
			int i = 0;
			for (Object param : params) {
				if (param == null){
					ps.setNull(++i, 0);
				}
				else {
					ps.setObject(++i, param);
				}
			}
		}
	}

	/**
	 * Ejecuta la consulta a la base de datos de la query y retorna un listado
	 * de Objetos del tipo usando en el rowMapper
	 * 
	 * @param sql
	 *            SQL a ejecutar
	 * @param rowMapper
	 *            Utilitario de extraccion de los datos del ResultSet y volcado
	 *            sobre un objeto
	 * @param params mapa con los parametros para la query
	 * @return
	 * @throws SQLException
	 */
	protected List<T> queryForModelList(String sql, RowMapper<T> rowMapper,
			Map<String, Object> params) throws SQLException {
		List<T> models = new ArrayList<T>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection connection = getConnection()) {
			Map<String, List<Integer>> paramIndex = new HashMap<String, List<Integer>>();

			String parsedQuery = parse(sql, paramIndex);

			ps = connection.prepareStatement(parsedQuery);

			setParameters(params, paramIndex, ps);

			rs = ps.executeQuery();
			while (rs.next()) {
				T model = rowMapper.mapRow(rs);
				models.add(model);
			}

			return models;

		} finally {
			try {
				if (rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("Error Close RS:");
			}

			if (ps != null){
				ps.close();
			}
		}
	}

	private void setParameters(Map<String, Object> params,
			Map<String, List<Integer>> paramIndex, PreparedStatement ps)
					throws SQLException {
		for (Entry<String, Object> paramEntry : params.entrySet()) {
			List<Integer> indexs = paramIndex.get(paramEntry.getKey());
			for (Integer idx : indexs) {
				if (paramEntry.getValue() == null){
					ps.setNull(idx, 0);
				}
				else {
					ps.setObject(idx, paramEntry.getValue());
				}
			}
		}

	}

	static final String parse(String query, Map<String, List<Integer>> paramMap) {
		// I was originally using regular expressions, but they didn't work well
		// for ignoring
		// parameter-like strings inside quotes.
		int length = query.length();
		StringBuffer parsedQuery = new StringBuffer(length);
		boolean inSingleQuote = false;
		boolean inDoubleQuote = false;
		int index = 1;

		for (int i = 0; i < length; i++) {
			char c = query.charAt(i);
			if (inSingleQuote) {
				if (c == '\'') {
					inSingleQuote = false;
				}
			} else if (inDoubleQuote) {
				if (c == '"') {
					inDoubleQuote = false;
				}
			} else {
				if (c == '\'') {
					inSingleQuote = true;
				} else if (c == '"') {
					inDoubleQuote = true;
				} else if (c == ':' && i + 1 < length
						&& Character.isJavaIdentifierStart(query.charAt(i + 1))) {
					int j = i + 2;
					while (j < length
							&& Character.isJavaIdentifierPart(query.charAt(j))) {
						j++;
					}
					String name = query.substring(i + 1, j);
					c = '?'; // replace the parameter with a question mark
					i += name.length(); // skip past the end if the parameter

					List<Integer> indexList = paramMap.get(name);
					if (indexList == null) {
						indexList = new LinkedList<Integer>();
						paramMap.put(name, indexList);
					}
					indexList.add(Integer.valueOf(index));

					index++;
				}
			}
			parsedQuery.append(c);
		}

		return parsedQuery.toString();
	}

}
