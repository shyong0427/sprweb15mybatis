package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport {
	@Autowired
	public DataDao(DriverManagerDataSource dataSource) { // DataDao 생성자 생성
		setDataSource(dataSource);
	}
	
	public ArrayList<SangpumDto> getDataAll(){
		String sql = "select * from sangdata";
		return (ArrayList)getJdbcTemplate().query(sql, new ItemRowMapper());
	}
	
	class ItemRowMapper implements RowMapper {
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SangpumDto dto = new SangpumDto();
			
			dto.setCode(rs.getString(1));
			dto.setSang(rs.getString(2));
			dto.setSu(rs.getString(3));
			dto.setDan(rs.getString(4));
			
			return dto;
		}
	}
}