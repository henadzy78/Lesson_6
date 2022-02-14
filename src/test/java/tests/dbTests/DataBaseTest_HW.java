package tests.dbTests;

import baseEntities.BaseTest;
import dbEntries.ProjectsTable;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseTest_HW extends BaseTest {
    public static Logger logger = Logger.getLogger(DataBaseTest_HW.class);

    @Test
    public void projectTableTest(){
        ProjectsTable projectsTable = new ProjectsTable(dataBaseService);

        projectsTable.createProjectsTable();
        projectsTable.addProjectInTable("DB_Project", "DB_Announcement");

        ResultSet rs = projectsTable.getProjectByID(1);
        try {
            while (rs.next()) {
                String nameProject = rs.getString("project");
                String announcement = rs.getString("announcement");

                logger.info("nameProject: " + nameProject);
                logger.info("announcement: " + announcement);
            }
        }catch (SQLException e){
            logger.error(e.toString());
        }





    }
}
