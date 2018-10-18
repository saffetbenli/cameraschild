package be.kdg.processor.services;

import be.kdg.processor.exceptions.CacheException;

import java.util.ArrayList;

public interface CachingService {


    /**
     * Saves a {@ProductLocation} for an {@Order}
     * @param key productID
     * @param location {@ProductLocation} to save
     */

    void saveLocation(int key, CameraService cameraService) throws CacheException;

    /**
     * Gets the ProductLocation for an Order
     *
     * @param key productID
     */
    CameraService getCameraService(int key) throws CacheException;
    /**
     * Get all the ProductLocations
     *
     */
    ArrayList<Integer> getProductIDs() throws CacheException;

    /**
     * Clears all ProductLocations
     */
    void clearLocations(int key) throws CacheException;

    /**
     * Clears all locations
     */
    void clearLocations() throws CacheException;


}s
