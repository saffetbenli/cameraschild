package be.kdg.simulator.simulator;

import be.kdg.simulator.LicenseGenerators.FileGenerator;
import be.kdg.simulator.LicenseGenerators.GeneratorInvocator;
import be.kdg.simulator.LicenseGenerators.LicensePlateGenerator;
import be.kdg.simulator.LicenseGenerators.RandomGenerator;
import be.kdg.simulator.Messages.MessageInvocator;
import be.kdg.simulator.Messages.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;

@Component
    public class Simulator {
        private MessageSender messageSender;
        private LicensePlateGenerator licensePlateGenerator;

        @Autowired
        public Simulator(GeneratorInvocator generatorInvocator, MessageInvocator messageInvocator) throws JAXBException {
            messageSender = messageInvocator.getMessageSender();
            licensePlateGenerator = generatorInvocator.getMessageGenerator();

            startSimulating();
        }

        private void startSimulating(){
            if (licensePlateGenerator instanceof RandomGenerator) {
                    while(true){
                        messageSender.sendMessage(licensePlateGenerator.generate());
                    }
            }else{
                    messageSender.sendMessage(licensePlateGenerator.generate());
                }
            }
        }
