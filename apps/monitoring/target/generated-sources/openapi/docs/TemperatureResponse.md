

# TemperatureResponse

Temperature data from external API

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**location** | **String** | Location name |  |
|**value** | **BigDecimal** | Temperature value |  |
|**unit** | **String** | Temperature unit |  |
|**status** | [**StatusEnum**](#StatusEnum) | Sensor status |  |
|**timestamp** | **OffsetDateTime** | When the temperature was recorded |  |
|**description** | **String** | Human-readable description |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| ACTIVE | &quot;active&quot; |
| INACTIVE | &quot;inactive&quot; |



