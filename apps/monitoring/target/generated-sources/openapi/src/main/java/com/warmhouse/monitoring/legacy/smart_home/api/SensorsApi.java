package com.warmhouse.monitoring.legacy.smart_home.api;

import com.warmhouse.monitoring.legacy.smart_home.ApiClient;

import com.warmhouse.monitoring.legacy.smart_home.model.ApiV1SensorsIdDelete200Response;
import com.warmhouse.monitoring.legacy.smart_home.model.ApiV1SensorsIdValuePatch200Response;
import com.warmhouse.monitoring.legacy.smart_home.model.ErrorResponse;
import com.warmhouse.monitoring.legacy.smart_home.model.Sensor;
import com.warmhouse.monitoring.legacy.smart_home.model.SensorCreate;
import com.warmhouse.monitoring.legacy.smart_home.model.SensorUpdate;
import com.warmhouse.monitoring.legacy.smart_home.model.TemperatureResponse;
import com.warmhouse.monitoring.legacy.smart_home.model.UpdateSensorValue;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient.ResponseSpec;
import org.springframework.web.client.RestClientResponseException;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2026-02-15T18:48:47.318794900+03:00[Europe/Moscow]", comments = "Generator version: 7.19.0")
public class SensorsApi {
    private ApiClient apiClient;

    public SensorsApi() {
        this(new ApiClient());
    }

    public SensorsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get all sensors
     * Retrieve all sensors from the database.  For temperature sensors, the response includes real-time data fetched from the external temperature API. 
     * <p><b>200</b> - List of all sensors
     * <p><b>500</b> - Internal server error
     * @return List&lt;Sensor&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1SensorsGetRequestCreation() throws RestClientResponseException {
        Object postBody = null;
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<List<Sensor>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/sensors", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get all sensors
     * Retrieve all sensors from the database.  For temperature sensors, the response includes real-time data fetched from the external temperature API. 
     * <p><b>200</b> - List of all sensors
     * <p><b>500</b> - Internal server error
     * @return List&lt;Sensor&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public List<Sensor> apiV1SensorsGet() throws RestClientResponseException {
        ParameterizedTypeReference<List<Sensor>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsGetRequestCreation().body(localVarReturnType);
    }

    /**
     * Get all sensors
     * Retrieve all sensors from the database.  For temperature sensors, the response includes real-time data fetched from the external temperature API. 
     * <p><b>200</b> - List of all sensors
     * <p><b>500</b> - Internal server error
     * @return ResponseEntity&lt;List&lt;Sensor&gt;&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Sensor>> apiV1SensorsGetWithHttpInfo() throws RestClientResponseException {
        ParameterizedTypeReference<List<Sensor>> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsGetRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Get all sensors
     * Retrieve all sensors from the database.  For temperature sensors, the response includes real-time data fetched from the external temperature API. 
     * <p><b>200</b> - List of all sensors
     * <p><b>500</b> - Internal server error
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1SensorsGetWithResponseSpec() throws RestClientResponseException {
        return apiV1SensorsGetRequestCreation();
    }

    /**
     * Delete a sensor
     * Delete a sensor by its ID
     * <p><b>200</b> - Sensor deleted successfully
     * <p><b>400</b> - Invalid sensor ID format
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @return ApiV1SensorsIdDelete200Response
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1SensorsIdDeleteRequestCreation(@jakarta.annotation.Nonnull Integer id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling apiV1SensorsIdDelete", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ApiV1SensorsIdDelete200Response> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/sensors/{id}", HttpMethod.DELETE, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Delete a sensor
     * Delete a sensor by its ID
     * <p><b>200</b> - Sensor deleted successfully
     * <p><b>400</b> - Invalid sensor ID format
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @return ApiV1SensorsIdDelete200Response
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ApiV1SensorsIdDelete200Response apiV1SensorsIdDelete(@jakarta.annotation.Nonnull Integer id) throws RestClientResponseException {
        ParameterizedTypeReference<ApiV1SensorsIdDelete200Response> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsIdDeleteRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Delete a sensor
     * Delete a sensor by its ID
     * <p><b>200</b> - Sensor deleted successfully
     * <p><b>400</b> - Invalid sensor ID format
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @return ResponseEntity&lt;ApiV1SensorsIdDelete200Response&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ApiV1SensorsIdDelete200Response> apiV1SensorsIdDeleteWithHttpInfo(@jakarta.annotation.Nonnull Integer id) throws RestClientResponseException {
        ParameterizedTypeReference<ApiV1SensorsIdDelete200Response> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsIdDeleteRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Delete a sensor
     * Delete a sensor by its ID
     * <p><b>200</b> - Sensor deleted successfully
     * <p><b>400</b> - Invalid sensor ID format
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1SensorsIdDeleteWithResponseSpec(@jakarta.annotation.Nonnull Integer id) throws RestClientResponseException {
        return apiV1SensorsIdDeleteRequestCreation(id);
    }

    /**
     * Get sensor by ID
     * Retrieve a specific sensor by its ID.  For temperature sensors, the response includes real-time data fetched from the external temperature API. 
     * <p><b>200</b> - Sensor found
     * <p><b>400</b> - Invalid sensor ID format
     * <p><b>404</b> - Sensor not found
     * @param id Numeric ID of the sensor
     * @return Sensor
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1SensorsIdGetRequestCreation(@jakarta.annotation.Nonnull Integer id) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling apiV1SensorsIdGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Sensor> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/sensors/{id}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get sensor by ID
     * Retrieve a specific sensor by its ID.  For temperature sensors, the response includes real-time data fetched from the external temperature API. 
     * <p><b>200</b> - Sensor found
     * <p><b>400</b> - Invalid sensor ID format
     * <p><b>404</b> - Sensor not found
     * @param id Numeric ID of the sensor
     * @return Sensor
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Sensor apiV1SensorsIdGet(@jakarta.annotation.Nonnull Integer id) throws RestClientResponseException {
        ParameterizedTypeReference<Sensor> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsIdGetRequestCreation(id).body(localVarReturnType);
    }

    /**
     * Get sensor by ID
     * Retrieve a specific sensor by its ID.  For temperature sensors, the response includes real-time data fetched from the external temperature API. 
     * <p><b>200</b> - Sensor found
     * <p><b>400</b> - Invalid sensor ID format
     * <p><b>404</b> - Sensor not found
     * @param id Numeric ID of the sensor
     * @return ResponseEntity&lt;Sensor&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Sensor> apiV1SensorsIdGetWithHttpInfo(@jakarta.annotation.Nonnull Integer id) throws RestClientResponseException {
        ParameterizedTypeReference<Sensor> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsIdGetRequestCreation(id).toEntity(localVarReturnType);
    }

    /**
     * Get sensor by ID
     * Retrieve a specific sensor by its ID.  For temperature sensors, the response includes real-time data fetched from the external temperature API. 
     * <p><b>200</b> - Sensor found
     * <p><b>400</b> - Invalid sensor ID format
     * <p><b>404</b> - Sensor not found
     * @param id Numeric ID of the sensor
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1SensorsIdGetWithResponseSpec(@jakarta.annotation.Nonnull Integer id) throws RestClientResponseException {
        return apiV1SensorsIdGetRequestCreation(id);
    }

    /**
     * Update a sensor
     * Update all fields of an existing sensor
     * <p><b>200</b> - Sensor updated successfully
     * <p><b>400</b> - Invalid request body or sensor ID
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @param sensorUpdate The sensorUpdate parameter
     * @return Sensor
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1SensorsIdPutRequestCreation(@jakarta.annotation.Nonnull Integer id, @jakarta.annotation.Nonnull SensorUpdate sensorUpdate) throws RestClientResponseException {
        Object postBody = sensorUpdate;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling apiV1SensorsIdPut", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'sensorUpdate' is set
        if (sensorUpdate == null) {
            throw new RestClientResponseException("Missing the required parameter 'sensorUpdate' when calling apiV1SensorsIdPut", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Sensor> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/sensors/{id}", HttpMethod.PUT, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update a sensor
     * Update all fields of an existing sensor
     * <p><b>200</b> - Sensor updated successfully
     * <p><b>400</b> - Invalid request body or sensor ID
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @param sensorUpdate The sensorUpdate parameter
     * @return Sensor
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Sensor apiV1SensorsIdPut(@jakarta.annotation.Nonnull Integer id, @jakarta.annotation.Nonnull SensorUpdate sensorUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<Sensor> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsIdPutRequestCreation(id, sensorUpdate).body(localVarReturnType);
    }

    /**
     * Update a sensor
     * Update all fields of an existing sensor
     * <p><b>200</b> - Sensor updated successfully
     * <p><b>400</b> - Invalid request body or sensor ID
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @param sensorUpdate The sensorUpdate parameter
     * @return ResponseEntity&lt;Sensor&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Sensor> apiV1SensorsIdPutWithHttpInfo(@jakarta.annotation.Nonnull Integer id, @jakarta.annotation.Nonnull SensorUpdate sensorUpdate) throws RestClientResponseException {
        ParameterizedTypeReference<Sensor> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsIdPutRequestCreation(id, sensorUpdate).toEntity(localVarReturnType);
    }

    /**
     * Update a sensor
     * Update all fields of an existing sensor
     * <p><b>200</b> - Sensor updated successfully
     * <p><b>400</b> - Invalid request body or sensor ID
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @param sensorUpdate The sensorUpdate parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1SensorsIdPutWithResponseSpec(@jakarta.annotation.Nonnull Integer id, @jakarta.annotation.Nonnull SensorUpdate sensorUpdate) throws RestClientResponseException {
        return apiV1SensorsIdPutRequestCreation(id, sensorUpdate);
    }

    /**
     * Update sensor value
     * Update the value and status of a sensor
     * <p><b>200</b> - Sensor value updated successfully
     * <p><b>400</b> - Invalid request body or sensor ID
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @param updateSensorValue The updateSensorValue parameter
     * @return ApiV1SensorsIdValuePatch200Response
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1SensorsIdValuePatchRequestCreation(@jakarta.annotation.Nonnull Integer id, @jakarta.annotation.Nonnull UpdateSensorValue updateSensorValue) throws RestClientResponseException {
        Object postBody = updateSensorValue;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new RestClientResponseException("Missing the required parameter 'id' when calling apiV1SensorsIdValuePatch", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // verify the required parameter 'updateSensorValue' is set
        if (updateSensorValue == null) {
            throw new RestClientResponseException("Missing the required parameter 'updateSensorValue' when calling apiV1SensorsIdValuePatch", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<ApiV1SensorsIdValuePatch200Response> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/sensors/{id}/value", HttpMethod.PATCH, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Update sensor value
     * Update the value and status of a sensor
     * <p><b>200</b> - Sensor value updated successfully
     * <p><b>400</b> - Invalid request body or sensor ID
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @param updateSensorValue The updateSensorValue parameter
     * @return ApiV1SensorsIdValuePatch200Response
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ApiV1SensorsIdValuePatch200Response apiV1SensorsIdValuePatch(@jakarta.annotation.Nonnull Integer id, @jakarta.annotation.Nonnull UpdateSensorValue updateSensorValue) throws RestClientResponseException {
        ParameterizedTypeReference<ApiV1SensorsIdValuePatch200Response> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsIdValuePatchRequestCreation(id, updateSensorValue).body(localVarReturnType);
    }

    /**
     * Update sensor value
     * Update the value and status of a sensor
     * <p><b>200</b> - Sensor value updated successfully
     * <p><b>400</b> - Invalid request body or sensor ID
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @param updateSensorValue The updateSensorValue parameter
     * @return ResponseEntity&lt;ApiV1SensorsIdValuePatch200Response&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ApiV1SensorsIdValuePatch200Response> apiV1SensorsIdValuePatchWithHttpInfo(@jakarta.annotation.Nonnull Integer id, @jakarta.annotation.Nonnull UpdateSensorValue updateSensorValue) throws RestClientResponseException {
        ParameterizedTypeReference<ApiV1SensorsIdValuePatch200Response> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsIdValuePatchRequestCreation(id, updateSensorValue).toEntity(localVarReturnType);
    }

    /**
     * Update sensor value
     * Update the value and status of a sensor
     * <p><b>200</b> - Sensor value updated successfully
     * <p><b>400</b> - Invalid request body or sensor ID
     * <p><b>500</b> - Internal server error
     * @param id Numeric ID of the sensor
     * @param updateSensorValue The updateSensorValue parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1SensorsIdValuePatchWithResponseSpec(@jakarta.annotation.Nonnull Integer id, @jakarta.annotation.Nonnull UpdateSensorValue updateSensorValue) throws RestClientResponseException {
        return apiV1SensorsIdValuePatchRequestCreation(id, updateSensorValue);
    }

    /**
     * Create a new sensor
     * Create a new sensor with the provided details
     * <p><b>201</b> - Sensor created successfully
     * <p><b>400</b> - Invalid request body
     * <p><b>500</b> - Internal server error
     * @param sensorCreate The sensorCreate parameter
     * @return Sensor
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1SensorsPostRequestCreation(@jakarta.annotation.Nonnull SensorCreate sensorCreate) throws RestClientResponseException {
        Object postBody = sensorCreate;
        // verify the required parameter 'sensorCreate' is set
        if (sensorCreate == null) {
            throw new RestClientResponseException("Missing the required parameter 'sensorCreate' when calling apiV1SensorsPost", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
        };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<Sensor> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/sensors", HttpMethod.POST, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Create a new sensor
     * Create a new sensor with the provided details
     * <p><b>201</b> - Sensor created successfully
     * <p><b>400</b> - Invalid request body
     * <p><b>500</b> - Internal server error
     * @param sensorCreate The sensorCreate parameter
     * @return Sensor
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public Sensor apiV1SensorsPost(@jakarta.annotation.Nonnull SensorCreate sensorCreate) throws RestClientResponseException {
        ParameterizedTypeReference<Sensor> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsPostRequestCreation(sensorCreate).body(localVarReturnType);
    }

    /**
     * Create a new sensor
     * Create a new sensor with the provided details
     * <p><b>201</b> - Sensor created successfully
     * <p><b>400</b> - Invalid request body
     * <p><b>500</b> - Internal server error
     * @param sensorCreate The sensorCreate parameter
     * @return ResponseEntity&lt;Sensor&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Sensor> apiV1SensorsPostWithHttpInfo(@jakarta.annotation.Nonnull SensorCreate sensorCreate) throws RestClientResponseException {
        ParameterizedTypeReference<Sensor> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsPostRequestCreation(sensorCreate).toEntity(localVarReturnType);
    }

    /**
     * Create a new sensor
     * Create a new sensor with the provided details
     * <p><b>201</b> - Sensor created successfully
     * <p><b>400</b> - Invalid request body
     * <p><b>500</b> - Internal server error
     * @param sensorCreate The sensorCreate parameter
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1SensorsPostWithResponseSpec(@jakarta.annotation.Nonnull SensorCreate sensorCreate) throws RestClientResponseException {
        return apiV1SensorsPostRequestCreation(sensorCreate);
    }

    /**
     * Get temperature by location
     * Fetch temperature data for a specific location from the external temperature API.  This endpoint queries the external temperature service directly and returns real-time temperature information including description. 
     * <p><b>200</b> - Temperature data retrieved successfully
     * <p><b>400</b> - Location parameter is missing
     * <p><b>500</b> - Failed to fetch temperature data
     * @param location Location to get temperature for
     * @return TemperatureResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec apiV1SensorsTemperatureLocationGetRequestCreation(@jakarta.annotation.Nonnull String location) throws RestClientResponseException {
        Object postBody = null;
        // verify the required parameter 'location' is set
        if (location == null) {
            throw new RestClientResponseException("Missing the required parameter 'location' when calling apiV1SensorsTemperatureLocationGet", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), null, null, null);
        }
        // create path and map variables
        final Map<String, Object> pathParams = new HashMap<>();

        pathParams.put("location", location);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<>();

        final String[] localVarAccepts = { 
            "application/json"
        };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] {  };

        ParameterizedTypeReference<TemperatureResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/api/v1/sensors/temperature/{location}", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get temperature by location
     * Fetch temperature data for a specific location from the external temperature API.  This endpoint queries the external temperature service directly and returns real-time temperature information including description. 
     * <p><b>200</b> - Temperature data retrieved successfully
     * <p><b>400</b> - Location parameter is missing
     * <p><b>500</b> - Failed to fetch temperature data
     * @param location Location to get temperature for
     * @return TemperatureResponse
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public TemperatureResponse apiV1SensorsTemperatureLocationGet(@jakarta.annotation.Nonnull String location) throws RestClientResponseException {
        ParameterizedTypeReference<TemperatureResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsTemperatureLocationGetRequestCreation(location).body(localVarReturnType);
    }

    /**
     * Get temperature by location
     * Fetch temperature data for a specific location from the external temperature API.  This endpoint queries the external temperature service directly and returns real-time temperature information including description. 
     * <p><b>200</b> - Temperature data retrieved successfully
     * <p><b>400</b> - Location parameter is missing
     * <p><b>500</b> - Failed to fetch temperature data
     * @param location Location to get temperature for
     * @return ResponseEntity&lt;TemperatureResponse&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<TemperatureResponse> apiV1SensorsTemperatureLocationGetWithHttpInfo(@jakarta.annotation.Nonnull String location) throws RestClientResponseException {
        ParameterizedTypeReference<TemperatureResponse> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiV1SensorsTemperatureLocationGetRequestCreation(location).toEntity(localVarReturnType);
    }

    /**
     * Get temperature by location
     * Fetch temperature data for a specific location from the external temperature API.  This endpoint queries the external temperature service directly and returns real-time temperature information including description. 
     * <p><b>200</b> - Temperature data retrieved successfully
     * <p><b>400</b> - Location parameter is missing
     * <p><b>500</b> - Failed to fetch temperature data
     * @param location Location to get temperature for
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec apiV1SensorsTemperatureLocationGetWithResponseSpec(@jakarta.annotation.Nonnull String location) throws RestClientResponseException {
        return apiV1SensorsTemperatureLocationGetRequestCreation(location);
    }
}
