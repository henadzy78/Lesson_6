package tests.api;

import baseEntities.BaseApiTest;
import enums.ProjectType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.*;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static utils.Endpoints.*;

public class TestRailMilestoneApiTest extends BaseApiTest {
    int projectID;
    int milestoneID;
    int suite_ID;
    int section_ID;
    int case_ID;

    @Test
    public void addProject() {
        ProjectBuilder project = ProjectBuilder.builder()
                .name("Henadzy")
                .typeOfProject(ProjectType.MULTIPLE.getProjectType())
                .build();

        projectID = given()
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(project.getName()))
                .extract().jsonPath().get("id");

        System.out.println("ID of project: " + projectID);
    }

    @Test(dependsOnMethods = "addMilestone")
    public void getMilestones() {
        given()
                .pathParam("project_id", projectID)
                .when()
                .get(GET_MILESTONES)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "addProject")
    public void addMilestone() {
        MilestoneBuilder milestoneBuilder = MilestoneBuilder.builder()
                .name("Henadzy_Milestone")
                .description("Information about Milestone")
                .build();

        milestoneID = given()
                .pathParam("project_id", projectID)
                .body(milestoneBuilder, ObjectMapperType.GSON)
                .when()
                .post(ADD_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(milestoneBuilder.getName()))
                .body("description", is(milestoneBuilder.getDescription()))
                .extract().jsonPath().get("id");
    }

    @Test(dependsOnMethods = "addMilestone")
    public void updateMilestone() {
        MilestoneBuilder updateMilestone = MilestoneBuilder.builder()
                .name("New Milestone")
                .description("About new Milestone")
                .build();

        Response response = given()
                .pathParam("milestone_id", milestoneID)
                .body(updateMilestone, ObjectMapperType.GSON)
                .when()
                .post(UPDATE_MILESTONE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(updateMilestone.getName()))
                .body("description", is(updateMilestone.getDescription()))
                .extract().response();

        Assert.assertEquals(response.getBody().jsonPath().get("description"),
                updateMilestone.getDescription());
    }

    @Test(dependsOnMethods = "updateMilestone")
    public void deleteMilestone() {
        given()
                .pathParam("milestone_id", milestoneID)
                .when()
                .post(DELETE_MILESTONE)
                .then()
                .log().body()
                .extract().response();
    }

    @Test(dependsOnMethods = "deleteMilestone")
    public void addSuite() {
        SuiteBuilder suite = SuiteBuilder.builder()
                .name("This is a new test suite")
                .description("Use the description to add additional context details")
                .build();

        suite_ID = given()
                .pathParam("project_id", projectID)
                .body(suite, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(ADD_SUITE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(suite.getName()))
                .body("description", is(suite.getDescription()))
                .extract().jsonPath().get("id");

        System.out.println("ID of suite: " + suite_ID);
    }

    @Test(dependsOnMethods = "addSuite")
    public void addSection() {
        SectionBuilder section = SectionBuilder.builder()
                .name("This is a new section")
                .suite_id(suite_ID)
                .build();

        section_ID = given()
                .pathParam("project_id", projectID)
                .body(section, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(ADD_SECTION)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .body("name", is(section.getName()))
                .body("suite_id", is(section.getSuite_id()))
                .extract().jsonPath().get("id");

        System.out.println("ID of section: " + section_ID);
    }

    @Test(dependsOnMethods = "addSection")
    public void addCase() {
        CaseBuilder addCase = CaseBuilder.builder()
                .title("This is a test case")
                .typeID(12)
                .build();

        case_ID = given()
                .pathParam("section_id", section_ID)
                .body(addCase, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(ADD_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
        System.out.println("ID of Case: " + case_ID);

        CaseBuilder actualCase = given()
                .pathParam("case_id", case_ID)
                .when()
                .get(GET_CASE)
                .then()
                .assertThat()
                .extract()
                .as(CaseBuilder.class);

        Assert.assertEquals(actualCase, addCase);
    }

    @Test(dependsOnMethods = "addCase")
    public void getCase() {
        given()
                .pathParam("case_id", case_ID)
                .when()
                .get(GET_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "getCase")
    public void updateCase() {
        CaseBuilder updateCase = CaseBuilder.builder()
                .title("Update TestCase")
                .typeID(5)
                .build();

        CaseBuilder actualCase = given()
                .pathParam("case_id", case_ID)
                .body(updateCase, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(UPDATE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .extract()
                .as(CaseBuilder.class);

        Assert.assertEquals(actualCase, updateCase);
    }

    @Test (dependsOnMethods = "updateCase")
    public void moveCasesToSection(){
        given()
                .pathParam("section_id", section_ID)
                .body(String.format("{\n" +
                        "  \"section_id\": %d,\n" +
                        "  \"suite_id\": %d,\n" +
                        "  \"case_ids\": [%d]\n" +
                        "}", section_ID, suite_ID, case_ID))
                .log().body()
                .when()
                .post(MOVE_CASES_TO_SECTION)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "moveCasesToSection")
    public void deleteCase(){
        given()
                .pathParam("case_id", case_ID)
                .when()
                .post(DELETE_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "deleteCase")
    public void deleteProject(){
        given()
                .pathParam("project_id", projectID)
                .when()
                .post(DELETE_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
