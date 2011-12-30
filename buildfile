# Generated by Buildr 1.4.6, change to your liking


# Version number for this release
VERSION_NUMBER = "0.0.1"
# Group identifier for your projects
GROUP = "SonosControl"
COPYRIGHT = "Klas Kalass"

# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://repo1.maven.org/maven2"
repositories.remote << "http://4thline.org/m2"

desc "The Sonoscontrol project"
define "SonosControl" do
  project.version = VERSION_NUMBER
  project.group = GROUP
  manifest["Implementation-Vendor"] = COPYRIGHT

  compile.with 'org.teleal.cling:cling-core:jar:1.0.5','org.teleal:teleal-common:jar:1.0.14','com.google.guava:guava:jar:11.0','org.slf4j:slf4j-api:jar:1.6.4', 'com.google.code.findbugs:jsr305:jar:1.3.9','org.slf4j:slf4j-jdk14:jar:1.6.4'
  package(:jar).with :manifest=>{ 'Copyright'=>'Klas Kalass (C) 2011', 'Main-Class'=>'de.kalass.sonoscontrol.SonosControl' }
end
