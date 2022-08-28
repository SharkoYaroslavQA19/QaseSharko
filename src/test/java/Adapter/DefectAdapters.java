package Adapter;

public class DefectAdapters extends BaseAdapter {

    private static final String ENDPOINT_DEFECT = "defect";

    public String getAllDefects(int statusCode, String defectCode) {
        return get(ENDPOINT_DEFECT + "/" + defectCode, statusCode);
    }

    public String getDefect(int statusCode, String defectCode, int id) {
        return get(ENDPOINT_DEFECT + "/" + defectCode + "/" + id, statusCode);
    }

    public String createDefect(int statusCode, String defectCode, String requestBody) {
        return post(ENDPOINT_DEFECT + "/" + defectCode, statusCode, requestBody);
    }

    public String deleteDefect(int statusCode, String defectCode, int id) {
        return delete(ENDPOINT_DEFECT + "/" + defectCode + "/" + id, statusCode);
    }

    public String patchDefect(int statusCode, String defectCode, int id, String requestBody) {
        return patch(ENDPOINT_DEFECT + "/" + defectCode + "/" + id, statusCode, requestBody);
    }

}