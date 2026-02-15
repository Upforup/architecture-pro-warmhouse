

# SensorUpdate

Data that can be updated for a sensor

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the sensor |  [optional] |
|**type** | [**TypeEnum**](#TypeEnum) | Type of the sensor |  [optional] |
|**location** | **String** | Physical location of the sensor |  [optional] |
|**value** | **BigDecimal** | Current sensor reading value (can be set to null) |  [optional] |
|**unit** | **String** | Unit of measurement for the sensor value |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Current status of the sensor |  [optional] |



## Enum: TypeEnum

| Name | Value |
|---- | -----|
| TEMPERATURE | &quot;temperature&quot; |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;active&quot; |
| INACTIVE | &quot;inactive&quot; |



