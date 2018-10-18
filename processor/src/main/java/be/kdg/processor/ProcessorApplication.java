package be.kdg.processor;

import BoeteBereken.BerekenBoete;
import be.kdg.sa.services.CameraServiceProxy;
import be.kdg.se3.services.LicensePlateServiceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

public class ProcessorApplication {
	public static void main(String[] args) throws IOException {
		//SpringApplication.run(ProcessorApplication.class, args);
		BerekenBoete berekenBoete = new BerekenBoete();
		System.out.println(berekenBoete.bereken());


        LicensePlateServiceProxy proxy = new LicensePlateServiceProxy();
		 CameraServiceProxy cameraServiceProxy = new CameraServiceProxy();


        System.out.println(cameraServiceProxy.get(1));
        System.out.println(cameraServiceProxy.get(2));
        System.out.println(cameraServiceProxy.get(3));
        System.out.println(cameraServiceProxy.get(4));
        System.out.println(cameraServiceProxy.get(5));


    }
}
