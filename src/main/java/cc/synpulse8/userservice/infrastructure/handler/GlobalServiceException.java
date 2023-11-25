package cc.synpulse8.userservice.infrastructure.handler;

public class GlobalServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public enum GlobalServiceErrorType implements IErrorType{

        INPUT_FORMAT_ERROR("00001", GlobalErrorLevel.LOW);


        private String customErrorCode;

        private GlobalErrorLevel customErrorLevel;

        GlobalServiceErrorType(String customErrorCode, GlobalErrorLevel customErrorLevel){
            this.customErrorCode = customErrorCode;
            this.customErrorLevel = customErrorLevel;
        }

        @Override
        public String getErrorCode() {
            return customErrorCode;
        }

        @Override
        public GlobalErrorLevel getErrorLevel() {
            return customErrorLevel;
        }
    }


    protected IErrorType errorType;


    protected String displayErrorMessage;


    public GlobalServiceException(IErrorType errorType,String aExceptionMsg) {
        super(aExceptionMsg);
        this.errorType = errorType;
        this.displayErrorMessage = aExceptionMsg;
    }

    public IErrorType getErrorType() {
        return errorType;
    }

    public String getDisplayErrorMessage(){
        return displayErrorMessage;
    }
}
