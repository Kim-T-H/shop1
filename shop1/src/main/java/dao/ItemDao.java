package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import logic.Item;

public class ItemDao {
	//spring의 jdbc 템플릿
	private NamedParameterJdbcTemplate template;
	private RowMapper<Item> mapper= new BeanPropertyRowMapper<Item>(Item.class);
	
	public void setDataSource(DataSource dataSource) {
		this.template =new NamedParameterJdbcTemplate(dataSource);
	}
	public List<Item> list() {
		return template.query("select * from item", mapper);
	}
	
	public Item selectOne(Integer id) {
		Map<String,Integer> param =new HashMap<>();
		param.put("id",id);
		//queryForObject : 결과가 1개의 레코드인 경우만 가능함.
		return template.queryForObject("select * from item where id=:id", param, mapper);
	}
}
