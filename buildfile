# Generated by Buildr 1.4.6, change to your liking


# Version number for this release
VERSION_NUMBER = "0.0.1"
# Group identifier for your projects
GROUP = "SonosControl"
COPYRIGHT = "Klas Kalass"

LIB_GUAVA='com.google.guava:guava:jar:11.0'
LIB_SLF4J_API='org.slf4j:slf4j-api:jar:1.6.4'
LIB_JSR305='com.google.code.findbugs:jsr305:jar:1.3.9'

LIB_CLING_CORE='org.teleal.cling:cling-core:jar:1.0.5'
LIB_TELEAL_COMMON='org.teleal:teleal-common:jar:1.0.14'
LIB_SLF4J_IMPL='org.slf4j:slf4j-jdk14:jar:1.6.4'

# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://repo1.maven.org/maven2"
repositories.remote << "http://4thline.org/m2"

def add_dependencies(pkg)
  tempfile = pkg.to_s.sub(/.jar$/, "-without-dependencies.jar")
  mv pkg.to_s, tempfile

  dependencies = compile.dependencies.map { |d| "-c #{d}"}.join(" ")
  sh "java -jar tools/autojar.jar -baev -m etc/META-INF/MANIFEST.MF -o #{pkg} #{dependencies} #{tempfile}"
end

desc "The Sonoscontrol project"
define "sonos-control" do
  project.version = VERSION_NUMBER
  project.group = GROUP
  manifest["Implementation-Vendor"] = COPYRIGHT

  define 'api', :base_dir => 'sonos-control-api' do
      compile.with LIB_GUAVA,LIB_SLF4J_API,LIB_JSR305
      package(:jar)
  end

  define 'api-clingimpl', :base_dir => 'sonos-control-api-clingimpl' do
      compile.with LIB_GUAVA,LIB_SLF4J_API,LIB_JSR305,LIB_CLING_CORE,LIB_TELEAL_COMMON,project('api')
      package(:jar)
  end

  define 'cli', :base_dir => 'sonos-control-cli' do
    compile.with LIB_GUAVA,LIB_SLF4J_API,LIB_JSR305,LIB_CLING_CORE,LIB_TELEAL_COMMON,LIB_SLF4J_IMPL,project('api'), project('api-clingimpl')

    package(:jar)
    package(:jar).enhance { |pkg| pkg.enhance { |pkg| add_dependencies(pkg) }}
  end

end
