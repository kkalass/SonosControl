package de.kalass.sonoscontrol.generator.events;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.fourthline.cling.UpnpService;
import org.fourthline.cling.UpnpServiceImpl;
import org.fourthline.cling.controlpoint.SubscriptionCallback;
import org.fourthline.cling.model.gena.CancelReason;
import org.fourthline.cling.model.gena.GENASubscription;
import org.fourthline.cling.model.message.UpnpResponse;
import org.fourthline.cling.model.message.header.STAllHeader;
import org.fourthline.cling.model.meta.Device;
import org.fourthline.cling.model.meta.Service;
import org.fourthline.cling.registry.DefaultRegistryListener;
import org.fourthline.cling.registry.Registry;
import org.xml.sax.SAXException;

import com.google.common.io.Files;

/**
 * Reads the service XML files and listens for events, saving them to the doc directory.
 * @author klas
 *
 */
public class QueryEvents {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        final String base= "/Users/klas/Documents/Programmieren/SonosControl/src/SonosControl/";
        final File outputDir = new File(args.length == 0 ? base+"sonos-control-api-generator/doc/sonos/example-events" : args[0]);

        UpnpService upnpService = new UpnpServiceImpl();
        upnpService.getRegistry().addListener(new DefaultRegistryListener() {

            @Override
            public void deviceAdded(Registry registry, final Device device) {
                if (!device.getDisplayString().contains("ZP90")) {
                    return;
                }
                final File deviceOutputDir = outputDir;// new File(outputDir, device.getDisplayString());
                Service[] services = device.findServices();
                for (final Service service : services) {
                    final File serviceOutputDir = new File(deviceOutputDir, service.getServiceId().getId());
                    serviceOutputDir.mkdirs();
                    registry.getUpnpService().getControlPoint().execute(new SubscriptionCallback(service) {

                        @Override
                        protected void failed(GENASubscription subscription,
                                UpnpResponse responseStatus, Exception exception, String defaultMsg) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        protected void eventsMissed(GENASubscription subscription,
                                int numberOfMissedEvents) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        protected void eventReceived(GENASubscription subscription) {
                            Map currentValues = subscription.getCurrentValues();
                            for (Map.Entry e : (Set<Map.Entry>)currentValues.entrySet()) {
                                Object key = e.getKey();
                                String value = e.getValue().toString();
                                final File outputFile = new File(serviceOutputDir, key + (value.startsWith("<") ? ".xml" : ".txt"));
                                try {
                                    // Hide Username/Passwords send in *cleartext*!
                                    String v = value.toString()
                                            .replaceAll("Password=\"[^\"]*\"", "Password=\"<pwd>\"")
                                            .replaceAll("Password0=\"[^\"]*\"", "Password0=\"<pwd>\"")
                                            ;
                                    Pattern usernamePattern = Pattern.compile("Username0=\"([^\"]*)\"");
                                    Matcher usernameMatcher = usernamePattern.matcher(v);
                                    while (usernameMatcher.find()) {
                                        String username = usernameMatcher.group(1);
                                        System.out.println("Found username");
                                        v = v.replaceAll(Pattern.quote(username), "<username>");
                                    }
                                    Files.write(v, outputFile, Charset.forName("UTF-8"));
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }

                        @Override
                        protected void established(GENASubscription subscription) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        protected void ended(GENASubscription subscription, CancelReason reason,
                                UpnpResponse responseStatus) {
                            // TODO Auto-generated method stub

                        }
                    });
                }
            }
        });

        // Send a search message to all devices and services, they should respond soon
        upnpService.getControlPoint().search(new STAllHeader());

    }
}
