package de.kalass.sonoscontrol;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.teleal.cling.UpnpService;
import org.teleal.cling.UpnpServiceImpl;
import org.teleal.cling.model.message.header.STAllHeader;
import org.teleal.cling.model.meta.Device;
import org.teleal.cling.registry.DefaultRegistryListener;
import org.teleal.cling.registry.Registry;
import org.xml.sax.SAXException;

/**
 * Reads the service XML files and listens for events, saving them to the doc directory.
 * @author klas
 *
 */
public class ListDevices {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        UpnpService upnpService = new UpnpServiceImpl();
        upnpService.getRegistry().addListener(new DefaultRegistryListener() {

            @Override
            public void deviceAdded(Registry registry, final Device device) {
                if (!device.getDisplayString().contains("Sonos")) {
                    return;
                }
                System.out.println(device.getDisplayString());
            }
        });

        // Send a search message to all devices and services, they should respond soon
        upnpService.getControlPoint().search(new STAllHeader());

    }
}
