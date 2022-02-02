package tests.api;

import baseEntities.BaseApiTest;
import enums.ProjectType;
import io.restassured.mapper.ObjectMapperType;
import models.MilestoneBuilderApi;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRailMilestoneTest extends BaseApiTest {

    int projectID;
    int milestoneID;
    int suiteID;
    int section_ID;
    int case_ID;

    @Test
    public void addProject() {
        String endpoint = "/index.php?/api/v2/add_project";

        ProjectBuilder project = ProjectBuilder.builder()
                .name("Henadzy")
                .typeOfProject(ProjectType.MULTIPLE.getProjectType())
                .build();

        projectID = given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

        System.out.println("Number of project: " + projectID);
    }


    @Test(dependsOnMethods = "addProject")
    public void addMilestone() {
        String endpoint = "/index.php?/api/v2/add_milestone/{project_id}";

        MilestoneBuilderApi milestone = MilestoneBuilderApi.builder()
                .name("Henadzy_Milestone")
                .description("Information about Milestone")
                .build();

        milestoneID = given()
                .pathParam("project_id", projectID)
                .body(milestone, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    @Test(dependsOnMethods = "addMilestone")
    public void getMilestones(){
        String endpoint = "/index.php?/api/v2/get_milestones/{project_id}";

        given()
                .pathParam("project_id", projectID)
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);


    }

}
