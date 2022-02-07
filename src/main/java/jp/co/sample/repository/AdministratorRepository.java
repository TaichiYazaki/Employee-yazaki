package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

@Repository
public class AdministratorRepository {

	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER=(rs,i)->{
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAdress(rs.getString("mailAdress"));
		administrator.setPassword(rs.getString("password"));
		
		return administrator;	
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	
	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		//if(administrator.getId() == null) {
			String insertSql
				="INSERT INTO administrators(name,mail_adress,password) VALUES(:name, :mailAdress, :password)";
			template.update(insertSql, param);
		/*}else {
			String upadateSql
				="UPDATE administrators SET name=:name, mail_adress=:mailAdress, password=:password";
			template.update(upadateSql, param);
		}
		return administrator;*/
	}
	
	public Administrator findByMailAdressAndPassword(String mailAddress, String password) {
		String sql = "SELECT mail_address FROM administrators";
		List<Administrator> administratorList = template.query(sql,ADMINISTRATOR_ROW_MAPPER);
				
		if(administratorList.size()==0) {
			return null;
		}
		return administratorList.get(0);
	}
}
