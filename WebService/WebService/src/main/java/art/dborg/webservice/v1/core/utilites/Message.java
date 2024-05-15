package art.dborg.webservice.v1.core.utilites;

public class Message {
    public static final String NOT_FOUND_ID = "Not found ID"; // General message for objects not found
    public static final String NOT_FOUND = "Not found object"; // General message for objects not found
    public static final String NULL_POINTER = "Please enter the ID values of dependent classes."; // Message for null pointers
    public static final String NULL_VALUES = "Please enter all requested data as JSON."; // Message for null values
    public static final String UPDATE_NOT_FOUND_ID = "Enter the 'VALID ID' for 'UPDATE'"; // Message for update operation with invalid ID
    public static final String NOT_UNIQUE = "Already Exist"; // Message for non-unique values
    public static final String CREATED = "Saved"; // Message for successful object creation
    public static final String OK = "Ok"; // General success message
    public static final String DELETED = "Deleted"; // Message for successful deletion
    public static final String NOT_NULL_MESSAGE = "Variables not null "; // Message for non-null variables
    public static final String SAME_VALUES = "Saved data with the same values already exists."; // Message for duplicate values
    public static final String RESOURCE_NOT_FOUND = "INVALID URL"; // Message for invalid URL
    public static final String UNREADABLE = "There is a syntax error in the JSON request"; // Message for unreadable JSON request
    public static final String MISSING_PARAMETER = "Missing parameter entry.";
}
