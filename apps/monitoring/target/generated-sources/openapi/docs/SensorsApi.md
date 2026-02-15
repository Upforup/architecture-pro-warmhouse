# SensorsApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1SensorsGet**](SensorsApi.md#apiV1SensorsGet) | **GET** /api/v1/sensors | Get all sensors |
| [**apiV1SensorsIdDelete**](SensorsApi.md#apiV1SensorsIdDelete) | **DELETE** /api/v1/sensors/{id} | Delete a sensor |
| [**apiV1SensorsIdGet**](SensorsApi.md#apiV1SensorsIdGet) | **GET** /api/v1/sensors/{id} | Get sensor by ID |
| [**apiV1SensorsIdPut**](SensorsApi.md#apiV1SensorsIdPut) | **PUT** /api/v1/sensors/{id} | Update a sensor |
| [**apiV1SensorsIdValuePatch**](SensorsApi.md#apiV1SensorsIdValuePatch) | **PATCH** /api/v1/sensors/{id}/value | Update sensor value |
| [**apiV1SensorsPost**](SensorsApi.md#apiV1SensorsPost) | **POST** /api/v1/sensors | Create a new sensor |
| [**apiV1SensorsTemperatureLocationGet**](SensorsApi.md#apiV1SensorsTemperatureLocationGet) | **GET** /api/v1/sensors/temperature/{location} | Get temperature by location |



## apiV1SensorsGet

> List&lt;Sensor&gt; apiV1SensorsGet()

Get all sensors

Retrieve all sensors from the database.  For temperature sensors, the response includes real-time data fetched from the external temperature API. 

### Example

```java
// Import classes:
import com.warmhouse.monitoring.legacy.smart_home.ApiClient;
import com.warmhouse.monitoring.legacy.smart_home.ApiException;
import com.warmhouse.monitoring.legacy.smart_home.Configuration;
import com.warmhouse.monitoring.legacy.smart_home.models.*;
import com.warmhouse.monitoring.legacy.smart_home.api.SensorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        SensorsApi apiInstance = new SensorsApi(defaultClient);
        try {
            List<Sensor> result = apiInstance.apiV1SensorsGet();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SensorsApi#apiV1SensorsGet");
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

[**List&lt;Sensor&gt;**](Sensor.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of all sensors |  -  |
| **500** | Internal server error |  -  |


## apiV1SensorsIdDelete

> ApiV1SensorsIdDelete200Response apiV1SensorsIdDelete(id)

Delete a sensor

Delete a sensor by its ID

### Example

```java
// Import classes:
import com.warmhouse.monitoring.legacy.smart_home.ApiClient;
import com.warmhouse.monitoring.legacy.smart_home.ApiException;
import com.warmhouse.monitoring.legacy.smart_home.Configuration;
import com.warmhouse.monitoring.legacy.smart_home.models.*;
import com.warmhouse.monitoring.legacy.smart_home.api.SensorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        SensorsApi apiInstance = new SensorsApi(defaultClient);
        Integer id = 56; // Integer | Numeric ID of the sensor
        try {
            ApiV1SensorsIdDelete200Response result = apiInstance.apiV1SensorsIdDelete(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SensorsApi#apiV1SensorsIdDelete");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**| Numeric ID of the sensor | |

### Return type

[**ApiV1SensorsIdDelete200Response**](ApiV1SensorsIdDelete200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sensor deleted successfully |  -  |
| **400** | Invalid sensor ID format |  -  |
| **500** | Internal server error |  -  |


## apiV1SensorsIdGet

> Sensor apiV1SensorsIdGet(id)

Get sensor by ID

Retrieve a specific sensor by its ID.  For temperature sensors, the response includes real-time data fetched from the external temperature API. 

### Example

```java
// Import classes:
import com.warmhouse.monitoring.legacy.smart_home.ApiClient;
import com.warmhouse.monitoring.legacy.smart_home.ApiException;
import com.warmhouse.monitoring.legacy.smart_home.Configuration;
import com.warmhouse.monitoring.legacy.smart_home.models.*;
import com.warmhouse.monitoring.legacy.smart_home.api.SensorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        SensorsApi apiInstance = new SensorsApi(defaultClient);
        Integer id = 56; // Integer | Numeric ID of the sensor
        try {
            Sensor result = apiInstance.apiV1SensorsIdGet(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SensorsApi#apiV1SensorsIdGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**| Numeric ID of the sensor | |

### Return type

[**Sensor**](Sensor.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sensor found |  -  |
| **400** | Invalid sensor ID format |  -  |
| **404** | Sensor not found |  -  |


## apiV1SensorsIdPut

> Sensor apiV1SensorsIdPut(id, sensorUpdate)

Update a sensor

Update all fields of an existing sensor

### Example

```java
// Import classes:
import com.warmhouse.monitoring.legacy.smart_home.ApiClient;
import com.warmhouse.monitoring.legacy.smart_home.ApiException;
import com.warmhouse.monitoring.legacy.smart_home.Configuration;
import com.warmhouse.monitoring.legacy.smart_home.models.*;
import com.warmhouse.monitoring.legacy.smart_home.api.SensorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        SensorsApi apiInstance = new SensorsApi(defaultClient);
        Integer id = 56; // Integer | Numeric ID of the sensor
        SensorUpdate sensorUpdate = new SensorUpdate(); // SensorUpdate | 
        try {
            Sensor result = apiInstance.apiV1SensorsIdPut(id, sensorUpdate);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SensorsApi#apiV1SensorsIdPut");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**| Numeric ID of the sensor | |
| **sensorUpdate** | [**SensorUpdate**](SensorUpdate.md)|  | |

### Return type

[**Sensor**](Sensor.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sensor updated successfully |  -  |
| **400** | Invalid request body or sensor ID |  -  |
| **500** | Internal server error |  -  |


## apiV1SensorsIdValuePatch

> ApiV1SensorsIdValuePatch200Response apiV1SensorsIdValuePatch(id, updateSensorValue)

Update sensor value

Update the value and status of a sensor

### Example

```java
// Import classes:
import com.warmhouse.monitoring.legacy.smart_home.ApiClient;
import com.warmhouse.monitoring.legacy.smart_home.ApiException;
import com.warmhouse.monitoring.legacy.smart_home.Configuration;
import com.warmhouse.monitoring.legacy.smart_home.models.*;
import com.warmhouse.monitoring.legacy.smart_home.api.SensorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        SensorsApi apiInstance = new SensorsApi(defaultClient);
        Integer id = 56; // Integer | Numeric ID of the sensor
        UpdateSensorValue updateSensorValue = new UpdateSensorValue(); // UpdateSensorValue | 
        try {
            ApiV1SensorsIdValuePatch200Response result = apiInstance.apiV1SensorsIdValuePatch(id, updateSensorValue);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SensorsApi#apiV1SensorsIdValuePatch");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **Integer**| Numeric ID of the sensor | |
| **updateSensorValue** | [**UpdateSensorValue**](UpdateSensorValue.md)|  | |

### Return type

[**ApiV1SensorsIdValuePatch200Response**](ApiV1SensorsIdValuePatch200Response.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Sensor value updated successfully |  -  |
| **400** | Invalid request body or sensor ID |  -  |
| **500** | Internal server error |  -  |


## apiV1SensorsPost

> Sensor apiV1SensorsPost(sensorCreate)

Create a new sensor

Create a new sensor with the provided details

### Example

```java
// Import classes:
import com.warmhouse.monitoring.legacy.smart_home.ApiClient;
import com.warmhouse.monitoring.legacy.smart_home.ApiException;
import com.warmhouse.monitoring.legacy.smart_home.Configuration;
import com.warmhouse.monitoring.legacy.smart_home.models.*;
import com.warmhouse.monitoring.legacy.smart_home.api.SensorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        SensorsApi apiInstance = new SensorsApi(defaultClient);
        SensorCreate sensorCreate = new SensorCreate(); // SensorCreate | 
        try {
            Sensor result = apiInstance.apiV1SensorsPost(sensorCreate);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SensorsApi#apiV1SensorsPost");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **sensorCreate** | [**SensorCreate**](SensorCreate.md)|  | |

### Return type

[**Sensor**](Sensor.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Sensor created successfully |  -  |
| **400** | Invalid request body |  -  |
| **500** | Internal server error |  -  |


## apiV1SensorsTemperatureLocationGet

> TemperatureResponse apiV1SensorsTemperatureLocationGet(location)

Get temperature by location

Fetch temperature data for a specific location from the external temperature API.  This endpoint queries the external temperature service directly and returns real-time temperature information including description. 

### Example

```java
// Import classes:
import com.warmhouse.monitoring.legacy.smart_home.ApiClient;
import com.warmhouse.monitoring.legacy.smart_home.ApiException;
import com.warmhouse.monitoring.legacy.smart_home.Configuration;
import com.warmhouse.monitoring.legacy.smart_home.models.*;
import com.warmhouse.monitoring.legacy.smart_home.api.SensorsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        SensorsApi apiInstance = new SensorsApi(defaultClient);
        String location = "living_room"; // String | Location to get temperature for
        try {
            TemperatureResponse result = apiInstance.apiV1SensorsTemperatureLocationGet(location);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SensorsApi#apiV1SensorsTemperatureLocationGet");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **location** | **String**| Location to get temperature for | |

### Return type

[**TemperatureResponse**](TemperatureResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Temperature data retrieved successfully |  -  |
| **400** | Location parameter is missing |  -  |
| **500** | Failed to fetch temperature data |  -  |

