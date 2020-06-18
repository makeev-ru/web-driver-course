if [ "$TRAVIS_PULL_REQUEST" = "false" ]
then
mvn org.openmrs.maven.plugins:openmrs-sdk-maven-plugin:3.9.0:setup-sdk -DbatchAnswers=n
mvn clean install -U -q
cd package/target/distro
export TOMCAT_PORT=8080

sleep 60

mvn -Dsurefire.suiteXmlFiles=/src/test/resources/testng.xml clean test
else
mvn clean install -U -q
fi