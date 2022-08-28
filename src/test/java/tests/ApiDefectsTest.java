package tests;

import Adapter.DefectAdapters;
import Model.DefectApi;
import Model.DefectApiResponse;
import Model.Results;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiDefectsTest {
    private final String expectedAllDefects = "{\"status\":true,\"result\":{\"total\":8,\"filtered\":8,\"count\":8,\"entities\":[{\"id\":1,\"title\":\"Adding\",\"actual_result\":\"Adding\",\"status\":\"open\",\"milestone_id\":null,\"project_id\":190013,\"severity\":\"critical\",\"member_id\":1,\"attachments\":[{\"hash\":\"b93e4393585c04cbaa7c9578d4925d7bee5f4919\"}],\"custom_fields\":[],\"external_data\":\"{}\",\"resolved_at\":null,\"created\":\"2022-06-21 17:42:39\",\"updated\":\"2022-08-28 18:15:43\",\"created_at\":\"2022-06-21T17:42:39+00:00\",\"updated_at\":\"2022-08-28T18:15:43+00:00\",\"tags\":[]},{\"id\":2,\"title\":\"User\",\"actual_result\":\"User\",\"status\":\"open\",\"milestone_id\":null,\"project_id\":190013,\"severity\":\"major\",\"member_id\":1,\"attachments\":[{\"hash\":\"4e9ad384c5039144509e576b917eecd028340ad3\"}],\"custom_fields\":[],\"external_data\":\"{}\",\"resolved_at\":null,\"created\":\"2022-06-21 17:58:01\",\"updated\":\"2022-08-28 18:15:58\",\"created_at\":\"2022-06-21T17:58:01+00:00\",\"updated_at\":\"2022-08-28T18:15:58+00:00\",\"tags\":[]},{\"id\":3,\"title\":\"Calculating\",\"actual_result\":\"Calculating\",\"status\":\"open\",\"milestone_id\":null,\"project_id\":190013,\"severity\":\"critical\",\"member_id\":1,\"attachments\":[{\"hash\":\"2505827fbf78dd342a14feabee71e05fd4822dce\"}],\"custom_fields\":[],\"external_data\":\"{}\",\"resolved_at\":null,\"created\":\"2022-06-21 18:06:53\",\"updated\":\"2022-08-28 18:16:21\",\"created_at\":\"2022-06-21T18:06:53+00:00\",\"updated_at\":\"2022-08-28T18:16:21+00:00\",\"tags\":[]},{\"id\":4,\"title\":\"Changing\",\"actual_result\":\"Changing\",\"status\":\"open\",\"milestone_id\":null,\"project_id\":190013,\"severity\":\"major\",\"member_id\":1,\"attachments\":[{\"hash\":\"e369d77a96bf52a949f2e837a8435a3c95b4ad36\"}],\"custom_fields\":[],\"external_data\":\"{}\",\"resolved_at\":null,\"created\":\"2022-06-21 20:40:41\",\"updated\":\"2022-08-28 18:16:35\",\"created_at\":\"2022-06-21T20:40:41+00:00\",\"updated_at\":\"2022-08-28T18:16:35+00:00\",\"tags\":[]},{\"id\":6,\"title\":\"After\",\"actual_result\":\"After\",\"status\":\"open\",\"milestone_id\":null,\"project_id\":190013,\"severity\":\"normal\",\"member_id\":1,\"attachments\":[],\"custom_fields\":[],\"external_data\":\"{}\",\"resolved_at\":null,\"created\":\"2022-06-21 21:04:22\",\"updated\":\"2022-08-28 18:16:48\",\"created_at\":\"2022-06-21T21:04:22+00:00\",\"updated_at\":\"2022-08-28T18:16:48+00:00\",\"tags\":[]},{\"id\":11,\"title\":\"Logout\",\"actual_result\":\"logout button\",\"status\":\"open\",\"milestone_id\":null,\"project_id\":190013,\"severity\":\"major\",\"member_id\":1,\"attachments\":[],\"custom_fields\":[],\"external_data\":\"{}\",\"resolved_at\":null,\"created\":\"2022-08-28 17:46:02\",\"updated\":\"2022-08-28 17:46:02\",\"created_at\":\"2022-08-28T17:46:02+00:00\",\"updated_at\":\"2022-08-28T17:46:02+00:00\",\"tags\":[]},{\"id\":12,\"title\":\"Yaroslav\",\"actual_result\":\"yaroslav\",\"status\":\"open\",\"milestone_id\":null,\"project_id\":190013,\"severity\":\"critical\",\"member_id\":1,\"attachments\":[],\"custom_fields\":[],\"external_data\":\"{}\",\"resolved_at\":null,\"created\":\"2022-08-28 17:55:05\",\"updated\":\"2022-08-28 17:55:05\",\"created_at\":\"2022-08-28T17:55:05+00:00\",\"updated_at\":\"2022-08-28T17:55:05+00:00\",\"tags\":[]},{\"id\":14,\"title\":\"Yaroslav\",\"actual_result\":\"yaroslav\",\"status\":\"open\",\"milestone_id\":null,\"project_id\":190013,\"severity\":\"critical\",\"member_id\":1,\"attachments\":[],\"custom_fields\":[],\"external_data\":\"{}\",\"resolved_at\":null,\"created\":\"2022-08-28 17:57:20\",\"updated\":\"2022-08-28 17:57:20\",\"created_at\":\"2022-08-28T17:57:20+00:00\",\"updated_at\":\"2022-08-28T17:57:20+00:00\",\"tags\":[]}]}}";
    private final String expectedDeleteDefect = "{\"status\":true,\"result\":{\"id\":13}}";
    private final String expectedDefectCode = "{\"status\":true,\"result\":{\"id\":2,\"title\":\"User\",\"actual_result\":\"User\",\"status\":\"open\",\"milestone_id\":null,\"project_id\":190013,\"severity\":\"major\",\"member_id\":1,\"attachments\":[{\"hash\":\"4e9ad384c5039144509e576b917eecd028340ad3\"}],\"custom_fields\":[],\"external_data\":\"{}\",\"resolved_at\":null,\"created\":\"2022-06-21 17:58:01\",\"updated\":\"2022-08-28 18:15:58\",\"created_at\":\"2022-06-21T17:58:01+00:00\",\"updated_at\":\"2022-08-28T18:15:58+00:00\",\"tags\":[]}}";
    private final String projectCode = "QA";
    private final int id = 16;
    private final int getId = 2;
    private final int updateId = 1;
    private final static Gson gson = new Gson();
    DefectAdapters DefectAdapter = new DefectAdapters();


    @Test
    public void getAllDefectTest() {
        String responseBody = DefectAdapter.getAllDefects(200, projectCode);
        Assert.assertEquals(responseBody, expectedAllDefects);
    }
    @Test
    public void createDefectTest() {

        DefectApi defect = DefectApi.builder()
                .title("Yaroslav")
                .actual_result("yaroslav")
                .severity(2)
                .build();

        DefectApiResponse expectedDefectResponseBody = DefectApiResponse
                .builder()
                .results(Results
                        .builder()
                        .id(id)
                        .build())
                .build();

        String actualResponseBody = DefectAdapter.createDefect(200, projectCode, gson.toJson(defect));
        Assert.assertEquals(gson.fromJson(actualResponseBody, DefectApiResponse.class),
                expectedDefectResponseBody);
    }
  @Test
    public void getDefectTest() {
      String responseBody = DefectAdapter.getDefect(200,projectCode,getId);
      Assert.assertEquals(responseBody, expectedDefectCode);
  }
    @Test
    public void deleteDefectTest() {
        String responseBody = DefectAdapter.deleteDefect(200, projectCode, id);
        Assert.assertEquals(responseBody, expectedDeleteDefect);
    }

    @Test
    public void updateDefectTest() {

        DefectApi defect = DefectApi.builder()
                .severity(2)
                .build();

        DefectApiResponse expectedDefectResponseBody = DefectApiResponse
                .builder()
                .results(Results
                        .builder()
                        .id(updateId)
                        .build())
                .build();

        String actualResponseBody = DefectAdapter.patchDefect(200, projectCode, updateId, gson.toJson(defect));
        Assert.assertEquals(gson.fromJson(actualResponseBody, DefectApiResponse.class),
                expectedDefectResponseBody);
    }
}
