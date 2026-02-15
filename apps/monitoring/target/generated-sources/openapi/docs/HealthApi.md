# HealthApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**healthGet**](HealthApi.md#healthGet) | **GET** /health | Health check |



## healthGet

> HealthGet200Response healthGet()

Health check

Check if the API is running

### Example

```java
// Import classes:
import com.warmhouse.monitoring.legacy.smart_home.ApiClient;
import com.warmhouse.monitoring.legacy.smart_home.ApiException;
import com.warmhouse.monitoring.legacy.smart_home.Configuration;
import com.warmhouse.monitoring.legacy.smart_home.models.*;
import com.warmhouse.monitoring.legacy.smart_home.api.HealthApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        HealthApi apiInstance = new HealthApi(defaultClient);
        try {
            HealthGet200Response result = apiInstance.healthGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling HealthApi#healthGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**HealthGet200Response**](HealthGet200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | API is healthy |  -  |

