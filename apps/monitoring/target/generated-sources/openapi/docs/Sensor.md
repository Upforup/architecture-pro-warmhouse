

# Sensor

Represents a smart home sensor

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **Integer** | Unique identifier for the sensor |  |
|**name** | **String** | Name of the sensor |  |
|**type** | [**TypeEnum**](#TypeEnum) | Type of the sensor |  |
|**location** | **String** | Physical location of the sensor |  |
|**value** | **BigDecimal** | Current sensor reading value |  |
|**unit** | **String** | Unit of measurement for the sensor value |  |
|**status** | [**StatusEnum**](#StatusEnum) | Current status of the sensor |  |
|**lastUpdated** | **OffsetDateTime** | Timestamp of the last sensor update |  |
|**createdAt** | **OffsetDateTime** | Timestamp when the sensor was created |  |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| TEMPERATURE | &quot;temperature&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;active&quot; |
| INACTIVE | &quot;inactive&quot; |



