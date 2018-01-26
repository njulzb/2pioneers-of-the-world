package utility.resultMsg;

public class ResultMsg {
    private boolean successful;//indicate the methods result
    private String errorMsg;//

    public ResultMsg(boolean flag, String errorMsg) {
        this.successful = flag;
        this.errorMsg = errorMsg;
    }

    // getter and setter below
    public boolean isSuccessful() {
        return successful;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    //getter and setter above
}
