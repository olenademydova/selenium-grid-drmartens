To launch selenium grid:

Execute these commands in separate terminals:

java -jar selenium-server-standalone-3.141.59.jar -role hub -hubConfig hubconfig.json

java -Dwebdriver.chrome.driver="chromedriver.exe" -Dwebdriver.gecko.driver="geckodriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig nodeconfig.json

