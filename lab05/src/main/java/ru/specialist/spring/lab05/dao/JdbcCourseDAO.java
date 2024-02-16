package ru.specialist.spring.lab05.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

class CourseRowMapper implements RowMapper<Course> {

    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        var c = new Course();
        c.setId(rs.getInt("id"));
        c.setTitle(rs.getString("title"));
        c.setLength(rs.getInt("length"));
        c.setDescription(rs.getString("description"));
        return c;
    }
}

public class JdbcCourseDAO implements CourseDAO {

    private static final String SQL_SELECT_COURSE = "SELECT \"id\", \"title\", \"length\", \"description\" FROM \"courses\"";

    private static final String SQL_SELECT_COURSE_BY_ID = SQL_SELECT_COURSE + " WHERE \"id\" = ?";

    private static final String SQL_SELECT_COURSE_BY_TITLE = SQL_SELECT_COURSE + " WHERE \"title\" ILIKE ?";

    private static final String SQL_DELETE_COURSE_BY_ID = "DELETE FROM \"courses\" WHERE \"id\" = ?";

    private static final String SQL_INSERT_COURSE = "INSERT INTO \"courses\" (\"title\", \"length\", \"description\") VALUES (?, ?, ?)";

    private static final String SQL_UPDATE_COURSE = "UPDATE \"courses\" SET \"title\" = ?, \"length\" = ?, \"description\" = ? WHERE \"id\" = ?";

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Course findById(int id) {
        Course course = getJdbcTemplate().queryForObject(SQL_SELECT_COURSE_BY_ID, new CourseRowMapper(), id);
        return course;
    }

    @Override
    public List<Course> findAll() {
//        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(SQL_SELECT_COURSE);
//
//        List<Course> courses = new ArrayList<Course>();
//        for (Map<String, Object> row : rows) {
//            Course c = new Course();
//            c.setId((int) row.get("id"));
//            c.setTitle((String) row.get("title"));
//            c.setLength((int) row.get("length"));
//            c.setDescription((String) row.get("description"));
//            courses.add(c);
//        }

//        List<Course> courses = getJdbcTemplate().query(SQL_SELECT_COURSE, new CourseRowMapper());

        List<Course> courses = getJdbcTemplate().query(SQL_SELECT_COURSE, new BeanPropertyRowMapper(Course.class));
        return courses;
    }

    @Override
    public List<Course> findByTitle(String title) {
        return getJdbcTemplate().query(SQL_SELECT_COURSE_BY_TITLE, new BeanPropertyRowMapper(Course.class), "%" + title + "%");
    }

    @Override
    public void insert(Course course) {
        PreparedStatementCreatorFactory factory = new PreparedStatementCreatorFactory(SQL_INSERT_COURSE, Types.VARCHAR, Types.INTEGER, Types.VARCHAR);

        factory.setGeneratedKeysColumnNames("id");
        KeyHolder holder = new GeneratedKeyHolder();

        getJdbcTemplate().update(factory.newPreparedStatementCreator(new Object[]{course.getTitle(), course.getLength(), course.getDescription()}), holder);

        course.setId(holder.getKey().intValue());
    }

    @Override
    public void update(Course course) {
        getJdbcTemplate().update(SQL_UPDATE_COURSE, course.getTitle(), course.getLength(), course.getDescription(), course.getId());

    }

    @Override
    public void delete(int id) {
        getJdbcTemplate().update(SQL_DELETE_COURSE_BY_ID, id);
    }
}
