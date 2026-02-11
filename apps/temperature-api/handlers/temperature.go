package handlers

import (
	"log"
	"math/rand"
	"net/http"
	"time"

	"github.com/gin-gonic/gin"
)

// SensorHandler handles sensor-related requests
type TemperatureHandler struct {
}

// NewSensorHandler creates a new SensorHandler
func NewTemperatureHandler() *TemperatureHandler {
	return &TemperatureHandler{}
}

// RegisterRoutes registers the sensor routes
func (h *TemperatureHandler) RegisterRoutes(router *gin.Engine) {
	sensors := router.Group("/temperature")
	{
		sensors.GET("", h.GetTemperatureByLocation)
		sensors.GET("/:id", h.GetTemperatureByID)
	}
}

// TemperatureResponse represents the response from the temperature API
type TemperatureResponse struct {
	Value       float64   `json:"value"`
	Unit        string    `json:"unit"`
	Timestamp   time.Time `json:"timestamp"`
	Location    string    `json:"location"`
	Status      string    `json:"status"`
	SensorID    string    `json:"sensor_id"`
	SensorType  string    `json:"sensor_type"`
	Description string    `json:"description"`
}

func (h *TemperatureHandler) GetSensorInfo(location string, sensorID string) (string, string) {
	// If no location is provided, use a default based on sensor ID
	if location == "" {
		switch sensorID {
		case "1":
			location = "Living Room"
		case "2":
			location = "Bedroom"
		case "3":
			location = "Kitchen"
		default:
			location = "Unknown"
		}
	}

	// If no sensor ID is provided, generate one based on location
	if sensorID == "" {
		switch location {
		case "Living Room":
			sensorID = "1"
		case "Bedroom":
			sensorID = "2"
		case "Kitchen":
			sensorID = "3"
		default:
			sensorID = "0"
		}
	}

	log.Printf("location: %v sensorID: %v\n", location, sensorID)

	return location, sensorID
}

func (h *TemperatureHandler) GetTemperatureByLocation(c *gin.Context) {
	location, sensorID := h.GetSensorInfo(c.Query("location"), "")
	t := getRandomTemperature()

	rs := TemperatureResponse{
		Location:    location,
		SensorID:    sensorID,
		Value:       t,
		Timestamp:   time.Now(),
		Unit:        "°C",
		Status:      "active",
		SensorType:  "temperature",
		Description: "Description",
	}

	log.Printf("GetTemperatureByLocation rs = %v", rs)

	c.JSON(http.StatusOK, rs)
}

func (h *TemperatureHandler) GetTemperatureByID(c *gin.Context) {

	location, sensorID := h.GetSensorInfo("", c.Param("id"))
	t := getRandomTemperature()

	rs := TemperatureResponse{
		Location:    location,
		SensorID:    sensorID,
		Value:       t,
		Timestamp:   time.Now(),
		Unit:        "°C",
		Status:      "active",
		SensorType:  "temperature",
		Description: "Description",
	}

	log.Printf("GetTemperatureByID rs = %v", rs)

	c.JSON(http.StatusOK, rs)
}

func getRandomTemperature() float64 {
	min := 15.0
	max := 30.0
	return min + rand.Float64()*(max-min)
}
