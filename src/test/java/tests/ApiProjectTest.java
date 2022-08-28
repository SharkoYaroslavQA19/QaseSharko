package tests;

import Adapter.ProjectAdapters;
import Model.ProjectApi;
import Model.ProjectApiResponse;
import Model.Results;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiProjectTest {
    private final String expectedProject="{\"status\":true,\"result\":{\"total\":2,\"filtered\":2,\"count\":2,\"entities\":[{\"title\":\"QA_19 Yaroslav\",\"code\":\"QA\",\"counts\":{\"cases\":19,\"suites\":2,\"milestones\":0,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":8,\"open\":8}}},{\"title\":\"Yaroslav\",\"code\":\"AQ\",\"counts\":{\"cases\":0,\"suites\":0,\"milestones\":0,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":0,\"open\":0}}}]}}";
    private final String expectedProjectCode="{\"status\":true,\"result\":{\"title\":\"Yaroslav\",\"code\":\"AQ\",\"counts\":{\"cases\":0,\"suites\":0,\"milestones\":0,\"runs\":{\"total\":0,\"active\":0},\"defects\":{\"total\":0,\"open\":0}}}}";
    private final String expectedProjectDelete="{\"status\":true}";

    private final String POSTCODE = "AQ";
    ProjectAdapters ProjectAdapters =new ProjectAdapters();

    private final static Gson gson = new Gson();



    @Test
    public void createProject(){
        ProjectApi project = ProjectApi.builder()
                .title("Yaroslav")
                .code(POSTCODE)
                .description("Yaroslav create project")
                .build();

        ProjectApiResponse expectedProjectResponseBody = ProjectApiResponse
                .builder()
                .results(Results
                        .builder()
                        .code(POSTCODE)
                        .build())
                .build();

        String actualResponseBody = ProjectAdapters.createProject(200, gson.toJson(project));
        Assert.assertEquals(gson.fromJson(actualResponseBody, ProjectApiResponse.class),
                expectedProjectResponseBody);
    }

    @Test
    public void getAllProjectsTest() {
        String responseBody = ProjectAdapters.getAllProjects(200);
        Assert.assertEquals(responseBody, expectedProject);
    }

    @Test
    public void getProjectTest(){
        String responseBody = ProjectAdapters.getProjectByCode(200,POSTCODE);
        Assert.assertEquals(responseBody, expectedProjectCode);
    }

    @Test
    public void deleteProjectTest(){
        String responseBody = ProjectAdapters.deleteProjectByCode(200,POSTCODE);
        Assert.assertEquals(responseBody,expectedProjectDelete);
    }
}
