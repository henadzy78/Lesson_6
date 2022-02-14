package dbEntries;

import core.DataBaseService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class MilestoneTable {
    public static Logger logger = Logger.getLogger(MilestoneTable.class);

    DataBaseService dataBaseService;

    public MilestoneTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    public void createMilestoneTable() {
        logger.info("Создаем таблицу milestones");

        String createMilestoneTableSQL = "CREATE TABLE milestones (" +
                "id SERIAL PRIMARY KEY, " +
                "milestone CHARACTER VARYING(30), " +
                "references CHARACTER VARYING(30), " +
                "description CHARACTER VARYING(30), " +
                ");";

        dataBaseService.executeSQL(createMilestoneTableSQL);
    }

    public void dropMilestoneTable() {
        logger.info("Удаляем таблицу milestones");

        String dropTableMilestoneSQL = "DROP TABLE milestones;";

        dataBaseService.executeSQL(dropTableMilestoneSQL);
    }

    public ResultSet getMilestoneByID(int id) {
        logger.info("Извлекаем запись по ID из таблицы milestones");

        String sql = "SELECT * FROM milestones WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addMilestone(String milestone, String references, String description) {
        logger.info("Добавляем запись в таблицу milestones");

        String insertTableSQL = "INSERT INTO public.milestones(" +
                "milestone, references, description)" +
                "VALUES ('" + milestone + "', '" + references + "', '" + description + "');";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
