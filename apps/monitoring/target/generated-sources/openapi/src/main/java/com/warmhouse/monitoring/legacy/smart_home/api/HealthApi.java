package com.warmhouse.monitoring.legacy.smart_home.api;

import com.warmhouse.monitoring.legacy.smart_home.ApiClient;

import com.warmhouse.monitoring.legacy.smart_home.model.HealthGet200Response;

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
public class HealthApi {
    private ApiClient apiClient;

    public HealthApi() {
        this(new ApiClient());
    }

    public HealthApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Health check
     * Check if the API is running
     * <p><b>200</b> - API is healthy
     * @return HealthGet200Response
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    private ResponseSpec healthGetRequestCreation() throws RestClientResponseException {
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

        ParameterizedTypeReference<HealthGet200Response> localVarReturnType = new ParameterizedTypeReference<>() {};
        return apiClient.invokeAPI("/health", HttpMethod.GET, pathParams, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Health check
     * Check if the API is running
     * <p><b>200</b> - API is healthy
     * @return HealthGet200Response
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public HealthGet200Response healthGet() throws RestClientResponseException {
        ParameterizedTypeReference<HealthGet200Response> localVarReturnType = new ParameterizedTypeReference<>() {};
        return healthGetRequestCreation().body(localVarReturnType);
    }

    /**
     * Health check
     * Check if the API is running
     * <p><b>200</b> - API is healthy
     * @return ResponseEntity&lt;HealthGet200Response&gt;
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<HealthGet200Response> healthGetWithHttpInfo() throws RestClientResponseException {
        ParameterizedTypeReference<HealthGet200Response> localVarReturnType = new ParameterizedTypeReference<>() {};
        return healthGetRequestCreation().toEntity(localVarReturnType);
    }

    /**
     * Health check
     * Check if the API is running
     * <p><b>200</b> - API is healthy
     * @return ResponseSpec
     * @throws RestClientResponseException if an error occurs while attempting to invoke the API
     */
    public ResponseSpec healthGetWithResponseSpec() throws RestClientResponseException {
        return healthGetRequestCreation();
    }
}
