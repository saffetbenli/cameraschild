package simulator;

import LicenseGenerators.FileGenerator;
import LicenseGenerators.GeneratorInvocator;
import LicenseGenerators.LicensePlateGenerator;
import LicenseGenerators.RandomGenerator;
import Messages.MessageInvocator;
import Messages.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import sun.rmi.rmic.Generator;

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

        private void startSimulating() throws JAXBException {
            if (licensePlateGenerator instanceof RandomGenerator) {
                while (true) {
                    messageSender.sendMessage(licensePlateGenerator.generate());
                }
            }
            if (licensePlateGenerator instanceof FileGenerator) {
                while (true) {
                    messageSender.sendMessage(licensePlateGenerator.generate());
                }
            }
        }
    }
